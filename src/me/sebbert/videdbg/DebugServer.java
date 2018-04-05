/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.sebbert.videdbg;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import de.malban.gui.CSAMainFrame;
import de.malban.vide.dissy.DissiPanel;
import de.malban.vide.vecx.VecXPanel;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

/**
 * 
 * @author Sebbert
 */
public class DebugServer extends WebSocketServer {
    static final JsonParser _jsonParser = new JsonParser();
    static final Gson _gson = new Gson();
    static final Logger _logger = Logger.getLogger(DebugServer.class.getName());
    
    DebugMessageListener _listener;
    
    public DebugServer(InetSocketAddress addr, DebugMessageListener listener) {
        super(addr);
        _listener = listener;
    }
    
    @Override
    public void onMessage(WebSocket ws, String json) {
        try {
            JsonObject rootObj = 
                    _jsonParser
                    .parse(json)
                    .getAsJsonObject();
            
            String typeName = 
                    rootObj
                    .getAsJsonPrimitive("type")
                    .getAsString();
            
            switch (typeName) {
                case "buildAndRun":
                    _listener.buildAndRun(deserialize(rootObj, BuildAndRunMessage.class));
                case "run":
                    _listener.run(deserialize(rootObj, RunMessage.class));
                default: break; 
            }
        }
        catch (JsonSyntaxException ex) {
            // Ignore non-json messages
            _logger.log(Level.WARNING, "Message was not valid JSON");
        }
        catch (Exception ex) {
            _logger.log(Level.WARNING, "Failed to parse message: {0}", ex.toString());
        }
    }
    
    private <T> T deserialize(JsonElement elem, Class<T> cls) {
        return (T)_gson.fromJson(elem, cls);
    }

    @Override
    public void onOpen(WebSocket ws, ClientHandshake ch) {
        
    }

    @Override
    public void onClose(WebSocket ws, int i, String string, boolean bln) {
    }

    @Override
    public void onError(WebSocket ws, Exception ex) {
    }

    @Override
    public void onStart() {
    }
}
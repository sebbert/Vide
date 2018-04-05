/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.sebbert.videdbg;
import java.util.HashSet;
import java.util.function.Consumer;

/**
 *
 * @author Sebbert
 */
public class Event<T> {
    public HashSet<Consumer<T>> _handlers;
    
    public Disposable listen(Consumer<T> handler) {
        _handlers.add(handler);
        return () -> {
            unlisten(handler);
        };
    }
    
    public void unlisten(Consumer<T> handler) {
        _handlers.remove(handler);
    }
    
    public void invoke(T arg) {
        _handlers.forEach((handler) -> handler.accept(arg));
    }
}

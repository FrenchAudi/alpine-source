package me.alpine.event;

import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.InvocationTargetException;

/**
 * Extensible Event Class
 *
 * @author Hideri
 * @since May 27, 2022
 */
public class Event {
    @Getter @Setter private boolean cancelled;

    public void call() {
        try {
            EventManager.invoke(this);
        } catch (IllegalAccessException | InvocationTargetException | InstantiationException e) {
            throw new RuntimeException("Failed to Invoke Method", e);
        }
    }
}

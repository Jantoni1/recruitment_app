package com.jantoni1.recruitmentapp.eventdispatcher;

import java.io.Serializable;

public interface EventListener<T> {
    void handle(T event);
}
package com.jantoni1.recruitmentapp.eventdispatcher;

import java.io.Serializable;

public interface EventDispatcher {
    void dispatch(Serializable event);
}
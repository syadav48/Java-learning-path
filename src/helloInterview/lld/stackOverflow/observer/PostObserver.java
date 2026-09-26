package helloInterview.lld.stackOverflow.observer;

import helloInterview.lld.stackOverflow.entities.Event;

public interface PostObserver {
    void onPostEvent(Event event);
}

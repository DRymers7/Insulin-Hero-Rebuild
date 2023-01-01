package com.techelevator.dao;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {

    private long waitTime;

    public MyCallable(int timeMillis) {
        this.waitTime = timeMillis;
    }
    @Override
    public String call() throws Exception {
        Thread.sleep(waitTime);
        return Thread.currentThread().getName();
    }
}

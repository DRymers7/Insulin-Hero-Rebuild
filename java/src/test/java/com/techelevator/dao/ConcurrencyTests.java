package com.techelevator.dao;

import com.techelevator.helperclasses.NutritionApiHelper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConcurrencyTests {

    NutritionApiHelper helper;

    @Before
    public void setup() {
        this.helper = new NutritionApiHelper();
    }

    @Test
    public void blocking_call() throws Exception {
        System.out.println("Request started");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Request finished");
    }

    @Test
    public void async_calc_practice() throws InterruptedException, ExecutionException {

        CompletableFuture<String> completableFuture = new CompletableFuture<>();

        Executors.newCachedThreadPool().submit(() -> {
            Thread.sleep(5000);
            completableFuture.complete("Hello");
            return null;
        });

        String result = completableFuture.get();
        Assert.assertEquals("Hello", result);
    }

    @Test
    public void async_calc_practice_2() throws InterruptedException, ExecutionException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hello");

        Assert.assertEquals("Hello", future.get());
    }

    @Test
    public void chaining_completable_futures() throws InterruptedException, ExecutionException{
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> "Hello")
                .thenCompose(s -> CompletableFuture.supplyAsync(() -> s + " World"));

        Assert.assertEquals("Hello World", completableFuture.get());
    }

    @Test
    public void running_multiple_futures_in_parallel() throws InterruptedException, ExecutionException {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "Beautiful");
        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> "World");

        // Combines result of all the completable futures
        String combined = Stream.of(future1, future2, future3)
                .map(CompletableFuture::join)
                .collect(Collectors.joining(" "));

        Assert.assertEquals("Hello Beautiful World", combined);
    }
}

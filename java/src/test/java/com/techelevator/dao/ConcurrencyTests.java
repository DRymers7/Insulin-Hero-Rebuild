package com.techelevator.dao;

import com.techelevator.dao.dao.MealDao;
import com.techelevator.dao.jdbcdao.JdbcMealDao;
import com.techelevator.helperclasses.NutritionApiHelper;
import com.techelevator.model.pojos.glycemicloadapi.recipeanalysis.IngredientAnalysis;
import com.techelevator.model.pojos.nutritionapi.wrappers.NutritionInfo;
import com.techelevator.services.GLLookupService;
import com.techelevator.services.NutritionLookupService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConcurrencyTests extends BaseDaoTests {

    RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
    private NutritionLookupService nutritionLookupService = new NutritionLookupService(restTemplateBuilder);
    private GLLookupService glLookupService = new GLLookupService(restTemplateBuilder);
    private NutritionApiHelper helper;
    private MealDao dao;

    @Before
    public void setup() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        dao = new JdbcMealDao(jdbcTemplate);
        this.helper = new NutritionApiHelper(nutritionLookupService, glLookupService, dao);
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

    @Test
    public void test_to_use_isDone() throws InterruptedException, ExecutionException {
        MyCallable callable1 = new MyCallable(1000);
        MyCallable callable2 = new MyCallable(2000);

        FutureTask<String> futureTask1 = new FutureTask<String>(callable1);
        FutureTask<String> futureTask2 = new FutureTask<String>(callable2);

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(futureTask1);
        executorService.execute(futureTask2);

        while (true) {
            try {
                if(futureTask1.isDone() && futureTask2.isDone()){
                    System.out.println("Done");
                    //shut down executor service
                    executorService.shutdown();
                    return;
                }

                if(!futureTask1.isDone()){
                    //wait indefinitely for future task to complete
                    System.out.println("FutureTask1 output="+futureTask1.get());
                }

                System.out.println("Waiting for FutureTask2 to complete");
                String s = futureTask2.get(200L, TimeUnit.MILLISECONDS);
                if(s !=null){
                    System.out.println("FutureTask2 output="+s);
                }
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                System.out.println("TIMEOUT");;
            }
        }
    }

    @Test
    public void test_one_for_nutrition_helper_async() throws InterruptedException, ExecutionException {

        String query1 = "Shrimp scampi";
        String query2 = "Fried chicken and mac and cheese";

        long start = System.currentTimeMillis();

        CompletableFuture<NutritionInfo> call1 = helper.getNutritionInfo(query1);
        CompletableFuture<NutritionInfo> call2 = helper.getNutritionInfo(query2);

        CompletableFuture.allOf(call1, call2).join();

        System.out.println("Elapsed time: " + (System.currentTimeMillis() - start));
        System.out.println("--> " + call1.get());
        System.out.println("--> " + call2.get());
    }

}

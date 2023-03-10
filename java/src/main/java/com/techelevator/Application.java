package com.techelevator;

import com.techelevator.exceptions.CustomAsyncExceptionHandler;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class Application implements AsyncConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

//    @Override
//    @Bean(name = "CICSEnabledTaskExecutor")
//    public Executor getAsyncExecutor()
//    {
//        return new DefaultManagedTaskExecutor();
//    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler()
    {
        return new CustomAsyncExceptionHandler();
    }

}



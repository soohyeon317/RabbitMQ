package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeoutException;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) throws InterruptedException, NoSuchAlgorithmException, KeyManagementException, TimeoutException, URISyntaxException, IOException {
        SpringApplication.run(DemoApplication.class, args);

        Publisher publisher = new Publisher();
        publisher.pub();

        Consumer consumer = new Consumer();
        consumer.cons();
    }

}


package com.example.demo;

import com.rabbitmq.client.*;
import lombok.Builder;
import lombok.Data;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeoutException;

@Data
@Builder
class Subscriber {
    void sub() throws NoSuchAlgorithmException, KeyManagementException, URISyntaxException, IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUri("amqp://guest:guest@192.168.220.129");
        factory.setConnectionTimeout(300000);
        Connection connection = factory.newConnection();

        Channel channel = connection.createChannel();
        channel.queueDeclare("my-queue", true, false, false, null);

        Channel channel2 = connection.createChannel();
        channel2.queueDeclare("my-queue2", true, false, false, null);

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            System.out.println("Recieved: " + message);

            channel2.basicPublish("", "my-queue2", null, message.getBytes());

            System.out.println("Sending to another MQ: " + message);
        };

        channel.basicConsume("my-queue",  true, deliverCallback, consumerTag -> {});


    }
}

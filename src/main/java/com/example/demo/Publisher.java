package com.example.demo;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import lombok.Builder;
import lombok.Data;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeoutException;

@Data
@Builder
class Publisher {
    public void pub() throws NoSuchAlgorithmException, KeyManagementException, URISyntaxException, IOException, TimeoutException, InterruptedException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUri("amqp://guest:guest@192.168.220.129");
        factory.setConnectionTimeout(300000);
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare("my-queue", true, false, false, null);

        int count = 0;

        while(count<5) {
            String message = "Message number" + count;

            channel.basicPublish("", "my-queue", null, message.getBytes());
            count++;
            System.out.println("Published message: " + message);

            Thread.sleep(3000);

        }
    }
}

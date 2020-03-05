package com.support.services;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class Producer {

    public void myProducer(){
        try {
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
            Connection connection = connectionFactory.createConnection();
            connection.start();

            Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);

            Destination destination = session.createTopic("JMS_TOPIC");

            MessageProducer producer = session.createProducer(destination);

            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
            String text = "hello World";
            TextMessage message = session.createTextMessage(text);
            producer.send(message);
            System.out.println("message sent from producer: ");
            session.close();
            connection.close();

        }catch (Exception e){

        }
    }

}

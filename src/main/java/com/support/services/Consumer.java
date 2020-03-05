package com.support.services;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class Consumer {


    public void myConsumer(){
        try {
            ConnectionFactory connectionFactory = new  ActiveMQConnectionFactory("tcp://localhost:61616");
            Connection connection = connectionFactory.createConnection();
            connection.start();

            Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);

            Destination destination = session.createTopic("JMS_TOPIC");

            MessageConsumer consumer = session.createConsumer(destination);

            consumer.setMessageListener(new MessageListener() {
                @Override
                public void onMessage(Message message) {
                    if(message instanceof  TextMessage){
                        TextMessage message1 = (TextMessage) message;
                        try {
                            System.out.println("Recieved message is: "+message1.getText());
                        } catch (JMSException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });

            session.close();
            connection.close();

        }catch (Exception e){

        }
    }

}

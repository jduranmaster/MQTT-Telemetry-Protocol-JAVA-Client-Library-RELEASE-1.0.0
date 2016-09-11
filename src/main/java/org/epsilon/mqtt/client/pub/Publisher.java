package org.epsilon.mqtt.client.pub;

import org.eclipse.paho.client.mqttv3.MqttException;
import org.epsilon.mqtt.client.AbstractMqttClient;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * An example MQTT publisher using Eclipse Paho client library,
 * Author: Jorge Durán Murillas.
 * Date: 7/19/14
 */
public class Publisher extends AbstractMqttClient{

    public static final String BROKER_URL = "tcp://test.mosquitto.org:1883";
    public static final String CLIENT_ID = "jduran-publisher";
    public static final String TOPIC = "jduran/test";

    private static final Logger logger = Logger.getLogger(Publisher.class.getName());


    public Publisher(String brokerUrl, String clientId) throws MqttException {
        super(brokerUrl, clientId, new PublisherCallback());
    }

    public void publish(String topic, String msg){
        try {
            getClient().publish(topic, msg.getBytes(), 1, true);
        } catch (MqttException e) {
            logger.log(Level.SEVERE, "Error publishing to broker.", e);
        }
    }

    public static void main(String[] args) throws MqttException {
        Publisher publisher = new Publisher(BROKER_URL, CLIENT_ID);
        System.out.println("Type in the message!");
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            String message = scanner.nextLine();
            if (!message.trim().toLowerCase().equals("quit")) {
                publisher.publish(TOPIC, message);
            } else {
                logger.info("Exit!.");
                publisher.disconnect();
            }
        }
    }
}

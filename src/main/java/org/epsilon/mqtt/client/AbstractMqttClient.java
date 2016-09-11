package org.epsilon.mqtt.client;

import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * An Abstract MQTT client implementation that is extended by publisher and the subscriber
 * Author: Jorge Durán Murillas.
 * Date: 7/19/14
 */
public class AbstractMqttClient {

    private static final Logger logger = Logger.getLogger(AbstractMqttClient.class.getName());

    private MqttClient client;

    public AbstractMqttClient(String brokerUrl, String clientId, MqttCallback callback) throws MqttException {
        try {
            client = new MqttClient(brokerUrl, clientId);
            client.setCallback(callback);
            client.connect();
            logger.info("Connected to " + brokerUrl + " with client-id " + clientId);
        } catch (MqttException e) {
            logger.log(Level.SEVERE, "Error instantiating the client", e);
            throw e;
        }
    }

    public void disconnect(){
        try {
            client.disconnect();
            logger.info("Disconnected from client.");
        } catch (MqttException e) {
            logger.log(Level.WARNING, "Error disconnecting!", e);
        } finally {
            if(client.isConnected()){
                try {
                    client.disconnect();
                } catch (MqttException e) {
                    logger.log(Level.WARNING, "Error disconnecting!", e);
                }
            }
        }
    }

    protected MqttClient getClient(){
        return client;
    }
}

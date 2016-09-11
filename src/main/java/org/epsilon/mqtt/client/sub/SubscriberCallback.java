package org.epsilon.mqtt.client.sub;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import java.util.logging.Logger;

/**
 * Subscriber callback
 * Author: Jorge Durán Murillas.
 * Date: 7/19/14
 */
public class SubscriberCallback implements MqttCallback {

    private static Logger logger = Logger.getLogger(SubscriberCallback.class.getName());

    @Override
    public void connectionLost(Throwable throwable) {
        logger.warning("Connection Lost!");
    }

    @Override
    public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {
        logger.info("Message Arrived. Topic: " + s + ", Message: " + new String(mqttMessage.getPayload()));
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {

    }
}

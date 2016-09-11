package org.epsilon.mqtt.client.pub;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import java.util.logging.Logger;

/**
 * Publisher callback. We use Qos levels greater than 0.
 * Author: Jorge Durán Murillas.
 * Date: 7/19/14
 */
public class PublisherCallback implements MqttCallback {

    private static Logger logger = Logger.getLogger(PublisherCallback.class.getName());

    @Override
    public void connectionLost(Throwable throwable) {
        logger.warning("Connection Lost!");
    }

    @Override
    public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {

    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
        logger.info("Delivery Complete!");
    }
}

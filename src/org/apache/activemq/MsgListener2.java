package org.apache.activemq;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class MsgListener2 implements MessageListener{

	@Override
	public void onMessage(Message msg) {
		try {
			System.out.println("Received2 topic msg:"+((TextMessage)msg).getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}

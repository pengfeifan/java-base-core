package org.apache.activemq;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class MsgListener1 implements MessageListener{

	@Override
	public void onMessage(Message msg) {
		try {
			System.out.println("Received1 topic msg:"+((TextMessage)msg).getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}

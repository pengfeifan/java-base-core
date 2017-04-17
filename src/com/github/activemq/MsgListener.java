package com.github.activemq;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class MsgListener implements MessageListener{

	@Override
	public void onMessage(Message msg) {
		try {
			System.out.println("Received msg:"+((TextMessage)msg).getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}

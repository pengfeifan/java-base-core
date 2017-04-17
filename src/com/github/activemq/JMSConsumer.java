package com.github.activemq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class JMSConsumer {

	private static final String USERNAME=ActiveMQConnection.DEFAULT_USER;//
	private static final String PASSWORD=ActiveMQConnection.DEFAULT_PASSWORD;//
	private static final String BROKEURL=ActiveMQConnection.DEFAULT_BROKER_URL;//
	
	public static void main(String[] args) {
		ConnectionFactory connectionFactory;//连接工厂
		Connection connection = null;//连接
		Session session;//会话 接受或者发送消息的线程
		Destination destination;//消息的目的地
		MessageConsumer messageConsumer;//消息生产者
		//实例化连接工厂
		connectionFactory=new ActiveMQConnectionFactory(JMSConsumer.USERNAME,JMSConsumer.PASSWORD,JMSConsumer.BROKEURL);
		try {
			connection=connectionFactory.createConnection();//通过连接工厂获取连接
			connection.start();//启动连接
			session=connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);//创建session
			destination=session.createQueue("firstQueue1");//创建连接的消息队列
			messageConsumer=session.createConsumer(destination);//创建消息生产者
			while(true){
				TextMessage textMessage=(TextMessage)messageConsumer.receive(100000);
				if(textMessage!=null){
					System.out.println("Receive message:"+textMessage.getText());
				}else{
					break;
				}
			}
		} catch (JMSException e) {
			e.printStackTrace();
		} 
	}
}

package com.github.activemq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

//http://localhost:8161/admin/
// admin/admin
public class JMSProducer {

	private static final String USERNAME=ActiveMQConnection.DEFAULT_USER;//
	private static final String PASSWORD=ActiveMQConnection.DEFAULT_PASSWORD;//
	private static final String BROKEURL=ActiveMQConnection.DEFAULT_BROKER_URL;//
	private static final int SENDNUM=10;//
	
	public static void main(String[] args) {
		ConnectionFactory connectionFactory;//连接工厂
		Connection connection = null;//连接
		Session session;//会话 接受或者发送消息的线程
		Destination destination;//消息的目的地
		MessageProducer messageProducer;//消息生产者
		//实例化连接工厂
		connectionFactory=new ActiveMQConnectionFactory(JMSProducer.USERNAME,JMSProducer.PASSWORD,JMSProducer.BROKEURL);
		try {
			connection=connectionFactory.createConnection();//通过连接工厂获取连接
			connection.start();//启动连接
			session=connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);//创建会话
			destination=session.createQueue("firstQueue1");//创建消息队列
			messageProducer=session.createProducer(destination);//创建消息生产者
			sendMessage(session,messageProducer);//发送消息
			session.commit();
		} catch (JMSException e) {
			e.printStackTrace();
		} finally{
			if(connection!=null){
				try {
					connection.close();
				} catch (JMSException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void sendMessage(Session session,MessageProducer messageProducer) {
		for(int i=0;i<JMSProducer.SENDNUM;i++){
			TextMessage message;
			try {
				message = session.createTextMessage("activeMQ send msg:"+i);
				System.out.println("Send :msg"+i);
				messageProducer.send(message);
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
	}
}

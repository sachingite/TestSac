package com.ibm.mq;

import javax.jms.Queue;
import javax.jms.QueueSender;
import javax.jms.Session;

import com.ibm.jms.JMSMessage;
import com.ibm.jms.JMSTextMessage;
import com.ibm.mq.jms.JMSC;
import com.ibm.mq.jms.MQQueueConnection;
import com.ibm.mq.jms.MQQueueConnectionFactory;
import com.ibm.mq.jms.MQQueueReceiver;
import com.ibm.mq.jms.MQQueueSender;
import com.ibm.mq.jms.MQQueueSession;

public class Test {

	public static void main(String[] args) {
		 
		try {
			MQQueueConnectionFactory cf = new MQQueueConnectionFactory();

		      // Config
		      cf.setHostName("localhost");
		      cf.setPort(1414);
		      cf.setTransportType(JMSC.MQJMS_TP_CLIENT_MQ_TCPIP);
		      cf.setQueueManager("CIMB.QM");
		      cf.setChannel("SYSTEM.DEF.SVRCONN");

		      MQQueueConnection connection = (MQQueueConnection) cf.createQueueConnection();
		      MQQueueSession session = (MQQueueSession) connection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
		      Queue queue = session.createQueue("queue:///Q_IN_FEEDER");
		      MQQueueReceiver receiver = (MQQueueReceiver) session.createReceiver(queue);
		      //QueueSender sender =  (MQQueueSender) session.createSender(queue);
		      

		      //JMSTextMessage message = (JMSTextMessage) session.createTextMessage("<test>xml</test>");     
		      //message.setJMSType("mcd://xmlnsc");
		      //message.setStringProperty("test.xml", "value");
		      
		      connection.start();

		    //sender.send(message);
		      //System.out.println("Sent message:\\n" + message);
		      
		      JMSMessage receivedMessage = (JMSMessage) receiver.receive(10000);
		      System.out.println("\\nReceived message:\\n" + receivedMessage);

		      //sender.close();
		      receiver.close();
		      session.close();
		      connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		}
}

package com.octo.xcite.jms;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Send Message
 *
 * @author <a href="mailto:tpe@octo.com">Thomas PEPIO</a>
 * @author <a href="mailto:clu@octo.com">Cedrick LUNVEN</a>
 */
@Component("messageProducer")
public class MessageProducer {
	
	/** logger. */
    private static Logger LOGGER = LoggerFactory.getLogger(MessageProducer.class);
   
	/** connection factory. */
	@Autowired
	private ConnectionFactory connFactory;
	
	/**
	 * Send message to queue.
	 *
	 * @param targetMsg
	 * 		message to send
	 * @param targetQ
	 * 		target Q
	 * @throws Exception
	 * 		exception on error
	 */
	public void sendTextMessageToQueue(String targetMsg, String targetQ)
	throws Exception {
		Connection jmsConnection = null;
		Session    jmsSession    = null;
		try {
			jmsConnection = connFactory.createConnection();
			jmsConnection.start();
			jmsSession = jmsConnection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			Destination testQueue = jmsSession.createQueue(targetQ);
			javax.jms.MessageProducer messageProducer = jmsSession.createProducer(testQueue);
			messageProducer.send(jmsSession.createTextMessage(targetMsg));
			messageProducer.close();
			LOGGER.info("Message has been sent (no TX)");
		} catch (JMSException e) {
			throw new RuntimeException("An error occured when sending message to queue");
		} finally {
			if (jmsSession != null)		jmsSession.close();
			if (jmsConnection != null)	jmsConnection.close();
		}
	}

}

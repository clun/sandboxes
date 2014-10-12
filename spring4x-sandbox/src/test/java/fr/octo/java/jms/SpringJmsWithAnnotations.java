package fr.octo.java.jms;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.octo.xcite.jms.MessageProducer;
import com.octo.xcite.spring4x.ApplicationConfig;
import com.octo.xcite.spring4x.MessageConsumerAnnotated;

/**
 * Spring JMS Sample test.
 * 
 * @author <a href="mailto:tpe@octo.com">Thomas PEPIO</a>
 * @author <a href="mailto:clu@octo.com">Cedrick LUNVEN</a>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-spring4x-ann.xml" })
public class SpringJmsWithAnnotations {

	@Autowired
	private MessageProducer msgProducer;
	
	@Test
	public void test() throws Exception {
		int nbMsgTosend = 10;
		String msg1 = "Here is the message : ";
		for (int idx = 0; idx < nbMsgTosend; idx++) {
			msgProducer.sendTextMessageToQueue(msg1 + idx, ApplicationConfig.QUEUETEST);
		}

		// Let the consumer time to work
		Thread.sleep(1000);

		Assert.assertEquals(nbMsgTosend, MessageConsumerAnnotated.totalProcessed);
	}

}

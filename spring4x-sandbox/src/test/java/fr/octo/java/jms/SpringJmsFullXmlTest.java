package fr.octo.java.jms;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.octo.xcite.jms.MessageConsumer;
import com.octo.xcite.jms.MessageProducer;

/**
 * Spring JMS Sample test.
 * 
 * @author <a href="mailto:tpe@octo.com">Thomas PEPIO</a>
 * @author <a href="mailto:clu@octo.com">Cedrick LUNVEN</a>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext-spring4x.xml"} )
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class SpringJmsFullXmlTest {
	
	@Autowired
    private MessageProducer msgProducer;
	
	@Value("${activemq.queueName}")
    private String targetQueueName;
	
	@Test
	public void test() throws Exception {
		int nbMsgTosend = 10;
		String msg1 = "Here is the message : ";
		for (int idx = 0;idx < nbMsgTosend; idx++) {
			msgProducer.sendTextMessageToQueue(msg1 + idx, targetQueueName);
		}

		// Let the consumer time to work
		Thread.sleep(1000);
		
		Assert.assertEquals(nbMsgTosend, MessageConsumer.totalProcessed);
	}
}

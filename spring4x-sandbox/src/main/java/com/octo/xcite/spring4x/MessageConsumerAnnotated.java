package com.octo.xcite.spring4x;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * Listener which will read messages from queue.
 *
 * @author <a href="mailto:tpe@octo.com">Thomas PEPIO</a>
 * @author <a href="mailto:clu@octo.com">Cedrick LUNVEN</a>
 */
@Component("messageConsumer")
public class MessageConsumerAnnotated {
	
	/** logger. */
    private static Logger LOGGER = LoggerFactory.getLogger(MessageConsumerAnnotated.class);
    
    /** Used for test results. */
    public static int totalProcessed = 0;
    
	/**
	 * Consume message only through annotation.
	 *
	 * @param msg
	 * 		target message as Text
	 */
	@JmsListener(containerFactory = "myContainerFactory", destination = ApplicationConfig.QUEUETEST)
	public void processMessage(String msg) {
		LOGGER.info("Votre message a été dépilé avec annotation {}", msg);
		totalProcessed++;
	}

}

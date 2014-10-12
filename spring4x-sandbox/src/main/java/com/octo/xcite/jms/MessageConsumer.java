package com.octo.xcite.jms;

import java.util.function.Consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Listener which will read messages from queue.
 *
 * @author <a href="mailto:tpe@octo.com">Thomas PEPIO</a>
 * @author <a href="mailto:clu@octo.com">Cedrick LUNVEN</a>
 */
public class MessageConsumer implements Consumer < String > {

	/** logger. */
    private static Logger LOGGER = LoggerFactory.getLogger(MessageConsumer.class);
    
    /** Used for test results. */
    public static int totalProcessed = 0;
   
	/** {@inheritDoc} */
	@Override
	public void accept(String msg) {
		LOGGER.info("Votre message a été dépilé {}", msg);
		totalProcessed++;
	}
}

package com.octo.xcite.spring4x;

import javax.jms.ConnectionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.support.destination.DynamicDestinationResolver;

/**
 * Application's configuration.
 */
@EnableJms
@Configuration
public class ApplicationConfig  {

	/**
	 * ActiveMQ broker injection
	 */
	@Autowired
	private ConnectionFactory jmsConnectionFactory;
	
	/** queue test. */
	public static final String QUEUETEST = "QTest";

	/**
	 * Configures the application.
	 * 
	 * @return a container factory.
	 */
	@Bean
	public DefaultJmsListenerContainerFactory myContainerFactory() {
		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
		factory.setConnectionFactory(jmsConnectionFactory);
		factory.setDestinationResolver(new DynamicDestinationResolver());
		factory.setConcurrency("3-10");
		return factory;
	}
}

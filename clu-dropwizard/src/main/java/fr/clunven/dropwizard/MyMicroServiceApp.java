package fr.clunven.dropwizard;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * Class principale executee en standalone.
 *
 * @author <a href="mailto:cedrick.lunven@gmail.com">Cedrick LUNVEN</a>
 */
public class MyMicroServiceApp extends Application<MyMicroServiceConf> {

    /** logger for this class. */
    protected final Logger log = LoggerFactory.getLogger(getClass());

    /** {@inheritDoc} */
    @Override
    public void initialize(Bootstrap<MyMicroServiceConf> bootstrap) {
    }

    /** {@inheritDoc} */
    @Override
    public void run(MyMicroServiceConf conf, Environment env) throws Exception {
        log.info("Configuration: " + conf.getMessage());
    }

    /**
     * HuDADA !
     * 
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        new MyMicroServiceApp().run(args);
    }

}

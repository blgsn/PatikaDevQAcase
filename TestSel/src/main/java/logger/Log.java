package logger;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
//Returning error, warning and info messages using log4j
public class Log {

    static Logger logger = Logger.getLogger(Log.class);

    public Log(){
        DOMConfigurator.configure("log4j.xml");
    }

    public void info(String message){
        logger.info(message);
    }

    public void warn(String message){
        logger.warn(message);
    }

    public void error(String message){
        logger.error(message);
    }

}

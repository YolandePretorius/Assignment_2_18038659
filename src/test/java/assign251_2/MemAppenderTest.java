package assign251_2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.spi.LoggingEvent;
import org.apache.velocity.runtime.log.Log;
import org.apache.velocity.runtime.log.LogManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class MemAppenderTest {
	Logger logList = Logger.getLogger("memoryList");
	MemAppender instanceMemAppender = MemAppender.getInstance();


	@BeforeEach
	void setUp() throws Exception {
		logList.addAppender(instanceMemAppender);
		instanceMemAppender.setLayout(new PatternLayout("%d{MMM dd yyyy HH:mm:ss} %5p [%t] (%F:%L) - %m%n"));
	}
	

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		instanceMemAppender.setEventsList(new ArrayList<LoggingEvent>());
		instanceMemAppender.setMaxListSize(3);
		logList.info("Adding a log to the list 1");
		logList.info("Adding a log to the list 2");
		logList.info("Adding a log to the list 3");
		logList.info("Adding a log to the list 4");
		//instanceMemAppender.setEventsList(new ArrayList<LoggingEvent>());
		//instanceMemAppender.eventsList.size();
		System.out.println(instanceMemAppender.eventsList.size());
		//logList.log(info, "Adding a log to the list");
		System.out.println(instanceMemAppender.getCurrentLogs().toString());
		//instanceMemAppender.getEventStrings();
		System.out.println(instanceMemAppender.getEventStrings());
		instanceMemAppender.printLogs();
	}

}

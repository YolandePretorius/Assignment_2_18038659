package assign251_2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.SimpleLayout;
import org.apache.log4j.spi.LoggingEvent;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StressTestMemAppender {
	
	Logger logList = Logger.getLogger("memoryList");
	MemAppender instanceMemAppender = MemAppender.getInstance();  // class MemAppender returns an instance

	
	@BeforeEach
	void setUp() throws Exception {
		logList.addAppender(instanceMemAppender);
		
		//instanceMemAppender.setLayout(new VelocityLayout( "[$p] $c $d: $m"));
		instanceMemAppender.setLayout(new PatternLayout( "[%p] %c %d: %m"));
		
		//instanceMemAppender.setEventsList(new ArrayList<LoggingEvent>());
		instanceMemAppender.setEventsList(new LinkedList<LoggingEvent>());
	
		instanceMemAppender.setMaxListSize(1000);		
	}

	@AfterEach
	void tearDown() throws Exception {
		instanceMemAppender.eventsList.clear();
	}

	@Test
	void testLinked() {
		for (int i = 0 ; i < 1000000 ;i++) {
			logList.info("Adding a log to the list"+i);
		};
		
	}

}

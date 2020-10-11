package assign251_2;



import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;

import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.SimpleLayout;
import org.apache.log4j.spi.LoggingEvent;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StressTestMemAppender {
	
	Logger logList = Logger.getLogger("memoryList");
	MemAppender instanceMemAppender; ;  // class MemAppender returns an instance
	 long startTime;
	 long endTime;

	
	@BeforeEach
	void setUp() throws Exception {
				
		instanceMemAppender = MemAppender.getInstance();  // class MemAppender returns an instance
		
		logList.addAppender(instanceMemAppender);
		
		instanceMemAppender.setLayout(new VelocityLayout( "[$p] $c $d: $m$n"));
		//instanceMemAppender.setLayout(new PatternLayout( "[%p] %c %d: %m%n"));
		
		//instanceMemAppender.setEventsList(new ArrayList<LoggingEvent>());
		instanceMemAppender.setEventsList(new LinkedList<LoggingEvent>());
	
		instanceMemAppender.setMaxListSize(1000);	
		
		startTime = System.currentTimeMillis();
	}

	@AfterEach
	void tearDown() throws Exception {
		instanceMemAppender.eventsList.clear();
		endTime = System.currentTimeMillis();
        System.out.println("Last  MemApender stress testcase exection time in millisecond : " + (endTime - startTime));
	}

	@Test
	void testLinked() {

		
		for (int i = 0 ; i < 1000000 ;i++) {
			logList.info("Adding a log to the list"+i);
			
		};
		
	}

}

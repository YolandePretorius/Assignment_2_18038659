package assign251_2;

import static org.junit.jupiter.api.Assertions.*;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class StressTestConsoleAppender {
	Logger logList = Logger.getLogger("console");
	ConsoleAppender conAppender;
	long startTime;
	long endTime;

	@BeforeEach
	void setUp() throws Exception {
		
		
		PatternLayout layout = new PatternLayout("[%p] %c %d: %m%n");
		//VelocityLayout layout = new VelocityLayout( "[$p] $c $d: $m%n");
		
		conAppender = new ConsoleAppender(layout, "console");
		logList.addAppender(conAppender);
		
		startTime = System.currentTimeMillis();
	
	}

	@AfterEach
	void tearDown() throws Exception {
		conAppender.close();
		endTime = System.currentTimeMillis();
		System.out.println("Last Console Apender stress testcase exection time in millisecond : " + (endTime - startTime));
	}

	@Test
	void test() {
		for (int i = 0 ; i < 1000000 ;i++) {
			logList.info("Adding a log to the list"+i);
		};
		
		
		
	}

}

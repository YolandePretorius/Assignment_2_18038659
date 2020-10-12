package assign251_2;

import static org.junit.jupiter.api.Assertions.*;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;



class StressTestConsoleAppender {
	Logger logList = Logger.getLogger("console");
	ConsoleAppender conAppender;
	long startTime;
	long endTime;

	@BeforeEach
	void setUp() throws Exception {
		
		
		//PatternLayout layout = new PatternLayout("[%p] %c %d: %m%n");
		VelocityLayout layout = new VelocityLayout( "[$p] $c $d: $m$n");
		
		conAppender = new ConsoleAppender(layout,"console");
		logList.addAppender(conAppender);
		
		startTime = System.currentTimeMillis();
	
	}

	@AfterEach
	void tearDown() throws Exception {
		//conAppender.close();
		endTime = System.currentTimeMillis();
		System.out.println("Last Console Apender stress testcase exection time in millisecond : " + (endTime - startTime));
	}

	@ParameterizedTest(name = "{index} => i =''{0}''")
	@ValueSource(ints = {100,1000,100000})
	void testLinked(int ints) {

		  for(int i = 0; i < ints;i++) { 
		
			logList.info("Adding a log to the list"+i);
		  }
		
	}

}

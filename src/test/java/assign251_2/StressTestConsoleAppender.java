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
	ConsoleAppender conAppender = new ConsoleAppender(null, "console");


	@BeforeEach
	void setUp() throws Exception {
		logList.addAppender(conAppender);
		conAppender.setLayout(new PatternLayout( "[%p] %c %d: %m"));
		//conAppender.setLayout(new VelocityLayout( "[$p] $c $d: $m"));
	
	
	}

	@AfterEach
	void tearDown() throws Exception {
		
	}

	@Test
	void test() {
		for (int i = 0 ; i < 1000000 ;i++) {
			logList.info("Adding a log to the list"+i);
		};
		
		
		
	}

}

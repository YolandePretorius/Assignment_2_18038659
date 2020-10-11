package assign251_2;

import static org.junit.jupiter.api.Assertions.*;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StressTestFileAppender {

	Logger logList = Logger.getLogger("File");
	 long startTime;
	 long endTime;
	 FileAppender fileAppender;
	 

	@BeforeEach
	void setUp() throws Exception {
		
		String filePath = "TestFile.txt";
		PatternLayout layout = new PatternLayout("[%p] %c %d: %m%n");
		 fileAppender = new FileAppender(layout,filePath);
		//VelocityLayout layout = new VelocityLayout( "[$p] $c $d: $m%n");
		//FileAppender fileAppender = new FileAppender(layout,filePath);
		
		
		logList.addAppender(fileAppender);
		
		startTime = System.currentTimeMillis();
		

	
	}

	@AfterEach
	void tearDown() throws Exception {
		fileAppender.close();
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

package assign251_2;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.junit.AfterClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


class StressTestFileAppender {
	
	 long startTime;
	 long endTime;
	FileAppender fileAppender;
	 Logger logList = Logger.getLogger("File");
	
	 		

	 

	 @BeforeEach
	void setUp() throws Exception {	
		 
		startTime = System.currentTimeMillis();
		
		//PatternLayout layout = new PatternLayout("[%p] %c %d: %m%n");

		VelocityLayout layout = new VelocityLayout( "[$p] $c $d: $m%n");
	
		String filePath = ("TestFile.txt");
		fileAppender = new FileAppender(layout,filePath);
		logList.addAppender(fileAppender);

	
	}
		

	@AfterClass
	void tearDown() {
		fileAppender.close();
		endTime = System.currentTimeMillis();
		System.out.println("Last Console Apender stress testcase exection time in millisecond : " + (endTime - startTime));
	}
	
	@ParameterizedTest(name = "{index} => i =''{0}''")
	@ValueSource(ints = {100,1000,1500,100000}) 
	void testLinked(int ints) {

		  for(int i = 0; i <= ints;i++) { 
		
			logList.info("Adding a log to the list"+i);
		
		  }
	}

}

package assign251_2;

import static org.junit.jupiter.api.Assertions.*;

import org.apache.log4j.Logger;
import org.apache.velocity.runtime.log.Log;
import org.apache.velocity.runtime.log.LogManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class MemAppenderTest {
	Logger logList = Logger.getLogger("memoryList");
	MemAppender appender = new MemAppender();

	@BeforeEach
	void setUp() throws Exception {
		logList.addAppender(appender);
	}
	

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		
		logList.info("Adding a log to the list");
		
	
	}

}

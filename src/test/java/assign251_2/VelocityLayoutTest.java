package assign251_2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggingEvent;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VelocityLayoutTest {
	
	Logger logList = Logger.getLogger("memoryList");
	MemAppender instanceApender = MemAppender.getInstance();  // class MemAppender returns an instance

	@BeforeEach
	void setUp() throws Exception {
		logList.addAppender(instanceApender);
	
		instanceApender.setEventsList(new ArrayList<LoggingEvent>());

		instanceApender.setMaxListSize(3);	}

	@AfterEach
	void tearDown() throws Exception {
		instanceApender.eventsList.clear();
	}

	@Test
	void test() {
		instanceApender.setLayout(new VelocityLayout( "[$p] $c $d: $m"));
		
	}

}

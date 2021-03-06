package assign251_2;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;


import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.SimpleLayout;
import org.apache.log4j.spi.LoggingEvent;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class MemAppenderTest {

	Logger logList = Logger.getLogger("memoryList");
	MemAppender instanceMemAppender = MemAppender.getInstance();  // class MemAppender returns an instance


	@BeforeEach
	void setUp() throws Exception {


		logList.addAppender(instanceMemAppender);

		//instanceMemAppender.setLayout(new PatternLayout( "%-5p [%t]: %m%n"));
		//instanceMemAppender.setLayout(new VelocityLayout( "[$p] $c $d: $m"));
		//instanceMemAppender.setLayout(new SimpleLayout());

		instanceMemAppender.setEventsList(new ArrayList<LoggingEvent>());

		instanceMemAppender.setMaxListSize(3);	


	}

	@AfterEach
	void tearDown() throws Exception {
		instanceMemAppender.eventsList.clear();

	}

	// Test if only one instance of object MemSpender is created by comparing two instances of an objects adresses
	@Test
	void testSingleton() {
		MemAppender onOtherInstanceMemAppender = MemAppender.getInstance();  // class MemAppender returns an instance	
		assertEquals(onOtherInstanceMemAppender, instanceMemAppender);
	}

	@Test
	void testunmodListException(){
	
		Exception exception = assertThrows(UnsupportedOperationException.class,() ->{
			List<LoggingEvent> list = instanceMemAppender.getCurrentLogs();
			LoggingEvent LoggingEvent = null;
			list.add(LoggingEvent);
			
		});

		assertEquals("java.lang.UnsupportedOperationException", exception.toString());
	
	}


	// After printing logs the list should be cleared thus its size should be zero
	@Test
	void testPrintLogs() {
		instanceMemAppender.printLogs();
		assertEquals(instanceMemAppender.eventsList.size(),0);
	}


	// test if old logs removed when new logs are added
	@Test
	void testAppend() {
		instanceMemAppender.setLayout(new VelocityLayout( "[$p] $c $d: $m"));
		logList.debug("Adding a log to the list 1");
		logList.debug("Adding a log to the list 2");
		logList.info("Adding a log to the list 3");
		logList.info("Adding a log to the list 4");
		int index = instanceMemAppender.getMaxListSize()-1;
		assertTrue(instanceMemAppender.getEventStrings().get(index).contains("Adding a log to the list 4"));
		assertTrue(instanceMemAppender.getEventStrings().get(0).contains("Adding a log to the list 2"));
		assertEquals(instanceMemAppender.getCounterDiscardedLogs(),1);
		instanceMemAppender.printLogs();
	}

	//Test if Layout is set to null if the getEventStrings function still stores the log
	@Test
	void testgetEventStringsLogs(){
		instanceMemAppender.setLayout(null);
		logList.info("Adding a log to the list 1");


		assertEquals(instanceMemAppender.getLayout(),null);
		assertTrue(instanceMemAppender.getEventStrings().get(0).contains("Adding a log to the list 1"));
	}


}

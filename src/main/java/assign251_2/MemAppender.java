package assign251_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.LongAdder;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.Layout;
import org.apache.log4j.spi.LoggingEvent;

public class MemAppender extends AppenderSkeleton {

	public List<LoggingEvent> eventsList = new ArrayList();
	private Layout layoutApender = null;
	private long counterDiscardedLogs = 0;
	private int maxListSize;
	
	private static MemAppender instance = new MemAppender(); // create instance of class so that only one instance is created
		
	public long getCounterDiscardedLogs() {
		return counterDiscardedLogs;
	}

	
	private MemAppender() {
	}

	public static MemAppender getInstance() { 
		return instance;  
	}

	public List<LoggingEvent> getEventsList() {
		return eventsList;
	}

	public void setEventsList(List<LoggingEvent> eventsList) {
		this.eventsList = eventsList;
	}

	@Override
	public boolean requiresLayout() {
		return true;
	}

	@Override
	protected void append(LoggingEvent event) {
		if (eventsList.size() < maxListSize) {
			eventsList.add(event);
		}
		else {
			eventsList.remove(0);
			eventsList.add(event);
			counterDiscardedLogs +=1; 
			
		}
	}
	

	@Override
	public void close() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setLayout(Layout layout) {
		layoutApender = layout;
		super.setLayout(layout);
	}

	public Layout getLayout() {
		return layout;
	}

	public List<LoggingEvent> getCurrentLogs() {
		List<LoggingEvent> eventsListUnMod = Collections.unmodifiableList(eventsList);
		return eventsListUnMod;
	}

	public List<String> getEventStrings() {

		List<String> listString = new ArrayList<String>();

		for (LoggingEvent item : eventsList) {

			if (layoutApender != null) {
				listString.add(layoutApender.format(item));
			} else {
				listString.add(item.toString());
			}

		}
		return Collections.unmodifiableList(listString);

	}

	public void printLogs() {
		if(eventsList.isEmpty()){
			System.out.println("No items to print");
		}
		else {
			for (LoggingEvent item : eventsList) {
				if (layoutApender != null) {
					System.out.println(layoutApender.format(item));
				} else {
					System.out.println(item.toString());
				}

			}
		eventsList.clear();
		}
	}
		

		public int getMaxListSize() {
			return maxListSize;
		}

		public void setMaxListSize(int maxListSize) {
			this.maxListSize = maxListSize;
		}
		
		
}

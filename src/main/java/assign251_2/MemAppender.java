package assign251_2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;

public class MemAppender extends AppenderSkeleton{
	
	private ArrayList<LoggingEvent>  eventsList = new ArrayList();
	 
	@Override
	public boolean requiresLayout() {
		
		return false;
	}

	public ArrayList<LoggingEvent> getEventsList() {
		return eventsList;
	}
	

	public void setEventsList(ArrayList<LoggingEvent> eventsList) {
		this.eventsList = eventsList;
	}

	@Override
	protected void append(LoggingEvent event) {
			eventsList.add(event);
	
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}
	
	
	

}

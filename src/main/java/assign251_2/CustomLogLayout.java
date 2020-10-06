package assign251_2;

import org.apache.log4j.PatternLayout;
import org.apache.log4j.spi.LoggingEvent;
import org.apache.velocity.app.Velocity;

public class CustomLogLayout  extends PatternLayout {
	
	
	public CustomLogLayout(LoggingEvent event)
	{
		super.format(event);
		
	}
	
	public String format(LoggingEvent event) {
		return null;
	}
}

package assign251_2;

import java.util.Date;

import org.apache.log4j.Level;
import org.apache.log4j.Priority;
import org.apache.log4j.spi.LoggingEvent;

import com.sun.javafx.sg.prism.NGLine;

public class VelocityVaraibles {
	
	//private String c = event;
	private String c;
	private long d; 
	private String m;
	private Priority p;
	private String t;
	//private NGLine n; 
	
	
	public VelocityVaraibles(LoggingEvent event) {
			//this.c = event.categoryName;
			//this.d = event.getTimeStamp();
			this.m = event.getRenderedMessage();
			this.p = event.getLevel();
			//this.t = event.getThreadName();
			//this.n = event.
			
			
		
	}


	public String getM() {
		return m;
	}


	public void setM(String m) {
		this.m = m;
	}
}

	
package assign251_2;

import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Layout;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.Priority;
import org.apache.log4j.spi.LoggingEvent;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.context.Context;

public class VelocityLayout extends PatternLayout {
	
	String formatString;	

	public String getFormatString() {
		return formatString;
	}

	public void setFormatString(String formatString) {
		formatString = formatString;
	}

	public VelocityLayout(String string) {
		this.formatString = string;
	}

	@Override
	public void activateOptions() {
		// TODO Auto-generated method stub

	}
	
	@Override
	public String format(LoggingEvent event) {

		try {
			Timestamp date = new Timestamp(event.timeStamp);
			java.util.Date dateformat = new java.util.Date(date.getTime());
			
			VelocityContext context = new VelocityContext();
			context.put("m", event.getMessage().toString());
			context.put("d",dateformat);
			context.put("p", event.getLevel());
			context.put("c", event.getLoggerName());
			context.put("t", event.getThreadName());
			context.put("n", "\n");

			StringWriter out = new StringWriter();
			Velocity.evaluate(context, out, "logTag", formatString);
			out.close();
			return out.toString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}




	@Override
	public boolean ignoresThrowable() {
		// TODO Auto-generated method stub
		return false;
	}

}

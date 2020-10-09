package assign251_2;

import java.io.FileWriter;
import java.io.IOException;

import org.apache.log4j.Layout;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.Priority;
import org.apache.log4j.spi.LoggingEvent;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.context.Context;

public class VelocityLayout extends Layout {
	
	

	public VelocityLayout(String string) {
	//VelocityVaraibles velocityVar = new VelocityVaraibles();
	}

	@Override
	public void activateOptions() {
		// TODO Auto-generated method stub

	}
	
	@Override
	public String format(LoggingEvent event){
		VelocityVaraibles velocityVar = new VelocityVaraibles(event);
		System.out.println(velocityVar);
		return VelocityMerger(velocityVar);
	
	
	}
	
public String VelocityMerger(VelocityVaraibles velocityVar){
		
		VelocityContext context = new VelocityContext();
		context.put("event",velocityVar);
		
		Template template = Velocity.getTemplate("template.vm");
		
		try {
		FileWriter out = new FileWriter("velocityLayOut.html");		
		
		template.merge((Context) velocityVar, out);
		
		
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		return null;
	}
/*
	@Override
	public String format(LoggingEvent event){
		
		VelocityContext context = new VelocityContext();
		context.put("event",event);
		
		Template template = Velocity.getTemplate("template.vm");
		
		try {
		FileWriter out = new FileWriter("velocityLayOut.html");		
		
		template.merge(event, out);
		
		
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		return null;
	}
*/
	@Override
	public boolean ignoresThrowable() {
		// TODO Auto-generated method stub
		return false;
	}

}

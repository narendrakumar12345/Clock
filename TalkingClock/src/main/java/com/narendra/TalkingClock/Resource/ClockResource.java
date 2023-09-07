package com.narendra.TalkingClock.Resource;

import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.narendra.TalkingClock.Service.ClockService;
import com.narendra.TalkingClock.model.Time;

@RestController
@RequestMapping("/talkingClock")
public class ClockResource {
	
	@Autowired
	ClockService clockService;

	@RequestMapping({"","/{time}"})
    public Time getTime(@PathVariable( required=false) String time) {
	      LocalTime lt=null;
	      try {
	    	  if(time==null)
	    	  {
	    		  lt= LocalTime.now();
	    	  }
	    	  else
	    		  lt=LocalTime.parse(time);
	      }
	      catch(Exception e) {
	    	  System.err.println("Error: " +e);
	      }

		time=clockService.printWords(lt.getHour(),lt.getMinute());
        return new Time(time);
    }	
}

package git.timer;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.ScheduleExpression;
import javax.ejb.Startup;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerConfig;
import javax.ejb.TimerService;
import javax.inject.Singleton;

;

@Singleton
@LocalBean
@Startup
public class SendMailTimer {
	
	private TimerService timerService;
	
	@PostConstruct
	private void init(){
		TimerConfig timerConfig = new TimerConfig();
		timerConfig.setInfo("CalendarProgTimerDemo_Info");
		ScheduleExpression schedule = new ScheduleExpression();
		schedule.hour("*").minute("*").second("13,34,57");
		timerService.createCalendarTimer(schedule, timerConfig); 
	}

	@Timeout
	public void execute(Timer timer){
		System.out.println("Timer Service : " + timer.getInfo());
		System.out.println("Execution Time : " + new Date());
	}

}

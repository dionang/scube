package utils;

import java.util.Map;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.quartz.CronScheduleBuilder;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import com.opensymphony.xwork2.ActionContext;

import utils.QuartzJob;

public final class QuartzHelper{
	public static final String newSchedule(ActionContext ac,JobDetail job, String cronScheduleTime){
		//JobDetail job = JobBuilder.newJob(QuartzJob.class).withIdentity("anyJobName", "group1").build();
		Map map= job.getJobDataMap();
		map.put("ActionContext", ac);
		try {
	
			Trigger trigger = TriggerBuilder.newTrigger().withIdentity("anyTriggerName", "group1")
					.withSchedule(CronScheduleBuilder.cronSchedule(cronScheduleTime)).build();
			Scheduler scheduler = new StdSchedulerFactory().getScheduler();
			scheduler.start();
			 
			scheduler.scheduleJob(job, trigger);
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
		return "success";
	}
	
	private String destory(){
		try {
			Scheduler scheduler = new StdSchedulerFactory().getScheduler();
			
			JobKey jk=new JobKey("anyJobName","group1");
			scheduler.deleteJob(jk);
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
		return "success";
	}
}

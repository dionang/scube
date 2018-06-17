package utils;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import com.opensymphony.xwork2.ActionSupport;

public class QuartzPlugin extends ActionSupport implements ServletContextListener {
	
	public void contextDestroyed(ServletContextEvent arg0) {
		//
	}
	public void contextInitialized(ServletContextEvent arg0) {
		Scheduler scheduler = null;
		try {
			scheduler = new StdSchedulerFactory().getScheduler();
			scheduler.start();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
		QuartzJobAttrHelper jobHelper = new QuartzJobAttrHelper();
		HashMap<String,String>jobMap = jobHelper.getQuartzJob();
		int jobNo =1;
		while(Validator.isNotNull(jobMap.get(jobNo+".quartz.jobGroup"))){

			String jobGroup = jobMap.get(jobNo+".quartz.jobGroup");
			String jobName = jobMap.get(jobNo+".quartz.jobName");
			String jobType = jobMap.get(jobNo+".quartz.jobType");
			String triggerGroup = jobMap.get(jobNo+".quartz.triggerGroup");
			String cronExpression = jobMap.get(jobNo+".quartz.cronExpression");
			String invokeClassPath = jobMap.get(jobNo+".quartz.invokeClassPath");
			String invokeClassLookupForEJB = jobMap.get(jobNo+".quartz.invokeClassLookupForEJB");
			String invokeClassMethod = jobMap.get(jobNo+".quartz.invokeClassMethod");

			JobDetail job = JobBuilder.newJob(QuartzJob.class).withIdentity(jobName, jobGroup).build();
			Map map = job.getJobDataMap();
			
			map.put(jobNo+".quartz.jobType", jobType);
			map.put(jobNo+".quartz.invokeClassPath", invokeClassPath);
			map.put(jobNo+".quartz.invokeClassMethod", invokeClassMethod);
			
			if("EJB".equals(jobType)){
			map.put(jobNo+".quartz.invokeClassLookupForEJB", invokeClassLookupForEJB);
			}
			
			try {
				Trigger trigger = TriggerBuilder.newTrigger().withIdentity(jobName, triggerGroup) .withSchedule( CronScheduleBuilder.cronSchedule(cronExpression)).build();

				scheduler.scheduleJob(job, trigger);
			} catch (SchedulerException e) {
				e.printStackTrace();
			}
			jobNo++;
			System.out.print("Scheduled job:"+jobName+" scheduler cron expression:"+cronExpression);


		}
	}
}

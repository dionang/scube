package utils;

import java.util.HashMap;

public class QuartzJobAttrHelper {

	public HashMap<String,String> getQuartzJob(){
		HashMap<String,String> hm1 = new HashMap<String,String>();
		hm1.put("1.quartz.jobGroup","SYSTEM");
		hm1.put("1.quartz.jobName","Event Log Archive");
		hm1.put("1.quartz.jobType", "EJB");
		hm1.put("1.quartz.triggerGroup", "SYSTEM");
		hm1.put("1.quartz.cronExpression", "59 59 23 L * ?");
		hm1.put("1.quartz.invokeClassPath", "com.setup.elm.ejb.ElmCtlr");
		hm1.put("1.quartz.invokeClassLookupForEJB", "java:global/ear/all/ElmCtlrBean!com.setup.elm.ejb.ElmCtlr");
		hm1.put("1.quartz.invokeClassMethod", "archiveEventLogs");
		
		return hm1;
	}
}

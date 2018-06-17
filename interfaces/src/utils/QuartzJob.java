package utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;


public class QuartzJob implements Job{
	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		Map jobDataMap = context.getJobDetail().getJobDataMap();
		Object[] params={};
		Class[] paramTypes={};
		if(Validator.isNotNull(jobDataMap)){
			int jobNo=1;
			while(Validator.isNotNull(jobDataMap.get(jobNo+".quartz.jobType"))){
				String jobType = (String)jobDataMap.get(jobNo+".quartz.jobType");
				String invokeClassPath= (String)jobDataMap.get(jobNo+".quartz.invokeClassPath");
				String invokeClassMethod=(String)jobDataMap.get(jobNo+".quartz.invokeClassMethod");
				String invokeClassLookupForEJB=(String)jobDataMap.get(jobNo+".quartz.invokeClassLookupForEJB");
				try{				

					Class classToInvoke = Class.forName(invokeClassPath);
					Method method = classToInvoke.getMethod(invokeClassMethod, paramTypes);
					if("action".equals(jobType)){
						Object objClass = classToInvoke.newInstance();
						method.invoke(objClass, params);
					}
					if("EJB".equals(jobType)){
						InitialContext initialContext = new InitialContext();
						Object objClass = initialContext.lookup(invokeClassLookupForEJB);
						method.invoke(objClass,params);
					}
				}catch(ClassNotFoundException cnfe){
					System.out.print("Class not found for "+invokeClassPath);
				}catch(IllegalAccessException iae){
					System.out.print("Illegal Access for class "+invokeClassPath);
				}catch(InstantiationException ie){
					System.out.print("Instantiation Error for class "+invokeClassPath);
				}catch(NoSuchMethodException nsme){
					System.out.print("No Such Method in "+invokeClassPath+":"+invokeClassMethod);
				}catch(InvocationTargetException ite){
					System.out.print("Invocation Target Exception when invoking method:"+invokeClassMethod+" in invokeClassPath");
				}catch(NamingException ne){
					System.out.print("Naming Exception when creating initial context");
				}
				jobNo++;
			}

		}
	}
}

package interceptors;


import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.opensymphony.xwork2.interceptor.ParametersInterceptor;

public class CheckLoginInterceptor implements Interceptor{
	
/**
	 * 
	 */
	private static final long serialVersionUID = 5722889044106603345L;
	
public String intercept(ActionInvocation invocation) throws Exception {
	   Map<String, Object> session=ActionContext.getContext().getSession();
       String className = invocation.getAction().getClass().getName();
       long startTime = System.currentTimeMillis();
       System.out.println("Before calling action: " + className);

       String result = invocation.invoke();

       long endTime = System.currentTimeMillis();
       System.out.println("After calling action: " + className
               + " Time taken: " + (endTime - startTime) + " ms");

       return result;
   }

   public void destroy() {
       System.out.println("Destroying MyLoggingInterceptor...");
   }
   public void init() {
       System.out.println("Initializing MyLoggingInterceptor...");
   }
}
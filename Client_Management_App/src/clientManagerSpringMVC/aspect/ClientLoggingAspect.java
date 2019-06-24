package clientManagerSpringMVC.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class ClientLoggingAspect {
	
	//set a logger
	private Logger logger = Logger.getLogger(getClass().getName());
	
	//set point cut declarations
	@Pointcut("execution(* clientManagerSpringMVC.Controller.*.*(..))")
	private void forControllerPackage() {}
	
	@Pointcut("execution(* clientManagerSpringMVC.service.*.*(..))")
	private void forServicePackage() {}
	
	@Pointcut("execution(* clientManagerSpringMVC.dao.*.*(..))")
	private void forDaoPackage() {}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {}
	
	//add @Before advice
	@Before("forAppFlow()")
	public void before(JoinPoint joinPoint) {
		String method = joinPoint.getSignature().toShortString();
		logger.info("@Before The method is: "+method);
		
		//display arguments(here it will show id)
		Object[] args = joinPoint.getArgs();
		for(Object arg:args) {
			logger.info("Arguments used in the method are: "+arg);
		}
		
	}
	
	//add @After advice		
	@AfterReturning(pointcut="forAppFlow()", returning="result")
	 public void afterReturning(JoinPoint joinPoint, Object result) {
		String method = joinPoint.getSignature().toShortString();
		logger.info("@AfterReturning The method is: "+method);
		
		//display data returned
		logger.info("Result: "+result);
		
	}
	
	
}

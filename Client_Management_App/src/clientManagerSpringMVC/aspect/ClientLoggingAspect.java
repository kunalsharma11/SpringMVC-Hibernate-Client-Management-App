package clientManagerSpringMVC.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class ClientLoggingAspect {
	
	//set a logger
	private Logger logger = Logger.getLogger(getClass().getName());
	
	//set point cut declarations
	@Pointcut("execution(* clientManagerSpringMVC.Controller.*.*.(..))")
	private void forControllerPackage() {}
	
	@Pointcut("execution(* clientManagerSpringMVC.service.*.*.(..))")
	private void forServicePackage() {}
	
	@Pointcut("execution(* clientManagerSpringMVC.dao.*.*.(..))")
	private void forDaoPackage() {}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {}
	
	//add @Before advice
}

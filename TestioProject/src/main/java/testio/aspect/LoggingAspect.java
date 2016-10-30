package testio.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by Mi on 27.10.16.
 */
@Aspect
@Component
public class LoggingAspect {
    
    @Before(value = "publicMethodsPointCut()")
    public void loggingPublicMethodsAdvice(){
        System.out.println("public method was called");
    }

    @Pointcut(value = "execution(public * testio.service..*(..))")
    public void publicMethodsPointCut(){}

    @Around(value = "publicMethodsPointCut()")
    public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint){
        String methodName = proceedingJoinPoint.getSignature().getName();
        System.out.printf("before method %s\n", methodName);

        Object value = null;

        try {
            value =  proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        System.out.printf("after method %s\n", methodName);

        return value;
    }

    
    
}

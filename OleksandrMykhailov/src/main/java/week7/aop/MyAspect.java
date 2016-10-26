package week7.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MyAspect {

 //   @Before("execution(public * *(..))")
    public void authorServiceAdvice(){
        System.out.println("Before service advice");
    }

    @Around("execution(public * *(..))")
    public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint){
        Signature signature = proceedingJoinPoint.getSignature();
        System.out.println(signature.toLongString());

        try{
            return proceedingJoinPoint.proceed(); // call method
        } catch (Throwable throwable){
            throwable.printStackTrace();
        }
        return null;
    }

  //  @Around("execution(public * AuthorService.getBooks(int))")
    public Object getBooksAroundAdvice(ProceedingJoinPoint proceedingJoinPoint){
        Signature signature = proceedingJoinPoint.getSignature();
        System.out.println(signature.toLongString());

        Integer arg1 = (Integer) proceedingJoinPoint.getArgs()[0];
        if(arg1 < 0){
            return null;
        }

        try{
            return proceedingJoinPoint.proceed(); // call method
        } catch (Throwable throwable){
            throwable.printStackTrace();
        }
        return null;
    }

}

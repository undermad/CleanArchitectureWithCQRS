package example.loggers;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class ControllerLogger {


    private static Logger logger = new Logger();

    @Pointcut("execution(* ectimel.controller..*(..))")
    public static void all() {
    }

    @Around("all()")
    public Object logAroundMethodCall(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        logger.info("Method called: " + joinPoint.getSignature().toShortString());
        logger.info("Arguments: " + Arrays.toString(joinPoint.getArgs()));

        Object result;
        try {
            result = joinPoint.proceed();
        } catch (Throwable throwable) {
            logger.info("Exception in method: " + joinPoint.getSignature().toShortString() + " with message: " + throwable.getMessage());
            throw throwable;
        }

        long timeTaken = System.currentTimeMillis() - startTime;
        logger.info("Method completed: " + joinPoint.getSignature().toShortString() + " in " + timeTaken + "ms");

        return result;
    }

}

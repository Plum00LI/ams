package ams.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAopAspect {

    private static final Logger logger = LoggerFactory.getLogger(LogAopAspect.class);


    @Around("execution(* ams.controller.*.*(..))")
    public Object process(ProceedingJoinPoint pjp) throws Throwable {

        Class<?> currentClass = pjp.getTarget().getClass();
        MethodSignature signature = (MethodSignature) (pjp.getSignature());
        String ClassName = currentClass.getSimpleName();
        String methodName = currentClass.getMethod(signature.getName(), signature.getParameterTypes()).getName();
        logger.info("======= 开始执行：" + ClassName + " — " + methodName + " ========");
        Object obj = pjp.proceed();
        logger.info("======= 执行结束：" + ClassName + " — " + methodName + " ========");
        return obj;

    }


}

package com.logtrace.internal;

import com.logtrace.annotation.LogTrace;
import com.logtrace.log.SysLog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.ConstructorSignature;
import org.aspectj.lang.reflect.MethodSignature;

import java.util.concurrent.TimeUnit;


@Aspect
public class LogTraceAjc {
	private static final String POINTCUT_METHOD = "execution(@com.logtrace.annotation.LogTrace * *(..))";
    private static final String POINTCUT_CONSTRUCTOR = "execution(@com.logtrace.annotation.LogTrace *.new(..))";


    @Pointcut(POINTCUT_METHOD)
    public void methodAnnotatedWithDebugTrace() {}

    @Pointcut(POINTCUT_CONSTRUCTOR)
    public void constructorAnnotatedDebugTrace() {}

    @Around("methodAnnotatedWithDebugTrace()")
    public Object weaveJoinPointMethod(ProceedingJoinPoint joinPoint) throws Throwable {
    	enterMethod(joinPoint);

        long startNanos = System.nanoTime();
        Object result = joinPoint.proceed();
        long stopNanos = System.nanoTime();
        long lengthMillis = TimeUnit.NANOSECONDS.toMillis(stopNanos - startNanos);

        exitMethod(joinPoint, result, lengthMillis);

        return result;
    }

    @Around("constructorAnnotatedDebugTrace()")
    public Object weaveJoinPointConstructor(ProceedingJoinPoint joinPoint) throws Throwable {
    	enterConstructor(joinPoint);

        long startNanos = System.nanoTime();
        Object result = joinPoint.proceed();
        long stopNanos = System.nanoTime();
        long lengthMillis = TimeUnit.NANOSECONDS.toMillis(stopNanos - startNanos);

        exitConstructor(joinPoint, result, lengthMillis);

        return result;
    }
    
    private static void enterMethod(JoinPoint joinPoint) {
    	MethodSignature signature = (MethodSignature) joinPoint.getSignature();
    	
        Class<?> cls = signature.getDeclaringType();
        String methodName = signature.getName();
        String[] parameterNames = signature.getParameterNames();
        Object[] parameterValues = joinPoint.getArgs();
        
        LogTrace annotation = signature.getMethod().getDeclaredAnnotation(LogTrace.class);
        int level = annotation.level();
        
        StringBuilder builder = new StringBuilder("\u21E2 ");
        builder.append(methodName).append('(');
        for (int i = 0; i < parameterValues.length; i++) {
        	if (i > 0) {
        		builder.append(", ");
        	}
        	builder.append(parameterNames[i]).append('=');
        	builder.append(Strings.toString(parameterValues[i]));
        }
        builder.append(')');

        builder.append(" [Thread:\"").append(Thread.currentThread().getName()).append("\"]");

        log(level,asTag(cls) + " "  + builder.toString());
        //LogUtils.log(asTag(cls), builder.toString());
	}

	private static void exitMethod(JoinPoint joinPoint, Object result, long lengthMillis) {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Class<?> cls = signature.getDeclaringType();
        String methodName = signature.getName();
        boolean hasReturnType = signature instanceof MethodSignature
            && ((MethodSignature) signature).getReturnType() != void.class;

        LogTrace annotation = signature.getMethod().getAnnotation(LogTrace.class);
        int level = annotation.level();
        
        StringBuilder builder = new StringBuilder("\u21E0 ")
            .append(methodName)
            .append(" [")
            .append(lengthMillis)
            .append("ms]");

        if (hasReturnType) {
        	builder.append(" = ");
        	builder.append(Strings.toString(result));
        }

        log(level,asTag(cls) + " "  + builder.toString());
        //LogUtils.log(asTag(cls), builder.toString());
	}
      
	private static void enterConstructor(JoinPoint joinPoint) {
    	ConstructorSignature signature = (ConstructorSignature) joinPoint.getSignature();
    	
        Class<?> cls = signature.getDeclaringType();
        String methodName = signature.getName();
        String[] parameterNames = signature.getParameterNames();
        Object[] parameterValues = joinPoint.getArgs();
        
        LogTrace annotation = signature.getConstructor().getDeclaredAnnotation(LogTrace.class);
        int level = annotation.level();
        
        StringBuilder builder = new StringBuilder("\u21E2 ");
        builder.append(methodName).append('(');
        for (int i = 0; i < parameterValues.length; i++) {
        	if (i > 0) {
        		builder.append(", ");
        	}
        	builder.append(parameterNames[i]).append('=');
        	builder.append(Strings.toString(parameterValues[i]));
        }
        builder.append(')');

        builder.append(" [Thread:\"").append(Thread.currentThread().getName()).append("\"]");

        log(level,asTag(cls) + " "  + builder.toString());
        //LogUtils.log(asTag(cls), builder.toString());
	}

	private static void exitConstructor(JoinPoint joinPoint, Object result, long lengthMillis) {
		ConstructorSignature signature = (ConstructorSignature) joinPoint.getSignature();
        Class<?> cls = signature.getDeclaringType();
        String methodName = signature.getName();
        boolean hasReturnType = signature instanceof MethodSignature
            && ((MethodSignature) signature).getReturnType() != void.class;

        LogTrace annotation = signature.getConstructor().getDeclaredAnnotation(LogTrace.class);
        int level = annotation.level();
        
        StringBuilder builder = new StringBuilder("\u21E0 ")
            .append(methodName)
            .append(" [")
            .append(lengthMillis)
            .append("ms]");

        if (hasReturnType) {
        	builder.append(" = ");
        	builder.append(Strings.toString(result));
        }

        log(level,asTag(cls) + " "  + builder.toString());
        //LogUtils.log(asTag(cls), builder.toString());
	}
	
	private static String asTag(Class<?> cls) {
		if (cls.isAnonymousClass()) {
			return asTag(cls.getEnclosingClass());
		}
		return cls.getSimpleName();
	}
	
	private static void log(int level,String message) {
        new SysLog().d(message);
		switch (level) {
		case 1:

			break;
		case 2:

			break;
		case 3:

			break;
		case 4:

			break;
		case 5:

			break;
		case 6:

			break;
		default:

			break;
		}
	}
}

package tuling;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;

import java.util.Arrays;

/**
 * Created by smlz on 2019/6/10.
 */
@Aspect
@Order
public class TulingLogAspect {

    @Pointcut("execution(* tuling.aspect.*.*(..))")
    public void pointCut(){};

//	@Around(value = "pointCut()")
//	public Object methodAround(ProceedingJoinPoint pjp) throws Throwable {
//		//定义返回值
//		Object rtValue = null;
//		try{
//			//前置通知
//			System.out.println("前置通知");
//			//1.获取参数
//			Object[] args = pjp.getArgs();
//			//2.执⾏切⼊点⽅法
//			rtValue = pjp.proceed(args);
//			//后置通知
//			System.out.println("后置通知");
//		}catch (Throwable t){
//			//异常通知
//			System.out.println("异常通知");
//			t.printStackTrace();
//		}finally {
//			//最终通知
//			System.out.println("最终通知");
//		}
//		return rtValue;
//	}

    @Before(value = "pointCut()")
    public void methodBefore(JoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("执行目标方法【"+methodName+"】的<前置通知>,入参"+ Arrays.asList(joinPoint.getArgs()));
    }

    @After(value = "pointCut()")
    public void methodAfter(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("执行目标方法【"+methodName+"】的<后置通知>,入参"+Arrays.asList(joinPoint.getArgs()));
    }

    @AfterReturning(value = "pointCut()",returning = "result")
    public void methodReturning(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("执行目标方法【"+methodName+"】的<返回通知>,入参"+Arrays.asList(joinPoint.getArgs()));
    }

    @AfterThrowing(value = "pointCut()")
    public void methodAfterThrowing(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("执行目标方法【"+methodName+"】的<异常通知>,入参"+Arrays.asList(joinPoint.getArgs()));
    }

}

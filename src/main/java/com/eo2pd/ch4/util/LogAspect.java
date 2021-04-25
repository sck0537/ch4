package com.eo2pd.ch4.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class LogAspect {


	public void myPointcut() {

	}


	public void mybefore(JoinPoint jp) {
		System.out.println("日志输出：" +jp.getTarget()+":"+ jp.getSignature().getName());
	}

	public Object myAround(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("【环绕前置通知】【"+ pjp.getSignature().getName()+"方法开始】");
		Object proceed = pjp.proceed();
		System.out.println("【环绕返回通知】【"+pjp.getSignature().getName()+"方法返回，返回值："+proceed+"】");
		return proceed;
	}
}

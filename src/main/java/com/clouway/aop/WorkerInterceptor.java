package com.clouway.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author Krasimir Raikov(raikov.krasimir@gmail.com)
 */
public class WorkerInterceptor implements MethodInterceptor {

  @Override
  public Object invoke(MethodInvocation methodInvocation) throws Throwable {
    Object o = methodInvocation.proceed();

    System.out.println("before work");
    return o;
  }
}

package com.clouway.aop;

import com.google.inject.AbstractModule;
import com.google.inject.matcher.Matchers;

/**
 * @author Krasimir Raikov(raikov.krasimir@gmail.com)
 */
public class WorkerModule extends AbstractModule {
  @Override
  protected void configure() {
    bindInterceptor(Matchers.any(), Matchers.annotatedWith(WorkerStatus.class), new WorkerInterceptor());
    }
}

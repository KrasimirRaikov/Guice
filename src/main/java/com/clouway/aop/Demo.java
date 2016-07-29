package com.clouway.aop;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author Krasimir Raikov(raikov.krasimir@gmail.com)
 */
public class Demo {
  public static void main(String[] args) {
    Injector injector = Guice.createInjector(new WorkerModule());
    Worker worker = injector.getInstance(Worker.class);
    System.out.println("The worker is "+worker.status());
  }
}

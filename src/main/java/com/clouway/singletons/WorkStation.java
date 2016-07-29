package com.clouway.singletons;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author Krasimir Raikov(raikov.krasimir@gmail.com)
 */
public class WorkStation {
  public static void main(String[] args) {
    Injector injector = Guice.createInjector(new WorkerModule());


    System.out.println("before the beginning of the work day");

    EagerWorker eagerWorker = injector.getInstance(EagerWorker.class);
    Worker worker = injector.getInstance(Worker.class);
  }
}

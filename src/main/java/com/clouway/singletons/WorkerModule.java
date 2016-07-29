package com.clouway.singletons;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;

/**
 * @author Krasimir Raikov(raikov.krasimir@gmail.com)
 */
public class WorkerModule extends AbstractModule {
  @Override
  protected void configure() {
    bind(EagerWorker.class).asEagerSingleton();
  }

  @Provides
  @Singleton
  public Worker getWorker() {
    return new Worker();
  }
}

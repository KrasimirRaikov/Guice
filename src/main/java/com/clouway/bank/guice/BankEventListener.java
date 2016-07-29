package com.clouway.bank.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;

/**
 * @author Krasimir Raikov(raikov.krasimir@gmail.com)
 */
public class BankEventListener extends GuiceServletContextListener {

  @Override
  protected Injector getInjector() {
    return Guice.createInjector(new BankModule(), new BankPersistentModule(), new BankServletModule());
  }
}

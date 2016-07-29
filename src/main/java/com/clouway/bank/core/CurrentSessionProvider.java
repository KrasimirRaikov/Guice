package com.clouway.bank.core;

import com.google.inject.Singleton;

/**
 * @author Krasimir Raikov(raikov.krasimir@gmail.com)
 */
@Singleton
public class CurrentSessionProvider implements SessionProvider {
  private Session session;

  public void set(Session newSession) {
    this.session = newSession;
  }

  public Session get() {
    return session;
  }
}

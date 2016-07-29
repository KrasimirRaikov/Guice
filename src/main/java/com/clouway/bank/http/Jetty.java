package com.clouway.bank.http;

import com.clouway.bank.guice.BankEventListener;
import com.google.inject.servlet.GuiceFilter;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;

import javax.servlet.DispatcherType;
import java.util.EnumSet;

/**
 * @author Krasimir Raikov(raikov.krasimir@gmail.com)
 */
public class Jetty {
  private Server server;

  /**
   * Jetty constructor to set up the servers port
   * and the database that the application uses
   *
   * @param port   the port that the server uses
   */
  public Jetty(int port) {
    this.server = new Server(port);
  }

  /**
   * Starts the server
   */
  public synchronized void start() {
    ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
    context.setContextPath("/");

    context.addFilter(GuiceFilter.class, "/*", EnumSet.allOf(DispatcherType.class));
    context.addServlet(DefaultServlet.class, "/");

    context.addEventListener(new BankEventListener());

    server.setHandler(context);
    try {
      server.start();
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  /**
   * stops the server
   */
  public void stop() {
    try {
      server.stop();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

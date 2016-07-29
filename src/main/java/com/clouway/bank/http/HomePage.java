package com.clouway.bank.http;

import com.clouway.bank.core.BankCalendar;
import com.clouway.bank.core.SessionRepository;
import com.clouway.utility.Template;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Krasimir Raikov(raikov.krasimir@gmail.com)
 */
@Singleton
public class HomePage extends HttpServlet {
  private Template template;
  private SessionRepository sessionRepository;
  private BankCalendar calendar;

  @Inject
  public HomePage(Template template, SessionRepository sessionRepository, BankCalendar calendar) {
    this.template = template;
    this.sessionRepository = sessionRepository;
    this.calendar = calendar;
  }

  @Override
  public void init() throws ServletException {
    template.loadFromFile("web/WEB-INF/pages/Home.html");
    template.put("message", "");
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    Integer onlineUsers = sessionRepository.countActive(calendar.getCurrentTime());
    if (onlineUsers == null) {
      template.put("message", "We have a problem with counting the online users.");
    } else {
      template.put("message", onlineUsers + " online users");
    }

    PrintWriter writer = response.getWriter();
    response.setContentType("text/html");
    writer.write(template.evaluate());
  }
}

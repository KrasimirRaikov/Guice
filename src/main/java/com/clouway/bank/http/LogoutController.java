package com.clouway.bank.http;

import com.clouway.bank.core.Session;
import com.clouway.bank.core.SessionProvider;
import com.clouway.bank.core.SessionRepository;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Krasimir Raikov(raikov.krasimir@gmail.com)
 */
@Singleton
public class LogoutController extends HttpServlet {
  private SessionRepository sessionRepository;
  private SessionProvider sessionProvider;

  @Inject
  public LogoutController(SessionRepository sessionRepository, SessionProvider sessionProvider) {
    this.sessionRepository = sessionRepository;
    this.sessionProvider = sessionProvider;
  }

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    Session session = sessionProvider.get();
    sessionRepository.remove(session.id);
    Cookie cookie = new Cookie("sessionId", session.id);
    cookie.setMaxAge(0);
    response.addCookie(cookie);
    response.sendRedirect("/login");
  }
}

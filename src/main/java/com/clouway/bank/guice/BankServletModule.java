package com.clouway.bank.guice;

import com.clouway.bank.core.BankCalendar;
import com.clouway.bank.core.SessionProvider;
import com.clouway.bank.core.SessionRepository;
import com.clouway.bank.http.*;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.servlet.ServletModule;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Krasimir Raikov(raikov.krasimir@gmail.com)
 */
public class BankServletModule extends ServletModule {

  @Override
  protected void configureServlets() {
    filter("/*").through(ConnectionFilter.class);
    filter("/*").through(HttprequestErrorReporter.class);
    filter("/*").through(SecurityFilter.class);

    serve("/login").with(LoginPage.class);
    serve("/logincontroller").with(LoginController.class);
    serve("/").with(HomePage.class);
    serve("/register").with(RegistrationPage.class);
    serve("/registercontroller").with(RegistrationController.class);
    serve("/deposit").with(DepositServlet.class);
    serve("/withdraw").with(WithdrawServlet.class);
    serve("/logoutcontroller").with(LogoutController.class);
    serve("/history").with(AccountHistoryPage.class);
  }


  @Provides
  @Singleton
  SecurityFilter getSecurityFilter(SessionRepository sessionRepository, BankCalendar bankCalendar, SessionProvider sessionProvider) {
    List<String> unsecuredPages = new ArrayList<>();
    unsecuredPages.add("/login");
    unsecuredPages.add("/logincontroller");
    unsecuredPages.add("/registercontroller");
    unsecuredPages.add("/register");
    return new SecurityFilter(sessionRepository, bankCalendar, unsecuredPages, sessionProvider);
  }
}

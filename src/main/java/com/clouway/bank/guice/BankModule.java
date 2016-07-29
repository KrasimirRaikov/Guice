package com.clouway.bank.guice;

import com.clouway.bank.core.*;
import com.clouway.bank.http.BankTimeCalendar;
import com.clouway.bank.http.validation.BankTransactionValidator;
import com.clouway.bank.http.validation.UserDataValidator;
import com.clouway.bank.persistent.DatabaseHelper;
import com.clouway.bank.persistent.PerRequestConnectionProvider;
import com.clouway.bank.persistent.PersistentAccountHistoryRepository;
import com.clouway.bank.persistent.PersistentAccountRepository;
import com.clouway.bank.persistent.PersistentSessionRepository;
import com.clouway.bank.persistent.PersistentUserRepository;
import com.clouway.utility.BracketsTemplate;
import com.clouway.utility.FileReader;
import com.clouway.utility.HtmlTableBuilder;
import com.clouway.utility.Reader;
import com.clouway.utility.TableBuilder;
import com.clouway.utility.Template;
import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * @author Krasimir Raikov(raikov.krasimir@gmail.com)
 */
public class BankModule extends AbstractModule {

  @Override
  protected void configure() {

    bind(Integer.class).annotatedWith(Names.named("pageSize")).toInstance(20);

    bind(Integer.class).annotatedWith(Names.named("sessionLiveLengthInMinutes")).toInstance(5);

    bind(String.class).annotatedWith(Names.named("bootstrapTablesClass")).toInstance("table table-hover table-bordered");

    bind(Calendar.class).toInstance(Calendar.getInstance());

    bind(Reader.class).to(FileReader.class);

    bind(Template.class).to(BracketsTemplate.class);

    bind(TableBuilder.class).to(HtmlTableBuilder.class);

    bind(BankCalendar.class).to(BankTimeCalendar.class);

    bind(SessionProvider.class).to(CurrentSessionProvider.class);

    bind(UserValidator.class).to(UserDataValidator.class);

    bind(TransactionValidator.class).to(BankTransactionValidator.class);

    bind(AccountPager.class).to(AccountHistoryPager.class);
  }

//  @Provides
//  AccountPager getAccountPage(AccountHistoryRepository accountHistoryRepository){
//    return new AccountHistoryPager(20, accountHistoryRepository);
//  }
//
//  @Provides
//  BankCalendar getBankTimeCalendar(){
//    return new BankTimeCalendar(Calendar.getInstance(), 5);
//  }
//
//  @Provides
//  TableBuilder getHtmlTableBuilder(){
//    return new HtmlTableBuilder("table table-hover table-bordered");
//  }
//
//  @Provides
//  Reader getFileReader(){
//    return new FileReader();
//  }
//
//  @Provides
//  Template getBracketsTemplate(Reader reader){
//    return new BracketsTemplate(reader);
//  }
//
//  @Provides
//  @Singleton
//  SessionProvider getCurrentSessionProvider(){
//    return  new CurrentSessionProvider();
//  }
//
//  @Provides
//  UserValidator getUserDataValidator(){
//    return  new UserDataValidator();
//  }
//
//  @Provides
//  TransactionValidator getBankTransactionValidator(){
//    return new BankTransactionValidator();
//  }
//
}

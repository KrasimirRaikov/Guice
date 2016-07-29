package com.clouway.bank.guice;

import com.clouway.bank.core.AccountHistoryRepository;
import com.clouway.bank.core.AccountRepository;
import com.clouway.bank.core.ConnectionProvider;
import com.clouway.bank.core.DataStore;
import com.clouway.bank.core.SessionRepository;
import com.clouway.bank.core.UserRepository;
import com.clouway.bank.persistent.DatabaseHelper;
import com.clouway.bank.persistent.PerRequestConnectionProvider;
import com.clouway.bank.persistent.PersistentAccountHistoryRepository;
import com.clouway.bank.persistent.PersistentAccountRepository;
import com.clouway.bank.persistent.PersistentSessionRepository;
import com.clouway.bank.persistent.PersistentUserRepository;
import com.google.inject.AbstractModule;

/**
 * @author Krasimir Raikov(raikov.krasimir@gmail.com)
 */
public class BankPersistentModule extends AbstractModule {
  @Override
  protected void configure() {

    bind(ConnectionProvider.class).to(PerRequestConnectionProvider.class);

    bind(DataStore.class).to(DatabaseHelper.class);

    bind(UserRepository.class).to(PersistentUserRepository.class);

    bind(SessionRepository.class).to(PersistentSessionRepository.class);

    bind(AccountRepository.class).to(PersistentAccountRepository.class);

    bind(AccountHistoryRepository.class).to(PersistentAccountHistoryRepository.class);

  }

//  @Provides
//  ConnectionProvider getConnectionProvider(){
//    return new PerRequestConnectionProvider();
//  }
//
//  @Provides
//  DataStore getDatabaseHelper(ConnectionProvider connectionProvider){
//    return new DatabaseHelper(connectionProvider);
//  }
//
//  @Provides
//  UserRepository getPersistentUserRepository(DataStore dataStore){
//    return new PersistentUserRepository(dataStore);
//  }
//
//  @Provides
//  SessionRepository getPersistentSessionRepository(DataStore dataStore){
//    return new PersistentSessionRepository(dataStore);
//  }
//
//  @Provides
//  AccountRepository getPersistentAccountRepository(DataStore dataStore){
//    return new PersistentAccountRepository(dataStore);
//  }
//
//  @Provides
//  AccountHistoryRepository getPersistentAccountHistoryRepository(DataStore dataStore){
//    return new PersistentAccountHistoryRepository(dataStore);
//  }
}

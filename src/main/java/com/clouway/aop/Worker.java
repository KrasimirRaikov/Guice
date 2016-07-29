package com.clouway.aop;

/**
 * @author Krasimir Raikov(raikov.krasimir@gmail.com)
 */
public class Worker {

  @WorkerStatus
  public String status(){
    return "working";
  }
}

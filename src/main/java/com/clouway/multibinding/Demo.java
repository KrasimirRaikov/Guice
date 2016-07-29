package com.clouway.multibinding;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author Krasimir Raikov(raikov.krasimir@gmail.com)
 */
public class Demo {
  public static void main(String[] args) {
    Injector injector = Guice.createInjector(new AnimalModule());
    AnimalFinder animalFinder = injector.getInstance(AnimalFinder.class);
    for (String presentAnimal: animalFinder.findAll()){
      System.out.println(presentAnimal);
    }

    System.out.println(animalFinder.find("cat"));
  }
}

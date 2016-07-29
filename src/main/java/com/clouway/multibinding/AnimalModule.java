package com.clouway.multibinding;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.MapBinder;
import com.google.inject.multibindings.Multibinder;

/**
 * @author Krasimir Raikov(raikov.krasimir@gmail.com)
 */
public class AnimalModule extends AbstractModule {
  @Override
  protected void configure() {
    Multibinder<Animal> animalBinder = Multibinder.newSetBinder(binder(), Animal.class);
    animalBinder.addBinding().to(Cat.class);
    animalBinder.addBinding().to(Dog.class);

    MapBinder<String, Animal> mapbinder
            = MapBinder.newMapBinder(binder(), String.class, Animal.class);
    mapbinder.addBinding("cat").to(Cat.class);
    mapbinder.addBinding("dog").to(Dog.class);
  }
}

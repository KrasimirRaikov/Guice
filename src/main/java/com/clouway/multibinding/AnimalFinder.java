package com.clouway.multibinding;

import com.google.inject.Inject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Krasimir Raikov(raikov.krasimir@gmail.com)
 */
public class AnimalFinder {
  private final Set<Animal> animals;
  private final Map<String, Animal> animalsMap;

  @Inject
  public AnimalFinder(Set<Animal> animals, Map<String, Animal> animalsMap) {
    this.animals = animals;
    this.animalsMap = animalsMap;
  }

  public List<String> findAll(){
    List<String> presentAnimals = new ArrayList<>();
    for (Animal animal: animals){
      presentAnimals.add(animal.identify()+" is present");
    }
    return presentAnimals;
  }

  String find(String animalName){
    return animalsMap.get(animalName).identify()+" is found";
  }

}

// Comparable & Comparator

package myPackage.j7Sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class SuperHeroX {
  private int id;
  private int age;
  private String name;

  public SuperHeroX(int id, int age, String name) {
    this.id = id;
    this.age = age;
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public int getAge() {
    return age;
  }

  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return "SuperHero [id=" + id + ", age=" + age + ", name=" + name + "]";
  }
}

public class ChainingComparators {
  public static void main(String[] args) {
    List<SuperHeroX> SuperHeroesX = new ArrayList<>();

    SuperHeroesX.add(new SuperHeroX(2, 35, "Iron Man"));
    SuperHeroesX.add(new SuperHeroX(2, 30, "Iron Man"));
    SuperHeroesX.add(new SuperHeroX(2, 25, "Iron Man"));
    SuperHeroesX.add(new SuperHeroX(1, 25, "Captain America"));
    SuperHeroesX.add(new SuperHeroX(3, 25, "Hulk"));
    SuperHeroesX.add(new SuperHeroX(3, 20, "Hulk"));

    // Chaining Comparators - sorting by Name & then by Age
    System.out.println("Sorting by Name & then Age - using Comparator");
    SuperHeroesX.forEach(superHero -> System.out.println(superHero.toString()));
    Collections.sort(SuperHeroesX, Comparator.comparing(SuperHeroX::getName).thenComparing(SuperHeroX::getAge));
    System.out.println();
    SuperHeroesX.forEach(superHero -> System.out.println(superHero.toString()));
    System.out.println();
  }
}

// Comparable & Comparator

package myPackage.j7Sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class SuperHero implements Comparable<SuperHero> {
  private int id;
  private int age;
  private String name;

  public SuperHero(int id, int age, String name) {
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

  @Override
  public int compareTo(SuperHero superHero) {
    return this.id - superHero.id;
  }
}

public class ComparableComparator {
  public static void main(String[] args) {
    List<SuperHero> SuperHeroes = new ArrayList<>();

    SuperHeroes.add(new SuperHero(2, 35, "Iron Man"));
    SuperHeroes.add(new SuperHero(1, 25, "Captain America"));
    SuperHeroes.add(new SuperHero(3, 20, "Hulk"));

    // Using Comparable - sorting by ID
    System.out.println("Sorting by ID - using Comparable");
    SuperHeroes.forEach(superHero -> System.out.println(superHero.toString()));
    Collections.sort(SuperHeroes, Collections.reverseOrder());
    System.out.println();
    SuperHeroes.forEach(superHero -> System.out.println(superHero.toString()));
    System.out.println();

    // Using Comparator - sorting by age
    System.out.println("Sorting by Age - using Comparator");
    SuperHeroes.forEach(superHero -> System.out.println(superHero.toString()));
    Comparator<SuperHero> superAge = (sh1, sh2) -> {
      return -1 * (sh1.getAge() - sh2.getAge());
    };
    Collections.sort(SuperHeroes, superAge);
    System.out.println();
    SuperHeroes.forEach(superHero -> System.out.println(superHero.toString()));
    System.out.println();

    // Using Comparator - sorting by name
    System.out.println("Sorting by Name - using Comparator");
    SuperHeroes.forEach(superHero -> System.out.println(superHero.toString()));
    Comparator<SuperHero> superName = (sh1, sh2) -> {
      return sh1.getName().compareTo(sh2.getName());
    };
    Collections.sort(SuperHeroes, superName);
    System.out.println();
    SuperHeroes.forEach(superHero -> System.out.println(superHero.toString()));
  }
}

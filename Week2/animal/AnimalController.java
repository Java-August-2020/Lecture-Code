package Aug2020.Week2.animal;

public class AnimalController {
  // Entry Point
  public static void main(String[] args) {
    Animal dog = new Animal(4, "black", "dog", 100);
    Animal cat = new Animal(4, "white", "cat", 100);
    System.out.println(cat.getHealth());
    dog.battle(cat, "Fireball");
    System.out.println(cat.getHealth());

    // Method Overloading.
    dog.battle(cat);
  }
}
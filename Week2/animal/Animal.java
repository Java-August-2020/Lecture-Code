package Aug2020.Week2.animal;

public class Animal {
  // Attributes
  private int numLegs;
  private String color;
  private String species;
  private int health;

  // Constructor
  public Animal(int numLegs, String color, String species, int health) {
    this.numLegs = numLegs;
    this.color = color;
    this.species = species;
    this.health = health;
  }

  public Animal(int numLegs, String color, String species) {
    this.health = 100;
    this.numLegs = numLegs;
    this.color = color;
    this.species = species;
  }

  // Getters and Setters
  public int getNumLegs() {
    return this.numLegs;
  }

  public void setNumLegs(int numLegs) {
    this.numLegs = numLegs;
  }

  public String getColor() {
    return this.color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public String getSpecies() {
    return this.species;
  }

  public void setSpecies(String species) {
    this.species = species;
  }

  public int getHealth() {
    return this.health;
  }

  public void setHealth(int health) {
    this.numLegs = health;
  }

  public void battle(Animal target, String powerMove) {
    int damage;
    if (powerMove.equals("Fireball")) {
      damage = 3;
    } else if (powerMove.equals("Roar")) {
      damage = 5;
    } else {
      System.out.println("Move is not recognized");
      return;
    }

    // reduce the target health
    target.health -= damage;

    // print to the console what just happened
    System.out.printf("%s attacks %s for %d damage points %n", this.species, target.species, damage);
  }

  public void battle(Animal target) {
    this.battle(target, "Roar");
  }

}
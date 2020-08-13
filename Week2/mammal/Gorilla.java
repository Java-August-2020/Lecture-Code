package Aug2020.Week2.mammal;

public class Gorilla extends Mammal {
  // directly calls Mammal constructor
  public Gorilla() {
    super("Gorilla", 500);
  }

  public void eatBanana() {
    this.setHealth(health + 10);
  }

  public void makeSound() {
    System.out.println("Stomps ground, pounds chest");
  }

  @Override
  public void takeDamage(int damageAmount) {
    this.health -= (damageAmount / 2);
  }

}
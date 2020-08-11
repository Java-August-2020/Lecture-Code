package Aug2020.Week2;

import java.util.Arrays;

public class PizzaMaker {
  // Entry Point Method
  public static void main(String[] args) {
    // Instantiating New Pizza Object
    // Pizza cheesePizza = new Pizza();
    // cheesePizza.toppings = new String[] { "cheese", "and thats all" };
    // cheesePizza.size = 'L';
    // cheesePizza.slices = 10;
    // cheesePizza.crustType = "thin crust";
    // System.out.println(Arrays.toString(cheesePizza.toppings));
    // Instantiating Pizza with Constructor
    Pizza pepperoniPizza = new Pizza(new String[] { "cheese", "pepperoni" }, 'L', "normal crust", 12);
    System.out.println(pepperoniPizza.eatSlices(5));
    System.out.println(pepperoniPizza.getSlices());
    Pizza meatLovers = new Pizza(new String[] { "sasuage", "pepperoni", "steak" }, "stuffed crust", 18);
    meatLovers.displayPizza();
    System.out.println(meatLovers.eatSlices(0.5));

  }
}
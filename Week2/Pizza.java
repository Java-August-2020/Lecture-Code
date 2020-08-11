package Aug2020.Week2;
// Attributes

// Toppings
// Size
// Crust Type
// Slices

// Methods
// Advertise
// EatSlice
// displayPizza
public class Pizza {
  private String[] toppings;
  private char size;
  private String crustType;
  private int slices;

  public Pizza(String[] toppings, String crustType, int slices) {
    this.toppings = toppings;
    this.size = 'L';
    this.crustType = crustType;
    this.slices = slices;
  }

  public Pizza(String[] toppings, char size, String crustType, int slices) {
    this.toppings = toppings;
    this.size = size;
    this.crustType = crustType;
    this.slices = slices;
  }

  public void setToppings(String[] toppings) {
    this.toppings = toppings;
  }

  public String[] getToppings() {
    return this.toppings;
  }

  public void setSize(char size) {
    this.size = size;
  }

  public char getSize() {
    return this.size;
  }

  public void setCrustType(String crustType) {
    if (crustType.equals("Deep Dish")) {
      System.out.println("We don't do that kind of pizza, get outta here");
      return;
    }
    this.crustType = crustType;
  }

  public String getCrustType() {
    return this.crustType;
  }

  public void setSlices(int slices) {
    this.slices = slices;
  }

  public int getSlices() {
    return this.slices;
  }

  public void displayPizza() {
    System.out.printf("This is a %s Crust pizza, with %d slices %n", this.crustType, this.slices);
  }

  public static void advertisement() {
    System.out.println("Psst.. hey you, check out these pizzas at these awesome prices");
  }

  public int eatSlices(int slices) {
    System.out.printf("You were hungry and ate %d slices %n", slices);
    this.slices -= slices;
    return this.slices;
  }

  public double eatSlices(double slices) {
    double eatenPizza = (double) this.slices;
    eatenPizza -= slices;
    System.out.println("You couldn't finish a full slice, so you ate " + slices + " of a slice");

    return eatenPizza;
  }
}
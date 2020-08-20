package Aug2020.Week2.mammal;

import java.util.ArrayList;

public class MammalController {
  public static void main(String[] args) {
    Mammal dolphin = new Mammal("Dolphin", 100);
    Gorilla dk = new Gorilla();

    ArrayList<Mammal> ourMammals = new ArrayList<Mammal>();
    ourMammals.add(dolphin);
    ourMammals.add(dk);

    for (Mammal m : ourMammals) {
      System.out.println(m.getSpecies());
    }

    
  }
}
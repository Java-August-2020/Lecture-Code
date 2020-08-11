package Aug2020.Week1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class puzzling {
  public static void main(String[] args) {
    Random r = new Random();
    ArrayList<Character> alphabet = new ArrayList<Character>();
    for (char ch = 'a'; ch <= 'z'; ++ch) {
      alphabet.add(ch);
    }

    System.out.println(alphabet);
    Collections.shuffle(alphabet);
    System.out.println(alphabet);

    int randomNum = r.nextInt(26);
    System.out.println("This is a random letter: " + alphabet.get(randomNum));
  }
}
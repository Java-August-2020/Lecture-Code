package Aug2020.Week1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Day2 {
  public static void main(String[] args) {
    // Arrays
    String[] people = new String[] { "Matthew", "Lily", "Blair", "Mike" };
    String[] notPresent = { "other people", "not here", "etc" };
    String[] newStringArray = new String[5];

    int[] numbers = new int[10];
    for (int i = 0; i < numbers.length; i++) {
      numbers[i] = i;
    }

    // ArrayList
    ArrayList<Integer> numsArrayList = new ArrayList<Integer>();
    numsArrayList.add(3);
    numsArrayList.add(35);
    numsArrayList.add(7);
    numsArrayList.add(19);
    numsArrayList.add(7);

    for (int i = 0; i < numsArrayList.size(); i++) {
      // System.out.println(numsArrayList.get(i));
    }

    for (Integer num : numsArrayList) {
      // System.out.println(numsArrayList.get(num));
    }

    // HashMaps
    HashMap<String, String> ourHobbies = new HashMap<String, String>();
    ourHobbies.put("Blair", "Music Maestro");
    ourHobbies.put("Lily", "Eating");
    ourHobbies.put("Mike", "Snowboarding");
    ourHobbies.put("Matt", "Photography");
    ourHobbies.put("Amanda", "WebFun");

    for (HashMap.Entry<String, String> map : ourHobbies.entrySet()) {
      System.out.println("Key: " + map.getKey() + " Value: " + map.getValue());
    }

    // Methods
    // System.out.println(Arrays.toString(numbers));
    // System.out.println(getMaxValue(numbers));

    // Errors
    for (int i = 0; i <= numbers.length; i++) {
      try {
        System.out.println(numbers[i]);
      } catch (Exception error) {
        System.out.println(error);
      }
    }

  }

  public static int getMaxValue(int[] nums) {
    // Get the biggest number from array
    // Loop Over Array, Compare each value before or after it
    // Return the biggest number from array
    int biggestNumber = nums[0];
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > biggestNumber) {
        System.out.println("here");
        biggestNumber = nums[i];
      }
    }

    return biggestNumber;
  }

}
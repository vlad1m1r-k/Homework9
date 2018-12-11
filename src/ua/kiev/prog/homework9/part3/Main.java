package ua.kiev.prog.homework9.part3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<Character, Integer> data = new HashMap<>(26);
        try {
            List<String> strings = Files.readAllLines(Paths.get("text.txt"));
            for (String string : strings) {
                for (int i = 0; i < string.length(); i++) {
                    String character = string.toLowerCase().substring(i, i + 1);
                    if (character.matches("[a-z]")) {
                        if (data.containsKey(character.charAt(0))){
                            int value = data.get(character.charAt(0));
                            value++;
                            data.replace(character.charAt(0), value);
                        } else {
                            data.put(character.charAt(0), 1);
                        }
                    }
                }

            }
            System.out.println(data);
            int valuesSum = 0;
            for (Integer value : data.values()){
                valuesSum += value;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int comparator(Integer set1, Integer set2){
        return set1 - set2;
    }
}

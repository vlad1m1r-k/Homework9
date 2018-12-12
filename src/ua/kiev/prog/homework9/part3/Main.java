package ua.kiev.prog.homework9.part3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    private static Map<Character, Float> data = new HashMap<>(26);

    public static void main(String[] args) {
        parseFile();
        int valuesSum = 0;
        for (Float value : data.values()) {
            valuesSum += value;
        }
        for (Map.Entry<Character, Float> entry : data.entrySet()) {
            data.replace(entry.getKey(), (entry.getValue() / valuesSum) * 100);
        }
        Set<Map.Entry<Character, Float>> set = new TreeSet<>((o1, o2) -> comparator(o1, o2));
        set.addAll(data.entrySet());
        for (Map.Entry<Character, Float> entry : set){
            System.out.printf("%c = %.2f %%\n", entry.getKey(), entry.getValue());
        }
    }

    private static int comparator(Map.Entry<Character, Float> entry1, Map.Entry<Character, Float> entry2) {
        float result = entry1.getValue() - entry2.getValue();
        if (result == 0) return 0;
        return result > 0 ? -1 : 1;
    }

    private static void parseFile() {
        try {
            List<String> strings = Files.readAllLines(Paths.get("text.txt"));
            for (String string : strings) {
                for (int i = 0; i < string.length(); i++) {
                    String character = string.toLowerCase().substring(i, i + 1);
                    if (character.matches("[a-z]")) {
                        if (data.containsKey(character.charAt(0))) {
                            float value = data.get(character.charAt(0));
                            value++;
                            data.replace(character.charAt(0), value);
                        } else {
                            data.put(character.charAt(0), 1f);
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

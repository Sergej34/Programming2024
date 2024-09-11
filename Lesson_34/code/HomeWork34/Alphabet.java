package HomeWork34;

import java.util.ArrayList;
import java.util.List;

public class Alphabet {
    public static void main(String[] args) {

        List<Character> alphabet = new ArrayList<>();

        for (int i = 0; i < 26; i++) {
            alphabet.add((char) ('A' + i));
        }

        // 2nd variant
//        for (char ch = 'A'; ch <= 'Z'; ch++ ) {
//            alphabet.add(ch);
//        }

        // print
        for (Character ch : alphabet) {
            System.out.print(ch + " | ");
        }
        System.out.println();
        System.out.println(alphabet);
    }
}

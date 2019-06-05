package com.company;

import java.util.Scanner;

public class Main {

    private static final String[] hexBits = {
            "0000", "0001", "0010", "0011",
            "0100", "0101", "0110", "0111",
            "1000", "1001", "1010", "1011",
            "1100", "1101", "1110", "1111"
    };

    private static Integer counter = 0;

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(ClassLoader.getSystemClassLoader().getResourceAsStream("memory-references-hex.csv")).useDelimiter(",")) {
            while (sc.hasNext()) {
                convertHexToBin(sc.next().trim());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(counter);
    }

    private static String convertHexToBin(String hexStr) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < hexStr.length(); i++) {
            int j = Character.digit(hexStr.toLowerCase().charAt(i), 16);
            sb.append(hexBits[j]);
        }

        counter++;
        System.out.println(sb.toString());
        return sb.toString();
    }

}

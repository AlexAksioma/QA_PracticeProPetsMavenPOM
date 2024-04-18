package helpers;

import java.util.Random;

public class RandomElements {
    public static String breedOfDog() {
        String[] arrayBreed = {"Affenpinscher", "Afghan Hound", "Africanis", "Aidi", "Akita",
                "Boxer", "Boykin Spaniel", "Bracco Italiano"};
        return arrayBreed[new Random().nextInt(arrayBreed.length)];
    }

    public static String breedOfCat() {
        String[] arrayBreed = {"Abyssinian", "Birman", "Egyptian Mau", "Korat",
                "Norwegian Forest Cat", "Russian Blue", "Persian Traditional"};
        return arrayBreed[new Random().nextInt(arrayBreed.length)];
    }

    public static String color() {
        String[] array = {"red", "white", "black", "green",
                "yellow", "blue", "gray"};
        return array[new Random().nextInt(array.length)];
    }

    public static String randomString(int strLength) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < strLength; i++) {
            stringBuilder.append(randomChar());
        }
        return stringBuilder.toString();
    }

    private static char randomChar() {
        return (char) ('a' + Math.random() * ('z' - 'a') + 1);
    }
}

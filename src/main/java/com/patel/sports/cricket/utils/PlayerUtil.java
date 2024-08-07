package com.patel.sports.cricket.utils;

import com.patel.sports.cricket.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PlayerUtil {
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final int MAX_NAME_LENGTH = 10;
    private static final Random RANDOM = new Random();
    public static List<Player> generateRandomNames(int numberOfNames) {
        List<Player> players = new ArrayList<>();
        for (int i = 0; i < numberOfNames; i++) {
            String name = "Player".concat(String.valueOf(i+1));
            Player p1 = new Player(name);
            players.add(p1);
        }
        return players;
    }

    public static Player generateRandomPlayer() {
        String name = generateRandomName();
        return new Player(name);
    }
    private static String generateRandomName() {
        int length = RANDOM.nextInt(MAX_NAME_LENGTH) + 1; // Ensure name length is between 1 and MAX_NAME_LENGTH
        StringBuilder name = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            name.append(CHARACTERS.charAt(RANDOM.nextInt(CHARACTERS.length())));
        }
        return name.toString();
    }
}

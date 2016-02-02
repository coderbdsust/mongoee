package guru.springframework.utils;

import java.util.Random;

public class KeyGenerator {
	private static String allCharacters = "0123456789abcdefghijklmnopqrstuvwxyz";

	public static String getKey() {
		Random rand = new Random();
		String key = "";
		for (int i = 0; i < 16; i++) {
			int index = rand.nextInt(allCharacters.length());
			key += allCharacters.substring(index, index + 1);
		}
		return key;

	}

}

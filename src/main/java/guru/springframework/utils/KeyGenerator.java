package guru.springframework.utils;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class KeyGenerator {
	private static String allCharacters = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

	public static String getKey() {
		Random rand = new Random();
		String key = "";
		for (int i = 0; i < 16; i++) {
			int index = rand.nextInt(allCharacters.length());
			key += allCharacters.substring(index, index + 1);
		}
		return key;

	}

	public static String getKey(int keyLength) {
		Random rand = new Random();
		String key = "";
		for (int i = 0; i < keyLength; i++) {
			int index = rand.nextInt(allCharacters.length());
			key += allCharacters.substring(index, index + 1);
		}
		return key;

	}

//	public static void main(String[] args) {
//		System.out.println("Started!");
//		long startTime = System.currentTimeMillis();
//		Set genes = new HashSet();
//		int keys = 1000000;
//		while (true) {
//
//			for (int i = 0; i < keys; i++) {
//				String key = KeyGenerator.getKey(10);
//				genes.add(key);
//			}
//
//			if (keys != genes.size()) {
//				break;
//			}
//			genes = new HashSet();
//		}
//		long endTime = System.currentTimeMillis();
//		long elapsedTime = endTime-startTime;
//		System.out.println("Ended!");
//		System.out.println("Time: " + elapsedTime);
//		
//		
//	}

}

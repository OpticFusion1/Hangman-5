import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

public class Hangman {

	static boolean running = true;
	static Scanner s = new Scanner(System.in);
	static char[] lettersFromWord;

	public static int randomNumber(int min, int max) {
		int range = (max - min) + 1;
		return (int) (Math.random() * range) + min;
	}

	public static void main(String[] args) throws Exception {

		FileReader fr = new FileReader("words.txt");
		BufferedReader reader = new BufferedReader(fr);

		String word = "";
		int counter = 0;
		int solved = 0;
		int pickWord = randomNumber(1, 40);
		String letter;

		for (int x = 0; x < pickWord; x++) {
			word = reader.readLine();
		}
		lettersFromWord = new char[word.length()];
		Arrays.fill(lettersFromWord, '_');

		System.out.println("Welcome to Hangman!");
		System.out.println("--------------------");
		System.out.println(word);

		while (running) {
			System.out.print("\nYour word is: ");

			System.out.print("[");
			for (int x = 0; x < lettersFromWord.length; x++) {
				if (lettersFromWord[x] == '_') {
					System.out.print(" _");
				} else {
					System.out.print(" " + lettersFromWord[x]);
				}
			}
			System.out.print(" ]");

			System.out.print("\nEnter your guess: ");
			letter = s.next();

			for (int i = 0; i < word.length(); i++) {
				if (word.substring(i, i + 1).equals(letter)) {
					lettersFromWord[i] = letter.charAt(0);
					solved++;
					if(solved >= word.length()) {
						System.out.println("You won!");
						running = false;
					}
				}
			}
		}

	}

}

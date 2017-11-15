import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.io.IOException;

public class Sorter {
	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	private static ArrayList<Integer> numberList = new ArrayList<Integer>();
	private static int numberOfNumbers;
	private static String[] numberStrings;
	private static final String INPUT = "1";
	private static final String INCREASING_ORDER = "2";
	private static final String DECREASING_ORDER = "3";
	private static final String QUIT = "4";
	private static final String WARNING_MESSAGE = "Incorrect Input!";
	
	public static void main(String[] args) throws IOException {
		String answer = new String();
		while (!answer.equals(QUIT)) {
			displayMenu();
			answer = reader.readLine();
			if (isInvalid(answer))
				System.out.println(WARNING_MESSAGE);
			else
				executeMenu(answer);
		}
	}
	
	private static void displayMenu() {
		System.out.println("\n[ ID: 1416365 ]\n[ Name: ÀÌÈ¿Á¤]\n");
		System.out.println("1. Input numbers");
		System.out.println("2. Print numbers in increasing order");
		System.out.println("3. Print numbers in decreasing order");
		System.out.print("4. Quit\n\n> ");
	}
	
	private static boolean isInvalid(String answer) {
		try {
			int answerNumber = Integer.parseInt(answer);
			if (isNotInRange(answerNumber))
				return true;
			else
				return false;
		} catch (NumberFormatException exception) {
			return true;
		}
	}
	
	private static boolean isNotInRange(int answerNumber) {
		if (answerNumber < 0 || answerNumber > 4)
			return true;
		else
			return false;
	}
	
	private static void executeMenu(String answer) throws IOException {
		if (answer.equals(INPUT))
			receiveAndSetInput();
		else if (answer.equals(INCREASING_ORDER)) {
			sortIncreasingOrder();
			printSortedNumbers();
		}
		else if (answer.equals(DECREASING_ORDER)) {
			sortDecreasingOrder();
			printSortedNumbers();
		}
	}
	
	private static void receiveAndSetInput() throws IOException {
		try {
			receiveVariables();
			setInputNumbers();
		} catch (NumberFormatException exception) {
			System.out.println(WARNING_MESSAGE);
		}
	}
	
	private static void receiveVariables() throws NumberFormatException, IOException {
		System.out.print("> The number of numbers: ");
		numberOfNumbers = Integer.parseInt(reader.readLine());
		System.out.print("> numbers: ");
		String numberString = reader.readLine();
		numberStrings = numberString.split(" ");
	}
	
	private static void setInputNumbers() {
		numberList = new ArrayList<Integer>();
		if (numberStrings.length != numberOfNumbers) {
			System.out.println(WARNING_MESSAGE);
			return;
		}
		for (int i = 0 ; i < numberOfNumbers ; i++) {
			int number = Integer.parseInt(numberStrings[i]);
			numberList.add(number);
		}
	}
	
	private static void sortIncreasingOrder() {
		if (!numberList.isEmpty())
			bubbleSort();
	}
	
	private static void bubbleSort() {
		for (int i = 0 ; i < numberList.size() ; i++) {
			for (int j = i ; j < numberList.size() ; j++) {
				if (numberList.get(i) > numberList.get(j))
					swapNumbersOfIndex(i, j);
			}
		}
	}
	
	private static void swapNumbersOfIndex(int firstIndex, int secondIndex) {
		int tempNumber = numberList.get(firstIndex);
		int secondNumber = numberList.get(secondIndex);
		numberList.set(firstIndex, secondNumber);
		numberList.set(secondIndex, tempNumber);
	}

	private static void sortDecreasingOrder() {
		sortIncreasingOrder();
		Collections.reverse(numberList);
	}
	
	private static void printSortedNumbers() {
		for (int number : numberList)
			System.out.print(number + " ");
	}
}

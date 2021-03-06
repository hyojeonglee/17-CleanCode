package hw1;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.io.IOException;

public class NumberSorter {
	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	final private static String INPUT_NUMBERS = "1";
	final private static String PRINT_INCREASING_ORDER = "2";
	final private static String PRINT_DECREASING_ORDER = "3";
	final private static String QUIT = "4";
	private ArrayList<Integer> numberList = new ArrayList<Integer>();
	private int numberOfNumbers;
	private String typeOfData;
	
	public static void main(String[] args) throws IOException {
		NumberSorter sorter = new NumberSorter();
		String selectedMenu = new String();
		while (!selectedMenu.equals(QUIT)) {
			sorter.displayMenu();
			selectedMenu = reader.readLine();
			sorter.executeMenuBy(selectedMenu);
		}
	}
	
	private void displayMenu() {
		System.out.println("\n[ ID: 1416365 ]\n[ Name: ��ȿ��]\n");
		System.out.println("1. Input numbers");
		System.out.println("2. Print numbers in increasing order");
		System.out.println("3. Print numbers in decreasing order");
		System.out.print("4. Quit\n\n> ");
	}
	
	private void executeMenuBy(String selectedMenu) throws IOException {
		if (selectedMenu.equals(INPUT_NUMBERS)) {
			selectTypeOfData();
			receiveNumberOfNumbers();
			receiveAndMakeNumberList();
		}
		else if (selectedMenu.equals(PRINT_INCREASING_ORDER)) {
			sortIncreasingOrder();
			printSortedNumbers();
		}
		else if (selectedMenu.equals(PRINT_DECREASING_ORDER)) {
			sortDecreasingOrder();
			printSortedNumbers();
		}
	}
	
	private void selectTypeOfData() throws IOException {
		System.out.print("> The type of data (n or c): ");
		typeOfData = reader.readLine();
	}
	
	private void receiveNumberOfNumbers() throws IOException {
		System.out.print("> The number of numbers: ");
		numberOfNumbers = Integer.parseInt(reader.readLine());
	}
	
	private void receiveAndMakeNumberList() throws IOException {
		numberList = new ArrayList<Integer>();
		System.out.print("> numbers: ");
		String stringOfNumbers = reader.readLine();
		String[] numberStrings = stringOfNumbers.split(" ");
		for (int i = 0 ; i < numberOfNumbers ; i++) {
			int number = Integer.parseInt(numberStrings[i]);
			numberList.add(number);
		}
	}
	
	private void sortIncreasingOrder() {
		if (!numberList.isEmpty())
			bubbleSort();
	}
	
	private void bubbleSort() {
		for (int i = 0 ; i < numberOfNumbers ; i++) {
			for (int j = i ; j < numberOfNumbers ; j++) {
				if (numberList.get(i) > numberList.get(j))
					swapNumbersByIndex(i, j);
			}
		}
	}
	
	private void swapNumbersByIndex(int firstIndex, int secondIndex) {
		int tempNumber = numberList.get(firstIndex);
		int secondNumber = numberList.get(secondIndex);
		numberList.set(firstIndex, secondNumber);
		numberList.set(secondIndex, tempNumber);
	}

	private void sortDecreasingOrder() {
		sortIncreasingOrder();
		Collections.reverse(numberList);
	}
	
	private void printSortedNumbers() {
		for (int number : numberList)
			System.out.print(number + " ");
		System.out.println();
	}
}

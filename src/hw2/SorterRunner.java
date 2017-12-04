package hw2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.IOException;

public class SorterRunner {
	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	private Sorter sorter;
	
	public static void main(String[] args) throws IOException {
		SorterRunner runner = new SorterRunner();
		String selectedMenu = new String();
		while (isNotQuit(selectedMenu)) {
			displayMenu();
			selectedMenu = reader.readLine();
			runner.executeBy(selectedMenu);
		}
	}
	
	private static boolean isNotQuit(String selectedMenu) {
		String quitCode = Menu.QUIT.getCode();
		if (!selectedMenu.equals(quitCode))
			return true;
		else
			return false;
	}
	
	private static void displayMenu() {
		System.out.println("[ ID: 1416365 ]\n[ Name: ÀÌÈ¿Á¤]\n");
		System.out.println("1. Input data");
		System.out.println("2. Print data in increasing order");
		System.out.println("3. Print data in decreasing order");
		System.out.print("4. Quit\n\n> ");
	}
	
	private void executeBy(String selectedMenu) throws IOException {
		ArrayList<String> sortedList = new ArrayList<String>();
		Menu menu = Menu.getMenuBy(selectedMenu);
		switch (menu) {
			case SET_INPUT_DATA :
				String typeOfData = receiveTypeOfData();
				receiveDataAndSetSorterBy(typeOfData);
				break;
			case PRINT_INCREASING_ORDER :
				sortedList = sorter.sortIncreasingOrder();
				print(sortedList);
				break;
			case PRINT_DECREASING_ORDER :
				sortedList = sorter.sortDecreasingOrder();
				print(sortedList);
				break;
			default:
				break;
		}
	}
	
	private String receiveTypeOfData() throws IOException {
		System.out.print("> The type of data (n or c): ");
		String typeOfData = reader.readLine();
		return typeOfData;
	}
	
	private void receiveDataAndSetSorterBy(String typeOfData) throws IOException {
		int numberOfData = receiveNumberOfData();
		String stringOfData = receiveData();
		String[] dataStrings = convertToArrayFrom(stringOfData);
		ArrayList<String> dataList = convertStringsToListBy(numberOfData, dataStrings);
		setSorterBy(typeOfData, numberOfData, dataList);
	}
	
	private int receiveNumberOfData() throws IOException {
		System.out.print("> The number of data: ");
		int numberOfData = Integer.parseInt(reader.readLine());
		return numberOfData;
	}
	
	private String receiveData() throws IOException {
		System.out.print("> data: ");
		String stringOfData = reader.readLine();
		return stringOfData;
	}
	
	private String[] convertToArrayFrom(String stringOfData) {
		String[] dataStrings = stringOfData.split(" ");
		return dataStrings;
	}
	
	private ArrayList<String> convertStringsToListBy(int numberOfData, String[] dataStrings) {
		ArrayList<String> dataList = new ArrayList<String>();
		for (int i = 0 ; i < numberOfData ; i++) {
			String data = dataStrings[i];
			dataList.add(data);
		}
		return dataList;
	}
	
	private void setSorterBy(String typeOfData, int numberOfData, ArrayList<String> dataList) {
		Option option = Option.getOptionBy(typeOfData);
		switch (option) {
			case NUMBER :
				sorter = new NumberSorter(numberOfData, dataList);
				break;
			case CHARACTER :
				sorter = new CharacterSorter(numberOfData, dataList);
				break;
			default:
				break;
		}
	}
	
	private void print(ArrayList<String> sortedList) {
		for (String data : sortedList)
			System.out.print(data + " ");
		System.out.println();
	}
}


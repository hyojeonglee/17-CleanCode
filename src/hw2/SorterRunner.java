package hw2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.IOException;

public class SorterRunner {
	private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	private Sorter sorter;
	
	public static void main(String[] args) throws IOException {
		SorterRunner runner = new SorterRunner();
		String selectedMenu = new String();
		while (!selectedMenu.equals(Option.QUIT.getCode())) {
			runner.displayMenu();
			selectedMenu = runner.reader.readLine();
			runner.executeBy(selectedMenu);
		}
	}
	
	private void displayMenu() {
		System.out.println("[ ID: 1416365 ]\n[ Name: ÀÌÈ¿Á¤]\n");
		System.out.println("1. Input data");
		System.out.println("2. Print data in increasing order");
		System.out.println("3. Print data in decreasing order");
		System.out.print("4. Quit\n\n> ");
	}
	
	private void executeBy(String selectedMenu) throws IOException {
		Option option = Option.getOptionBy(selectedMenu);
		switch (option) {
			case SET_INPUT_DATA :
				String typeOfData = receiveTypeOfData();
				int numberOfData = receiveNumberOfData();
				ArrayList<String> dataList = receiveAndMakeDataList(numberOfData);
				sorter = setObjectBy(typeOfData, numberOfData, dataList);
				break;
			case PRINT_INCREASING_ORDER :
				sorter.sortIncreasingOrder();
				sorter.printSortedData();
				break;
			case PRINT_DECREASING_ORDER :
				sorter.sortDecreasingOrder();
				sorter.printSortedData();
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
	
	private int receiveNumberOfData() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("> The number of data: ");
		int numberOfData = Integer.parseInt(reader.readLine());
		return numberOfData;
	}
	
	private ArrayList<String> receiveAndMakeDataList(int numberOfData) throws IOException {
		ArrayList<String> dataList = new ArrayList<String>();
		System.out.print("> data: ");
		String stringOfData = reader.readLine();
		String[] dataStrings = stringOfData.split(" ");
		for (int i = 0 ; i < numberOfData ; i++) {
			String data = dataStrings[i];
			dataList.add(data);
		}
		return dataList;
	}
	
	private Sorter setObjectBy(String typeOfData, int numberOfData, ArrayList<String> dataList) {
		Sorter sorter = null;
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
		return sorter;
	}
}


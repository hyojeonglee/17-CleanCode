import java.io.*;
import java.util.ArrayList;

public class SorterRunner {
	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	private Sorter sorter;
	
	public static void main(String[] args) throws IOException {
		SorterRunner runner = new SorterRunner();
		String selectedMenu = new String();
		while (!isQuit(selectedMenu)) {
			displayMenu();
			selectedMenu = reader.readLine();
			runner.executeBy(selectedMenu);
		}
	}
	
	private static boolean isQuit(String selectedMenu) {
		String quitCode = Menu.QUIT.code;
		if (selectedMenu.equals(quitCode))
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
				sorter = receiveDataAndGetSorterBy(typeOfData);
				break;
			case PRINT_INCREASING_ORDER :
				sortedList = sorter.sortIncreasingOrder();
				printDataList(sortedList);
				break;
			case PRINT_DECREASING_ORDER :
				sortedList = sorter.sortDecreasingOrder();
				printDataList(sortedList);
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
	
	private Sorter receiveDataAndGetSorterBy(String typeOfData) throws IOException {
		int numberOfData = receiveNumberOfData();
		ArrayList<String> dataList = receiveAndMakeDataListBy(numberOfData);
		Sorter sorter = setSorterWith(typeOfData, numberOfData, dataList);
		return sorter;
	}
	
	private int receiveNumberOfData() throws IOException {
		System.out.print("> The number of data: ");
		int numberOfData = Integer.parseInt(reader.readLine());
		return numberOfData;
	}
	
	private ArrayList<String> receiveAndMakeDataListBy(int numberOfData) throws IOException {
		System.out.print("> data: ");
		String stringOfData = reader.readLine();
		String[] dataStrings = convertToArrayFrom(stringOfData);
		ArrayList<String> dataList = convertArrayToListWith(numberOfData, dataStrings);
		return dataList;
	}
	
	private String[] convertToArrayFrom(String stringOfData) {
		String[] dataStrings = stringOfData.split(" ");
		return dataStrings;
	}
	
	private ArrayList<String> convertArrayToListWith(int numberOfData, String[] dataStrings) {
		ArrayList<String> dataList = new ArrayList<String>();
		for (int i = 0 ; i < numberOfData ; i++) {
			String data = dataStrings[i];
			dataList.add(data);
		}
		return dataList;
	}
	
	private Sorter setSorterWith(String typeOfData, int numberOfData, ArrayList<String> dataList) {
		Option option = Option.getOptionBy(typeOfData);
		switch (option) {
			case NUMBER :
				return new NumberSorter(numberOfData, dataList);
			case CHARACTER :
				return new CharacterSorter(numberOfData, dataList);
			default:
				return null;
		}
	}
	
	private void printDataList(ArrayList<String> sortedList) {
		for (String data : sortedList)
			System.out.print(data + " ");
		System.out.println();
	}
}


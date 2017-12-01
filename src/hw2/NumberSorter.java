package hw2;

import java.util.ArrayList;

class NumberSorter extends Sorter {
	public NumberSorter(int numberOfData, ArrayList<String> dataList) {
		super(numberOfData, dataList);
	}
	
	@Override
	protected void sortIncreasingOrder() {
		ArrayList<Integer> numberList = convertStringToIntegerList();
		numberList = bubbleSort(numberList);
		dataList.clear();
		for (int number : numberList) {
			String data = Integer.toString(number);
			dataList.add(data);
		}
	}

	@Override
	protected ArrayList<Integer> convertStringToIntegerList() {
		ArrayList<Integer> numberList = new ArrayList<Integer>();
		for (String data : dataList) {
			int number = Integer.parseInt(data);
			numberList.add(number);
		}
		return numberList;
	}
}

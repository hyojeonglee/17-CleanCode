package hw2;

import java.util.ArrayList;

class NumberSorter extends Sorter {
	public NumberSorter(int numberOfData, ArrayList<String> dataList) {
		super(numberOfData, dataList);
	}
	
	@Override
	protected ArrayList<Integer> convertStringToIntList() {
		ArrayList<Integer> numberList = new ArrayList<Integer>();
		for (String data : super.getDataList()) {
			int number = Integer.parseInt(data);
			numberList.add(number);
		}
		return numberList;
	}
	
	@Override
	protected ArrayList<String> convertIntToStringList() {
		ArrayList<String> dataList = new ArrayList<String>();
		for (int number : super.getSortableList()) {
			String data = Integer.toString(number);
			dataList.add(data);
		}
		return dataList;
	}

}

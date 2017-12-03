package hw2;

import java.util.ArrayList;

class NumberSorter extends Sorter {
	public NumberSorter(int numberOfData, ArrayList<String> dataList) {
		super(numberOfData, dataList);
	}
	
	@Override
	protected SortableList convertDataToSortableList(ArrayList<String> dataList) {
		SortableList sortableList = super.getSortableList();
		ArrayList<Integer> numberList = new ArrayList<Integer>();
		for (String data : dataList) {
			int number = Integer.parseInt(data);
			numberList.add(number);
		}
		sortableList.setSortableList(numberList);
		return sortableList;
	}
	
	@Override
	protected ArrayList<String> convertSortableToDataList(SortableList sortedList) {
		ArrayList<String> dataList = new ArrayList<String>();
		for (int number : sortedList.getSortableList()) {
			String data = Integer.toString(number);
			dataList.add(data);
		}
		return dataList;
	}

}

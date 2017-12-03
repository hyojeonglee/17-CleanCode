package hw2;

import java.util.ArrayList;
import java.util.Collections;

abstract class Sorter {
	private int numberOfData;
	private ArrayList<String> dataList;
	private SortableList sortableList;
	
	abstract protected SortableList convertDataToSortableList(ArrayList<String> dataList);
	
	abstract protected ArrayList<String> convertSortableToDataList(SortableList sortableList);
	
	public Sorter(int numberOfData, ArrayList<String> dataList) {
		this.numberOfData = numberOfData;
		this.dataList = dataList;
		this.sortableList = new SortableList(this.numberOfData);
	}
	
	public SortableList getSortableList() {
		return this.sortableList;
	}

	public ArrayList<String> sortIncreasingOrder() {
		sortableList = convertDataToSortableList(dataList);
		ArrayList<Integer> sortedList = sortableList.bubbleSort();
		sortableList.setSortableList(sortedList);
		dataList = convertSortableToDataList(sortableList);
		return dataList;
	}
	
	public ArrayList<String> sortDecreasingOrder() {
		dataList = sortIncreasingOrder();
		Collections.reverse(dataList);
		return dataList;
	}

	@Override
	public String toString() {
		String formattedString = new String();
		for (String data : this.dataList)
			formattedString += data + " ";
		return formattedString;
	}
}

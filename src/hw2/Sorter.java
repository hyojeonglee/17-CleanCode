package hw2;

import java.util.ArrayList;
import java.util.Collections;

abstract class Sorter {
	private int numberOfData;
	private ArrayList<String> dataList;
	private ArrayList<Integer> sortableList;
	
	public Sorter() {
		this.numberOfData = 0;
		this.dataList = new ArrayList<String>();
	}
	
	public Sorter(int numberOfData, ArrayList<String> dataList) {
		this.numberOfData = numberOfData;
		this.dataList = dataList;
	}
	
	ArrayList<String> getDataList() {
		return this.dataList;
	}
	
	ArrayList<Integer> getSortableList() {
		return this.sortableList;
	}
	
	void sortIncreasingOrder() {
		sortableList = convertStringToIntList();
		bubbleSort();
		dataList = convertIntToStringList();
	}

	abstract protected ArrayList<Integer> convertStringToIntList();
	abstract protected ArrayList<String> convertIntToStringList();
	
	void sortDecreasingOrder() {
		sortIncreasingOrder();
		Collections.reverse(dataList);
	}
	
	void printSortedData() {
		for (String data : this.dataList)
			System.out.print(data + " ");
		System.out.println();
	}
	
	private void bubbleSort() {
		for (int i = 0 ; i < numberOfData ; i++) {
			for (int j = i ; j < numberOfData ; j++) {
				if (sortableList.get(i) > sortableList.get(j))
					swap(i, j);
			}
		}
	}
	
	private void swap(int firstIndex, int secondIndex) {
		int tempData = sortableList.get(firstIndex);
		int secondData = sortableList.get(secondIndex);
		sortableList.set(firstIndex, secondData);
		sortableList.set(secondIndex, tempData);
	}
}

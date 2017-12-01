package hw2;

import java.util.ArrayList;
import java.util.Collections;

abstract class Sorter {
	private int numberOfData;
	protected ArrayList<String> dataList;
	
	public Sorter() {
		this.numberOfData = 0;
		this.dataList = new ArrayList<String>();
	}
	
	public Sorter(int numberOfData, ArrayList<String> dataList) {
		this.numberOfData = numberOfData;
		this.dataList = dataList;
	}

	abstract protected void sortIncreasingOrder();
	abstract protected ArrayList<Integer> convertStringToIntegerList();
	
	void sortDecreasingOrder() {
		sortIncreasingOrder();
		Collections.reverse(dataList);
	}
	
	void printSortedData() {
		for (String data : this.dataList)
			System.out.print(data + " ");
		System.out.println();
	}
	
	protected ArrayList<Integer> bubbleSort(ArrayList<Integer> dataList) {
		for (int i = 0 ; i < numberOfData ; i++) {
			for (int j = i ; j < numberOfData ; j++) {
				if (dataList.get(i) > dataList.get(j))
					swap(dataList, i, j);
			}
		}
		return dataList;
	}
	
	private void swap(ArrayList<Integer> dataList, int firstIndex, int secondIndex) {
		int tempData = dataList.get(firstIndex);
		int secondData = dataList.get(secondIndex);
		dataList.set(firstIndex, secondData);
		dataList.set(secondIndex, tempData);
	}
}

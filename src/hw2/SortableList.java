package hw2;

import java.util.ArrayList;
import java.util.Collections;

// TODO : convert method (abstract) 2개를 여기로 옮길 것인지? (envy 현상 떄문)

public class SortableList {
	private int numberOfData;
	private ArrayList<Integer> sortableList;
	
	public SortableList(int numberOfData) {
		this.numberOfData = numberOfData;
		this.sortableList = new ArrayList<Integer>();
	}
	
	public ArrayList<Integer> getSortableList() {
		return this.sortableList;
	}
	
	public void setSortableList(ArrayList<Integer> sortableList) {
		this.sortableList = sortableList;
	}
	
	public ArrayList<Integer> bubbleSort() {
		for (int i = 0 ; i < numberOfData ; i++) {
			for (int j = i ; j < numberOfData ; j++) {
				if (sortableList.get(i) > sortableList.get(j))
					Collections.swap(sortableList, i, j);
			}
		}
		return sortableList;
	}
}

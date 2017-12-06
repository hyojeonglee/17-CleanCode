import java.util.*;

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
	
	public ArrayList<Integer> bubbleSortIncreasingOrder() {
		for (int i = 0 ; i < numberOfData ; i++) {
			for (int j = i ; j < numberOfData ; j++) {
				if (sortableList.get(i) > sortableList.get(j))
					Collections.swap(sortableList, i, j);
			}
		}
		return sortableList;
	}
}

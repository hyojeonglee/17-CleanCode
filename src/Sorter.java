import java.util.*;

abstract class Sorter {
	private int numberOfData;
	private ArrayList<String> dataList;
	private ArrayList<Integer> sortableList;
	
	abstract protected ArrayList<Integer> convertDataToSortableList(ArrayList<String> dataList);
	
	abstract protected ArrayList<String> convertSortableToDataList(ArrayList<Integer> sortableList);
	
	public Sorter(int numberOfData, ArrayList<String> dataList) {
		this.numberOfData = numberOfData;
		this.dataList = dataList;
		this.sortableList = new ArrayList<Integer>();
	}

	public ArrayList<String> sortIncreasingOrder() {
		sortableList = convertDataToSortableList(dataList);
		bubbleSortIncreasingOrder();
		dataList = convertSortableToDataList(sortableList);
		return dataList;
	}
	
	private void bubbleSortIncreasingOrder() {
		for (int i = 0 ; i < numberOfData ; i++) {
			for (int j = i ; j < numberOfData ; j++) {
				if (sortableList.get(i) > sortableList.get(j))
					Collections.swap(sortableList, i, j);
			}
		}
	}
	
	public ArrayList<String> sortDecreasingOrder() {
		dataList = sortIncreasingOrder();
		Collections.reverse(dataList);
		return dataList;
	}
}

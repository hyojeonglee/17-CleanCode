import java.util.ArrayList;

class NumberSorter extends Sorter {
	public NumberSorter(int numberOfData, ArrayList<String> dataList) {
		super(numberOfData, dataList);
	}
	
	@Override
	protected ArrayList<Integer> convertDataToSortableList(ArrayList<String> dataList) {
		ArrayList<Integer> sortableNumberList = new ArrayList<Integer>();
		for (String data : dataList) {
			int number = Integer.parseInt(data);
			sortableNumberList.add(number);
		}
		return sortableNumberList;
	}
	
	@Override
	protected ArrayList<String> convertSortableToDataList(ArrayList<Integer> sortedList) {
		ArrayList<String> dataList = new ArrayList<String>();
		for (int number : sortedList) {
			String data = Integer.toString(number);
			dataList.add(data);
		}
		return dataList;
	}

}

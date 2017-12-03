package hw2;

import java.util.ArrayList;

class CharacterSorter extends Sorter {
	public CharacterSorter(int numberOfData, ArrayList<String> dataList) {
		super(numberOfData, dataList);
	}

	@Override
	protected SortableList convertDataToSortableList(ArrayList<String> dataList) {
		SortableList sortableList = super.getSortableList();
		ArrayList<Integer> asciiCodeList = new ArrayList<Integer>();
		for (String data : dataList) {
			int code = convertToASCIICode(data);
			asciiCodeList.add(code);
		}
		sortableList.setSortableList(asciiCodeList);
		return sortableList;
	}
	
	private int convertToASCIICode(String data) {
		int code = 0;
		char[] chars = data.toCharArray();
		for (char c : chars)
			code = (int) c;
		return code;
	}
	
	@Override
	protected ArrayList<String> convertSortableToDataList(SortableList sortedList) {
		ArrayList<String> dataList = new ArrayList<String>();
		for (int code : sortedList.getSortableList()) {
			String data = convertASCIIToString(code);
			dataList.add(data);
		}
		return dataList;
	}
	
	private String convertASCIIToString(int code) {
		char c = (char) code;
		String data = Character.toString(c);
		return data;
	}
}

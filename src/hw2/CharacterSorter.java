package hw2;

import java.util.ArrayList;

class CharacterSorter extends Sorter {
	public CharacterSorter(int numberOfData, ArrayList<String> dataList) {
		super(numberOfData, dataList);
	}

	@Override
	protected void sortIncreasingOrder() {
		ArrayList<Integer> asciiCodeList = convertStringToIntegerList();
		asciiCodeList = bubbleSort(asciiCodeList);
		dataList.clear();
		for (int code : asciiCodeList) {
			char c = (char) code;
			String data = Character.toString(c);
			dataList.add(data);
		}
	}

	@Override
	protected ArrayList<Integer> convertStringToIntegerList() {
		ArrayList<Integer> asciiCodeList = new ArrayList<Integer>();
		for (String data : dataList) {
			char[] chars = data.toCharArray();
			for (char c : chars) {
				int code = (int) c;
				asciiCodeList.add(code);
			}
		}
		return asciiCodeList;
	}
}

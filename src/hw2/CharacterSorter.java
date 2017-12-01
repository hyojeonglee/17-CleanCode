package hw2;

import java.util.ArrayList;

class CharacterSorter extends Sorter {
	public CharacterSorter(int numberOfData, ArrayList<String> dataList) {
		super(numberOfData, dataList);
	}

	@Override
	protected ArrayList<Integer> convertStringToIntList() {
		ArrayList<Integer> asciiCodeList = new ArrayList<Integer>();
		for (String data : super.getDataList()) {
			char[] chars = data.toCharArray();
			for (char c : chars) {
				int code = (int) c;
				asciiCodeList.add(code);
			}
		}
		return asciiCodeList;
	}
	
	@Override
	protected ArrayList<String> convertIntToStringList() {
		ArrayList<String> dataList = new ArrayList<String>();
		for (int code : super.getSortableList()) {
			char c = (char) code;
			String data = Character.toString(c);
			dataList.add(data);
		}
		return dataList;
	}

}

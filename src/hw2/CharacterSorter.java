package hw2;

import java.util.ArrayList;

import javax.xml.stream.events.Characters;

class CharacterSorter extends Sorter {
	public CharacterSorter(int numberOfData, ArrayList<String> dataList) {
		super(numberOfData, dataList);
	}

	@Override
	protected SortableList convertDataToSortableList(ArrayList<String> dataList) {
		SortableList sortableList = super.getSortableList();
		ArrayList<Integer> asciiCodeList = new ArrayList<Integer>();
		for (String data : dataList) {
			int asciiCode = convertStringToASCII(data);
			asciiCodeList.add(asciiCode);
		}
		sortableList.setSortableList(asciiCodeList);
		return sortableList;
	}
	
	// TODO : Is 0 magic number?
	private int convertStringToASCII(String data) {
		char[] characters = data.toCharArray();
		char firstCharacter = characters[0];
		int asciiCode = (int) firstCharacter;
		return asciiCode;
	}
	
	@Override
	protected ArrayList<String> convertSortableToDataList(SortableList sortedList) {
		ArrayList<String> dataList = new ArrayList<String>();
		for (int asciiCode : sortedList.getSortableList()) {
			String data = convertASCIIToString(asciiCode);
			dataList.add(data);
		}
		return dataList;
	}
	
	private String convertASCIIToString(int asciiCode) {
		char character = (char) asciiCode;
		String data = Character.toString(character);
		return data;
	}
}

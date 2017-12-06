import java.util.ArrayList;

class CharacterSorter extends Sorter {
	public CharacterSorter(int numberOfData, ArrayList<String> dataList) {
		super(numberOfData, dataList);
	}

	@Override
	protected ArrayList<Integer> convertDataToSortableList(ArrayList<String> dataList) {
		ArrayList<Integer> sortableAsciiCodeList = new ArrayList<Integer>();
		for (String data : dataList) {
			int asciiCode = convertStringToASCII(data);
			sortableAsciiCodeList.add(asciiCode);
		}
		return sortableAsciiCodeList;
	}
	
	private int convertStringToASCII(String data) {
		char[] characters = data.toCharArray();
		char firstCharacter = characters[0];
		int asciiCode = (int) firstCharacter;
		return asciiCode;
	}
	
	@Override
	protected ArrayList<String> convertSortableToDataList(ArrayList<Integer> sortedList) {
		ArrayList<String> dataList = new ArrayList<String>();
		for (int asciiCode : sortedList) {
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

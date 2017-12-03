package hw2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class SortIncreasingOrderTest {
	private int numberOfData;
	private ArrayList<String> dataList;
	private Sorter sorter;
	
	@Test
	public void testSortNumber() {
		numberOfData = 5;
		dataList = new ArrayList<String>(Arrays.asList("-5", "6", "21", "4", "23"));
		sorter = new NumberSorter(numberOfData, dataList);
		assertEquals(Arrays.asList("-5", "4", "6", "21", "23"), sorter.sortIncreasingOrder());
	}
	
	@Test
	public void testSortCharacter() {
		numberOfData = 5;
		dataList = new ArrayList<String>(Arrays.asList("A", "d", "e", "o", "K"));
		sorter = new CharacterSorter(numberOfData, dataList);
		assertEquals(Arrays.asList("A", "K", "d", "e", "o"), sorter.sortIncreasingOrder());
	}
}

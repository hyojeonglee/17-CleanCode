package hw2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class SortDecreasingOrderTest {
	private int numberOfData;
	private ArrayList<String> dataList;
	private Sorter sorter;
	
	@Test
	public void testSortNumber() {
		numberOfData = 5;
		dataList = new ArrayList<String>(Arrays.asList("-5", "6", "21", "4", "23"));
		sorter = new NumberSorter(numberOfData, dataList);
		assertEquals(Arrays.asList("23", "21", "6", "4", "-5"), sorter.sortDecreasingOrder());
	}
	
	@Test
	public void testSortCharacter() {
		numberOfData = 5;
		dataList = new ArrayList<String>(Arrays.asList("A", "d", "e", "o", "K"));
		sorter = new CharacterSorter(numberOfData, dataList);
		assertEquals(Arrays.asList("o", "e", "d", "K", "A"), sorter.sortDecreasingOrder());
	}
}

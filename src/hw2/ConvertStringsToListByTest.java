package hw2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class ConvertStringsToListByTest {
	private SorterRunner runner = new SorterRunner();
	private int numberOfData;
	private String[] dataStrings;
	private ArrayList<String> correctList;
	
	@Test
	public void testConvertNumberStrings() {
		numberOfData = 5;
		dataStrings = new String[] {"1", "2", "3", "4", "5"};
		correctList = new ArrayList<String>(Arrays.asList("1", "2", "3", "4", "5"));
		assertEquals(correctList, runner.convertStringsToListBy(numberOfData, dataStrings));
	}
	
	@Test
	public void testConvertCharacterStrings() {
		numberOfData = 5;
		dataStrings = new String[] {"a", "b", "c", "d", "e"};
		correctList = new ArrayList<String>(Arrays.asList("a", "b", "c", "d", "e"));
		assertEquals(correctList, runner.convertStringsToListBy(numberOfData, dataStrings));
	}
}

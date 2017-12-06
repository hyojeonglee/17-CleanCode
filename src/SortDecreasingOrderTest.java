import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;

public class SortDecreasingOrderTest {
	private int numberOfData;
	private ArrayList<String> dataList;
	private ArrayList<String> correctSortedList;
	private Sorter sorter;

	@Test
	public void testNumberSorting() {
		setDataForTest(5, new ArrayList<String>(Arrays.asList("-5", "6", "21", "4", "23")));
		setCorrectSortedList(new ArrayList<String>(Arrays.asList("23", "21", "6", "4", "-5")));
		sorter = new NumberSorter(numberOfData, dataList);
		assertEquals(correctSortedList, sorter.sortDecreasingOrder());
	}
	
	@Test
	public void testCharacterSorting() {
		setDataForTest(5, new ArrayList<String>(Arrays.asList("A", "d", "e", "o", "K")));
		setCorrectSortedList(new ArrayList<String>(Arrays.asList("o", "e", "d", "K", "A")));
		sorter = new CharacterSorter(numberOfData, dataList);
		assertEquals(correctSortedList, sorter.sortDecreasingOrder());
	}
	
	public void setDataForTest(int numberOfData, ArrayList<String> dataList) {
		this.numberOfData = numberOfData;
		this.dataList = dataList;
	}
	
	public void setCorrectSortedList(ArrayList<String> correctSortedList) {
		this.correctSortedList = correctSortedList;
	}
}

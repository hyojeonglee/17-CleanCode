import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;

public class SortIncreasingOrderTest {
	private int numberOfData;
	private ArrayList<String> dataList;
	private ArrayList<String> correctSortedList;
	private Sorter sorter;
	
	@Test
	public void testNumberSorting() {
		setDataForTest(5, new ArrayList<String>(Arrays.asList("-5", "6", "21", "4", "23")));
		setCorrectSortedList(new ArrayList<String>(Arrays.asList("-5", "4", "6", "21", "23")));
		sorter = new NumberSorter(numberOfData, dataList);
		assertEquals(correctSortedList, sorter.sortIncreasingOrder());
	}
	
	@Test
	public void testCharacterSorting() {
		setDataForTest(5, new ArrayList<String>(Arrays.asList("A", "d", "e", "o", "K")));
		setCorrectSortedList(new ArrayList<String>(Arrays.asList("A", "K", "d", "e", "o")));
		sorter = new CharacterSorter(numberOfData, dataList);
		assertEquals(correctSortedList, sorter.sortIncreasingOrder());
	}
	
	public void setDataForTest(int numberOfData, ArrayList<String> dataList) {
		this.numberOfData = numberOfData;
		this.dataList = dataList;
	}
	
	public void setCorrectSortedList(ArrayList<String> correctSortedList) {
		this.correctSortedList = correctSortedList;
	}
}

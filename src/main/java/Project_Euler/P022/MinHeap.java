/**
 * @author vinod<vinodpal458@gmail.com
 */
package Project_Euler.P022;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * https://projecteuler.net/problem=18 A 46K text file containing over
 * five-thousand first names, begin by sorting it into alphabetical order. Then
 * working out the alphabetical value for each name, multiply this value by its
 * alphabetical position in the list to obtain a name score.
 * 
 * For example, when the list is sorted into alphabetical order, COLIN, which is
 * worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. So, COLIN
 * would obtain a score of 938 × 53 = 49714.
 * 
 * What is the total of all the name scores in the file?
 * 
 */
/*
 * public class P022 {
 * 
 * }
 */

public class MinHeap {
	/*int[] minHeap = null;
	int pos = 0;

	public void create(int[] list) {
		minHeap = new int[list.length + 1];
		pos = 0;
		for (int i = 0; i < list.length; ++i) {
			insert(list[i]);
		}
	}

	public void insert(int num) {
		if (pos == 0) {
			minHeap[pos + 1] = num;
			pos = 2;
		} else {
			minHeap[pos] = num;
			++pos;
		}
		bubbleUp();
	}

	void bubbleUp() {
		int p = pos - 1;
		while (p > 0 && minHeap[p / 2] > minHeap[p]) {
			swap(p / 2, p);
			p = p / 2;
		}
	}

	int getMin() {
		int currentMin = minHeap[1];
		minHeap[1] = minHeap[pos - 1];
		--pos;
		sinkDown(1);
		return currentMin;
	}

	void sinkDown(int sinkPosistion) {
		int k = sinkPosistion;
		if (sinkPosistion * 2 <= pos && minHeap[sinkPosistion * 2] < minHeap[k])
			k = sinkPosistion * 2;
		if (sinkPosistion * 2 + 1 <= pos && minHeap[sinkPosistion * 2 + 1] < minHeap[k])
			k = sinkPosistion * 2 + 1;
		if (sinkPosistion != k) {
			swap(sinkPosistion, k);
			sinkDown(k);
		}
	}

	void swap(int p1, int p2) {
		minHeap[p1] = minHeap[p1] ^ minHeap[p2];
		minHeap[p2] = minHeap[p1] ^ minHeap[p2];
		minHeap[p1] = minHeap[p1] ^ minHeap[p2];
	}

	void display() {
		Arrays.stream(minHeap).forEach(x -> System.out.print(x + " , "));
	}*/

	public static void main(String args[]) {
		/*int arrA[] = { 3, 1, 2, 7, 8, 4, 10, 16, 12 };
		System.out.print("Original Array : ");
		for (int i = 0; i < arrA.length; i++) {
			System.out.print("  " + arrA[i]);
		}
		MinHeap m = new MinHeap();
		System.out.print("\nMin-Heap : ");
		m.create(arrA);
		m.display();
		System.out.println();
		System.out.print("Extract Min :");
		for (int i = 0; i < arrA.length; i++) {
			System.out.print("  " + m.getMin());
		}*/
		String [][]list = readFile();
		MinHeap m = new MinHeap();
		
		int arr[][] = { { 2, 6, 12, 34 }, { 1, 9, 20, 1000 }, { 23, 34, 90, 2000 } };
		m.createSortedRecords(list);
		m.getSortedRecords(list);
		m.resultSortedRecords.forEach(x -> System.out.print(x + " , "));
	}

	private static String[][] readFile() {
		String[][] araay = null;
		try {
			BufferedReader br = new BufferedReader(new FileReader(
					new File("/home/devnew/DO/Project-Euler/src/main/java/Project_Euler/P022/P022_names.txt")));
			String[] line = br.readLine().split(",");
			System.out.println(br.lines());
			araay = new String[5][line.length/5];
			int i = 0, j = 0;
			try {
				while (j<line.length) {
					for (int itr = 0; itr < line.length/5 && j<line.length; ++itr) {
						araay[i][itr] = line[j++];
					}
					++i;
				}
			} catch (Exception exception) {
				System.out.println(exception.toString());
			}

			
		} catch (Exception exception) {
			System.out.println(exception.toString());
		}
		return araay;
	}
	
	
	MinHeapNode[] minHeapForSort = null;
	int position = 0;
	
	void createSortedRecords(String[][] list) {

		minHeapForSort = new MinHeapNode[list.length + 1];
		position = 0;
		for (int itr = 0; itr < list.length; ++itr) {
			insertIntoHeap(list[itr][0], itr, 0);
			minHeapBubbleUp();
		}

	}

	private void insertIntoHeap(String number, int rowIndex, int columnIndex) {
		if (position == 0) {
			minHeapForSort[position + 1] = new MinHeapNode();
			minHeapForSort[position + 1].setNodeValue(number);
			minHeapForSort[position + 1].setRowIndex(rowIndex);
			minHeapForSort[position + 1].setColumnIndex(columnIndex);
			position = 2;
		} else {
			minHeapForSort[position] = new MinHeapNode();
			minHeapForSort[position].setNodeValue(number);
			minHeapForSort[position].setRowIndex(rowIndex);
			minHeapForSort[position].setColumnIndex(columnIndex);
			++position;
		}

	}

	private void minHeapBubbleUp() {
		int pos = position - 1;
		while (pos / 2 > 0 && minHeapForSort[pos].getNodeValue().compareTo(minHeapForSort[pos / 2].getNodeValue())<0) {
			swapMinHeapNodes(pos, pos / 2);
			pos /= 2;
		}
	}

	private void swapMinHeapNodes(int pos1, int pos2) {
		MinHeapNode tempMinHeapNode = minHeapForSort[pos1];
		minHeapForSort[pos1] = minHeapForSort[pos2];
		minHeapForSort[pos2] = tempMinHeapNode;
	}

	private ArrayList<String> resultSortedRecords = new ArrayList<String>();

	void getSortedRecords(String[][] list) {
		for (int itr = 1; itr < list.length * list[0].length; ++itr) {
			resultSortedRecords.add(minHeapForSort[1].getNodeValue());
			if (minHeapForSort[1].getColumnIndex() < list[0].length - 1) {
				position = 1;
				insertIntoHeap(list[minHeapForSort[1].getRowIndex()][minHeapForSort[1].getColumnIndex() + 1],
						minHeapForSort[1].getRowIndex(), minHeapForSort[1].getColumnIndex() + 1);
			} else {
				position = 1;
				insertIntoHeap("ZZZZZZZZZZZZZZ", Integer.MAX_VALUE, Integer.MAX_VALUE);
			}
			position = list.length + 1;
			MinHeapSinkDown(1);
		}
	}

	private void MinHeapSinkDown(int pos) {
		int k = pos;
		if (pos * 2 < position && minHeapForSort[k].getNodeValue().compareTo(minHeapForSort[pos * 2].getNodeValue())>0) {
			k = pos * 2;
		}
		if (pos * 2 + 1 < position && minHeapForSort[k].getNodeValue().compareTo(minHeapForSort[pos * 2 + 1].getNodeValue())>0) {
			k = pos * 2 + 1;
		}
		if (pos != k) {
			swapMinHeapNodes(k, pos);
			MinHeapSinkDown(k);
		}
	}

}

class MinHeapNode implements Comparator {
	private String nodeValue;
	private Integer rowIndex;
	private Integer columnIndex;

	@Override
	public boolean equals(Object object) {
		if (object == null)
			return false;
		if (object == this)
			return true;
		if (!(object instanceof MinHeapNode)) {
			return ((MinHeapNode) object).getNodeValue().equals(this.getNodeValue());
		}
		return false;
	}



	public Integer getRowIndex() {
		return rowIndex;
	}

	public void setRowIndex(Integer rowIndex) {
		this.rowIndex = rowIndex;
	}

	public Integer getColumnIndex() {
		return columnIndex;
	}

	public void setColumnIndex(Integer columnIndex) {
		this.columnIndex = columnIndex;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(Object o1, Object o2) {
		return ((MinHeapNode) o1).getNodeValue().compareTo(((MinHeapNode) o2).getNodeValue());

	}

	@Override
	public String toString() {
		return "valueNode : " + getNodeValue();
	}



	public String getNodeValue() {
		return nodeValue;
	}



	public void setNodeValue(String nodeValue) {
		this.nodeValue = nodeValue;
	}
}

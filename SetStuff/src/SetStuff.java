import java.util.ArrayList;
import java.util.Arrays;

/**
 * Implements the 11 methods created in setstuff into one class
 * @author ameliamao
 */
public class SetStuff {
	
	/**
	 * Return an ArrayList<Integer> that contains 17.
	 * @return: 17
	 */
	ArrayList<Integer> ret17() {
		ArrayList<Integer> seventeen = new ArrayList<>();
		seventeen.add(17);
		return seventeen;
	}

	/**
	 * Take an ArrayList<Integer> and return its zeroth element.
	 * @param al: an ArrayList<Integer>
	 * @return: its zeroth element
	 */
	Integer zerothElement(ArrayList<Integer> al) {
		return al.get(0);
	}

	/**
	 * contains is a method that returns true when the int array ar contaits a the int argument
	 * @param a: an int
	 * @param ar: an int array
	 * @return: boolean if int array contains int
	 */
	boolean contains(int a, int[] ar) {
		for (int i = 0; i < ar.length; i++) {
			if (ar[i] == a) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Takes two arrays and returns true if any element of a is in b.
	 * @param a: int array
	 * @param b: int array
	 * @return: true if any element of a is in b
	 */
	boolean anyContains(int[] a, int[] b) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b.length; j++) {
				if (a[i] == b[j]) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Return the int array that contains all elements in either a or b assuming
	 * the intersection of a and b is empty.
	 * @param a: an int array
	 * @param b: an int array
	 * @return: an int array that contains all elements in a and b
	 */
	int[] union(int[] a, int[] b) {
		int[] arr = new int[a.length + b.length];
		for (int i = 0; i < a.length; i++) {
			arr[i] = a[i];
		}
		for (int j = a.length; j < a.length + b.length; j++) {
			arr[j] = b[j - a.length];
		}
		return arr;
	}

	/**
	 * Returns an array that: 1: Is sorted 2: Has no repeat values 3: Contains any value that is in both a and b
	 * @param a: an int array
	 * @param b: an int array
	 * @return: the intersection of array a and b
	 */
	int[] intersect(int[] a, int[] b) {
		bubbleSort(a);
		bubbleSort(b);
		int[] c = new int[Math.min(a.length, b.length)];
		int ai = 0, bi = 0, ci = 0;
		while (ai < a.length && bi < b.length) {
			if (a[ai] < b[bi]) {
				ai++;
			} else if (a[ai] > b[bi]) {
				bi++;
			} else {
				if (ci == 0 || a[ai] != c[ci - 1]) {
					c[ci++] = a[ai];
				}
				ai++;
				bi++;
			}
		}
		return Arrays.copyOfRange(c, 0, ci);
	}

	/**
	 * helper method for intersect which sorts the array from least to greatest
	 * @param arr: an int array to be sorted
	 */
	public void bubbleSort(int[] arr) {
		int n = arr.length;
		int temp = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 1; j < (n - i); j++) {
				if (arr[j - 1] > arr[j]) {
					temp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}

	/**
	 * Finds the String at the index of the smallest integer for which the corresponding boolean is false. 
	 * Returns an empty string if no distances qualify, assuming the largest value in distance is less than 99999.
	 * @param visited: a boolean array
	 * @param distance: an int array
	 * @param nodeName: a String array
	 * @return: the String at the index of the smallest integer for which the corresponding boolean is false
	 */
	String nearesUnvisitedNode(boolean[] visited, int[] distance, String[] nodeName) {
		int visit = 99999;
		String node = "";
		for (int i = 0; i < visited.length; i++) {
			if (!visited[i]) {
				if (distance[i] < visit) {
					visit = distance[i];
					node = nodeName[i];
				}
			}
		}
		return node;
	}

	/**
	 * Take three ints and return an arrayList containing them.
	 * @param a: an int
	 * @param b: an int
	 * @param c: an int
	 * @return: an arrayList containing all 3 int parameters
	 */
	ArrayList<Object> listify(int a, int b, int c) {
		ArrayList<Object> arr = new ArrayList<>();
		arr.add(a);
		arr.add(b);
		arr.add(c);
		return arr;
	}

	/**
	 * Takes an arraylist of arraylists of integers, and three integers. Makes those three integers into an arrayslist 
	 * and adds that arraylist to the given arraylist and returns that.
	 * @param graph: an arrayList of arrayLists
	 * @param a: an int
	 * @param b: an int
	 * @param c: an int
	 * @return: an arrayList of arrayLists containg the given arrayList and the 3 passed in integers
	 */
	ArrayList<ArrayList<Object>> addEdge(ArrayList<ArrayList<Object>> graph, int a, int b, int c) {
		ArrayList<Object> arr = new ArrayList<>();
		arr.add(a);
		arr.add(b);
		arr.add(c);
		graph.add(arr);
		return graph;
	}

	/**
	 * Takes an arraylist of arraylists of size three of integers and return an arraylist 
	 * that contains the union of all the integers that appear in the first two elements of each arraylist of size three.
	 * @param edgelist: an arrayList of arrayList of size 3 integers
	 * @return: an arrayList that contains the union of all the integers that appear in the first two elements of each arraylist 
	 */
	ArrayList<Integer> collectNodes(ArrayList<ArrayList<Integer>> edgelist) {
		ArrayList<Integer> arr = new ArrayList<>();
		for (int i = 0; i < edgelist.size(); i++) {
			for (int j = 0; j < 2; j++) {
				arr.add(edgelist.get(i).get(j));
			}
		}
		for (int a = 0; a < arr.size(); a++) {
			for (int b = a + 1; b < arr.size(); b++) {
				if (arr.get(a) == arr.get(b)) {
					arr.remove(b);
					b--;
				}
			}
		}
		return arr;
	}

	/**
	 * Given an integer for the size and an integer for the start node create an arraylist of integers 
	 * whose values are maximal except the entry at the index of the start, which should be zero.
	 * @param n: an integer for size
	 * @param start: an interger for the startnode
	 * @return: an arraylist of integers whose values are maximal except the entry at the index of the start, which should be zero
	 */
	ArrayList<Integer> setInfinity(int n, int start) {
		ArrayList<Integer> arr = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			if (i == start) {
				arr.add(0);
			} else {
				arr.add(Integer.MAX_VALUE);
			}
		}
		return arr;
	}
	
	public static void main(String[] arg) {
		
	}

}

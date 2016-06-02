package Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortingExamples {
	
	public static void main(String... orange){
		List<Integer> list = new ArrayList<Integer>(Arrays.asList(1,2,3,5,1,2,3,4,6,3,2,1,-1,-7));
		Collections.sort(list);
		
		
		list = new ArrayList<Integer>(Arrays.asList(-1,-3,-7,0,-2,1,5,-2,-6,10,11,12,15));
		Collections.sort(list);
		for(Integer i : list){
			System.out.println(i);
		}
	}

}


//Name: Sri Darahas Koneru
//Description: This is the sorts file that sorts using the comparator

import java.util.ArrayList;
import java.util.Comparator;



public class Sorts {
	public static void sort(ArrayList<Movie> reviewList, Comparator<Movie> xComparator) {
		//using insertion sort to sort the reviewList based on the specified comparators
		for(int i = 1; i < reviewList.size(); i++) {
			Movie movie = reviewList.get(i);
			int j = i-1;
			while(j >= 0) {
				if(xComparator.compare(movie, reviewList.get(j)) < 0) {
					reviewList.set(j+1, reviewList.get(j));
				} else {
					break;
				}
				j = j-1;
			}
			reviewList.set(j+1, movie);
		}
	}
}
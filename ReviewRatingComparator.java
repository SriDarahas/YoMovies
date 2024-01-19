//Name: Sri Darahas Koneru
//Description: This class is the comparator to sort based on the stars, movie name, director and review

import java.util.Comparator;



public class ReviewRatingComparator implements Comparator<Movie> {

	@Override
	public int compare(Movie first, Movie second) {

		if (first.getStars() == second.getStars()) {
			if (first.getMovieName().compareTo(second.getMovieName()) > 0) {
				return 1;
			} else if (first.getMovieName().compareTo(second.getMovieName()) < 0) {
				return -1;
			} else {
				if (first.getDirector().compareTo(second.getDirector()) > 0) {
					return 1;
				} else if (first.getDirector().compareTo(second.getDirector()) < 0) {
					return -1;
				} else {
					if (first.getReview().compareTo(second.getReview()) > 0) {
						return 1;
					} else if (first.getReview().compareTo(second.getReview()) < 0) {
						return -1;
					} else {
						return 0;
					}
				}
			}
		} else {
			return first.getStars() - second.getStars();
		}
	}
	
}

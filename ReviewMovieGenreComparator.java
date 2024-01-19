//Name: Sri Darahas Koneru
//Description: This class is the comparator to sort based on the movie genre, collection, movie name, director and review

import java.util.Comparator;


public class ReviewMovieGenreComparator implements Comparator<Movie> {

	@Override
	public int compare(Movie first, Movie second) {
		if (first.getMovieGenre().getGenre().compareTo(second.getMovieGenre().getGenre()) > 0) {
			return 1;
		} else if (first.getMovieGenre().getGenre().compareTo(second.getMovieGenre().getGenre()) < 0) {
			return -1;
		} else {
			if (first.getCollection() != second.getCollection()) {
				return first.getCollection() - second.getCollection();
			} else {
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
			}
		}
	}

}

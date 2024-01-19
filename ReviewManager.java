//Name: Sri Darahas Koneru
//Description: This is the review manager details class

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class ReviewManager implements Serializable {
    // The serialVersionUID is used to verify compatibility of senders and
    // receivers. See the document for more details:
    // https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/io/Serializable.html
    private static final long serialVersionUID = 205L;

    private ArrayList<Movie> reviewList;

    public ReviewManager() {
        reviewList = new ArrayList<>();
    }
    
    /**
     * Constructor using the fields
     * @param reviewList
     */
    public ReviewManager(ArrayList<Movie> reviewList) {
		super();
		this.reviewList = reviewList;
	}
    
	public ArrayList<Movie> getReviewList() {
		return reviewList;
	}

	public void setReviewList(ArrayList<Movie> reviewList) {
		this.reviewList = reviewList;
	}

	/**
     * Add a Movie object to the reviewList and return true if such an object
     * is added successfully. Otherwise, return false. Two Movies are
     * considered duplicates if they have the exact same movie name and genre.
     * 
     * @param  movieName          the name of the movie
     * @param  stars              the number of stars the movie received
     * @param  review             the movie review
     * @param  totalCollection    the integer total collection earned by the movie
     * @param  genre              the movie's genre
     * @param  director           the movie's director
     * @param  prodictionCompany  production comapny of the movie
     * @return                    true if the operation is successful; false otherwise
     */
	//Adds a movie review to the reviewList
    public boolean addReview(String movieName, int stars, String review, String totalCollection, String genre, String director, String productionCompany) {
        if (movieExists(movieName, director) == -1) {
            int collection = totalCollection.length();
            MovieGenre newGenre = new MovieGenre(genre, productionCompany);
            Movie newMovie = new Movie(movieName, stars, review, collection, director, newGenre);
            reviewList.add(newMovie);
            return true;
        }
        return false;
    }
    
    /**
     * This method is used to compare the existing movie name and director
     * @param movieName
     * @param director
     * @return the index of existing movie
     */
    private int movieExists(String movieName, String director) {
    	int result = -1;
    	for (Movie movie : reviewList) {
			if (movie.getMovieName().equals(movieName) && movie.getDirector().equals(director)) {
				return reviewList.indexOf(movie);
			}
		}
    	return result;
	}
    
    /**
     * Getting the movie genre indices from the reviewList
     * @param inputGenre
     * @return
     */
    public ArrayList<Integer> movieGenreExists(String inputGenre) {
    	ArrayList<Integer> response = new ArrayList<>();
    	for (int i = 0; i < reviewList.size(); i++) {
    		if(reviewList.get(i).getMovieGenre().getGenre().equals(inputGenre)) {
    			response.add(i);
    		}
    	}
    	return response;
    }
    
    /**
     * getter movie based on the index
     * @param index
     * @return
     */
    public Movie getMovie(int index) {
    	return reviewList.get(index);
    }

    /**
     * This method is used to return the list of reviews in the specified format.
     * @return
     */
	public String listReviews() {
		StringBuilder sb = new StringBuilder();
		if(reviewList.size() > 0) {
			for (Movie movie : reviewList) {
				sb.append(movie);
				sb.append("\n");
			}
		} else {
			sb.append("No Reviews available");
		}
		
		return sb.toString();
	}

	/**
	 * This method is used to get the review by movie name and the director
	 * @param movieName
	 * @param director
	 * @return
	 */
	public String getReviewByMovieNameAndDirector(String movieName, String director) {
		for(Movie movie : reviewList) {
			if(movie.getMovieName().equals(movieName) && movie.getDirector().equals(director)) {
				return "Movie found. Here's the review:\n"+movie.getReview()+'\n';
			}
		}
		return "Movie not found. Please try again"+'\n';
	}

	/**
	 * This method is used to get the number of movies by genre
	 * @param movieGenre
	 * @return
	 */
	public String getNumberOfMoviesByGenre(String movieGenre) {
		String response = null;
		int count = 0;
		List<Movie> reviews = new ArrayList<>();
		for (Movie movie : reviewList) {
			if (movie.getMovieGenre().getGenre().equals(movieGenre)) {
				count = count + 1;
				reviews.add(movie);
			}
		}
		if (count > 0) {
			response = count+" Movies matching "+movieGenre+" type were found:"+'\n';
			for(Movie movie:reviews) {
				response = response + movie;
			}
		} else {
			response =  "Movie Genre: "+movieGenre+" was NOT found" + '\n';
		}
		return response;
	}

	/**
	 * This method is use to clear the reviewList
	 */
	public void closeReviewManager() {
		reviewList.clear();
	}

	/**
	 * This method is used to remove the review based on the movie name and director
	 * @param movieName
	 * @param director
	 * @return
	 */
	public String removeReview(String movieName, String director) {
		String response = movieName+", "+director+" was NOT removed"+'\n';
		for (Movie movie : reviewList) {
			if (movie.getMovieName().equals(movieName) && movie.getDirector().equals(director)) {
				reviewList.remove(movie);
				return movieName+", "+director+" was removed"+'\n';
			}
		}
		return response;
	}

	/**
	 * This method is used to Sort by rating
	 */
	public void sortByRating() {
		ReviewRatingComparator reviewRatingComparator = new ReviewRatingComparator();
		Sorts.sort(reviewList, reviewRatingComparator);
	}

	/**
	 * This method is used to Sort by Movie genre
	 */
	public void sortByMovieGenre() {
		ReviewMovieGenreComparator reviewMovieGenreComparator = new ReviewMovieGenreComparator();
		Sorts.sort(reviewList, reviewMovieGenreComparator);
	}
}

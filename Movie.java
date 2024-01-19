
//Name: Sri Darahas Koneru
//Description: This is the movie details class

import java.io.Serializable;


public class Movie implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String movieName;
	private int stars;
	private String review;
	private int collection;
	private String director;
	private MovieGenre movieGenre;

	public Movie() {
		
	}

	public Movie(String movieName, int stars, String review, int collection, String director, MovieGenre movieGenre) {
		super();
		this.movieName = movieName;
		this.stars = stars;
		this.review = review;
		this.collection = collection;
		this.director = director;
		this.movieGenre = movieGenre;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public int getStars() {
		return stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public int getCollection() {
		return collection;
	}

	public void setCollection(int collection) {
		this.collection = collection;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public MovieGenre getMovieGenre() {
		return movieGenre;
	}

	public void setMovieGenre(MovieGenre movieGenre) {
		this.movieGenre = movieGenre;
	}

	@Override
	public String toString() {
		String stars = "";
		for (int i = 0; i < this.getStars(); i++) {
			stars = stars.concat("*");
		}
		String collection = "";
		for (int j = 0; j < this.getCollection(); j++) {
			collection = collection.concat("$");
		}
		return this.getMovieName() + " Movie\n" + stars + '\n' + "Total Collection earned: " + collection + '\n'
				+ this.getMovieGenre().getGenre() + " Movie" + '\n' + "Production Company: "
				+ this.getMovieGenre().getProductionCompany() + '\n' + "Director: " + this.getDirector() + '\n'
				+ "Review: " + this.getReview() + '\n';
	}

}
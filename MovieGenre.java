//Name: Sri Darahas Koneru
//Description: This is the movie genre details class

import java.io.Serializable;


public class MovieGenre implements Serializable {
    // The serialVersionUID is used to verify compatibility of senders and
    // receivers. See the document for more details:
    // https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/io/Serializable.html
    private static final long serialVersionUID = 205L; 
    private String genre;
    private String productionCompany;

    public MovieGenre(String genre, String productionCompany) {
        this.genre = genre;
        this.productionCompany = productionCompany;
    }

    public String getGenre() {
        return genre;
    }

    public String getProductionCompany() {
		return productionCompany;
	}

	@Override
    public String toString() {
        return genre + " Movie\n" +
                "Production Company:\t" + productionCompany + '\n';
    }
}

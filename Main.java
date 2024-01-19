//Name: Sri Darahas Koneru
//Description: Contains the Main File and Menu

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
 


public class Main
{
    public static void main(String[] args) {
        // Menu options
        char inputOpt = ' ';
        String inputLine;
        // Movie and Movie Genre information
        String movieName, movieGenre;
        String review = null, director, productionCompany, totalCollection;

        int rating;
        // Output information
        String outFilename, inFilename;
        String outMsg, inMsg;
        // Movie manager
        ReviewManager reviewManager = new ReviewManager();
        // Operation result
        boolean opResult;   
        
        try {
            printMenu();
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader stdin = new BufferedReader(isr);

            do {
                System.out.print("\nWhat action would you like to perform?\n");
                inputLine = stdin.readLine().trim();
                if (inputLine.isEmpty()) {
                    continue;
                }
                inputOpt = inputLine.charAt(0);
                inputOpt = Character.toUpperCase(inputOpt);

                switch (inputOpt) {

                    case 'A': // Add a new Movie Review
                        System.out.print("Please enter the movie information:\n");
                        System.out.print("Enter the movie name:\n");
                        movieName = stdin.readLine().trim(); 
                        System.out.print("Enter the review:\n");
                        review = stdin.readLine().trim();
                        System.out.print("Enter the total collection:\n");
                        totalCollection = stdin.readLine().trim();
                        System.out.print("Enter the rating:\n");
                        rating = Integer.parseInt(stdin.readLine().trim());
                        System.out.print("Enter the movie genre:\n");
                        movieGenre = stdin.readLine().trim();
                        System.out.print("Enter the movie's Director:\n");
                        director = stdin.readLine().trim();
                        System.out.print("Enter the movie's production company\n");
                        productionCompany = stdin.readLine().trim();
                        /*********************************************************************
                         * Complete the code by calling the addReview method.                 *
                         * If the review was added successfully, show                    *
                         * "Movie added to the database!\n" on screen, otherwise "Movie NOT added!\n" *
                         **********************************************************************/
                        boolean response = reviewManager.addReview(movieName, rating, review, totalCollection, movieGenre, director, productionCompany);
                        if(response == true) {
                        	System.out.print("Movie added to the database!"+'\n');
                        } else {
                        	System.out.print("Movie NOT added!"+'\n');
                        }
                    break;
                    case 'D': // Search for a movie
                        System.out.print("Please enter the Movie name to search:\n");
                        movieName = stdin.readLine().trim();
                        System.out.print("Please enter the movies's director':\n");
                        director = stdin.readLine().trim();
                        
                        /*********************************************************************
                         * Complete the code. If the movie review exists, print            *
                         * "Movie found. Here's the review:\n"                           *
                         * Otherwise, print "Movie not found. Please try again\n"        *
                         **********************************************************************/
                        String reviewResponse = reviewManager.getReviewByMovieNameAndDirector(movieName, director);
                        System.out.print(reviewResponse);
                        break;
                    case 'E': // Search for a Movie Genre
                        System.out.print("Please enter the movie genre to search:\n");
                        movieGenre = stdin.readLine().trim();
                        
                        /*******************************************************************************
                        * Complete the code. If a movie genre is found, show on the screen how many    *
                        * movies match that genre by printing                                          *
                        * "%s Movies matching %s type were found:\n" followed by the reviews.          *
                        * Otherwise, print "Movie Genre: %s was NOT found\n"                           *
                        ******************************************************************************/   
                        String genreResponse = reviewManager.getNumberOfMoviesByGenre(movieGenre);
                        System.out.print(genreResponse);
                        break;
                    case 'L': // List movie's reviews
                        System.out.print("\n" + reviewManager.listReviews() + "\n");
                        break;
                    
                     /******************************************************************************************
                     * Complete the code by adding two cases:                                                  *
                     * case 'N': sorts the movie reviews by rating and prints "sorted by rating\n"             *
                     * case 'P': sorts the movie reviews by movie genre and prints "sorted by genre\n"         *
                     * You must implement your own sorting algorithm!
                     ******************************************************************************************/                        
                    case 'N':
                    	reviewManager.sortByRating();
                    	System.out.print("sorted by rating\n");
                    	break;
                    case 'P':
                    	reviewManager.sortByMovieGenre();
                    	System.out.print("sorted by genre\n");
                    	break;
                    case 'Q': // Quit
                        break;

                    case 'R': // Remove a review
                        System.out.print("Please enter the name of the movie for which you want the review removed:\n");
                        movieName = stdin.readLine().trim();
                        System.out.print("Please enter the name of the movie's director:\n");
                        director = stdin.readLine().trim();
                        
                        /*******************************************************************************
                        * Complete the code. If a review for a certain movie directed by the given     *
                        * director is found, remove the review and print that it was removed. Otherwise*
                        * print that it was NOT removed.                                               * 
                        *******************************************************************************/
                       String removedReview = reviewManager.removeReview(movieName, director);
                       System.out.print(removedReview);
                       break;
        
                    case 'T': // Close reviewList
                        reviewManager.closeReviewManager();
                        System.out.print("The movie management system was reset!\n");
                        break;

                    case 'U': // Write movies' names and reviews to a text file
                        System.out.print("Please enter a file name that we will write to:\n");
                        outFilename = stdin.readLine().trim();
                        System.out.print("Please enter the name of the movie:\n");
                        movieName = stdin.readLine().trim();
                        System.out.println("Please enter a review to save locally:\n");
                        review = stdin.readLine().trim();
                        outMsg = movieName + "\n" + review + "\n";
                        
                        /*************************************************************************************
                        * Add a try and catch block to write the string outMsg into the user-specified file  *
                        * Then, print on the screen that the file " is written\n"                            *
                        * In case of an IO Exception, print "Write string inside the file error\n"           *                                                             
                        *************************************************************************************/    
						try {
							FileWriter writer = new FileWriter(outFilename);  
	                        BufferedWriter buffer = new BufferedWriter(writer);  
	                        buffer.write(outMsg);  
	                        buffer.close();
	                        System.out.println(outFilename+" is written"+'\n'); 
						} catch (IOException e) {
							System.out.println("Write string inside the file error"+'\n');
						}
                        break;
                    case 'V': // Read strings from a text file
                        System.out.print("Please enter a file name which we will read from:\n");
                        inFilename = stdin.readLine().trim();
                        
                        /******************************************************************************************
                        * Add a try and catch block to read from the above text file. Confirm that the file       *
                        * " was read\n" and then print "The contents of the file are:\n" followed by the contents *
                        * In case of an IO Exception, print "Read string from file error\n"                       *  
                        * In case of a file not found exception, print that the file " was not found\n"           *                                                             
                        ******************************************************************************************/ 
						try {
							FileReader fr = new FileReader(inFilename);
	                        System.out.println(inFilename+" was read");
	                        System.out.println("The contents of the file are:");
	                        int i;
	                        while((i = fr.read()) != -1) {
	                        	System.out.print((char)i);
	                        }
	                        fr.close();
	                        System.out.println("\n");
						} catch (FileNotFoundException e) {
							System.out.println(inFilename+" was not found"+'\n');
						} catch(IOException e) {
							System.out.println("Read string from file error"+'\n');
						}
                        break;
                    case 'W': // Serialize ReviewManager to a data file
                        System.out.print("Please enter a file name to write:\n");
                        outFilename = stdin.readLine().trim();
                        
                        ReviewManager rm = new ReviewManager(reviewManager.getReviewList());
                        /****************************************************************************
                        * Add a try and catch block to serialize ReviewManager to a data file.      *
                        * Catch two exceptions and print the corresponding messages on the screen:  *
                        * "Not serializable exception\n"                                            *
                        * "Data file written exception\n"                                           * 
                        ****************************************************************************/  
                        
						try {
							FileOutputStream fos = new FileOutputStream(outFilename);
							ObjectOutputStream oos = new ObjectOutputStream(fos);
							oos.writeObject(rm);
							oos.close();
							fos.close();
							//System.out.println(outFilename+" was written\n");
						} catch (NotSerializableException e) {
							System.out.println("Not serializable exception\n");
						} catch (IOException e) {
							System.out.println("Data file written exception\n");
						}
                        break;
                    case 'X': // Deserialize ReviewManager from a data file
                        System.out.print("Please enter a file name which we will read from:\n");
                        inFilename = stdin.readLine().trim();
                        
                        /*****************************************************************************
                         * Add a try and catch block to deserialize ReviewManager from a data file.  *
                         * Catch three exceptions and print the corresponding messages on the screen:*
                         * "Class not found exception\n"                                             *
                         * "Not serializable exception\n"                                            * 
                         * "Data file read exception\n"                                              *
                         ****************************************************************************/ 
                        ReviewManager reviewMgr = null;
						try {
							FileInputStream fis = new FileInputStream(inFilename);
							ObjectInputStream ois = new ObjectInputStream(fis);

							reviewMgr = (ReviewManager) ois.readObject();
							
							ois.close();
							fis.close();
							System.out.print(inFilename+" was read\n");
							reviewManager.setReviewList(reviewMgr.getReviewList());
						} catch (NotSerializableException e) {
							System.out.println("Not serializable exception\n");
						} catch (IOException ex) {
							System.out.println("Data file read exception\n");
						} catch (ClassNotFoundException ex) {
							System.out.println("Class not found exception\n");
						} 
                        break;
                    case '?': // Display help
                        printMenu();
                        break;

                    default:
                        System.out.print("Unknown action\n");
                        break;
                }

            } while (inputOpt != 'Q' || inputLine.length() != 1);
        }
        catch (IOException exception) {
            System.out.print("IO Exception\n");
        }
    }

    public static void printMenu() {
        System.out.println("Welcome to YoMovies! ");
        System.out.println("Find or post reviews for your favorite (and not so favorite) movies.");

        System.out.print("Choice\t\tAction\n" + "------\t\t------\n" + "A\t\tAdd a review\n"
                + "D\t\tSearch for a movie\n" + "E\t\tSearch for a genre\n"
                + "L\t\tList all reviews\n" + "N\t\tSort by stars\n" + "P\t\tSort by genre\n"
                + "Q\t\tQuit\n" + "R\t\tRemove a review\n"
                + "U\t\tAdd personal review to a local file\n" + "V\t\tRetrieve personal review from a local file\n"
                + "W\t\tSave reviews to a file\n"
                + "X\t\tUpload reviews from a file\n"
                + "T\t\t(admin) reset database\n"
                + "?\t\tDisplay Help\n");
    }
   
}

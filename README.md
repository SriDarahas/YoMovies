# YoMovies - Movie Review Management System

## Project Overview

YoMovies is a command-line Movie Review Management System designed to simplify the process of managing and reviewing movies. It provides functionalities to search for movies, add reviews, list reviews, and perform operations like sorting, searching, serialization, and deserialization.

## Features

- **Add a Review (Option A):** Input movie details, a review, total collection, movie rating, movie genre, director, and production company.
- **Search for a Movie (Option D):** Look up a movie review by movie name and director.
- **Search for a Movie Genre (Option E):** Search for movies of a specific genre.
- **List Movie Reviews (Option L):** Display a list of all movie reviews.
- **Sort reviews by rating (Option N):** Sort movie reviews by rating.
- **Sort reviews by movie genre (Option P):** Sort movie reviews by movie genre.
- **Remove a movie review (Option R):** Remove a movie review by movie name and director.
- **Write/Read to/from text file (Options U and V):** Save and retrieve movie names and reviews to/from a text file.
- **Serialize/Deserialize ReviewManager (Options W and X):** Save and load the Movie Review System.

## How to Run

1. Download the following files:
   - Main.java
   - ReviewManager.java
   - MovieGenre.java
   - Movie.java
   - Sorts.java
   - ReviewRatingComparator.java
   - ReviewMovieGenreComparator.java

2. Implement the missing code based on provided comments.

3. Compile and run `Main.java` to interact with YoMovies.

## Implementation

- Implement classes in the suggested order (Movie, ReviewRatingComparator, ReviewMovieGenreComparator, Sorts, ReviewManager).
- Test each menu option to ensure proper functionality.
- Comment out unimplemented menu choices during testing.
- Handle user input with appropriate prompts and display results clearly.

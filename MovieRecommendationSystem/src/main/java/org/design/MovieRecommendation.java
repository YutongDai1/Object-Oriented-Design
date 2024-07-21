package org.design;

import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class MovieRecommendation {
  private RatingRegister ratingRegister;

  public MovieRecommendation(RatingRegister ratingRegister) {
    this.ratingRegister = ratingRegister;
  }

  public String recommendMovie(User user) {
    if (this.ratingRegister.getUserMovies(user).isEmpty()) {
      return recommendMovieToUnknownUser();
    } else {
      return recommendMovieToExistingUser(user);
    }
  }

  private String recommendMovieToUnknownUser() {
    double bestRating = 0;
    Movie bestMovie = null;
    List<Movie> movies = this.ratingRegister.getMovies();
    for (Movie cur : movies) {
      double curRating = this.ratingRegister.getAverageRating(cur);
      if (curRating > bestRating) {
        bestRating = curRating;
        bestMovie = cur;
      }
    }
    return bestMovie != null ? bestMovie.getTitle() : null;
  }

  private String recommendMovieToExistingUser(User user) {
    Movie bestMovie = null;
    int similarityScore = Integer.MAX_VALUE; // Lower is better

    for (User reviewer : this.ratingRegister.getUsers()) {
      if (reviewer.getId() == user.getId()) {
        continue;
      }
      int score = this.getSimilarityScore(user, reviewer);
      if (score < similarityScore) {
        similarityScore = score;
        Movie recommendedMovie = this.recommendUnwatchedMovie(user, reviewer);
        bestMovie = recommendedMovie != null ? recommendedMovie : bestMovie;
      }
    }
    return bestMovie != null ? bestMovie.getTitle() : null;
  }

  private int getSimilarityScore(User user1, User user2) {

    int similarityScore = Integer.MAX_VALUE; // Lower is better
    for (Movie movie : this.ratingRegister.getUserMovies(user2)) {
      Map<Integer, MovieRating> ratings = this.ratingRegister.getMovieRatings(movie);
      // If user1 also rated the movie, add the difference in ratings
      if (ratings.containsKey(user1.getId())) {
        similarityScore = (similarityScore == Integer.MAX_VALUE) ? 0 : similarityScore;
        similarityScore += Math.abs(
            ratings.get(user1.getId()).ordinal() - ratings.get(user2.getId()).ordinal());
      }
    }
    return similarityScore;
  }

  private Movie recommendUnwatchedMovie(User user1, User user2) {
    Movie bestMovie = null;
    int bestRating = 0;
    for (Movie movie : this.ratingRegister.getUserMovies(user2)) {
      Map<Integer, MovieRating> ratingMap = this.ratingRegister.getMovieRatings(movie);
      if (!ratingMap.containsKey(user1.getId()) && ratingMap.get(user2.getId()).ordinal() > bestRating) {
        bestMovie = movie;
        bestRating = ratingMap.get(user2.getId()).ordinal();
      }
    }

    return bestMovie;
  }
}

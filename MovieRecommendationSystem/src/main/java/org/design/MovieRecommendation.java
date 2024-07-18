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
    if (this.ratingRegister.gerUserMovies(user).isEmpty()) {
      return recommendMovieToUnknownUser();
    } else {
      return recommendMovieToExistingUser();
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
}

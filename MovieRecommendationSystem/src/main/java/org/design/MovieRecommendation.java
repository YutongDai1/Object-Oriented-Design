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

  private String recommendMovieToExistingUser() {
    return "";
  }
}

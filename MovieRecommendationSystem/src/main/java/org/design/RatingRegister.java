package org.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RatingRegister {

  private Map<Integer, List<Movie>> userMovies;
  private Map<Integer, Map<Integer, MovieRating>> movieRatings;

  private List<Movie> movies;
  private List<User> users;

  public RatingRegister() {
    this.userMovies = new HashMap<>();
    this.movieRatings = new HashMap<>();

    this.movies = new ArrayList<>();
    this.users = new ArrayList<>();
  }

  public void addRating(User user, Movie movie, MovieRating rating) {
    if (!userMovies.containsKey(user.getId())) {
      users.add(user);
      userMovies.put(user.getId(), new ArrayList<>());
    }

    if (!movieRatings.containsKey(movie.getId())) {
      movies.add(movie);
      movieRatings.put(movie.getId(), new HashMap<>());
    }
    this.userMovies.get(user.getId()).add(movie);
    this.movieRatings.get(movie.getId()).put(user.getId(), rating);
  }
  public double getAverageRating(Movie movie) {
    if (!this.movieRatings.containsKey(movie.getId())) {
      return MovieRating.NOT_RATED.ordinal();
    }
    Map<Integer, MovieRating> ratings = this.movieRatings.get(movie.getId());
    int sum = 0;
    for (MovieRating rating : ratings.values()) {
      sum += rating.ordinal();
    }
    return (double) sum / ratings.size();
  }

  public List<Movie> getUserMovies(User user) {
    int userId = user.getId();
    if (!userMovies.containsKey(userId)) {
      return new ArrayList<>();
    }
    return userMovies.get(userId);
  }
  public Map<Integer, MovieRating> getMovieRatings(Movie movie) {
    if (!this.movieRatings.containsKey(movie.getId())) {
      return new HashMap<>();
    }
    return this.movieRatings.get(movie.getId());
  }
  public List<User> getUsers() {
    return this.users;
  }

  public List<Movie> getMovies() {
    return this.movies;
  }

}

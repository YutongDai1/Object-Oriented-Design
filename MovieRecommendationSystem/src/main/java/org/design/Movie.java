package org.design;


public class Movie {
  private int id;
  private String title;

  public Movie(int id, String title) {
    this.id = id;
    this.title = title;
  }

  public int getId() {
    return this.id;
  }

  public String getTitle() {
    return this.title;
  }
}
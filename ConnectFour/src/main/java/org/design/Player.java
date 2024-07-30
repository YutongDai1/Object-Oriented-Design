package org.design;

public class Player {

  private String name;
  private GridPositionStatus piece;

  public Player(String name, GridPositionStatus piece) {
    this.name = name;
    this.piece = piece;
  }

  public String getName() {
    return this.name;
  }

  public GridPositionStatus getPieceColor() {
    return this.piece;
  }

}

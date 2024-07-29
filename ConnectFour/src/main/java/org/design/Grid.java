package org.design;

public class Grid {
  private int rows;
  private int columns;
  private int[][] grid;

  public Grid(int rows, int columns) {
    this.rows = rows;
    this.columns = columns;
    initGrid();
  }

  public void initGrid() {
    this.grid = new int[rows][columns];
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        grid[i][j] = GridPosition.EMPTY.ordinal();
      }
    }
  }
}

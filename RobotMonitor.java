public class RobotMonitor {
  // CONSTANTS
  public static final int MAX = 6;
  public static final int MIN = 1;

  // STATE ATTRIBUTES
  private int row;
  private int col;
  private Move move;

  // invariant
  public boolean inv() {
    return (MIN <= row && row <= MAX
        && MIN <= col && col <= MAX);
  }

  // initialisation
  public RobotMonitor() {
    row = MIN;
    col = MIN;
    move = null;

    if (!inv()) {
      throw new VDMException("Invarient broken!");
    }
  }

  // operations
  public int GetCol() {
    return col;
  }

  public int GetRow() {
    return row;
  }

  public Move GetMove() {
    return move;
  }

  public void MoveRight() {
    if (move != Move.RIGHT && col != MAX) {
      col = col + 1;
      move = Move.RIGHT;
    } else if (col == MAX) {
      throw new VDMException(
          "Current col is: " + col + ", Robot is on the edge!");
    } else {
      throw new VDMException(
          "Previous move was: " + move + ", Cannot move the same direction twice.");
    }

    if (!inv()) {
      throw new VDMException("Invarient broken!");
    }
  }

  public void MoveLeft() {
    if (move != Move.LEFT && col != MIN) {
      col = col - 1;
      move = Move.LEFT;
    } else if (col == MIN) {
      throw new VDMException(
          "Current col is: " + col + ", Robot is on the edge!");
    } else {
      throw new VDMException(
          "Previous move was: " + move + ", Cannot move the same direction twice.");
    }

    if (!inv()) {
      throw new VDMException("Invarient broken!");
    }
  }

  public void MoveDown() {
    if (move != Move.DOWN && row != MAX) {
      row = row + 1;
      move = Move.DOWN;
    } else if (row == MAX) {
      throw new VDMException(
          "Current row is: " + row + ", Robot is on the edge!");
    } else {
      throw new VDMException(
          "Previous move was: " + move + ", Cannot move the same direction twice.");
    }

    if (!inv()) {
      throw new VDMException("Invarient broken!");
    }
  }

  public void MoveUp() {
    if (move != Move.UP && row != MIN) {
      row = row - 1;
      move = Move.UP;
    } else if (row == MIN) {
      throw new VDMException(
          "Current row is: " + row + ", Robot is on the edge!");
    } else {
      throw new VDMException(
          "Previous move was: " + move + ", Cannot move the same direction twice.");
    }

    if (!inv()) {
      throw new VDMException("Invarient broken!");
    }
  }

  public void Exit() {
    if (row == MAX && col == MAX) {
      System.out.println("Robot mission completed...");
      row = MIN;
      col = MIN;
      move = null;
    } else {
      throw new VDMException("Robot is not on the exit tile... Current position: row = "
          + row + ", col = " + col);
    }
  }

  // toString method added
  public String toString() {
    // modify if you are using the text based tester
    return " ";
  }
}

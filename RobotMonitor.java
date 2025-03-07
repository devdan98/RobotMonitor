public class RobotMonitor {
  private static final int MAX = 6;
  private static final int MIN = 1;
  public static int row = MIN;
  public static int col = MIN;
  public static Moves move;

  public RobotMonitor(int rowIn, int colIn, Moves moveIn) {
    row = rowIn;
    col = colIn;
    move = moveIn;
  }

  public static void main(String[] args) {
    System.out.println(RobotMonitor.GetCol());
    System.out.println(RobotMonitor.GetRow());
    System.out.println(RobotMonitor.GetMove());

    RobotMonitor.MoveRight();
    RobotMonitor.MoveDown();
    RobotMonitor.MoveLeft();
    RobotMonitor.MoveUp();

    System.out.println(RobotMonitor.GetCol());
    System.out.println(RobotMonitor.GetRow());
    System.out.println(RobotMonitor.GetMove());

    RobotMonitor.MoveRight();
    RobotMonitor.MoveDown();
    RobotMonitor.MoveRight();
    RobotMonitor.MoveDown();
    RobotMonitor.MoveRight();
    RobotMonitor.MoveDown();
    RobotMonitor.MoveRight();
    RobotMonitor.MoveDown();
    RobotMonitor.MoveRight();
    RobotMonitor.MoveDown();

    System.out.println(RobotMonitor.GetCol());
    System.out.println(RobotMonitor.GetRow());
    System.out.println(RobotMonitor.GetMove());

    RobotMonitor.Exit();

    RobotMonitor.MoveRight();
    RobotMonitor.MoveDown();

    System.out.println(RobotMonitor.GetCol());
    System.out.println(RobotMonitor.GetRow());
    System.out.println(RobotMonitor.GetMove());
  }

  static void MoveRight() {
    if (RobotMonitor.GetMove() != Moves.RIGHT && col != MAX) {
      col = col + 1;
      move = Moves.RIGHT;
    } else {
      throw new IllegalArgumentException(
          "Previous move was: " + RobotMonitor.GetMove() + ", Cannot move the same direction twice.");
    }
  }

  static void MoveLeft() {
    if (RobotMonitor.GetMove() != Moves.LEFT && col != MIN) {
      col = col - 1;
      move = Moves.LEFT;
    } else {
      throw new IllegalArgumentException(
          "Previous move was: " + RobotMonitor.GetMove() + ", Cannot move the same direction twice.");
    }
  }

  static void MoveUp() {
    if (RobotMonitor.GetMove() != Moves.UP && row != MIN) {
      row = row - 1;
      move = Moves.UP;
    } else {
      throw new IllegalArgumentException(
          "Previous move was: " + RobotMonitor.GetMove() + ", Cannot move the same direction twice.");
    }
  }

  static void MoveDown() {
    if (RobotMonitor.GetMove() != Moves.DOWN && row != MAX) {
      row = row + 1;
      move = Moves.DOWN;
    } else {
      throw new IllegalArgumentException(
          "Previous move was: " + RobotMonitor.GetMove() + ", Cannot move the same direction twice.");
    }
  }

  static Moves GetMove() {
    return move;
  }

  static int GetCol() {
    return col;
  }

  static int GetRow() {
    return row;
  }

  static void Exit() {
    if (RobotMonitor.GetRow() == MAX && RobotMonitor.GetCol() == MAX) {
      System.out.println("Robot mission completed...");
      row = MIN;
      col = MIN;
      move = null;
    } else {
      throw new IllegalArgumentException("Robot is not on the exit tile... Current position: row = "
          + RobotMonitor.GetRow() + ", col = " + RobotMonitor.GetCol());
    }
  }
}

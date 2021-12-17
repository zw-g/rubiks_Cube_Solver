/**
 * <h2> Rubiks Cube solver </h2>
 * This program implements an AI to solve Rubiks Cube without any human knowledge
 * <p>
 * <b>Note:</b> I got the Idea from the paper https://tomas.rokicki.com/rubik20.pdf
 * it explains that I can move from any position to another in 20 moves or less. This sequence of
 * moves can be very hard to find but it exists...
 *
 * So I have used 21 as the size of the array to find the solution move to complete the cube.
 * @author Zhaowei Gu
 * @version 1.0
 * @since 2021-12-10
 */

public class ForceSolver {

  //possible moved to be down
  private final String[] m = {"L", "L'", "R", "R'", "U", "U'", "D", "D'", "F", "F'", "B", "B'", "M",
      "M'", "E", "E'", "S", "S'"};

  //solve
  public void solve(RubiksCube cube) {
    findMove(cube, 1);
  }

  //it will find the best move and do it with recursion
  private boolean findMove(RubiksCube cube, int l) {
    int level = l;
    if (level <= 21) {
      for (int i = 0; i < 18; i++) {
        if (cube.checkComplete()) {
          return true;
        } else {
          level++;
          cube.move(m[i]);
          if (findMove(cube, level)) {
            return true;
          } else {
            level--;
          }
        }
      }
    }
    return false;
  }
}

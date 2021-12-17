/**
 * <h2> Rubiks Cube solver </h2>
 * This program implements an AI to solve Rubiks Cube
 * it implements based on Rubiks solving algorithms with human knowledge
 * it works very well
 * <p>
 * <b>Note:</b> Divided the job into to 7 methods
 *
 * @author Zhaowei Gu
 * @version 1.0
 * @since 2021-12-10
 */

public class AiSolver {

  //split to 7 steps
  public void solve(RubiksCube cube) {
    solveEdge(cube);
    solveCorner(cube);
    solveSecondLayer(cube);
    solveCross(cube);
    finishTop(cube);
    finishCorners(cube);
    fixTopEdge(cube);
  }

  //solve the bottom layer to draw a cross
  private void solveEdge(RubiksCube cube) {
    while (!cube.getCube()[5][4][0].equals(cube.getCube()[5][1][0])
        || !cube.getCube()[5][4][0].equals(cube.getCube()[5][3][0])
        || !cube.getCube()[5][4][0].equals(cube.getCube()[5][5][0])
        || !cube.getCube()[5][4][0].equals(cube.getCube()[5][7][0])
        || !cube.getCube()[0][4][0].equals(cube.getCube()[0][7][0])
        || !cube.getCube()[1][4][0].equals(cube.getCube()[1][7][0])
        || !cube.getCube()[3][4][0].equals(cube.getCube()[3][7][0])
        || !cube.getCube()[4][4][0].equals(cube.getCube()[4][7][0])) {

      // 90 turns
      if (cube.getCube()[5][4][0].equals(cube.getCube()[3][3][0]) && cube.getCube()[4][5][0].equals(
          cube.getCube()[4][4][0])) {
        cube.move("F");
      }
      if (cube.getCube()[5][4][0].equals(cube.getCube()[1][5][0]) && cube.getCube()[0][3][0].equals(
          cube.getCube()[0][4][0])) {
        cube.move("F'");
      }
      if (cube.getCube()[5][4][0].equals(cube.getCube()[0][3][0]) && cube.getCube()[1][5][0].equals(
          cube.getCube()[1][4][0])) {
        cube.move("L");
      }
      if (cube.getCube()[5][4][0].equals(cube.getCube()[4][5][0]) && cube.getCube()[1][3][0].equals(
          cube.getCube()[1][4][0])) {
        cube.move("L'");
      }
      if (cube.getCube()[5][4][0].equals(cube.getCube()[0][5][0]) && cube.getCube()[3][3][0].equals(
          cube.getCube()[3][4][0])) {
        cube.move("R'");
      }
      if (cube.getCube()[5][4][0].equals(cube.getCube()[4][3][0]) && cube.getCube()[3][5][0].equals(
          cube.getCube()[3][4][0])) {
        cube.move("R");
      }
      if (cube.getCube()[5][4][0].equals(cube.getCube()[1][3][0]) && cube.getCube()[4][5][0].equals(
          cube.getCube()[4][4][0])) {
        cube.move("B");
      }
      if (cube.getCube()[5][4][0].equals(cube.getCube()[3][5][0]) && cube.getCube()[4][3][0].equals(
          cube.getCube()[4][4][0])) {
        cube.move("B'");
      }

      // bottom zero, top
      if (cube.getCube()[5][4][0].equals(cube.getCube()[2][7][0]) && cube.getCube()[0][1][0].equals(
          cube.getCube()[0][4][0])) {
        cube.move("F");
        cube.move("F");
      }
      if (cube.getCube()[5][4][0].equals(cube.getCube()[0][1][0]) && cube.getCube()[2][7][0].equals(
          cube.getCube()[0][4][0])) {
        cube.move("R");
        cube.move("U'");
        cube.move("R'");
        cube.move("F");
      }
      if (cube.getCube()[5][4][0].equals(cube.getCube()[2][3][0]) && cube.getCube()[1][1][0].equals(
          cube.getCube()[0][4][0])) {
        cube.move("U'");
        cube.move("F");
        cube.move("F");
      }
      if (cube.getCube()[5][4][0].equals(cube.getCube()[1][1][0]) && cube.getCube()[2][3][0].equals(
          cube.getCube()[0][4][0])) {
        cube.move("U'");
        cube.move("R");
        cube.move("U'");
        cube.move("R'");
        cube.move("F");
      }
      if (cube.getCube()[5][4][0].equals(cube.getCube()[2][5][0]) && cube.getCube()[3][1][0].equals(
          cube.getCube()[0][4][0])) {
        cube.move("U");
        cube.move("F");
        cube.move("F");
      }
      if (cube.getCube()[5][4][0].equals(cube.getCube()[3][1][0]) && cube.getCube()[2][5][0].equals(
          cube.getCube()[0][4][0])) {
        cube.move("U");
        cube.move("R");
        cube.move("U'");
        cube.move("R'");
        cube.move("F");
      }
      if (cube.getCube()[5][4][0].equals(cube.getCube()[2][1][0]) && cube.getCube()[4][1][0].equals(
          cube.getCube()[0][4][0])) {
        cube.move("U");
        cube.move("U");
        cube.move("F");
        cube.move("F");
      }
      if (cube.getCube()[5][4][0].equals(cube.getCube()[4][1][0]) && cube.getCube()[2][1][0].equals(
          cube.getCube()[0][4][0])) {
        cube.move("U");
        cube.move("U");
        cube.move("R");
        cube.move("U'");
        cube.move("R'");
        cube.move("F");
      }

      // bottom one, top
      if (cube.getCube()[5][4][0].equals(cube.getCube()[2][3][0]) && cube.getCube()[1][1][0].equals(
          cube.getCube()[1][4][0])) {
        cube.move("L");
        cube.move("L");
      }
      if (cube.getCube()[5][4][0].equals(cube.getCube()[1][1][0]) && cube.getCube()[2][3][0].equals(
          cube.getCube()[1][4][0])) {
        cube.move("F");
        cube.move("U'");
        cube.move("F'");
        cube.move("L");
      }
      if (cube.getCube()[5][4][0].equals(cube.getCube()[2][7][0]) && cube.getCube()[0][1][0].equals(
          cube.getCube()[1][4][0])) {
        cube.move("U");
        cube.move("L");
        cube.move("L");
      }
      if (cube.getCube()[5][4][0].equals(cube.getCube()[0][1][0]) && cube.getCube()[2][7][0].equals(
          cube.getCube()[1][4][0])) {
        cube.move("U");
        cube.move("F");
        cube.move("U'");
        cube.move("F'");
        cube.move("L");
      }
      if (cube.getCube()[5][4][0].equals(cube.getCube()[2][5][0]) && cube.getCube()[3][1][0].equals(
          cube.getCube()[1][4][0])) {
        cube.move("U");
        cube.move("U");
        cube.move("L");
        cube.move("L");
      }
      if (cube.getCube()[5][4][0].equals(cube.getCube()[3][1][0]) && cube.getCube()[2][5][0].equals(
          cube.getCube()[1][4][0])) {
        cube.move("U");
        cube.move("U");
        cube.move("F");
        cube.move("U'");
        cube.move("F'");
        cube.move("L");
      }
      if (cube.getCube()[5][4][0].equals(cube.getCube()[2][1][0]) && cube.getCube()[4][1][0].equals(
          cube.getCube()[1][4][0])) {
        cube.move("U'");
        cube.move("L");
        cube.move("L");
      }
      if (cube.getCube()[5][4][0].equals(cube.getCube()[4][1][0]) && cube.getCube()[2][1][0].equals(
          cube.getCube()[1][4][0])) {
        cube.move("U'");
        cube.move("F");
        cube.move("U'");
        cube.move("F'");
        cube.move("L");
      }

      // bottom three, top
      if (cube.getCube()[5][4][0].equals(cube.getCube()[2][5][0]) && cube.getCube()[3][1][0].equals(
          cube.getCube()[3][4][0])) {
        cube.move("R");
        cube.move("R");
      }
      if (cube.getCube()[5][4][0].equals(cube.getCube()[3][1][0]) && cube.getCube()[2][5][0].equals(
          cube.getCube()[3][4][0])) {
        cube.move("F'");
        cube.move("U");
        cube.move("F");
        cube.move("R'");
      }
      if (cube.getCube()[5][4][0].equals(cube.getCube()[2][7][0]) && cube.getCube()[0][1][0].equals(
          cube.getCube()[3][4][0])) {
        cube.move("U'");
        cube.move("R");
        cube.move("R");
      }
      if (cube.getCube()[5][4][0].equals(cube.getCube()[0][1][0]) && cube.getCube()[2][7][0].equals(
          cube.getCube()[3][4][0])) {
        cube.move("U'");
        cube.move("F'");
        cube.move("U");
        cube.move("F");
        cube.move("R'");
      }
      if (cube.getCube()[5][4][0].equals(cube.getCube()[2][3][0]) && cube.getCube()[1][1][0].equals(
          cube.getCube()[3][4][0])) {
        cube.move("U'");
        cube.move("U'");
        cube.move("R");
        cube.move("R");
      }
      if (cube.getCube()[5][4][0].equals(cube.getCube()[1][1][0]) && cube.getCube()[2][3][0].equals(
          cube.getCube()[3][4][0])) {
        cube.move("U'");
        cube.move("U'");
        cube.move("F'");
        cube.move("U");
        cube.move("F");
        cube.move("R'");
      }
      if (cube.getCube()[5][4][0].equals(cube.getCube()[2][1][0]) && cube.getCube()[4][1][0].equals(
          cube.getCube()[3][4][0])) {
        cube.move("U");
        cube.move("R");
        cube.move("R");
      }
      if (cube.getCube()[5][4][0].equals(cube.getCube()[4][1][0]) && cube.getCube()[2][1][0].equals(
          cube.getCube()[3][4][0])) {
        cube.move("U");
        cube.move("F'");
        cube.move("U");
        cube.move("F");
        cube.move("R'");
      }

      // bottom four, top
      if (cube.getCube()[5][4][0].equals(cube.getCube()[2][1][0]) && cube.getCube()[4][1][0].equals(
          cube.getCube()[4][4][0])) {
        cube.move("B");
        cube.move("B");
      }
      if (cube.getCube()[5][4][0].equals(cube.getCube()[4][1][0]) && cube.getCube()[2][1][0].equals(
          cube.getCube()[4][4][0])) {
        cube.move("B'");
        cube.move("R'");
        cube.move("U'");
        cube.move("R");
        cube.move("B'");
        cube.move("B'");
      }
      if (cube.getCube()[5][4][0].equals(cube.getCube()[2][7][0]) && cube.getCube()[0][1][0].equals(
          cube.getCube()[4][4][0])) {
        cube.move("U'");
        cube.move("U'");
        cube.move("B");
        cube.move("B");
      }
      if (cube.getCube()[5][4][0].equals(cube.getCube()[0][1][0]) && cube.getCube()[2][7][0].equals(
          cube.getCube()[4][4][0])) {
        cube.move("U'");
        cube.move("U'");
        cube.move("B'");
        cube.move("R'");
        cube.move("U'");
        cube.move("R");
        cube.move("B'");
        cube.move("B'");
      }
      if (cube.getCube()[5][4][0].equals(cube.getCube()[2][3][0]) && cube.getCube()[1][1][0].equals(
          cube.getCube()[4][4][0])) {
        cube.move("U");
        cube.move("B");
        cube.move("B");
      }
      if (cube.getCube()[5][4][0].equals(cube.getCube()[1][1][0]) && cube.getCube()[2][3][0].equals(
          cube.getCube()[4][4][0])) {
        cube.move("U");
        cube.move("B'");
        cube.move("R'");
        cube.move("U'");
        cube.move("R");
        cube.move("B'");
        cube.move("B'");
      }
      if (cube.getCube()[5][4][0].equals(cube.getCube()[2][5][0]) && cube.getCube()[3][1][0].equals(
          cube.getCube()[4][4][0])) {
        cube.move("U'");
        cube.move("B");
        cube.move("B");
      }
      if (cube.getCube()[5][4][0].equals(cube.getCube()[3][1][0]) && cube.getCube()[2][5][0].equals(
          cube.getCube()[4][4][0])) {
        cube.move("U'");
        cube.move("B'");
        cube.move("R'");
        cube.move("U'");
        cube.move("R");
        cube.move("B'");
        cube.move("B'");
      }

      // Flipping An Edge to top
      if (cube.getCube()[5][4][0].equals(cube.getCube()[0][7][0])) {
        cube.move("F'");
        cube.move("F'");
      }
      if (cube.getCube()[5][4][0].equals(cube.getCube()[1][7][0])) {
        cube.move("L'");
        cube.move("L'");
      }
      if (cube.getCube()[5][4][0].equals(cube.getCube()[3][7][0])) {
        cube.move("R");
        cube.move("R");
      }
      if (cube.getCube()[5][4][0].equals(cube.getCube()[4][7][0])) {
        cube.move("B");
        cube.move("B");
      }

      //Flipping The middle Layer
      if (cube.getCube()[5][4][0].equals(cube.getCube()[0][5][0]) && cube.getCube()[3][3][0].equals(
          cube.getCube()[0][4][0])) {
        cube.move("D");
        cube.move("R'");
        cube.move("D'");
      }
      if (cube.getCube()[5][4][0].equals(cube.getCube()[0][3][0]) && cube.getCube()[1][1][0].equals(
          cube.getCube()[0][4][0])) {
        cube.move("D'");
        cube.move("L");
        cube.move("D");
      }
      if (cube.getCube()[5][4][0].equals(cube.getCube()[1][5][0]) && cube.getCube()[0][3][0].equals(
          cube.getCube()[1][4][0])) {
        cube.move("D");
        cube.move("F'");
        cube.move("D'");
      }
      if (cube.getCube()[5][4][0].equals(cube.getCube()[1][3][0]) && cube.getCube()[4][5][0].equals(
          cube.getCube()[1][4][0])) {
        cube.move("D'");
        cube.move("B");
        cube.move("D");
      }
      if (cube.getCube()[5][4][0].equals(cube.getCube()[3][3][0]) && cube.getCube()[0][5][0].equals(
          cube.getCube()[3][4][0])) {
        cube.move("D'");
        cube.move("F");
        cube.move("D");
      }
      if (cube.getCube()[5][4][0].equals(cube.getCube()[3][5][0]) && cube.getCube()[4][3][0].equals(
          cube.getCube()[3][4][0])) {
        cube.move("D");
        cube.move("B'");
        cube.move("D'");
      }
      if (cube.getCube()[5][4][0].equals(cube.getCube()[4][5][0]) && cube.getCube()[1][3][0].equals(
          cube.getCube()[4][4][0])) {
        cube.move("D");
        cube.move("L'");
        cube.move("D'");
      }
      if (cube.getCube()[5][4][0].equals(cube.getCube()[4][3][0]) && cube.getCube()[3][5][0].equals(
          cube.getCube()[4][4][0])) {
        cube.move("D'");
        cube.move("R");
        cube.move("D");
      }

      //Flipping The middle Layer to top
      if (cube.getCube()[5][4][0].equals(cube.getCube()[0][5][0])) {
        cube.move("R");
        cube.move("U");
        cube.move("R'");
      }
      if (cube.getCube()[5][4][0].equals(cube.getCube()[0][3][0])) {
        cube.move("L'");
        cube.move("U");
        cube.move("L");
      }
      if (cube.getCube()[5][4][0].equals(cube.getCube()[1][5][0])) {
        cube.move("F");
        cube.move("U");
        cube.move("F'");
      }
      if (cube.getCube()[5][4][0].equals(cube.getCube()[1][3][0])) {
        cube.move("B'");
        cube.move("U");
        cube.move("B");
      }
      if (cube.getCube()[5][4][0].equals(cube.getCube()[3][3][0])) {
        cube.move("F'");
        cube.move("U");
        cube.move("F");
      }
      if (cube.getCube()[5][4][0].equals(cube.getCube()[3][5][0])) {
        cube.move("B");
        cube.move("U");
        cube.move("B'");
      }
      if (cube.getCube()[5][4][0].equals(cube.getCube()[4][5][0])) {
        cube.move("L");
        cube.move("U");
        cube.move("L'");
      }
      if (cube.getCube()[5][4][0].equals(cube.getCube()[4][3][0])) {
        cube.move("R'");
        cube.move("U");
        cube.move("R");
      }

      //if It's not right spot
      if (cube.getCube()[5][4][0].equals(cube.getCube()[5][7][0])
          && !cube.getCube()[0][7][0].equals(cube.getCube()[0][4][0])) {
        cube.move("F");
        cube.move("F");
      }
      if (cube.getCube()[5][4][0].equals(cube.getCube()[5][5][0])
          && !cube.getCube()[1][7][0].equals(cube.getCube()[1][4][0])) {
        cube.move("L");
        cube.move("L");
      }
      // bottom three, top
      if (cube.getCube()[5][4][0].equals(cube.getCube()[5][3][0])
          && !cube.getCube()[3][7][0].equals(cube.getCube()[3][4][0])) {
        cube.move("R");
        cube.move("R");
      }
      if (cube.getCube()[5][4][0].equals(cube.getCube()[5][1][0])
          && !cube.getCube()[4][7][0].equals(cube.getCube()[4][4][0])) {
        cube.move("B");
        cube.move("B");
      }
//      System.out.println(cube);
    }
  }

  //solve the bottom layer to put the right corner
  private void solveCorner(RubiksCube cube) {
    while (!cube.getCube()[5][4][0].equals(cube.getCube()[5][0][0])
        || !cube.getCube()[5][4][0].equals(cube.getCube()[5][2][0])
        || !cube.getCube()[5][4][0].equals(cube.getCube()[5][6][0])
        || !cube.getCube()[5][4][0].equals(cube.getCube()[5][8][0])
        || !cube.getCube()[0][4][0].equals(cube.getCube()[0][6][0])
        || !cube.getCube()[0][4][0].equals(cube.getCube()[0][8][0])
        || !cube.getCube()[1][4][0].equals(cube.getCube()[1][6][0])
        || !cube.getCube()[1][4][0].equals(cube.getCube()[1][8][0])
        || !cube.getCube()[3][4][0].equals(cube.getCube()[3][6][0])
        || !cube.getCube()[3][4][0].equals(cube.getCube()[3][8][0])
        || !cube.getCube()[4][4][0].equals(cube.getCube()[4][6][0])
        || !cube.getCube()[4][4][0].equals(cube.getCube()[4][8][0])) {
      //top zero
      if (cube.getCube()[5][4][0].equals(cube.getCube()[1][2][0]) && cube.getCube()[0][4][0].equals(
          cube.getCube()[0][0][0])) {
        cube.move("L'");
        cube.move("U'");
        cube.move("L");
      }
      if (cube.getCube()[5][4][0].equals(cube.getCube()[4][2][0]) && cube.getCube()[0][4][0].equals(
          cube.getCube()[1][0][0])) {
        cube.move("U'");
        cube.move("L'");
        cube.move("U'");
        cube.move("L");
      }
      if (cube.getCube()[5][4][0].equals(cube.getCube()[3][2][0]) && cube.getCube()[0][4][0].equals(
          cube.getCube()[4][0][0])) {
        cube.move("U'");
        cube.move("U'");
        cube.move("L'");
        cube.move("U'");
        cube.move("L");
      }
      if (cube.getCube()[5][4][0].equals(cube.getCube()[0][2][0]) && cube.getCube()[0][4][0].equals(
          cube.getCube()[3][0][0])) {
        cube.move("U");
        cube.move("L'");
        cube.move("U'");
        cube.move("L");
      }
      if (cube.getCube()[5][4][0].equals(cube.getCube()[3][0][0]) && cube.getCube()[0][4][0].equals(
          cube.getCube()[0][2][0])) {
        cube.move("R");
        cube.move("U");
        cube.move("R'");
      }
      if (cube.getCube()[5][4][0].equals(cube.getCube()[4][0][0]) && cube.getCube()[0][4][0].equals(
          cube.getCube()[3][2][0])) {
        cube.move("U");
        cube.move("R");
        cube.move("U");
        cube.move("R'");
      }
      if (cube.getCube()[5][4][0].equals(cube.getCube()[1][0][0]) && cube.getCube()[0][4][0].equals(
          cube.getCube()[4][2][0])) {
        cube.move("U");
        cube.move("U");
        cube.move("R");
        cube.move("U");
        cube.move("R'");
      }
      if (cube.getCube()[5][4][0].equals(cube.getCube()[0][0][0]) && cube.getCube()[0][4][0].equals(
          cube.getCube()[1][2][0])) {
        cube.move("U'");
        cube.move("R");
        cube.move("U");
        cube.move("R'");
      }
      //top one
      if (cube.getCube()[5][4][0].equals(cube.getCube()[4][2][0]) && cube.getCube()[1][4][0].equals(
          cube.getCube()[1][0][0])) {
        cube.move("B'");
        cube.move("U'");
        cube.move("B");
      }
      if (cube.getCube()[5][4][0].equals(cube.getCube()[3][2][0]) && cube.getCube()[1][4][0].equals(
          cube.getCube()[4][0][0])) {
        cube.move("U'");
        cube.move("B'");
        cube.move("U'");
        cube.move("B");
      }
      if (cube.getCube()[5][4][0].equals(cube.getCube()[0][2][0]) && cube.getCube()[1][4][0].equals(
          cube.getCube()[3][0][0])) {
        cube.move("U'");
        cube.move("U'");
        cube.move("B'");
        cube.move("U'");
        cube.move("B");
      }
      if (cube.getCube()[5][4][0].equals(cube.getCube()[1][2][0]) && cube.getCube()[1][4][0].equals(
          cube.getCube()[0][0][0])) {
        cube.move("U");
        cube.move("B'");
        cube.move("U'");
        cube.move("B");
      }
      if (cube.getCube()[5][4][0].equals(cube.getCube()[0][0][0]) && cube.getCube()[1][4][0].equals(
          cube.getCube()[1][2][0])) {
        cube.move("F");
        cube.move("U");
        cube.move("F'");
      }
      if (cube.getCube()[5][4][0].equals(cube.getCube()[3][0][0]) && cube.getCube()[1][4][0].equals(
          cube.getCube()[0][2][0])) {
        cube.move("U");
        cube.move("F");
        cube.move("U");
        cube.move("F'");
      }
      if (cube.getCube()[5][4][0].equals(cube.getCube()[4][0][0]) && cube.getCube()[1][4][0].equals(
          cube.getCube()[3][2][0])) {
        cube.move("U");
        cube.move("U");
        cube.move("F");
        cube.move("U");
        cube.move("F'");
      }
      if (cube.getCube()[5][4][0].equals(cube.getCube()[1][0][0]) && cube.getCube()[1][4][0].equals(
          cube.getCube()[4][2][0])) {
        cube.move("U'");
        cube.move("F");
        cube.move("U");
        cube.move("F'");
      }

      //top three
      if (cube.getCube()[5][4][0].equals(cube.getCube()[0][2][0]) && cube.getCube()[3][4][0].equals(
          cube.getCube()[3][0][0])) {
        cube.move("F'");
        cube.move("U'");
        cube.move("F");
      }
      if (cube.getCube()[5][4][0].equals(cube.getCube()[1][2][0]) && cube.getCube()[3][4][0].equals(
          cube.getCube()[0][0][0])) {
        cube.move("U'");
        cube.move("F'");
        cube.move("U'");
        cube.move("F");
      }
      if (cube.getCube()[5][4][0].equals(cube.getCube()[4][2][0]) && cube.getCube()[3][4][0].equals(
          cube.getCube()[1][0][0])) {
        cube.move("U'");
        cube.move("U'");
        cube.move("F'");
        cube.move("U'");
        cube.move("F");
      }
      if (cube.getCube()[5][4][0].equals(cube.getCube()[3][2][0]) && cube.getCube()[3][4][0].equals(
          cube.getCube()[4][0][0])) {
        cube.move("U");
        cube.move("F'");
        cube.move("U'");
        cube.move("F");
      }
      if (cube.getCube()[5][4][0].equals(cube.getCube()[4][0][0]) && cube.getCube()[3][4][0].equals(
          cube.getCube()[3][2][0])) {
        cube.move("B");
        cube.move("U");
        cube.move("B'");
      }
      if (cube.getCube()[5][4][0].equals(cube.getCube()[1][0][0]) && cube.getCube()[3][4][0].equals(
          cube.getCube()[4][2][0])) {
        cube.move("U");
        cube.move("B");
        cube.move("U");
        cube.move("B'");
      }
      if (cube.getCube()[5][4][0].equals(cube.getCube()[0][0][0]) && cube.getCube()[3][4][0].equals(
          cube.getCube()[1][2][0])) {
        cube.move("U");
        cube.move("U");
        cube.move("B");
        cube.move("U");
        cube.move("B'");
      }
      if (cube.getCube()[5][4][0].equals(cube.getCube()[3][0][0]) && cube.getCube()[3][4][0].equals(
          cube.getCube()[0][2][0])) {
        cube.move("U'");
        cube.move("B");
        cube.move("U");
        cube.move("B'");
      }

      //top four
      if (cube.getCube()[5][4][0].equals(cube.getCube()[3][2][0]) && cube.getCube()[4][4][0].equals(
          cube.getCube()[4][0][0])) {
        cube.move("R'");
        cube.move("U'");
        cube.move("R");
      }
      if (cube.getCube()[5][4][0].equals(cube.getCube()[4][2][0]) && cube.getCube()[4][4][0].equals(
          cube.getCube()[1][0][0])) {
        cube.move("U'");
        cube.move("R'");
        cube.move("U'");
        cube.move("R");
      }
      if (cube.getCube()[5][4][0].equals(cube.getCube()[1][2][0]) && cube.getCube()[4][4][0].equals(
          cube.getCube()[0][0][0])) {
        cube.move("U'");
        cube.move("U'");
        cube.move("R'");
        cube.move("U'");
        cube.move("R");
      }
      if (cube.getCube()[5][4][0].equals(cube.getCube()[0][2][0]) && cube.getCube()[4][4][0].equals(
          cube.getCube()[3][0][0])) {
        cube.move("U");
        cube.move("R'");
        cube.move("U'");
        cube.move("R");
      }
      if (cube.getCube()[5][4][0].equals(cube.getCube()[1][0][0]) && cube.getCube()[4][4][0].equals(
          cube.getCube()[4][2][0])) {
        cube.move("L");
        cube.move("U");
        cube.move("L'");
      }
      if (cube.getCube()[5][4][0].equals(cube.getCube()[0][0][0]) && cube.getCube()[4][4][0].equals(
          cube.getCube()[1][2][0])) {
        cube.move("U");
        cube.move("L");
        cube.move("U");
        cube.move("L'");
      }
      if (cube.getCube()[5][4][0].equals(cube.getCube()[3][0][0]) && cube.getCube()[4][4][0].equals(
          cube.getCube()[0][2][0])) {
        cube.move("U");
        cube.move("U");
        cube.move("L");
        cube.move("U");
        cube.move("L'");
      }
      if (cube.getCube()[5][4][0].equals(cube.getCube()[4][0][0]) && cube.getCube()[4][4][0].equals(
          cube.getCube()[3][2][0])) {
        cube.move("U'");
        cube.move("L");
        cube.move("U");
        cube.move("L'");
      }

      //top face up
      if (cube.getCube()[5][4][0].equals(cube.getCube()[2][6][0]) && cube.getCube()[0][0][0].equals(
          cube.getCube()[1][4][0]) && cube.getCube()[1][2][0].equals(cube.getCube()[0][4][0])) {
        cube.move("L");
        cube.move("L");
        cube.move("U'");
        cube.move("L");
        cube.move("L");
        cube.move("U");
        cube.move("L");
        cube.move("L");
      }
      if (cube.getCube()[5][4][0].equals(cube.getCube()[2][8][0]) && cube.getCube()[0][2][0].equals(
          cube.getCube()[3][4][0]) && cube.getCube()[3][0][0].equals(cube.getCube()[0][4][0])) {
        cube.move("R");
        cube.move("R");
        cube.move("U");
        cube.move("R");
        cube.move("R");
        cube.move("U'");
        cube.move("R");
        cube.move("R");
      }
      if (cube.getCube()[5][4][0].equals(cube.getCube()[2][2][0]) && cube.getCube()[4][0][0].equals(
          cube.getCube()[3][4][0]) && cube.getCube()[3][2][0].equals(cube.getCube()[4][4][0])) {
        cube.move("R");
        cube.move("R");
        cube.move("U'");
        cube.move("R");
        cube.move("R");
        cube.move("U");
        cube.move("R");
        cube.move("R");
      }
      if (cube.getCube()[5][4][0].equals(cube.getCube()[2][0][0]) && cube.getCube()[1][0][0].equals(
          cube.getCube()[4][4][0]) && cube.getCube()[4][2][0].equals(cube.getCube()[1][4][0])) {
        cube.move("L");
        cube.move("L");
        cube.move("U");
        cube.move("L");
        cube.move("L");
        cube.move("U'");
        cube.move("L");
        cube.move("L");
      }

      //top face up change
      if (cube.getCube()[5][4][0].equals(cube.getCube()[2][0][0]) && cube.getCube()[1][0][0].equals(
          cube.getCube()[1][4][0]) && cube.getCube()[4][2][0].equals(cube.getCube()[0][4][0])) {
        cube.move("U'");
        cube.move("L");
        cube.move("L");
        cube.move("U'");
        cube.move("L");
        cube.move("L");
        cube.move("U");
        cube.move("L");
        cube.move("L");
      }
      if (cube.getCube()[5][4][0].equals(cube.getCube()[2][2][0]) && cube.getCube()[4][0][0].equals(
          cube.getCube()[1][4][0]) && cube.getCube()[3][2][0].equals(cube.getCube()[0][4][0])) {
        cube.move("U'");
        cube.move("U'");
        cube.move("L");
        cube.move("L");
        cube.move("U'");
        cube.move("L");
        cube.move("L");
        cube.move("U");
        cube.move("L");
        cube.move("L");
      }
      if (cube.getCube()[5][4][0].equals(cube.getCube()[2][8][0]) && cube.getCube()[3][0][0].equals(
          cube.getCube()[1][4][0]) && cube.getCube()[0][2][0].equals(cube.getCube()[0][4][0])) {
        cube.move("U");
        cube.move("L");
        cube.move("L");
        cube.move("U'");
        cube.move("L");
        cube.move("L");
        cube.move("U");
        cube.move("L");
        cube.move("L");
      }
      if (cube.getCube()[5][4][0].equals(cube.getCube()[2][6][0]) && cube.getCube()[1][2][0].equals(
          cube.getCube()[3][4][0]) && cube.getCube()[0][0][0].equals(cube.getCube()[0][4][0])) {
        cube.move("U'");
        cube.move("R");
        cube.move("R");
        cube.move("U");
        cube.move("R");
        cube.move("R");
        cube.move("U'");
        cube.move("R");
        cube.move("R");
      }
      if (cube.getCube()[5][4][0].equals(cube.getCube()[2][0][0]) && cube.getCube()[4][2][0].equals(
          cube.getCube()[3][4][0]) && cube.getCube()[1][0][0].equals(cube.getCube()[0][4][0])) {
        cube.move("U");
        cube.move("U");
        cube.move("R");
        cube.move("R");
        cube.move("U");
        cube.move("R");
        cube.move("R");
        cube.move("U'");
        cube.move("R");
        cube.move("R");
      }
      if (cube.getCube()[5][4][0].equals(cube.getCube()[2][2][0]) && cube.getCube()[3][2][0].equals(
          cube.getCube()[3][4][0]) && cube.getCube()[4][0][0].equals(cube.getCube()[0][4][0])) {
        cube.move("U");
        cube.move("R");
        cube.move("R");
        cube.move("U");
        cube.move("R");
        cube.move("R");
        cube.move("U'");
        cube.move("R");
        cube.move("R");
      }
      if (cube.getCube()[5][4][0].equals(cube.getCube()[2][0][0]) && cube.getCube()[1][0][0].equals(
          cube.getCube()[3][4][0]) && cube.getCube()[4][2][0].equals(cube.getCube()[4][4][0])) {
        cube.move("U");
        cube.move("R");
        cube.move("R");
        cube.move("U'");
        cube.move("R");
        cube.move("R");
        cube.move("U");
        cube.move("R");
        cube.move("R");
      }
      if (cube.getCube()[5][4][0].equals(cube.getCube()[2][6][0]) && cube.getCube()[0][0][0].equals(
          cube.getCube()[3][4][0]) && cube.getCube()[1][2][0].equals(cube.getCube()[4][4][0])) {
        cube.move("U'");
        cube.move("U'");
        cube.move("R");
        cube.move("R");
        cube.move("U'");
        cube.move("R");
        cube.move("R");
        cube.move("U");
        cube.move("R");
        cube.move("R");
      }
      if (cube.getCube()[5][4][0].equals(cube.getCube()[2][8][0]) && cube.getCube()[3][0][0].equals(
          cube.getCube()[3][4][0]) && cube.getCube()[0][2][0].equals(cube.getCube()[4][4][0])) {
        cube.move("U'");
        cube.move("R");
        cube.move("R");
        cube.move("U'");
        cube.move("R");
        cube.move("R");
        cube.move("U");
        cube.move("R");
        cube.move("R");
      }
      if (cube.getCube()[5][4][0].equals(cube.getCube()[2][6][0]) && cube.getCube()[0][0][0].equals(
          cube.getCube()[4][4][0]) && cube.getCube()[1][2][0].equals(cube.getCube()[1][4][0])) {
        cube.move("U");
        cube.move("L");
        cube.move("L");
        cube.move("U");
        cube.move("L");
        cube.move("L");
        cube.move("U'");
        cube.move("L");
        cube.move("L");
      }
      if (cube.getCube()[5][4][0].equals(cube.getCube()[2][8][0]) && cube.getCube()[3][0][0].equals(
          cube.getCube()[4][4][0]) && cube.getCube()[0][2][0].equals(cube.getCube()[1][4][0])) {
        cube.move("U");
        cube.move("U");
        cube.move("L");
        cube.move("L");
        cube.move("U");
        cube.move("L");
        cube.move("L");
        cube.move("U'");
        cube.move("L");
        cube.move("L");
      }
      if (cube.getCube()[5][4][0].equals(cube.getCube()[2][2][0]) && cube.getCube()[4][0][0].equals(
          cube.getCube()[4][4][0]) && cube.getCube()[3][2][0].equals(cube.getCube()[1][4][0])) {
        cube.move("U'");
        cube.move("L");
        cube.move("L");
        cube.move("U");
        cube.move("L");
        cube.move("L");
        cube.move("U'");
        cube.move("L");
        cube.move("L");
      }

      if (cube.getCube()[5][4][0].equals(cube.getCube()[0][8][0]) || cube.getCube()[5][4][0].equals(
          cube.getCube()[3][6][0]) || (cube.getCube()[5][4][0].equals(cube.getCube()[5][6][0])
          && !cube.getCube()[0][4][0].equals(cube.getCube()[0][8][0]))) {
        cube.move("R");
        cube.move("U");
        cube.move("R'");
      }
      if (cube.getCube()[5][4][0].equals(cube.getCube()[0][6][0]) || cube.getCube()[5][4][0].equals(
          cube.getCube()[1][8][0]) || (cube.getCube()[5][4][0].equals(cube.getCube()[5][8][0])
          && !cube.getCube()[0][4][0].equals(cube.getCube()[0][6][0]))) {
        cube.move("L'");
        cube.move("U'");
        cube.move("L");
      }
      if (cube.getCube()[5][4][0].equals(cube.getCube()[1][6][0]) || cube.getCube()[5][4][0].equals(
          cube.getCube()[4][8][0]) || (cube.getCube()[5][4][0].equals(cube.getCube()[5][2][0])
          && !cube.getCube()[1][4][0].equals(cube.getCube()[1][6][0]))) {
        cube.move("L");
        cube.move("U");
        cube.move("L'");
      }
      if (cube.getCube()[5][4][0].equals(cube.getCube()[4][6][0]) || cube.getCube()[5][4][0].equals(
          cube.getCube()[3][8][0]) || (cube.getCube()[5][4][0].equals(cube.getCube()[5][0][0])
          && !cube.getCube()[4][4][0].equals(cube.getCube()[4][6][0]))) {
        cube.move("R'");
        cube.move("U");
        cube.move("R");
      }
    }
  }

  //solve the middle layer to put the right edge
  private void solveSecondLayer(RubiksCube cube) {
    while (!cube.getCube()[0][4][0].equals(cube.getCube()[0][3][0])
        || !cube.getCube()[0][4][0].equals(cube.getCube()[0][5][0])
        || !cube.getCube()[1][4][0].equals(cube.getCube()[1][3][0])
        || !cube.getCube()[1][4][0].equals(cube.getCube()[1][5][0])
        || !cube.getCube()[3][4][0].equals(cube.getCube()[3][3][0])
        || !cube.getCube()[3][4][0].equals(cube.getCube()[3][5][0])
        || !cube.getCube()[4][4][0].equals(cube.getCube()[4][3][0])
        || !cube.getCube()[4][4][0].equals(cube.getCube()[4][5][0])) {

      //right
      if (cube.getCube()[0][4][0].equals(cube.getCube()[0][1][0]) && cube.getCube()[3][4][0].equals(
          cube.getCube()[2][7][0])) {
        cube.move("U");
        cube.move("R");
        cube.move("U'");
        cube.move("R'");
        cube.move("U'");
        cube.move("F'");
        cube.move("U");
        cube.move("F");
      }
      if (cube.getCube()[1][4][0].equals(cube.getCube()[1][1][0]) && cube.getCube()[0][4][0].equals(
          cube.getCube()[2][3][0])) {
        cube.move("U'");
        cube.move("D");
        cube.move("E");
        cube.move("U");
        cube.move("R");
        cube.move("U'");
        cube.move("R'");
        cube.move("U'");
        cube.move("F'");
        cube.move("U");
        cube.move("F");
      }
      if (cube.getCube()[3][4][0].equals(cube.getCube()[3][1][0]) && cube.getCube()[4][4][0].equals(
          cube.getCube()[2][5][0])) {
        cube.move("U");
        cube.move("D'");
        cube.move("E'");
        cube.move("U");
        cube.move("R");
        cube.move("U'");
        cube.move("R'");
        cube.move("U'");
        cube.move("F'");
        cube.move("U");
        cube.move("F");
      }
      if (cube.getCube()[4][4][0].equals(cube.getCube()[4][1][0]) && cube.getCube()[1][4][0].equals(
          cube.getCube()[2][1][0])) {
        cube.move("U");
        cube.move("U");
        cube.move("D'");
        cube.move("D'");
        cube.move("E'");
        cube.move("E'");
        cube.move("U");
        cube.move("R");
        cube.move("U'");
        cube.move("R'");
        cube.move("U'");
        cube.move("F'");
        cube.move("U");
        cube.move("F");
      }

      //left
      if (cube.getCube()[0][4][0].equals(cube.getCube()[0][1][0]) && cube.getCube()[1][4][0].equals(
          cube.getCube()[2][7][0])) {
        cube.move("U'");
        cube.move("L'");
        cube.move("U");
        cube.move("L");
        cube.move("U");
        cube.move("F");
        cube.move("U'");
        cube.move("F'");
      }
      if (cube.getCube()[1][4][0].equals(cube.getCube()[1][1][0]) && cube.getCube()[4][4][0].equals(
          cube.getCube()[2][3][0])) {
        cube.move("U'");
        cube.move("D");
        cube.move("E");
        cube.move("U'");
        cube.move("L'");
        cube.move("U");
        cube.move("L");
        cube.move("U");
        cube.move("F");
        cube.move("U'");
        cube.move("F'");
      }
      if (cube.getCube()[3][4][0].equals(cube.getCube()[3][1][0]) && cube.getCube()[0][4][0].equals(
          cube.getCube()[2][5][0])) {
        cube.move("U");
        cube.move("D'");
        cube.move("E'");
        cube.move("U'");
        cube.move("L'");
        cube.move("U");
        cube.move("L");
        cube.move("U");
        cube.move("F");
        cube.move("U'");
        cube.move("F'");
      }
      if (cube.getCube()[4][4][0].equals(cube.getCube()[4][1][0]) && cube.getCube()[3][4][0].equals(
          cube.getCube()[2][1][0])) {
        cube.move("U");
        cube.move("D'");
        cube.move("E'");
        cube.move("U");
        cube.move("D'");
        cube.move("E'");
        cube.move("U'");
        cube.move("L'");
        cube.move("U");
        cube.move("L");
        cube.move("U");
        cube.move("F");
        cube.move("U'");
        cube.move("F'");
      }

      //not in the right spot
      if (cube.getCube()[0][5][0].equals(cube.getCube()[3][4][0]) && cube.getCube()[3][3][0].equals(
          cube.getCube()[0][4][0])) {
        cube.move("U");
        cube.move("R");
        cube.move("U'");
        cube.move("R'");
        cube.move("U'");
        cube.move("F'");
        cube.move("U");
        cube.move("F");
        cube.move("U'");
        cube.move("R");
        cube.move("U'");
        cube.move("R'");
        cube.move("U'");
        cube.move("F'");
        cube.move("U");
        cube.move("F");
      }
      if (cube.getCube()[1][5][0].equals(cube.getCube()[0][4][0]) && cube.getCube()[0][3][0].equals(
          cube.getCube()[1][4][0])) {
        cube.move("U'");
        cube.move("D");
        cube.move("E");
        cube.move("U");
        cube.move("R");
        cube.move("U'");
        cube.move("R'");
        cube.move("U'");
        cube.move("F'");
        cube.move("U");
        cube.move("F");
        cube.move("U'");
        cube.move("R");
        cube.move("U'");
        cube.move("R'");
        cube.move("U'");
        cube.move("F'");
        cube.move("U");
        cube.move("F");
      }
      if (cube.getCube()[4][5][0].equals(cube.getCube()[1][4][0]) && cube.getCube()[1][3][0].equals(
          cube.getCube()[4][4][0])) {
        cube.move("U'");
        cube.move("D");
        cube.move("E");
        cube.move("U'");
        cube.move("D");
        cube.move("E");
        cube.move("U");
        cube.move("R");
        cube.move("U'");
        cube.move("R'");
        cube.move("U'");
        cube.move("F'");
        cube.move("U");
        cube.move("F");
        cube.move("U'");
        cube.move("R");
        cube.move("U'");
        cube.move("R'");
        cube.move("U'");
        cube.move("F'");
        cube.move("U");
        cube.move("F");
      }
      if (cube.getCube()[3][5][0].equals(cube.getCube()[4][4][0]) && cube.getCube()[4][3][0].equals(
          cube.getCube()[3][4][0])) {
        cube.move("U");
        cube.move("D'");
        cube.move("E'");
        cube.move("U");
        cube.move("R");
        cube.move("U'");
        cube.move("R'");
        cube.move("U'");
        cube.move("F'");
        cube.move("U");
        cube.move("F");
        cube.move("U'");
        cube.move("R");
        cube.move("U'");
        cube.move("R'");
        cube.move("U'");
        cube.move("F'");
        cube.move("U");
        cube.move("F");
      }

      boolean a =
          cube.getCube()[2][4][0].equals(cube.getCube()[0][1][0]) || cube.getCube()[2][4][0].equals(
              cube.getCube()[2][7][0]);
      boolean b =
          cube.getCube()[2][4][0].equals(cube.getCube()[1][1][0]) || cube.getCube()[2][4][0].equals(
              cube.getCube()[2][3][0]);
      boolean c =
          cube.getCube()[2][4][0].equals(cube.getCube()[4][1][0]) || cube.getCube()[2][4][0].equals(
              cube.getCube()[2][1][0]);
      boolean d =
          cube.getCube()[2][4][0].equals(cube.getCube()[3][1][0]) || cube.getCube()[2][4][0].equals(
              cube.getCube()[2][5][0]);

      if (a && b && c && d) {
        //should not be there
        if (!cube.getCube()[0][5][0].equals(cube.getCube()[0][4][0])
            && !cube.getCube()[0][5][0].equals(cube.getCube()[3][4][0])
            || !cube.getCube()[3][3][0].equals(cube.getCube()[3][4][0])
            && !cube.getCube()[3][3][0].equals(cube.getCube()[0][4][0])) {
          cube.move("U");
          cube.move("R");
          cube.move("U'");
          cube.move("R'");
          cube.move("U'");
          cube.move("F'");
          cube.move("U");
          cube.move("F");
        }
        if ((!cube.getCube()[3][5][0].equals(cube.getCube()[3][4][0])
            && !cube.getCube()[3][5][0].equals(cube.getCube()[4][4][0])) || (
            !cube.getCube()[4][3][0].equals(cube.getCube()[4][4][0])
                && !cube.getCube()[4][3][0].equals(cube.getCube()[3][4][0]))) {
          cube.move("U");
          cube.move("D'");
          cube.move("E'");
          cube.move("U");
          cube.move("R");
          cube.move("U'");
          cube.move("R'");
          cube.move("U'");
          cube.move("F'");
          cube.move("U");
          cube.move("F");
        }
        if (!cube.getCube()[4][5][0].equals(cube.getCube()[4][4][0])
            && !cube.getCube()[4][5][0].equals(cube.getCube()[1][4][0])
            || !cube.getCube()[1][3][0].equals(cube.getCube()[1][4][0])
            && !cube.getCube()[1][3][0].equals(cube.getCube()[4][4][0])) {
          cube.move("U");
          cube.move("D'");
          cube.move("E'");
          cube.move("U");
          cube.move("D'");
          cube.move("E'");
          cube.move("U");
          cube.move("R");
          cube.move("U'");
          cube.move("R'");
          cube.move("U'");
          cube.move("F'");
          cube.move("U");
          cube.move("F");
        }
        if (!cube.getCube()[1][5][0].equals(cube.getCube()[1][4][0])
            && !cube.getCube()[1][5][0].equals(cube.getCube()[0][4][0])
            || !cube.getCube()[0][3][0].equals(cube.getCube()[0][4][0])
            && !cube.getCube()[0][3][0].equals(cube.getCube()[1][4][0])) {
          cube.move("U'");
          cube.move("D");
          cube.move("E");
          cube.move("U");
          cube.move("R");
          cube.move("U'");
          cube.move("R'");
          cube.move("U'");
          cube.move("F'");
          cube.move("U");
          cube.move("F");
        }
      }

      cube.move("U");
//      System.out.println(cube);
    }
  }

  //make the top layer cross
  private void solveCross(RubiksCube cube) {
    while (!cube.getCube()[2][4][0].equals(cube.getCube()[2][7][0])
        || !cube.getCube()[2][4][0].equals(cube.getCube()[2][3][0])
        || !cube.getCube()[2][4][0].equals(cube.getCube()[2][1][0])
        || !cube.getCube()[2][4][0].equals(cube.getCube()[2][5][0])) {
      if (!cube.getCube()[2][4][0].equals(cube.getCube()[2][7][0])
          && !cube.getCube()[2][4][0].equals(cube.getCube()[2][3][0])
          && !cube.getCube()[2][4][0].equals(cube.getCube()[2][1][0])
          && !cube.getCube()[2][4][0].equals(cube.getCube()[2][5][0])) {
        cube.move("F");
        cube.move("R");
        cube.move("U");
        cube.move("R'");
        cube.move("U'");
        cube.move("F'");
      }
      if (cube.getCube()[2][4][0].equals(cube.getCube()[2][7][0]) && cube.getCube()[2][4][0].equals(
          cube.getCube()[2][5][0]) && !cube.getCube()[2][4][0].equals(cube.getCube()[2][1][0])
          && !cube.getCube()[2][4][0].equals(cube.getCube()[2][3][0])) {
        cube.move("F");
        cube.move("R");
        cube.move("U");
        cube.move("R'");
        cube.move("U'");
        cube.move("F'");
        cube.move("U");
      }
      if (!cube.getCube()[2][4][0].equals(cube.getCube()[2][7][0])
          && cube.getCube()[2][4][0].equals(cube.getCube()[2][5][0])
          && cube.getCube()[2][4][0].equals(cube.getCube()[2][1][0])
          && !cube.getCube()[2][4][0].equals(cube.getCube()[2][3][0])) {
        cube.move("U");
        cube.move("D'");
        cube.move("E'");
        cube.move("F");
        cube.move("R");
        cube.move("U");
        cube.move("R'");
        cube.move("U'");
        cube.move("F'");
        cube.move("U");
      }
      if (!cube.getCube()[2][4][0].equals(cube.getCube()[2][7][0])
          && !cube.getCube()[2][4][0].equals(cube.getCube()[2][5][0])
          && cube.getCube()[2][4][0].equals(cube.getCube()[2][1][0])
          && cube.getCube()[2][4][0].equals(cube.getCube()[2][3][0])) {
        cube.move("U");
        cube.move("U");
        cube.move("D'");
        cube.move("D'");
        cube.move("E'");
        cube.move("E'");
        cube.move("F");
        cube.move("R");
        cube.move("U");
        cube.move("R'");
        cube.move("U'");
        cube.move("F'");
        cube.move("U");
      }
      if (cube.getCube()[2][4][0].equals(cube.getCube()[2][7][0])
          && !cube.getCube()[2][4][0].equals(cube.getCube()[2][5][0])
          && !cube.getCube()[2][4][0].equals(cube.getCube()[2][1][0])
          && cube.getCube()[2][4][0].equals(cube.getCube()[2][3][0])) {
        cube.move("U'");
        cube.move("D");
        cube.move("E");
        cube.move("F");
        cube.move("R");
        cube.move("U");
        cube.move("R'");
        cube.move("U'");
        cube.move("F'");
        cube.move("U");
      }
      if (!cube.getCube()[2][4][0].equals(cube.getCube()[2][7][0])
          && cube.getCube()[2][4][0].equals(cube.getCube()[2][5][0])
          && !cube.getCube()[2][4][0].equals(cube.getCube()[2][1][0])
          && cube.getCube()[2][4][0].equals(cube.getCube()[2][3][0])
          && cube.getCube()[2][4][0].equals(cube.getCube()[0][1][0])) {
        cube.move("F");
        cube.move("R");
        cube.move("U");
        cube.move("R'");
        cube.move("U'");
        cube.move("F'");
      }
      if (!cube.getCube()[2][4][0].equals(cube.getCube()[2][7][0])
          && cube.getCube()[2][4][0].equals(cube.getCube()[2][5][0])
          && !cube.getCube()[2][4][0].equals(cube.getCube()[2][1][0])
          && cube.getCube()[2][4][0].equals(cube.getCube()[2][3][0])
          && cube.getCube()[2][4][0].equals(cube.getCube()[4][1][0])) {
        cube.move("U");
        cube.move("D'");
        cube.move("E'");
        cube.move("U");
        cube.move("D'");
        cube.move("E'");
        cube.move("F");
        cube.move("R");
        cube.move("U");
        cube.move("R'");
        cube.move("U'");
        cube.move("F'");
      }
      if (cube.getCube()[2][4][0].equals(cube.getCube()[2][7][0])
          && !cube.getCube()[2][4][0].equals(cube.getCube()[2][5][0])
          && cube.getCube()[2][4][0].equals(cube.getCube()[2][1][0])
          && !cube.getCube()[2][4][0].equals(cube.getCube()[2][3][0])
          && cube.getCube()[2][4][0].equals(cube.getCube()[3][1][0])) {
        cube.move("U");
        cube.move("D'");
        cube.move("E'");
        cube.move("F");
        cube.move("R");
        cube.move("U");
        cube.move("R'");
        cube.move("U'");
        cube.move("F'");
      }
      if (cube.getCube()[2][4][0].equals(cube.getCube()[2][7][0])
          && !cube.getCube()[2][4][0].equals(cube.getCube()[2][5][0])
          && cube.getCube()[2][4][0].equals(cube.getCube()[2][1][0])
          && !cube.getCube()[2][4][0].equals(cube.getCube()[2][3][0])
          && cube.getCube()[2][4][0].equals(cube.getCube()[1][1][0])) {
        cube.move("U'");
        cube.move("D");
        cube.move("E");
        cube.move("F");
        cube.move("R");
        cube.move("U");
        cube.move("R'");
        cube.move("U'");
        cube.move("F'");
      }
//      System.out.println(cube);
    }
  }

  //complete the cross to fill all the top
  private void finishTop(RubiksCube cube) {
    while (!cube.getCube()[2][4][0].equals(cube.getCube()[2][7][0])
        || !cube.getCube()[2][4][0].equals(cube.getCube()[2][3][0])
        || !cube.getCube()[2][4][0].equals(cube.getCube()[2][1][0])
        || !cube.getCube()[2][4][0].equals(cube.getCube()[2][5][0])
        || !cube.getCube()[2][4][0].equals(cube.getCube()[2][0][0])
        || !cube.getCube()[2][4][0].equals(cube.getCube()[2][2][0])
        || !cube.getCube()[2][4][0].equals(cube.getCube()[2][6][0])
        || !cube.getCube()[2][4][0].equals(cube.getCube()[2][8][0])) {

      //case one
      if (cube.getCube()[2][4][0].equals(cube.getCube()[2][7][0]) && cube.getCube()[2][4][0].equals(
          cube.getCube()[2][3][0]) && cube.getCube()[2][4][0].equals(cube.getCube()[2][1][0])
          && cube.getCube()[2][4][0].equals(cube.getCube()[2][5][0])
          && !cube.getCube()[2][4][0].equals(cube.getCube()[2][0][0])
          && !cube.getCube()[2][4][0].equals(cube.getCube()[2][2][0])
          && cube.getCube()[2][4][0].equals(cube.getCube()[2][6][0])
          && !cube.getCube()[2][4][0].equals(cube.getCube()[2][8][0])
          && cube.getCube()[2][4][0].equals(cube.getCube()[1][0][0])
          && cube.getCube()[2][4][0].equals(cube.getCube()[3][0][0])
          && cube.getCube()[2][4][0].equals(cube.getCube()[4][0][0])) {
        cube.move("R");
        cube.move("U");
        cube.move("R'");
        cube.move("U");
        cube.move("R");
        cube.move("U");
        cube.move("U");
        cube.move("R'");
      }
      //case two
      else if (cube.getCube()[2][4][0].equals(cube.getCube()[2][7][0])
          && cube.getCube()[2][4][0].equals(cube.getCube()[2][3][0])
          && cube.getCube()[2][4][0].equals(cube.getCube()[2][1][0])
          && cube.getCube()[2][4][0].equals(cube.getCube()[2][5][0])
          && !cube.getCube()[2][4][0].equals(cube.getCube()[2][0][0])
          && !cube.getCube()[2][4][0].equals(cube.getCube()[2][2][0])
          && cube.getCube()[2][4][0].equals(cube.getCube()[2][6][0])
          && !cube.getCube()[2][4][0].equals(cube.getCube()[2][8][0])
          && cube.getCube()[2][4][0].equals(cube.getCube()[4][2][0])
          && cube.getCube()[2][4][0].equals(cube.getCube()[3][2][0])
          && cube.getCube()[2][4][0].equals(cube.getCube()[0][2][0])) {
        cube.move("R");
        cube.move("U");
        cube.move("R'");
        cube.move("U");
        cube.move("R");
        cube.move("U");
        cube.move("U");
        cube.move("R'");
      }
      //case three
      else if (cube.getCube()[2][4][0].equals(cube.getCube()[2][7][0])
          && cube.getCube()[2][4][0].equals(cube.getCube()[2][3][0])
          && cube.getCube()[2][4][0].equals(cube.getCube()[2][1][0])
          && cube.getCube()[2][4][0].equals(cube.getCube()[2][5][0])
          && !cube.getCube()[2][4][0].equals(cube.getCube()[2][0][0])
          && !cube.getCube()[2][4][0].equals(cube.getCube()[2][2][0])
          && !cube.getCube()[2][4][0].equals(cube.getCube()[2][6][0])
          && !cube.getCube()[2][4][0].equals(cube.getCube()[2][8][0])
          && cube.getCube()[2][4][0].equals(cube.getCube()[1][2][0])
          && cube.getCube()[2][4][0].equals(cube.getCube()[1][0][0])
          && cube.getCube()[2][4][0].equals(cube.getCube()[0][2][0])
          && cube.getCube()[2][4][0].equals(cube.getCube()[4][0][0])) {
        cube.move("R");
        cube.move("U");
        cube.move("R'");
        cube.move("U");
        cube.move("R");
        cube.move("U");
        cube.move("U");
        cube.move("R'");
      }
      //case four
      else if (cube.getCube()[2][4][0].equals(cube.getCube()[2][7][0])
          && cube.getCube()[2][4][0].equals(cube.getCube()[2][3][0])
          && cube.getCube()[2][4][0].equals(cube.getCube()[2][1][0])
          && cube.getCube()[2][4][0].equals(cube.getCube()[2][5][0])
          && !cube.getCube()[2][4][0].equals(cube.getCube()[2][0][0])
          && !cube.getCube()[2][4][0].equals(cube.getCube()[2][2][0])
          && !cube.getCube()[2][4][0].equals(cube.getCube()[2][6][0])
          && !cube.getCube()[2][4][0].equals(cube.getCube()[2][8][0])
          && cube.getCube()[2][4][0].equals(cube.getCube()[1][2][0])
          && cube.getCube()[2][4][0].equals(cube.getCube()[1][0][0])
          && cube.getCube()[2][4][0].equals(cube.getCube()[3][2][0])
          && cube.getCube()[2][4][0].equals(cube.getCube()[3][0][0])) {
        cube.move("R");
        cube.move("U");
        cube.move("R'");
        cube.move("U");
        cube.move("R");
        cube.move("U");
        cube.move("U");
        cube.move("R'");
      }
      //case five
      else if (cube.getCube()[2][4][0].equals(cube.getCube()[2][7][0])
          && cube.getCube()[2][4][0].equals(cube.getCube()[2][3][0])
          && cube.getCube()[2][4][0].equals(cube.getCube()[2][1][0])
          && cube.getCube()[2][4][0].equals(cube.getCube()[2][5][0])
          && !cube.getCube()[2][4][0].equals(cube.getCube()[2][0][0])
          && cube.getCube()[2][4][0].equals(cube.getCube()[2][2][0])
          && !cube.getCube()[2][4][0].equals(cube.getCube()[2][6][0])
          && cube.getCube()[2][4][0].equals(cube.getCube()[2][8][0])
          && cube.getCube()[2][4][0].equals(cube.getCube()[0][0][0])
          && cube.getCube()[2][4][0].equals(cube.getCube()[4][2][0])) {
        cube.move("R");
        cube.move("U");
        cube.move("R'");
        cube.move("U");
        cube.move("R");
        cube.move("U");
        cube.move("U");
        cube.move("R'");
      }
      //case six
      else if (cube.getCube()[2][4][0].equals(cube.getCube()[2][7][0])
          && cube.getCube()[2][4][0].equals(cube.getCube()[2][3][0])
          && cube.getCube()[2][4][0].equals(cube.getCube()[2][1][0])
          && cube.getCube()[2][4][0].equals(cube.getCube()[2][5][0])
          && cube.getCube()[2][4][0].equals(cube.getCube()[2][0][0])
          && cube.getCube()[2][4][0].equals(cube.getCube()[2][2][0])
          && !cube.getCube()[2][4][0].equals(cube.getCube()[2][6][0])
          && !cube.getCube()[2][4][0].equals(cube.getCube()[2][8][0])
          && cube.getCube()[2][4][0].equals(cube.getCube()[0][0][0])
          && cube.getCube()[2][4][0].equals(cube.getCube()[0][2][0])) {
        cube.move("R");
        cube.move("U");
        cube.move("R'");
        cube.move("U");
        cube.move("R");
        cube.move("U");
        cube.move("U");
        cube.move("R'");
      }
      //case seven
      else if (cube.getCube()[2][4][0].equals(cube.getCube()[2][7][0])
          && cube.getCube()[2][4][0].equals(cube.getCube()[2][3][0])
          && cube.getCube()[2][4][0].equals(cube.getCube()[2][1][0])
          && cube.getCube()[2][4][0].equals(cube.getCube()[2][5][0])
          && cube.getCube()[2][4][0].equals(cube.getCube()[2][0][0])
          && !cube.getCube()[2][4][0].equals(cube.getCube()[2][2][0])
          && !cube.getCube()[2][4][0].equals(cube.getCube()[2][6][0])
          && cube.getCube()[2][4][0].equals(cube.getCube()[2][8][0])
          && cube.getCube()[2][4][0].equals(cube.getCube()[0][0][0])
          && cube.getCube()[2][4][0].equals(cube.getCube()[3][2][0])) {
        cube.move("R");
        cube.move("U");
        cube.move("R'");
        cube.move("U");
        cube.move("R");
        cube.move("U");
        cube.move("U");
        cube.move("R'");
      } else {
        cube.move("U'");
        cube.move("D");
        cube.move("E");
      }
    }
  }

  //fix the side corner
  private void finishCorners(RubiksCube cube) {
    while (!cube.getCube()[1][2][0].equals(cube.getCube()[1][0][0])
        || !cube.getCube()[0][0][0].equals(cube.getCube()[0][2][0])
        || !cube.getCube()[3][2][0].equals(cube.getCube()[3][0][0])
        || !cube.getCube()[4][2][0].equals(cube.getCube()[4][0][0])) {
      for (int i = 0; i < 4; i++) {
        if (!cube.getCube()[3][0][0].equals(cube.getCube()[3][2][0])) {
          cube.move("U");
          cube.move("D'");
          cube.move("E'");
        } else {
          break;
        }
        if (i == 3 && !cube.getCube()[3][0][0].equals(cube.getCube()[3][2][0])) {
          cube.move("L");
          cube.move("M");
          cube.move("R'");

          cube.move("R");
          cube.move("R");
          cube.move("D");
          cube.move("D");
          cube.move("R'");
          cube.move("U'");
          cube.move("R");
          cube.move("D");
          cube.move("D");
          cube.move("R'");
          cube.move("U");
          cube.move("R'");

          cube.move("L'");
          cube.move("M'");
          cube.move("R");
          for (int x = 0; x < 4; x++) {
            if (!cube.getCube()[3][0][0].equals(cube.getCube()[3][2][0])) {
              cube.move("U");
              cube.move("D'");
              cube.move("E'");
            } else {
              break;
            }
          }
        }
      }
      cube.move("L");
      cube.move("M");
      cube.move("R'");
      cube.move("R");
      cube.move("R");
      cube.move("D");
      cube.move("D");
      cube.move("R'");
      cube.move("U'");
      cube.move("R");
      cube.move("D");
      cube.move("D");
      cube.move("R'");
      cube.move("U");
      cube.move("R'");
      cube.move("L'");
      cube.move("M'");
      cube.move("R");
    }
  }

  //fix the edge top
  private void fixTopEdge(RubiksCube cube) {
    while (!cube.checkComplete()) {
      if (cube.getCube()[0][0][0].equals(cube.getCube()[0][1][0]) && cube.getCube()[0][1][0].equals(
          cube.getCube()[0][2][0]) && cube.getCube()[0][2][0].equals(cube.getCube()[0][0][0])
          && cube.getCube()[1][0][0].equals(cube.getCube()[1][1][0])
          && cube.getCube()[1][1][0].equals(cube.getCube()[1][2][0])
          && cube.getCube()[1][2][0].equals(cube.getCube()[1][0][0])
          && cube.getCube()[3][0][0].equals(cube.getCube()[3][1][0])
          && cube.getCube()[3][1][0].equals(cube.getCube()[3][2][0])
          && cube.getCube()[3][2][0].equals(cube.getCube()[3][0][0])
          && cube.getCube()[4][0][0].equals(cube.getCube()[4][1][0])
          && cube.getCube()[4][1][0].equals(cube.getCube()[4][2][0])
          && cube.getCube()[4][2][0].equals(cube.getCube()[4][0][0])) {
        while (!cube.checkComplete()) {
          cube.move("U");
//          System.out.println(cube);
        }
        break;
      }
      //case one
      if (cube.getCube()[1][1][0].equals(cube.getCube()[0][0][0]) && cube.getCube()[0][1][0].equals(
          cube.getCube()[3][0][0]) && cube.getCube()[3][1][0].equals(cube.getCube()[1][0][0])) {
        cube.move("R");
        cube.move("U'");
        cube.move("R");
        cube.move("U");
        cube.move("R");
        cube.move("U");
        cube.move("R");
        cube.move("U'");
        cube.move("R'");
        cube.move("U'");
        cube.move("R");
        cube.move("R");
      }
      //case two
      else if (cube.getCube()[1][1][0].equals(cube.getCube()[3][0][0])
          && cube.getCube()[3][1][0].equals(cube.getCube()[0][0][0])
          && cube.getCube()[0][1][0].equals(cube.getCube()[1][0][0])) {
        cube.move("R");
        cube.move("U'");
        cube.move("R");
        cube.move("U");
        cube.move("R");
        cube.move("U");
        cube.move("R");
        cube.move("U'");
        cube.move("R'");
        cube.move("U'");
        cube.move("R");
        cube.move("R");
      }
      //case three
      else if (cube.getCube()[1][1][0].equals(cube.getCube()[3][0][0])
          && cube.getCube()[3][1][0].equals(cube.getCube()[1][0][0])
          && cube.getCube()[0][1][0].equals(cube.getCube()[4][0][0])
          && cube.getCube()[4][1][0].equals(cube.getCube()[0][0][0])) {
        cube.move("R");
        cube.move("U'");
        cube.move("R");
        cube.move("U");
        cube.move("R");
        cube.move("U");
        cube.move("R");
        cube.move("U'");
        cube.move("R'");
        cube.move("U'");
        cube.move("R");
        cube.move("R");
      }
      //case four
      else if (cube.getCube()[0][1][0].equals(cube.getCube()[3][0][0])
          && cube.getCube()[3][1][0].equals(cube.getCube()[0][0][0])
          && cube.getCube()[1][1][0].equals(cube.getCube()[4][0][0])
          && cube.getCube()[4][1][0].equals(cube.getCube()[1][0][0])) {
        cube.move("R");
        cube.move("U'");
        cube.move("R");
        cube.move("U");
        cube.move("R");
        cube.move("U");
        cube.move("R");
        cube.move("U'");
        cube.move("R'");
        cube.move("U'");
        cube.move("R");
        cube.move("R");
      } else {
        cube.move("U");
        cube.move("D'");
        cube.move("E'");
      }
//      System.out.println(cube);
    }
  }
}

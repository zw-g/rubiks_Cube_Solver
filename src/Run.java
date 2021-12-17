/**
 * <h2> CS 664 Final Project </h2>
 * I took this opportunity to develop something I always wanted to do, which is an AI project for
 * Rubiks cube. Inside the Run class I will show you two AI have created one without any Human
 * knowledge, one used the algorithm and solve the cube as a human.
 * <p>
 * <b>Note:</b> the ForceSolver might take a bit long
 *
 * @author Zhaowei Gu
 * @version 1.0
 * @since 2021-12-10
 */

public class Run {

  public static void main(String[] args) {

    //AI Solver with algorithm
    AiSolver as = new AiSolver();
    RubiksCube cube;
    long startTime = System.currentTimeMillis();
    for (int i = 0; i < 1000000; i++) {
      cube = new RubiksCube();
      cube.shuffle(23);
      as.solve(cube);
      if (cube.checkComplete()) {
        System.out.println("complete " + (i + 1));
      } else {
        System.out.println("fail");
        System.out.println(cube);
        break;
      }
    }
    long endTime = System.currentTimeMillis();
    System.out.println(
        "example of AI solve cube, shuffled 23 times, and solve 1 Million of them in "
            + (endTime - startTime) / 1000F + " seconds");

    //Force solver with only computing power
    ForceSolver cs = new ForceSolver();
    RubiksCube cb = new RubiksCube();
    cb.shuffle(2);
    startTime = System.currentTimeMillis();
    cs.solve(cb);
    endTime = System.currentTimeMillis();
    System.out.println(
        "example of force solve, shuffled 2 times it takes " + (endTime - startTime) / 1000F
            + " seconds");
  }
}
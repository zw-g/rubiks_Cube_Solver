import java.util.ArrayList;
import java.util.Random;

/**
 * <h2> Rubiks Cube </h2>
 * This program implements the skeleton and the logic of the Rubiks cube.
 * <p>
 * <b>Note:</b> It is implemented with 3D array, I will be able to move x,y,z axis in total 18
 * different movement.
 *
 * @author Zhaowei Gu
 * @version 1.0
 * @since 2021-12-10
 */

public class RubiksCube {

  String[][][] cube;

  //init the cube
  public RubiksCube() {
    //white 0, orange 1, blue 2, red 3, yellow 4, green 5
    cube = new String[][][]{{{"w"}, {"w"}, {"w"}, {"w"}, {"w"}, {"w"}, {"w"}, {"w"}, {"w"}},
        {{"o"}, {"o"}, {"o"}, {"o"}, {"o"}, {"o"}, {"o"}, {"o"}, {"o"}},
        {{"b"}, {"b"}, {"b"}, {"b"}, {"b"}, {"b"}, {"b"}, {"b"}, {"b"}},
        {{"r"}, {"r"}, {"r"}, {"r"}, {"r"}, {"r"}, {"r"}, {"r"}, {"r"}},
        {{"y"}, {"y"}, {"y"}, {"y"}, {"y"}, {"y"}, {"y"}, {"y"}, {"y"}},
        {{"g"}, {"g"}, {"g"}, {"g"}, {"g"}, {"g"}, {"g"}, {"g"}, {"g"}}};
  }

  @Override
  public String toString() {
    String out = "             ";
    out += "| " + cube[1][8][0] + " | " + cube[1][7][0] + " | " + cube[1][6][0] + " |";
    out += "                         \n";
    out += "             ";
    out += "| " + cube[1][5][0] + " | " + cube[1][4][0] + " | " + cube[1][3][0] + " |";
    out += "                         \n";
    out += "             ";
    out += "| " + cube[1][2][0] + " | " + cube[1][1][0] + " | " + cube[1][0][0] + " |";
    out += "                         \n";

    out += "| " + cube[0][6][0] + " | " + cube[0][3][0] + " | " + cube[0][0][0] + " |";
    out += "| " + cube[2][6][0] + " | " + cube[2][3][0] + " | " + cube[2][0][0] + " |";
    out += "| " + cube[4][2][0] + " | " + cube[4][5][0] + " | " + cube[4][8][0] + " |";
    out += "| " + cube[5][2][0] + " | " + cube[5][5][0] + " | " + cube[5][8][0] + " |\n";

    out += "| " + cube[0][7][0] + " | " + cube[0][4][0] + " | " + cube[0][1][0] + " |";
    out += "| " + cube[2][7][0] + " | " + cube[2][4][0] + " | " + cube[2][1][0] + " |";
    out += "| " + cube[4][1][0] + " | " + cube[4][4][0] + " | " + cube[4][7][0] + " |";
    out += "| " + cube[5][1][0] + " | " + cube[5][4][0] + " | " + cube[5][7][0] + " |\n";

    out += "| " + cube[0][8][0] + " | " + cube[0][5][0] + " | " + cube[0][2][0] + " |";
    out += "| " + cube[2][8][0] + " | " + cube[2][5][0] + " | " + cube[2][2][0] + " |";
    out += "| " + cube[4][0][0] + " | " + cube[4][3][0] + " | " + cube[4][6][0] + " |";
    out += "| " + cube[5][0][0] + " | " + cube[5][3][0] + " | " + cube[5][6][0] + " |\n";

    out += "             ";
    out += "| " + cube[3][0][0] + " | " + cube[3][1][0] + " | " + cube[3][2][0] + " | ";
    out += "                         \n";
    out += "             ";
    out += "| " + cube[3][3][0] + " | " + cube[3][4][0] + " | " + cube[3][5][0] + " |";
    out += "                         \n";
    out += "            ";
    out += " | " + cube[3][6][0] + " | " + cube[3][7][0] + " | " + cube[3][8][0] + " |";
    out += "                          \n";

    return out;
  }

  //it will randomly shuffle the cube count times.
  public void shuffle(int count) {
    Random rand = new Random();
    ArrayList<String> moves = new ArrayList<>();
    String[] m = {"L", "L'", "R", "R'", "U", "U'", "D", "D'", "F", "F'", "B", "B'", "M", "M'", "E",
        "E'", "S", "S'"};
    for (int i = 0; i < count; i++) {
      moves.add(m[rand.nextInt(18)]);
    }
    for (int i = 0; i < count; i++) {
      move(moves.get(i));
    }
  }

  //check to see if the cube is in a complete stage
  public boolean checkComplete() {
    boolean zero = (cube[0][4][0].equals(cube[0][0][0]) && cube[0][4][0].equals(cube[0][1][0])
        && cube[0][4][0].equals(cube[0][2][0]) && cube[0][4][0].equals(cube[0][3][0])
        && cube[0][4][0].equals(cube[0][5][0]) && cube[0][4][0].equals(cube[0][6][0])
        && cube[0][4][0].equals(cube[0][7][0]) && cube[0][4][0].equals(cube[0][8][0]));
    boolean one = (cube[1][4][0].equals(cube[1][0][0]) && cube[1][4][0].equals(cube[1][1][0])
        && cube[1][4][0].equals(cube[1][2][0]) && cube[1][4][0].equals(cube[1][3][0])
        && cube[1][4][0].equals(cube[1][5][0]) && cube[1][4][0].equals(cube[1][6][0])
        && cube[1][4][0].equals(cube[1][7][0]) && cube[1][4][0].equals(cube[1][8][0]));
    boolean two = (cube[2][4][0].equals(cube[2][0][0]) && cube[2][4][0].equals(cube[2][1][0])
        && cube[2][4][0].equals(cube[2][2][0]) && cube[2][4][0].equals(cube[2][3][0])
        && cube[2][4][0].equals(cube[2][5][0]) && cube[2][4][0].equals(cube[2][6][0])
        && cube[2][4][0].equals(cube[2][7][0]) && cube[2][4][0].equals(cube[2][8][0]));
    boolean three = (cube[3][4][0].equals(cube[3][0][0]) && cube[3][4][0].equals(cube[3][1][0])
        && cube[3][4][0].equals(cube[3][2][0]) && cube[3][4][0].equals(cube[3][3][0])
        && cube[3][4][0].equals(cube[3][5][0]) && cube[3][4][0].equals(cube[3][6][0])
        && cube[3][4][0].equals(cube[3][7][0]) && cube[3][4][0].equals(cube[3][8][0]));
    boolean four = (cube[4][4][0].equals(cube[4][0][0]) && cube[4][4][0].equals(cube[4][1][0])
        && cube[4][4][0].equals(cube[4][2][0]) && cube[4][4][0].equals(cube[4][3][0])
        && cube[4][4][0].equals(cube[4][5][0]) && cube[4][4][0].equals(cube[4][6][0])
        && cube[4][4][0].equals(cube[4][7][0]) && cube[4][4][0].equals(cube[4][8][0]));
    boolean five = (cube[5][4][0].equals(cube[5][0][0]) && cube[5][4][0].equals(cube[5][1][0])
        && cube[5][4][0].equals(cube[5][2][0]) && cube[5][4][0].equals(cube[5][3][0])
        && cube[5][4][0].equals(cube[5][5][0]) && cube[5][4][0].equals(cube[5][6][0])
        && cube[5][4][0].equals(cube[5][7][0]) && cube[5][4][0].equals(cube[5][8][0]));
    return (zero && one && two && three && four && five);
  }

  //return the cube information int[][][]
  public String[][][] getCube() {
    return cube;
  }

  //make a move depending on S
  public void move(String s) {
    String x, y, z;
    switch (s) {
      //x top
      case "U":
        rotateClock(2);

        x = cube[0][0][0];
        y = cube[0][1][0];
        z = cube[0][2][0];

        cube[0][0][0] = cube[3][0][0];
        cube[0][1][0] = cube[3][1][0];
        cube[0][2][0] = cube[3][2][0];

        cube[3][0][0] = cube[4][0][0];
        cube[3][1][0] = cube[4][1][0];
        cube[3][2][0] = cube[4][2][0];

        cube[4][0][0] = cube[1][0][0];
        cube[4][1][0] = cube[1][1][0];
        cube[4][2][0] = cube[1][2][0];

        cube[1][0][0] = x;
        cube[1][1][0] = y;
        cube[1][2][0] = z;
        break;
      case "U'":
        rotateCounter(2);

        x = cube[0][0][0];
        y = cube[0][1][0];
        z = cube[0][2][0];

        cube[0][0][0] = cube[1][0][0];
        cube[0][1][0] = cube[1][1][0];
        cube[0][2][0] = cube[1][2][0];

        cube[1][0][0] = cube[4][0][0];
        cube[1][1][0] = cube[4][1][0];
        cube[1][2][0] = cube[4][2][0];

        cube[4][0][0] = cube[3][0][0];
        cube[4][1][0] = cube[3][1][0];
        cube[4][2][0] = cube[3][2][0];

        cube[3][0][0] = x;
        cube[3][1][0] = y;
        cube[3][2][0] = z;
        break;
      //x mid
      case "E":
        x = cube[0][3][0];
        y = cube[0][4][0];
        z = cube[0][5][0];

        cube[0][3][0] = cube[1][3][0];
        cube[0][4][0] = cube[1][4][0];
        cube[0][5][0] = cube[1][5][0];

        cube[1][3][0] = cube[4][3][0];
        cube[1][4][0] = cube[4][4][0];
        cube[1][5][0] = cube[4][5][0];

        cube[4][3][0] = cube[3][3][0];
        cube[4][4][0] = cube[3][4][0];
        cube[4][5][0] = cube[3][5][0];

        cube[3][3][0] = x;
        cube[3][4][0] = y;
        cube[3][5][0] = z;
        break;
      case "E'":
        x = cube[0][3][0];
        y = cube[0][4][0];
        z = cube[0][5][0];

        cube[0][3][0] = cube[3][3][0];
        cube[0][4][0] = cube[3][4][0];
        cube[0][5][0] = cube[3][5][0];

        cube[3][3][0] = cube[4][3][0];
        cube[3][4][0] = cube[4][4][0];
        cube[3][5][0] = cube[4][5][0];

        cube[4][3][0] = cube[1][3][0];
        cube[4][4][0] = cube[1][4][0];
        cube[4][5][0] = cube[1][5][0];

        cube[1][3][0] = x;
        cube[1][4][0] = y;
        cube[1][5][0] = z;
        break;
      case "D":
        rotateClock(5);

        x = cube[0][6][0];
        y = cube[0][7][0];
        z = cube[0][8][0];

        cube[0][6][0] = cube[1][6][0];
        cube[0][7][0] = cube[1][7][0];
        cube[0][8][0] = cube[1][8][0];

        cube[1][6][0] = cube[4][6][0];
        cube[1][7][0] = cube[4][7][0];
        cube[1][8][0] = cube[4][8][0];

        cube[4][6][0] = cube[3][6][0];
        cube[4][7][0] = cube[3][7][0];
        cube[4][8][0] = cube[3][8][0];

        cube[3][6][0] = x;
        cube[3][7][0] = y;
        cube[3][8][0] = z;
        break;
      case "D'":
        rotateCounter(5);

        x = cube[0][6][0];
        y = cube[0][7][0];
        z = cube[0][8][0];

        cube[0][6][0] = cube[3][6][0];
        cube[0][7][0] = cube[3][7][0];
        cube[0][8][0] = cube[3][8][0];

        cube[3][6][0] = cube[4][6][0];
        cube[3][7][0] = cube[4][7][0];
        cube[3][8][0] = cube[4][8][0];

        cube[4][6][0] = cube[1][6][0];
        cube[4][7][0] = cube[1][7][0];
        cube[4][8][0] = cube[1][8][0];

        cube[1][6][0] = x;
        cube[1][7][0] = y;
        cube[1][8][0] = z;
        break;
      //y
      case "L":
        rotateClock(1);

        x = cube[0][6][0];
        y = cube[0][3][0];
        z = cube[0][0][0];

        cube[0][6][0] = cube[2][6][0];
        cube[0][3][0] = cube[2][3][0];
        cube[0][0][0] = cube[2][0][0];

        cube[2][6][0] = cube[4][2][0];
        cube[2][3][0] = cube[4][5][0];
        cube[2][0][0] = cube[4][8][0];

        cube[4][2][0] = cube[5][2][0];
        cube[4][5][0] = cube[5][5][0];
        cube[4][8][0] = cube[5][8][0];

        cube[5][2][0] = x;
        cube[5][5][0] = y;
        cube[5][8][0] = z;
        break;
      case "L'":
        rotateCounter(1);

        x = cube[0][6][0];
        y = cube[0][3][0];
        z = cube[0][0][0];

        cube[0][6][0] = cube[5][2][0];
        cube[0][3][0] = cube[5][5][0];
        cube[0][0][0] = cube[5][8][0];

        cube[5][2][0] = cube[4][2][0];
        cube[5][5][0] = cube[4][5][0];
        cube[5][8][0] = cube[4][8][0];

        cube[4][2][0] = cube[2][6][0];
        cube[4][5][0] = cube[2][3][0];
        cube[4][8][0] = cube[2][0][0];

        cube[2][6][0] = x;
        cube[2][3][0] = y;
        cube[2][0][0] = z;
        break;
      case "R":
        rotateClock(3);

        x = cube[0][8][0];
        y = cube[0][5][0];
        z = cube[0][2][0];

        cube[0][8][0] = cube[5][0][0];
        cube[0][5][0] = cube[5][3][0];
        cube[0][2][0] = cube[5][6][0];

        cube[5][0][0] = cube[4][0][0];
        cube[5][3][0] = cube[4][3][0];
        cube[5][6][0] = cube[4][6][0];

        cube[4][0][0] = cube[2][8][0];
        cube[4][3][0] = cube[2][5][0];
        cube[4][6][0] = cube[2][2][0];

        cube[2][8][0] = x;
        cube[2][5][0] = y;
        cube[2][2][0] = z;
        break;
      case "R'":
        rotateCounter(3);

        x = cube[0][8][0];
        y = cube[0][5][0];
        z = cube[0][2][0];

        cube[0][8][0] = cube[2][8][0];
        cube[0][5][0] = cube[2][5][0];
        cube[0][2][0] = cube[2][2][0];

        cube[2][8][0] = cube[4][0][0];
        cube[2][5][0] = cube[4][3][0];
        cube[2][2][0] = cube[4][6][0];

        cube[4][0][0] = cube[5][0][0];
        cube[4][3][0] = cube[5][3][0];
        cube[4][6][0] = cube[5][6][0];

        cube[5][0][0] = x;
        cube[5][3][0] = y;
        cube[5][6][0] = z;
        break;
      case "M":
        x = cube[0][1][0];
        y = cube[0][4][0];
        z = cube[0][7][0];

        cube[0][1][0] = cube[2][1][0];
        cube[0][4][0] = cube[2][4][0];
        cube[0][7][0] = cube[2][7][0];

        cube[2][1][0] = cube[4][7][0];
        cube[2][4][0] = cube[4][4][0];
        cube[2][7][0] = cube[4][1][0];

        cube[4][7][0] = cube[5][7][0];
        cube[4][4][0] = cube[5][4][0];
        cube[4][1][0] = cube[5][1][0];

        cube[5][7][0] = x;
        cube[5][4][0] = y;
        cube[5][1][0] = z;
        break;
      case "M'":
        x = cube[0][1][0];
        y = cube[0][4][0];
        z = cube[0][7][0];

        cube[0][1][0] = cube[5][7][0];
        cube[0][4][0] = cube[5][4][0];
        cube[0][7][0] = cube[5][1][0];

        cube[5][7][0] = cube[4][7][0];
        cube[5][4][0] = cube[4][4][0];
        cube[5][1][0] = cube[4][1][0];

        cube[4][7][0] = cube[2][1][0];
        cube[4][4][0] = cube[2][4][0];
        cube[4][1][0] = cube[2][7][0];

        cube[2][1][0] = x;
        cube[2][4][0] = y;
        cube[2][7][0] = z;
        break;
      //z
      case "F":
        rotateClock(0);

        x = cube[1][8][0];
        y = cube[1][5][0];
        z = cube[1][2][0];

        cube[1][8][0] = cube[5][6][0];
        cube[1][5][0] = cube[5][7][0];
        cube[1][2][0] = cube[5][8][0];

        cube[5][6][0] = cube[3][0][0];
        cube[5][7][0] = cube[3][3][0];
        cube[5][8][0] = cube[3][6][0];

        cube[3][0][0] = cube[2][6][0];
        cube[3][3][0] = cube[2][7][0];
        cube[3][6][0] = cube[2][8][0];

        cube[2][6][0] = x;
        cube[2][7][0] = y;
        cube[2][8][0] = z;
        break;
      case "F'":
        rotateCounter(0);

        x = cube[1][8][0];
        y = cube[1][5][0];
        z = cube[1][2][0];

        cube[1][8][0] = cube[2][6][0];
        cube[1][5][0] = cube[2][7][0];
        cube[1][2][0] = cube[2][8][0];

        cube[2][6][0] = cube[3][0][0];
        cube[2][7][0] = cube[3][3][0];
        cube[2][8][0] = cube[3][6][0];

        cube[3][0][0] = cube[5][6][0];
        cube[3][3][0] = cube[5][7][0];
        cube[3][6][0] = cube[5][8][0];

        cube[5][6][0] = x;
        cube[5][7][0] = y;
        cube[5][8][0] = z;
        break;
      case "B":
        rotateClock(4);

        x = cube[1][6][0];
        y = cube[1][3][0];
        z = cube[1][0][0];

        cube[1][6][0] = cube[2][0][0];
        cube[1][3][0] = cube[2][1][0];
        cube[1][0][0] = cube[2][2][0];

        cube[2][0][0] = cube[3][2][0];
        cube[2][1][0] = cube[3][5][0];
        cube[2][2][0] = cube[3][8][0];

        cube[3][2][0] = cube[5][0][0];
        cube[3][5][0] = cube[5][1][0];
        cube[3][8][0] = cube[5][2][0];

        cube[5][0][0] = x;
        cube[5][1][0] = y;
        cube[5][2][0] = z;
        break;
      case "B'":
        rotateCounter(4);

        x = cube[1][6][0];
        y = cube[1][3][0];
        z = cube[1][0][0];

        cube[1][6][0] = cube[5][0][0];
        cube[1][3][0] = cube[5][1][0];
        cube[1][0][0] = cube[5][2][0];

        cube[5][0][0] = cube[3][2][0];
        cube[5][1][0] = cube[3][5][0];
        cube[5][2][0] = cube[3][8][0];

        cube[3][2][0] = cube[2][0][0];
        cube[3][5][0] = cube[2][1][0];
        cube[3][8][0] = cube[2][2][0];

        cube[2][0][0] = x;
        cube[2][1][0] = y;
        cube[2][2][0] = z;
        break;
      case "S":
        x = cube[1][1][0];
        y = cube[1][4][0];
        z = cube[1][7][0];

        cube[1][1][0] = cube[5][5][0];
        cube[1][4][0] = cube[5][4][0];
        cube[1][7][0] = cube[5][3][0];

        cube[5][5][0] = cube[3][7][0];
        cube[5][4][0] = cube[3][4][0];
        cube[5][3][0] = cube[3][1][0];

        cube[3][7][0] = cube[2][5][0];
        cube[3][4][0] = cube[2][4][0];
        cube[3][1][0] = cube[2][3][0];

        cube[2][5][0] = x;
        cube[2][4][0] = y;
        cube[2][3][0] = z;
        break;
      case "S'":
        x = cube[1][7][0];
        y = cube[1][4][0];
        z = cube[1][1][0];

        cube[1][7][0] = cube[2][3][0];
        cube[1][4][0] = cube[2][4][0];
        cube[1][1][0] = cube[2][5][0];

        cube[2][3][0] = cube[3][1][0];
        cube[2][4][0] = cube[3][4][0];
        cube[2][5][0] = cube[3][7][0];

        cube[3][1][0] = cube[5][3][0];
        cube[3][4][0] = cube[5][4][0];
        cube[3][7][0] = cube[5][5][0];

        cube[5][3][0] = x;
        cube[5][4][0] = y;
        cube[5][5][0] = z;
        break;
    }
  }

  //move can all it to rotate counter
  private void rotateCounter(int panel) {
    String x;
    x = cube[panel][0][0];
    cube[panel][0][0] = cube[panel][2][0];
    cube[panel][2][0] = cube[panel][8][0];
    cube[panel][8][0] = cube[panel][6][0];
    cube[panel][6][0] = x;
    x = cube[panel][1][0];
    cube[panel][1][0] = cube[panel][5][0];
    cube[panel][5][0] = cube[panel][7][0];
    cube[panel][7][0] = cube[panel][3][0];
    cube[panel][3][0] = x;
  }

  //move can all it to rotate clock
  private void rotateClock(int panel) {
    String x;
    x = cube[panel][0][0];
    cube[panel][0][0] = cube[panel][6][0];
    cube[panel][6][0] = cube[panel][8][0];
    cube[panel][8][0] = cube[panel][2][0];
    cube[panel][2][0] = x;
    x = cube[panel][1][0];
    cube[panel][1][0] = cube[panel][3][0];
    cube[panel][3][0] = cube[panel][7][0];
    cube[panel][7][0] = cube[panel][5][0];
    cube[panel][5][0] = x;
  }
}

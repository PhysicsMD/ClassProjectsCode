package lab4;

/**
 * @author Alenn Wright and Jordan D.
 * agw73,jjd292
 * 10/12/18
 */
public class Sudoku {

    char array3d[][] = new char[9][9];//This initializes an array

    Sudoku() {//This initializes a game with a blank array
        for (int i = 0; i < 81; i++) {
            array3d[i / 9][i % 9] = ' ';
        }
    }

    Sudoku(String start) {//This initializes a game with the start array
        for (int i = 0; i < 81; i++) {
            if (i < 10) {
                array3d[i / 9][i % 9] = start.charAt(i);
            } else if (i == 10) {//weird glich compensation in making a 2d array
                array3d[i / 9][i % 9 - 1] = start.charAt(i);
                array3d[i / 9][i % 9] = start.charAt(i + 1);
            } else {
                int count = i / 9;
                array3d[i / 9][i % 9] = start.charAt(i + count);
            }
        }
    }

    char getSquare(int row, int col) {//This method takes a specific character from an array and returns it
        char character = array3d[row][col];
        return character;
    }

    void setSquare(int row, int col, char value) {//This method takes a specific point in an array and sets it
        array3d[row][col] = value;
    }

    boolean alphacheck() {//this check verifies if there are just numbers and spaces
        boolean status = true; //This boolean statement stands as out innocent until proven guilty variable
        for (int i = 0; i < 81; i++) {//we utilized a switch case statement
            switch (array3d[i / 9][i % 9]) {
                case '1': break;
                case '2': break;
                case '3': break;
                case '4': break;
                case '5': break;
                case '6': break;
                case '7': break;
                case '8': break;
                case '9': break;
                case ' ':  break;
                default:
                    status = false;
                    break;
            }
        }
        return status;
    }

    boolean numcheck() {//this check verifies if there are just numbers
        boolean status = true; //This boolean statement stands as out innocent until proven guilty variable
        for (int i = 0; i < 81; i++) {
            //we utilized a switch case statement
            switch (array3d[i / 9][i % 9]) {
                case '1': break;
                case '2': break;
                case '3': break;
                case '4': break;
                case '5': break;
                case '6': break;
                case '7': break;
                case '8': break;
                case '9': break;
                default:
                    status = false;
                    break;
            }
        }
        return status;
    }

    boolean rowcheck() {
        boolean status = true;  //This boolean statement stands as out innocent until proven guilty variable
        char number; //This holds a value to compare
        for (int i = 0; i < 9; i++) { //This iterates columns
            for (int j = 0; j < 9; j++) { //This iterates rows
                number = array3d[i][j]; //Comparison value setter
                for (int z = 0; z < 9; z++) { //This iterates by 1 in the rows
                    if ((number == array3d[i][z]) && (j != z) && (number != ' ')) {
                        status = false; //If value is duplicated excluding a space
                    }
                }
            }
        }
        return status;
    }

    boolean colcheck() {
        boolean status = true;  //This boolean statement stands as out innocent until proven guilty variable
        char number; //This holds a value to compare
        for (int i = 0; i < 9; i++) { //This iterates columns
            for (int j = 0; j < 9; j++) { //This iterates rows
                number = array3d[i][j]; //Comparison value setter
                for (int z = 0; z < 9; z++) { //This iterates by 1 in the columns
                    if ((number == array3d[z][j]) && (i != z) && (number != ' ')) {
                        status = false; //If value is duplicated excluding a space
                    }
                }
            }
        }
        return status;
    }

    boolean squarecheck() {
        boolean status = true;  //This boolean statement stands as out innocent until proven guilty variable
        char number; //This holds a value to compare
        for (int i = 0; i < 9; i++) { //This iterates columns
            for (int j = 0; j < 9; j++) { //This iterates rows
                number = array3d[i][j]; //Comparison value setter
                for (int z = 0; z < 9; z++) { //This iterates by 1 in the 3x3 square
                    if ((number == array3d[z / 3 + (i / 3) * 3][z % 3 + (j / 3) * 3]) && (i != (z / 3 + (i / 3) * 3)) && (j != (z % 3 + (j / 3) * 3)) && (number != ' ')) {
                        status = false; //If value is duplicated excluding a space
                    }
                }
            }
        }
        return status;
    }

    boolean isValid() {
        boolean status = false;
        if ((alphacheck() == true) && (rowcheck() == true) && (colcheck() == true) && (squarecheck() == true)) {
            status = true; // If all methods say true then it is valid
        }
        return status;
    }

    boolean isSolved() {
        boolean status = false;
        if ((isValid() == true) && (numcheck() == true)) {
            status = true; // if isValid returns true and there are no spaces then it returns true
        }
        return status;
    }
}

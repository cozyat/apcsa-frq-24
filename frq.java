import java.util.*;

public class frq {
    /*
     * I defined this class because the stupid public type must be defined as frq.java
     * Not all of the code is right and I only just did this for fun
     * It gets more insane as you progress through each class
     * Do NOT ever attempt the gridPath class question
     */
}

/* FRQ STARTS HERE */

class Feeder {
    private int currentFood;

    public void simulateOneDay(int numBirds) {
        if (Math.random() < 0.05) {
            currentFood = 0;
        } else {
            currentFood = (int) (Math.random() * 41) + 10;
            int totalFoodConsumed = currentFood * numBirds;
            if (totalFoodConsumed > currentFood) {
                currentFood = 0;
            }
        }
    }

    public int simulateManyDays(int numBirds, int numDays) {
        int countDays = 0;
        int counter = 0;
        while (currentFood > 0 && counter < numDays) {
            countDays++;
            counter++;
            simulateOneDay(numBirds);
        }
        return countDays;
    }
}

class ScoreBoard {
    private String teamOne;
    private String teamTwo;
    private int scoreOne;
    private int scoreTwo;
    private int active;

    public ScoreBoard(String a, String b) {
        teamOne = a;
        teamTwo = b;
        scoreOne = 0;
        scoreTwo = 0;
        active = 2;
    }

    public String getScore() {
        if (active % 2 == 0) {
            return scoreOne + "-" + scoreTwo + "-" + teamOne;
        } else {
            return scoreOne + "-" + scoreTwo + "-" + teamTwo;
        }
    }

    public void recordPlay(int points) {
        if (points == 0) {
            active++;
        } else {
            if (active % 2 == 0) {
                scoreOne += points;
            } else {
                scoreTwo += points;
            }
        }
    }
}

class WordChecker {
    private ArrayList<String> wordList = new ArrayList<>();
    private ArrayList<String> resized = new ArrayList<>();

    public boolean isWordChain() {
        for (int i = 0; i < wordList.size(); i++) {
            if (wordList.get(i).indexOf(wordList.get(i - 1)) == 1) {
                return false;
            }
        }
        return true;
    }

    public ArrayList<String> createList(String target) {
        for (int i = 0; i < wordList.size(); i++) {
            if (wordList.get(i).substring(0, target.length()).equals(target)) {
                resized.add(wordList.get(i).substring(target.length()));
            }
        }
        return resized;
    }
}

class Location {
    private int theRow;
    private int theCol;

    public Location(int r, int c) {
        theRow = r;
        theCol = c;
    }

    public int getRow() {
        return theRow;
    }

    public int getCol() {
        return theCol;
    }
}

class GridPath {
    private int[][] grid;
    public Location getNextLoc(int row, int col) {
        int rowBelow = row + 1;
        int colRight = col + 1;
        if (rowBelow < grid.length && colRight < grid[0].length) {
            if (grid[rowBelow][col] < grid[row][colRight]) {
                return new Location(rowBelow, col);
            } else {
                return new Location(row, colRight);
            }
        } else if (rowBelow < grid.length) {
            return new Location(rowBelow, col);
        } else {
            return new Location(row, col);
        }
    }

    public int sumPath(int row, int col) {
        int sum = grid[row][col];
        while (row != grid.length - 1 && col != grid[0].length - 1) {
            Location nextGrid = getNextLoc(row, col);
            row = nextGrid.getRow();
            col = nextGrid.getCol();
            sum += grid[row][col];
        }
        return sum;
    }
}

/* FRQ ENDS HERE */

package p03.ex01;

public class JGaloLogic implements JGaloInterface {
    /**
     * ATTRIBUTES
     */
    private char player1;
    private char player2;
    private int playerRecord;
    private char[][] grid;
    private int nMoves;

    /**
     * CONSTRUCTOR
     */
    public JGaloLogic() {
        this.player1 = 'X';
        this.player2 = 'O';
        this.playerRecord = 1;
        this.grid = new char[3][3];
        this.nMoves = 0;
    }

    /**
     * METHODS
     */
    @Override
    public char getActualPlayer() {
        if (this.playerRecord % 2 == 1)
            return this.player1;
        return this.player2;
    }

    @Override
    public boolean setJogada(int lin, int col) {
        // lin and col go from 1 to 3, so decrement 1 value to check and put in grid
        lin--;
        col--;
        if (lin >= 0 || lin < 3 || col >= 0 || col < 3 || this.grid[lin][col] != '\0') {
            char player = getActualPlayer();
            this.grid[lin][col] = player;
            this.playerRecord++;
            this.nMoves++;
            return true;
        } else {
            return false;
        }
    }

    // Returns true if found; false otherwise
    // Receives A char array containing the soup AND A word to be searched
    public boolean findWord(char[][] soup, String word) {
        int soupSize = soup.length;

        int dir;

        for (int i = 0; i < soupSize; i++) {
            for (int j = 0; j < soupSize; j++) {
                if (soup[i][j] == word.charAt(0)) {
                    dir = checkAllDirs(soup, word, i, j);
                    if (dir != -1)
                        return true;
                }
            }
        }
        return false;
    }

    private int checkAllDirs(char[][] wordJumble, String word, int startX, int startY) {
        int[] xDirs = { 0, -1, -1, 1 }; // In order: UP LEFT UPLEFT UPRIGHT
        int[] yDirs = { -1, 0, -1, -1 }; // In order: UP LEFT UPLEFT UPRIGHT

        for (int dir = 0; dir < 4; dir++) // Search the 4 cardinal directions
        {

            int charCounter, nextX = startX + xDirs[dir], nextY = startY + yDirs[dir];
            // NOTE: We already checked the first letter before calling this function ;
            // Check all other chars in the same direction
            for (charCounter = 1; charCounter < word.length(); charCounter++) {
                // If out of bound
                if (nextX >= wordJumble.length || nextX < 0 || nextY >= wordJumble.length || nextY < 0)
                    break;

                // If not matched
                if (wordJumble[nextX][nextY] != word.charAt(charCounter))
                    break;

                // Continue moving
                nextX += xDirs[dir];
                nextY += yDirs[dir];
            }

            if (charCounter == word.length())
                return dir;
        }
        return -1;
    }

    @Override
    public boolean isFinished() {
        if (checkResult() != ' ' || this.nMoves == 9) {
            return true;
        }
        return false;
    }

    @Override
    public char checkResult() {
        if (findWord(this.grid, repeat(this.player1, 3))) {
            return this.player1;
        } else if (findWord(this.grid, repeat(this.player2, 3))) {
            return this.player2;
        }
        return ' ';
    }

    private String repeat(char c, int nOfRepeats) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nOfRepeats; i++) {
            sb.append(c);
        }
        return sb.toString();
    }
}

package com.example.jordan.theroyalgameofur;

public class Board {
    private int[] spaces;
    final int EMPTY = 0;
    final int PLAYER1 = 1;
    final int PLAYER2 = -1;


    public Board() {
        this.spaces = new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};

    }

    public int[] roll (){
        int[] tetradice = new int[4];
        for(int x = 0; x < 4; x++){
            tetradice[x] = (int)(Math.round(Math.random()));
        }
        return tetradice;
    }

    public int rollScore(int[] tetradice) {
        int score = 0;
        for(int x = 0; x < 4; x++) {
            score = score + tetradice[x];
        }
        return score;
    }

    //checks if a space contains a rosette
    public boolean rosette(int space) {
        boolean rosette = false;
        switch (space) {
            case -1: case 0: case 1:
            case 2: case 4: case 5:
            case 6: case 8: case 9:
            case 10: case 11: case 12:
            case 14: case 15:
                rosette = false;
                break;
            case 3: case 7: case 13:
                rosette = true;
                break;
        }

        return rosette;
    }

    //update board to move piece
    public void updateBoard(int tile, int player) {
        this.spaces[tile] = player;
    }

    /**
     * @return the spaces
     */
    public int[] getSpaces() {
        return spaces;
    }

    public int getSpaces(int x) {
        return spaces[x];
    }
}

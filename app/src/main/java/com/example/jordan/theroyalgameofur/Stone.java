package com.example.jordan.theroyalgameofur;

public class Stone {
    public int location;
    public final int PLAYER;
    public boolean safe;
    private boolean inPlay;


    public Stone(int player) {
        this.location = -1;
        this.inPlay = true;
        this.safe = true;
        this.PLAYER = player;
    }

    /**
     * @return the location
     */
    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    /**
     * @return the PLAYER
     */
    public int getPLAYER() {
        return PLAYER;
    }

    /**
     * @param safe the safe to set
     */
    public void setSafe(boolean safe) {
        this.safe = safe;
    }
}

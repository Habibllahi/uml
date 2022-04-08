package com.klaipeda.assessment.uml;

public class MovablePoint implements Movable{
    private int x;

    private int y;


    /**
     * <p>Get point X</p>
     * @return int
     */
    public int getX() {
        return x;
    }

    /**
     * <p>Set point X</p>
     * @param x X coordinate
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Get point Y
     * @return int
     */
    public int getY() {
        return y;
    }

    /**
     * <p>Set point Y</p>
     * @param y Y coordinate
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * <p>Move point upward along X-axis</p>
     */
    @Override
    public void moveUp() {
        x++;
    }

    /**
     * <p>Move point downward along X-axis</p>
     */
    @Override
    public void moveDown() {
        x--;
    }

    /**
     * <p>Move point leftward along Y-axis</p>
     */
    @Override
    public void moveLeft() {
        y--;
    }

    /**
     * <p>Move point rightward along Y-axis</p>
     */
    @Override
    public void moveRight() {
        y++;
    }

    @Override
    public String toString() {
        return "MovablePoint{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

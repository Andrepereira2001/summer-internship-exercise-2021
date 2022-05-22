package com.premiumminds.internship.screenlocking;

import java.util.ArrayList;
import java.util.List;

public class Pattern {
    List<Integer> pattern;
    int length;

    /**
     * Constructor of the pattern class used to save a patter
     * @param begin - beginning number of the pattern
     * @param lenght - length of the pattern
     */
    public Pattern(Integer begin, Integer lenght){
        this.length = lenght;
        pattern = new ArrayList<>();
        pattern.add(begin);
    }

    /**
     * Get total length of the pattern
     * @return - length of the pattern
     */
    public int getLength() {
        return length;
    }

    /**
     * Get current length of the pattern
     * @return - current length of the pattern
     */
    public int getPatternLength(){
        return pattern.size();
    }

    /**
     * Get current pattern
     * @return - current pattern
     */
    public List<Integer> getPattern() {
        return pattern;
    }

    /**
     * Given a number returns its x in a matrix
     * @param number - number of the matrix
     * @return - x of the number in the matrix
     */
    public int getMatrixX(Integer number){
        return (number - 1) % 3;
    }

    /**
     * Given a number returns its y in a matrix
     * @param number - number of the matrix
     * @return - y of the number in the matrix
     */
    public int getMatrixY(Integer number){
        return (int) Math.floor((number - 1) / 3);
    }

    /**
     * Given coordinates in the matrix return number in pos
     * @param x - column in the matrix
     * @param y - row in the matrix
     * @return - value in the pos (x,y)
     */
    public int getMatrixNumber(int x, int y){
        return y * 3 + x + 1;
    }

    /**
     * Verifies if the pattern length is the desired
     * @return - true if current length is the desired else false
     */
    public boolean validPattern(){
        return getPatternLength() == getLength();
    }

    /**
     * Add number to pattern if valid
     * @param number - number to be added to the pattern
     * @return - true if number was added else false
     */
    public boolean addNumber(Integer number){
        if(validAdd(number)){
            pattern.add(number);
            return true;
        }
        return false;
    }

    /**
     * verifies if number can be added to the matrix
     * @param number - number to verify
     * @return - true if valid add or false if not valid add
     */
    private boolean validAdd(Integer number){
        if(pattern.contains(number)){
            return false;
        }

        Integer curr = pattern.get(pattern.size() - 1);
        int currX = getMatrixX(curr);
        int currY = getMatrixY(curr);
        int numberX = getMatrixX(number);
        int numberY = getMatrixY(number);
        int deltaX = numberX - currX;
        int deltaY = numberY - currY;

        //Vertical line
        if(deltaX == 0){
            int incr = deltaY/Math.abs(deltaY);
            for (int i = currY + incr; i != numberY; i+= incr){
                //Patter must contain number in the middle of both values
                if(!pattern.contains(getMatrixNumber(currX,i))){
                    return false;
                }
            }
        }
        //Horizontal line
        else if(deltaY == 0){
            int incr = deltaX/Math.abs(deltaX);
            for (int i = currX + incr; i != numberX; i+= incr){
                //Patter must contain number in the middle of both values
                if(!pattern.contains(getMatrixNumber(i,currY))){
                    return false;
                }
            }
        }
        //Diagonal line
        else if(Math.abs(deltaX) == Math.abs(deltaY)){
            int incrX = deltaX/Math.abs(deltaX);
            int incrY = deltaY/Math.abs(deltaY);
            int y = currY + incrY;
            for (int x = currX + incrX; x != numberX; x+= incrX){
                y += incrY;
                //Patter must contain number in the middle of both values
                if(!pattern.contains(getMatrixNumber(x,y))){
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * Removes last number in the matrix
     */
    public void removeLast(){
        pattern.remove(pattern.size() - 1);
    }
}

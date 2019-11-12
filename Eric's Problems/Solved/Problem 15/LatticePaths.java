/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecteuler;

/**
 *
 * @author 2jine
 */
public class LatticePaths {
      /**
     * PROJECT EULER 15
     * @param right - length of grid
     * @param down - height of grid
     * @return Starting from the top left corner of a right x down grid,
     * returns the number of possible paths through the grid only being able
     * to move to the right or down.
     */
    public static long latticePaths(long right, long down)
    {
        if( right == 0 || down == 0)
                return 1;
        return latticePaths(right-1, down) + latticePaths(right, down-1);
    }
    
     
    public static void main(String[] args) {
        // VERY LONG RUNTIME!
        System.out.println(latticePaths(20,20));
        
    }
    
}

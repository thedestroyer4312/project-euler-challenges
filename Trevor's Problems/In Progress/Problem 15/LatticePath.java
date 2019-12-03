
/**
 * ***WORK IN PROGRESS***
 * Euler Problem #15
 * Given a 20 x 20 grid, how many ways can you get to the bottom right
 * if you start at the top left corner?
 * @author Trevor Tsai
 */
import java.util.*;

public class LatticePath{

    public static void main(String[] args){
        LatticePath obj = new LatticePath();
        int combinations = obj.latticePaths(20, 20);
        System.out.println(combinations);
    }

    //instance variable
    //this hashmap will store already-run combinations to reduce runtime
    private HashMap<int[], Integer> paths;

    //constructor
    public LatticePath(){
        paths = new HashMap<int[], Integer>();
    }

    //instance methods
    /**
     * Finds the number of possible ways to get the bottom right of an n x n
     * lattice path starting from the top left corner
     * @param n1 The length of the grid
     * @param n2 The width of the grid
     * @return the number of combinations to get to the bottom right
     */
    public int latticePaths(int n1, int n2){
        if(n1 == 0 && n2 == 0){
            return 1;
        }
        if(n1 < 0 || n2 < 0){
            return 0;
        }
        //let's check if it's already in the hashmap
        int[] temp = {n1, n2};
        if(paths.containsKey(temp)){
            return paths.get(temp);
        }else{
            paths.put(temp, latticePaths(n1 - 1, n2) + latticePaths(n1, n2 - 1));
        }

        return latticePaths(n1 - 1, n2) + latticePaths(n1, n2 - 1);
    }
}

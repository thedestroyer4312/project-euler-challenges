package problems.problem22;

import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

/**
 * ***WORK IN PROGRESS***
 * Euler Problem #22
 * Given a text file, sort the names and then multiply their alphabetical value by their position
 * and find the sum
 * @author Trevor Tsai
 */
public class NameScores{

	public static void main(String[] args) throws IOException{
		File file = new File("./p022_names.txt");
		Path path = FileSystems.getDefault().getPath("./po22_names.txt");
		List<String> lines = Files.readAllLines(path);
		while(lines.contains("")){
			lines.remove("");
		}
		
		List<String> names = new ArrayList<String>();
		sort(lines, names);
	}
	
	/**
	 * Sorts lines into alphabetical order by breaking them up and putting them into a new List
	 * @param lines The input list that holds the lines of the file
	 * @param names The list of names that will have names added alphabetically
	 */
	public static void sort(List<String> lines, List<String> names){
		
	}
	
	public static String filter(String line){
		return null;
	}
}

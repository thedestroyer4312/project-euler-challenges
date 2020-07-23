package problems.problem22;

import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * ***SOLVED***
 * Euler Problem #22
 * Given a text file, sort the names and then multiply their alphabetical value by their position
 * and find the sum
 * @author Trevor Tsai
 */
public class NameScores{

	public static final String FILE_PATH = "src/problems/problem22/p022_names.txt";

	public static void main(String[] args) throws IOException{
		Path path = Paths.get(FILE_PATH);
		List<String> lines = Files.readAllLines(path);
		while(lines.contains("")){
			lines.remove("");
		}
		String file = "";
		for(String line : lines){
			file += line.trim() + " ";
		}
		file = filter(file.trim().toUpperCase());
		List<String> names = toList(file);
		names.sort(String::compareTo);
		long score = calculateScore(names);
		System.out.println(score);
	}
	//
	// /**
	// * Sorts an already-filtered list of names using quicksort
	// *
	// * @param lines The input list that holds all of the names in the file
	// *
	// * @param names The list of names that will have names added alphabetically
	// */
	// public static void quicksort(List<String> names){
	// quicksort(names, 0, names.size());
	// }
	//
	// /**
	// * Backend quicksort algorithm
	// * @param names The list that is being sorted
	// * @param low The lower index (inclusive)
	// * @param high The higher index (exclusive)
	// */
	// private static void quicksort(List<String> names, int low, int high){
	// if(low < high){
	// int pivot = partition(names, low, high);
	// quicksort(names, low, pivot - 1);
	// quicksort(names, pivot + 1, high);
	// }
	// }
	//
	// /**
	// * Returns the index of the partition, which is selected to be the middle index
	// * @param names The list of Strings that is being partitioned
	// * @param low The lower index
	// * @param high The higher index
	// * @return The index of the pivot
	// */
	// private static int partition(List<String> names, int low, int high){
	// String pivot = names.get((high - low) / 2);
	// int small = low - 1;
	// for(int i = low; i < high; i++){
	// // if current element smaller than pivot
	// if(names.get(i).compareTo(pivot) < 0){
	// ++small;
	// String temp = names.get(i);
	// names.set(i, names.get(small));
	// names.set(small, temp);
	// }
	// }
	// // swap small + 1 and high
	// String temp = names.get(small + 1);
	// names.set(small + 1, pivot);
	// names.set((high - low) / 2, temp);
	// return small + 1;
	// }

	/**
	 * Filters out quotation marks, unnecessary spaces, and commas from the list of names
	 * @param line The String that represents the entirety of the text file
	 * @return A filtered String that contains all of the names separated by one space
	 */
	public static String filter(String line){
		line = line.trim();
		line = removeQuotes(line);
		line = removeCommas(line);
		line = cleanSpaces(line);
		return line;
	}

	/**
	 * Removes the quotation marks in the names
	 * @param s The names
	 * @return The names without quotation marks
	 */
	private static String removeQuotes(String s){
		// remove the quote at the beginning
		s = s.substring(1);
		while(s.indexOf('"') != -1){
			int index = s.indexOf('"');
			s = s.substring(0, index) + " " + s.substring(index + 1);
		}
		return s.trim();
	}

	/**
	 * Removes any double spaces that may have been left over from the filtering
	 * @param s The String s that is supposed to be clean of other symbols except for spaces and letters
	 * @return A cleaned String with no double spaces
	 */
	private static String cleanSpaces(String s){
		s = s.trim();
		while(s.indexOf("  ") != -1){
			int index = s.indexOf("  ");
			s = s.substring(0, index + 1) + s.substring(index + 2);
		}
		return s.trim();
	}

	/**
	 * Removes the commas in the words
	 * @param s The String s that is supposed to have already had its quotes removed, although this can work
	 * independently of that
	 * @return A cleaned String with no commas
	 */
	private static String removeCommas(String s){
		while(s.indexOf(',') != -1){
			int index = s.indexOf(',');
			s = s.substring(0, index) + " " + s.substring(index + 1);
		}
		return s.trim();
	}

	/**
	 * Takes a filtered String that contains all of the names separated by a space and returns a List containing those
	 * names
	 * @param line
	 * @return
	 */
	public static List<String> toList(String line){
		ArrayList<String> names = new ArrayList<String>();
		line = line.trim() + " ";
		while(line.indexOf(' ') != -1){
			int index = line.indexOf(' ');
			String word = line.substring(0, index);
			names.add(word);
			line = line.substring(index + 1);
		}
		return names;
	}

	/**
	 * Returns the name score sum of a sorted list of names
	 * @param names A sorted list of Strings
	 * @return a long that represents then name score as defined in problem 22 (position * String length)
	 */
	public static long calculateScore(List<String> names){
		long count = 0;
		for(int i = 0; i < names.size(); i++){
			String s = names.get(i);
			long temp = i + 1;
			count += temp * nameScore(s);
		}
		return count;
	}

	/**
	 * Returns the alphabetical sum of the characters
	 * @param name The input String that represents a name
	 * @return The sum of the alphabetical positions in the word (A=1, B=2, etc.)
	 */
	public static int nameScore(String in){
		char[] name = in.toCharArray();
		int count = 0;
		for(char c : name){
			count += c - ('A' - 1);
		}
		return count;
	}
}

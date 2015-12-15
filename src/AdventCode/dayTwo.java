package AdventCode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class dayTwo {
	
	static File file = new File("C:\\Users\\nafee_000\\Documents\\Projects\\AdventCode\\src\\AdventCode\\dayTwoInput");
    
	static String test1 = "29x13x26";
	static String test2 = "2x3x4";
	static int[] anArray = new int[2];
	
	public static int ribbon(int l, int w, int h){
		int[] temp = smallestNumbers(l, w, h);
		int acc = 0;
		acc = (temp[0]*2) + (temp[1]*2) + (l*w*h);
		return acc;
	}
	
	public static int[] smallestNumbers(int first, int second, int third){
		anArray[0] = Math.min(first, Math.min(second, third));
		if (anArray[0] == first){
			anArray[1] = Math.min(second, third);
		}
		if (anArray[0] == second){
			anArray[1] = Math.min(first, third);
		}
		if (anArray[0] == third){
			anArray[1] = Math.min(first, second);
		}

		return anArray;
	}
	
	public static int wrapping(int l, int w, int h){
		int feet = (2*l*w) + (2*w*h) + (2*h*l) + smallestArea(l, w, h);
		return feet;
	}
	
	private static int smallestArea(int l, int w, int h) {
		int lw = l*w;
		int wh = w*h;
		int lh = l*h;
		return Math.min(Math.min(lw, wh), lh);
	}
	
	public static int calculate(String measure){
		int result = 0;
		String[] parts = measure.split("x");
		
		int length = Integer.parseInt(parts[0]);
		int width = Integer.parseInt(parts[1]);
		int height = Integer.parseInt(parts[2]);
		
//		result = wrapping(length, width, height);
		result = ribbon(length, width, height);
		return result;		
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		int acc = 0;
		
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		       acc += calculate(line);
		    }
		}	

		System.out.println(acc);
	}

}

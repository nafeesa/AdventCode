package AdventCode;

import java.io.BufferedReader;
import java.io.Console;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class dayFive {
	
	static File file = new File("C:\\Users\\nafee_000\\Documents\\Projects\\AdventCode\\src\\AdventCode\\dayFiveInput");
	
	static String input1 = "ugknbfddgicrmopn";
	static String input2 = "aaa";
	static String novowels = "abbbc";
	static String input3 = "jchzalrnumimnmhp";
	static String input4 = "rthkunfaakmwmush";

	
	public static Boolean hasPairDoubles(String string){
		
		Pattern pattern = Pattern.compile("(\\w\\w)(.*)(\\1)");
		Matcher matcher = pattern.matcher(string);
		
		boolean found = false;
        while (matcher.find()) {
                matcher.group();
                matcher.start();
                matcher.end();
            found = true;
        }
		
		return found;
	}
	

	public static Boolean letterInBetween(String string){
		
		Pattern pattern = Pattern.compile("(\\w)(\\w)\\1+");
		Matcher matcher = pattern.matcher(string);
		
		boolean found = false;
        while (matcher.find()) {
                matcher.group();
                matcher.start();
                matcher.end();
            found = true;
        }
		
		return found;
	}

	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		int acc = 0;
		
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		    	if(letterInBetween(line) == true){
		    		if(hasPairDoubles(line) == true){
		    			acc++;
		    		}
		    	}
		   
				}
		    }

		System.out.println(acc);
	}
	
}


/*part one solution
public class dayFive {

static File file = new File("C:\\Users\\nafee_000\\Documents\\Projects\\AdventCode\\src\\AdventCode\\dayFiveInput");

static String input1 = "ugknbfddgicrmopn";
static String input2 = "aaa";
static String novowels = "abbbc";
static String input3 = "jchzalrnumimnmhp";
static String input4 = "rthkunfaakmwmush";

public static Boolean hasThreeVowels(String string){
	int acc = 0;
	
	for(int i = 0; i < string.length(); i++){
		if(string.charAt(i) == 'a'||
			string.charAt(i) == 'e' ||
			string.charAt(i) == 'i' ||
			string.charAt(i) == 'o' ||
			string.charAt(i) == 'u'){
				acc++;
			}
	}
	
	if(acc >= 3){
		return true;
	}
	else return false;
}

public static Boolean hasDoubleLetters(String string){
	
	Pattern pattern = Pattern.compile("(\\w)\\1+");
	Matcher matcher = pattern.matcher(string);
	
	boolean found = false;
    while (matcher.find()) {
            matcher.group();
            matcher.start();
            matcher.end();
        found = true;
    }
	
	return found;
}

//It does not contain the strings ab, cd, pq, or xy,
//even if they are part of one of the other requirements.

public static Boolean containsStrings(String string){
	CharSequence ab = "ab"; 
	CharSequence cd = "cd";
	CharSequence pq = "pq";
	CharSequence xy = "xy";
	
	if(string.contains(ab) ||
		string.contains(cd) ||
		string.contains(pq) ||
		string.contains(xy)){
		return true;
	}
	
	else return false;
}


public static void main(String[] args) throws FileNotFoundException, IOException {
	int acc = 0;
	
	try (BufferedReader br = new BufferedReader(new FileReader(file))) {
	    String line;
	    while ((line = br.readLine()) != null) {
	    	if(containsStrings(line) == false){
				if(hasDoubleLetters(line) == true){
					if(hasThreeVowels(line) == true){
						acc++;
					}
				}
			}
	       
	    }
	}
	
	System.out.println(acc);
	
}


}*/
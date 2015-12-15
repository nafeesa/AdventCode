package AdventCode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class daySix {

	static int[][] lights = new int[1000][1000];
	static File file = new File("C:\\Users\\nafee_000\\Documents\\Projects\\AdventCode\\src\\AdventCode\\daySixInput");

	//personal reminder: 0 is off, 1 is on

	public static void turnOff(int[][] offLights){
		for(int i = 0; i < offLights.length; i++){
			for(int j = 0; j < offLights.length; j++){
				offLights[i][j] = 0;
			}
		}
	}

	public static void on(int[][] turnOn, int startx, int starty, int endx, int endy){

		for(int i = startx; i <= endx; i++){
			for(int j = starty; j <= endy; j++){
				turnOn[i][j] += 1;
			}
		}	
	}	

	public static void off(int[][] turnOff, int startx, int starty, int endx, int endy){

		for(int i = startx; i <= endx; i++){
			for(int j = starty; j <= endy; j++){
				if(turnOff[i][j] > 0){
					turnOff[i][j] -= 1;
				}
			}
		}
	}


	public static void toggle(int[][] toggLights, int startx, int starty, int endx, int endy){

		for(int i = startx; i <= endx; i++){
			for(int j = starty; j <= endy; j++){
				toggLights[i][j] += 2;
			}
		}

	}

	public static int countLights(int[][] finalState){
		int acc = 0;

		for(int i = 0; i < finalState.length; i++){
			for(int j = 0; j < finalState.length; j++){
					acc += finalState[i][j];
			}
		}

		return acc;

	}

	public static void main(String[] args) throws FileNotFoundException, IOException {
		turnOff(lights);

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = br.readLine()) != null) {
				if ((line.toString()).contains("turn off")){
					Scanner in = new Scanner(line).useDelimiter("[^0-9]+");
					int startx = in.nextInt();
					int starty = (in.nextInt());
					int endx = in.nextInt();
					int endy = in.nextInt();
					off(lights, startx, starty, endx, endy);
				}
				if ((line.toString()).contains("turn on")){
					Scanner in = new Scanner(line).useDelimiter("[^0-9]+");
					int startx = in.nextInt();
					int starty = (in.nextInt());
					int endx = in.nextInt();
					int endy = in.nextInt();
					on(lights, startx, starty, endx, endy);
				}
				if ((line.toString()).contains("toggle")){
					Scanner in = new Scanner(line).useDelimiter("[^0-9]+");
					int startx = in.nextInt();
					int starty = (in.nextInt());
					int endx = in.nextInt();
					int endy = in.nextInt();
					toggle(lights, startx, starty, endx, endy);
				}
			}
		}

		System.out.println(countLights(lights));

	}
}

/*part one answer
 * public class daySix {

	static int[][] lights = new int[1000][1000];
	static File file = new File("C:\\Users\\nafee_000\\Documents\\Projects\\AdventCode\\src\\AdventCode\\daySixInput");

	//personal reminder: 0 is off, 1 is on

	public static void turnOff(int[][] offLights){
		for(int i = 0; i < offLights.length; i++){
			for(int j = 0; j < offLights.length; j++){
				offLights[i][j] = 0;
			}
		}
	}

	public static void off(int[][] turnOff, int startx, int starty, int endx, int endy){

		for(int i = startx; i <= endx; i++){
			for(int j = starty; j <= endy; j++){
				turnOff[i][j] = 0;
			}
		}
	}

public static void on(int[][] turnOn, int startx, int starty, int endx, int endy){

		for(int i = startx; i <= endx; i++){
			for(int j = starty; j <= endy; j++){
				turnOn[i][j] = 1;
			}
		}	
	}


public static void toggle(int[][] toggLights, int startx, int starty, int endx, int endy){

	for(int i = startx; i <= endx; i++){
		for(int j = starty; j <= endy; j++){
			if(toggLights[i][j] == 0){
				toggLights[i][j] = 1;
			}
			else toggLights[i][j] = 0;
		}
	}

}

public static int countLights(int[][] finalState){
	int acc = 0;

	for(int i = 0; i < finalState.length; i++){
		for(int j = 0; j < finalState.length; j++){
			if(finalState[i][j] == 1){
				acc++;
			}
		}
	}

	return acc;

}

	public static void main(String[] args) throws FileNotFoundException, IOException {
		turnOff(lights);

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		       if ((line.toString()).contains("turn off")){
		    	   Scanner in = new Scanner(line).useDelimiter("[^0-9]+");
		    	   int startx = in.nextInt();
		    	   int starty = (in.nextInt());
		    	   int endx = in.nextInt();
		    	   int endy = in.nextInt();
		    	   off(lights, startx, starty, endx, endy);
		       }
		       if ((line.toString()).contains("turn on")){
		    	   Scanner in = new Scanner(line).useDelimiter("[^0-9]+");
		    	   int startx = in.nextInt();
		    	   int starty = (in.nextInt());
		    	   int endx = in.nextInt();
		    	   int endy = in.nextInt();
		    	   on(lights, startx, starty, endx, endy);
		       }
		       if ((line.toString()).contains("toggle")){
		    	   Scanner in = new Scanner(line).useDelimiter("[^0-9]+");
		    	   int startx = in.nextInt();
		    	   int starty = (in.nextInt());
		    	   int endx = in.nextInt();
		    	   int endy = in.nextInt();
		    	   toggle(lights, startx, starty, endx, endy);
		       }
		    }
		}

		System.out.println(countLights(lights));

	}
}*/

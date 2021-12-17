import java.util.ArrayList;

public class MontyHallSimulation {
	
	public static int doorNum = 3;
	public static ArrayList<Integer> totalResults;
	public static int totalRuns = 5375;
	
 	public static void main(String[]args) {
		
		totalResults = new ArrayList<>();
		simulation(totalRuns);
	}
	
	public static void simulation(int totalRuns) {
		
		if(totalRuns == 0) {
			printResults();
			
		} else {
		
			int[] doors = placeRandom();
			int[] choice = placeRandom();
			
			int revealDoor = 0;
			
			for(int x = 0; x < doors.length; x++) {
				if(doors[x] == 0 && choice[x] == 0) revealDoor = x;
			}
			
			boolean swap = true;
			
			if(swap) {
				for(int x = 0; x < choice.length; x++) {
					if(choice[x] == 0 && revealDoor != x) {
						choice = fill0(choice);
						choice[x] = 1;
						break;
					}
				}
			}
			
			int achieved = 0;
			
			for(int x = 0; x < choice.length; x++) {
				if(choice[x] == 1 && doors[x] == 1) {
					achieved = 1;
				}
			}
			
			totalResults.add(achieved);
			
			simulation(totalRuns - 1);
		}
	}
	
	public static void printResults() {
		int sum = 0;
		for(int n: totalResults) {
			sum += n;
		}
		
		double avg = ((double)sum / totalResults.size()) * 100;
		
		System.out.printf("In a test of %d runs, swapping every time gave a success rate of %.3f%%%n", totalRuns, avg);
	}
	
	public static int[] placeRandom() {
		int[] ret = new int[doorNum];
		
		for(int x = 0; x < ret.length; x++) {
			ret[x] = 0;
		}
		
		int choice = (int) (Math.random() * doorNum);
		ret[choice] = 1;
		
		return ret;
	}
	
	public static int[] fill0(int[] arr) {
		for(int x = 0; x < arr.length; x++) {
			arr[x] = 0;
		}
		
		return arr;
	}
}

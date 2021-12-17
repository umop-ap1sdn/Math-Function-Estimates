import java.util.*;

public class SquareRoot {
	public static void main(String[]args) {
		//Square roots can be predicted using Newton's Method of a quadratic function
		//Square functions always have a derivative of 2x so creating a convergence algorithm is fairly simple
		//For a relatively simple and reasonable starting guess, index will start at x = the inflection point of the algorithm
		Scanner sc = new Scanner(System.in);
		
		T timer = new T();
		Thread time = new Thread(timer);
		
		time.start();
		runSquareRoot(sc);
	}
	
	public static void runSquareRoot(Scanner sc) {
		System.out.println("Enter a number");
		double square = sc.nextDouble();
		double estimate = 1;
		final int iterations = 20;
		
		double yOffset = 0.0;
		double xOffset = 0.0;
		
		double slope = 2 * estimate;
		
		//function y = (x^2 - square)
		//since x^2 is a very simple multiplication
		
		for(int it = 0; it < iterations; it++) {
			xOffset = estimate;
			yOffset = (estimate * estimate) - square;
			
			//slope is solved simply as the derivative of the equation at point estimate
			slope = 2 * estimate;
			
			//This contains the data for point-slope form equation, needs to be translated to slope intercept form
			xOffset = pointToIntercept(slope, yOffset, xOffset);
			
			//estimation is updated to where the the x-intercept of the graph would be
			//this effectively causes the equation to be 0 = mx + b
			//x = -b / m
			
			estimate = (xOffset * -1) / slope;
		}
		
		System.out.printf("Square Root estimation for %.2f after %d iterations: %.5f%n", square, iterations, estimate);
		
		double actual = Math.sqrt(square);
		System.out.printf("Actual Answer: %.5f%n%n", actual);
		runSquareRoot(sc);
	}
	
	//point slope is notated y - yOff = slope(x - xOff), while slope intercept is y = mx + b (and is easier to work with)
	//since slope is the same in both point slope and slope intercept, only need to return the xOffset
	public static double pointToIntercept(double slope, double yOff, double xOff) {
		xOff *= -1;
		xOff *= slope;
		xOff += yOff;
		
		return xOff;
	}
}

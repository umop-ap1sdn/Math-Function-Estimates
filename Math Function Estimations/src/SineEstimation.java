import java.util.*;

public class SineEstimation {
	public static void main(String[] args) {
		//Sine estimation is done by using the taylor series function of sine
		//The taylor series expansion is equal to E(n=0 -> infinity) ((-1)^n*x^(2n+1))/(2n+1)!
		
		Scanner sc = new Scanner(System.in);
		
		T t = new T();
		Thread time = new Thread(t);
		time.start();
		estimateSine(sc);
	}
	
	public static void estimateSine(Scanner sc) {
		
		System.out.println("Enter a number");
		double theta = sc.nextDouble();
		
		double thetaSave = theta;
		
		double sum = 0;
		
		//First squash theta to a value between pi and -pi
		
		while(theta > Math.PI) {
			theta -= 2 * Math.PI;
		}
		
		final int iterations = 6;
		double adder = 0;
		
		for(int it = 0; it < iterations; it++) {
			adder = Math.pow(-1, it);
			int modifyN = 2 * it + 1;
			
			adder *= Math.pow(theta, modifyN);
			adder /= factorial(modifyN);
			
			sum += adder;
		}
		
		double actual = Math.sin(theta);
		
		System.out.printf("Sine approximation for angle %.2f after %d iterations: %.5f%n", thetaSave, iterations, sum);
		System.out.printf("Actual Answer: %.5f%n%n", actual);
		
		estimateSine(sc);
	}
	
	public static int factorial(int num) {
		int product = 1;
		
		for(; num > 0; num--) {
			product *= num;
		}
		
		return product;
	}
}

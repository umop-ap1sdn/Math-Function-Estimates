
public class T implements Runnable{
	
	@Override
	public void run() {
		try {
			Thread.sleep(60000);
		} catch (Exception e) {
			
		}
		
		System.out.println("Program has ended");
		System.exit(0);
	}
}

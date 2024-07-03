/*import java.io.*;
import java.util.*;

public class GFG extends Thread {
	// initiated run method for Thread
	public void run()
	{
		System.out.println("Thread Started Running...");
	}
	public static void main(String[] args)
	{
		GFG g1 = new GFG();

		// Invoking Thread using start() method
		g1.start();
	}
}
*/
import java.io.*;
import java.util.*;

public class GFG implements Runnable {
	// method to start Thread
	public void run()
	{
		System.out.println(
			"Thread is Running Successfully");
	}

	public static void main(String[] args)
	{
		GFG g1 = new GFG();
		// initializing Thread Object
		Thread t1 = new Thread(g1);
		t1.start();
	}
}

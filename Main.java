
public class Main {
	public static void main(String[] args) {
		  
		// Create Shared Bank Account
		Account account = new Account();

		// Prepare Base Output
		System.out.printf("Deposit Threads\t\t\tWithdrawl Threads\t\tBalence\t\t\t\n");
		System.out.printf("---------------\t\t\t-----------------\t\t---------------\t\t\t\n");

		// Setup Type of Threads
		depositThread d = new depositThread(account);
		withdrawlThread w = new withdrawlThread(account);

		// Initalize threads
		Thread d1 = new Thread(d, "D0");
		Thread d2 = new Thread(d, "D1");
		Thread d3 = new Thread(d, "D2");
		Thread d4 = new Thread(d, "D3");
		Thread d5 = new Thread(d,"D4");
		Thread d6 = new Thread(d,"D5");

		Thread w1 = new Thread(w, "W0");
		Thread w2 = new Thread(w, "W1");
		Thread w3 = new Thread(w, "W2");
		Thread w4 = new Thread(w, "W3");
		Thread w5 = new Thread(w, "W4");
		Thread w6 = new Thread(w, "W5");
		Thread w7 = new Thread(w, "W6");
		Thread w8 = new Thread(w, "W7");
		Thread w9 = new Thread(w, "W8");
		

		// Start threads
		d1.start();
		w1.start();
		d2.start();
		w2.start();
		w3.start();
		d3.start();
		w4.start();
		w5.start();
		w6.start();
		w7.start();
		d4.start();
		w8.start();
		d5.start();
		w9.start();
		
		}
}

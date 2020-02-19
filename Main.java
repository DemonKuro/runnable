import java.util.Scanner;
import java.lang.Runnable;

class StreamRunn implements Runnable
{
	String text;
	long pause;
	public StreamRunn(String text, long pause){
		this.text = text;
		this.pause = pause;
	}
	public void run(){
		System.out.println(text + " start");
		try {
			Thread.sleep(pause);
		}
		catch (InterruptedException e) {
			System.out.println("Interrupted");
		}
		System.out.println(text + " end");
	}
}

public class Main
{
	public static void main(String[] args) throws InterruptedException
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("First stream text: ");
		String text1 = scan.nextLine();
		System.out.print("First stream pause: ");
		long pause1 = scan.nextLong();
		scan.nextLine();
		System.out.print("Second stream text: ");
		String text2 = scan.nextLine();
		System.out.print("Second stream pause: ");
		long pause2 = scan.nextLong();
		StreamRunn runn1 = new StreamRunn(text1, pause1);
		StreamRunn runn2 = new StreamRunn(text2, pause2);
		Thread thread1 = new Thread(runn1);
		Thread thread2 = new Thread(runn2);
		thread1.start();
		thread2.start();
	}
}
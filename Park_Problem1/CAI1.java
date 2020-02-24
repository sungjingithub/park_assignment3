import java.util.*;
import java.security.*;

public class CAI1 {
	static Scanner sinput = new Scanner(System.in);
	
	public static void main(String[] args) {
		quiz();
	}
	static void quiz() {
		boolean goodAnswer = false;
		
		SecureRandom srand = new SecureRandom();
		while(!goodAnswer) {
			int srint1 = srand.nextInt(10);
			int srint2 = srand.nextInt(10);
			int result = srint1 * srint2;
			askQuestion(srint1, srint2);
			int answer = readResponse();
			if(isAnswerCorrect(result, answer)) {
				displayCorrectResponse();
				goodAnswer = true;
			}
			else
			{
				displayIncorrectResponse();
			}
		}
		sinput.close();
	}
	static void askQuestion(int srint1, int srint2) {
		System.out.println("How much is " + srint1 + " times " + srint2 + "?");
	}
	static int readResponse() {
		int retValue = sinput.nextInt();
		return retValue;
	}
	static boolean isAnswerCorrect(int result, int answer) {
		return (answer == result);
	}
	static void displayCorrectResponse() {
		System.out.println("Very good!");
	}
	static void displayIncorrectResponse() {
		System.out.println("No. Please try again.");
	}
}

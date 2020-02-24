import java.util.*;
import java.security.*;

public class CAI2 {
	static Scanner sinput = new Scanner(System.in);

	public static void main(String[] args) {
		quiz();
	}
	static void quiz() {
		boolean goodAnswer = false;
		
		SecureRandom srand = new SecureRandom();
		int srint1 = srand.nextInt(10);
		int srint2 = srand.nextInt(10);
		int result = srint1 * srint2;
		while(!goodAnswer) {
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
		SecureRandom srand = new SecureRandom();
		int srint = srand.nextInt(4) + 1;
		switch(srint) {
			case 1:	System.out.println("Very good!");
				   	break;
			case 2:	System.out.println("Excellent!");
				   	break;
			case 3:	System.out.println("Nice work!");
				   	break;
			case 4:	System.out.println("Keep up the good work!");
				   	break;
		    default:System.out.println("Answer Not Available.");
		    		break;
		}
	}
	static void displayIncorrectResponse() {
		SecureRandom srand = new SecureRandom();
		int srint = srand.nextInt(4) + 1;
		switch(srint) {
			case 1:	System.out.println("No. Please try again.");
				    break;
			case 2: System.out.println("Wrong. Try once more");
				    break;
			case 3:	System.out.println("Don't give up!");
				   	break;
			case 4:	System.out.println("No. Keep trying.");
				   	break;
		    default:System.out.println("Answer Not Available.");
		    		break;
		}

	}
}

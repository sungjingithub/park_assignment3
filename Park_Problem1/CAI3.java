import java.util.*;
import java.security.*;

public class CAI3 {
	static Scanner sinput = new Scanner(System.in);
	
	public static void main(String[] args) {
		quiz();
	}
	static void quiz() {
		int goodAnswers = 0;
		boolean tryAgain = true;
		
		while(tryAgain) {
			for(int i=0; i<10; i++) {
				SecureRandom srand = new SecureRandom();
				int srint1 = srand.nextInt(10);
				int srint2 = srand.nextInt(10);
				int result = srint1 * srint2;
				askQuestion(srint1, srint2);
				int answer = readResponse();
				if(isAnswerCorrect(result, answer)) {
					displayCorrectResponse();
					goodAnswers++;
				}
				else
				{
					displayIncorrectResponse();
				}
			}
			tryAgain = displayCompletionMessage(goodAnswers / 10.0f);
			goodAnswers = 0;
		}
		sinput.close();
		System.out.println("\nProgram end.");
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
	static boolean displayCompletionMessage(float score) {
		String tryAnswer;
		System.out.println("Your total score was " + score*100 + "%\n");
		
		if(score < 0.75f) {
			System.out.println("Please ask your teacher for extra help.");
		}
		else {
			System.out.println("Congratulations, you are ready to go to the next level!");
		}
		
		do {
			System.out.print("Try another set(Y/N)?");
			tryAnswer = sinput.next().toUpperCase();
		}while(!(tryAnswer.equals("Y") || tryAnswer.equals("N")));
		if(tryAnswer.equals("Y")) {
			return true;
		}else {
			return false;
		}
	}
}

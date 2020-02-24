import java.util.*;
import java.security.*;

public class CAI5 {
	static Scanner sinput = new Scanner(System.in);
	
	public static void main(String[] args) {
		quiz();
	}
	static void quiz() {
		int goodAnswers = 0;
		boolean tryAgain = true;
		
		while(tryAgain) {
			int difficultyLevel = readDifficulty();
			int problemType = readProblemType();
			int questionArgument = generateQuestionArgument(difficultyLevel);
			for(int i=0; i<10; i++) {
				SecureRandom srand = new SecureRandom();
				int srint1 = srand.nextInt(questionArgument);
				int srint2 = srand.nextInt(questionArgument);
				int result = 0;
				switch(problemType){
					case 1:	result = srint1 + srint2;
							askQuestion(problemType, srint1, srint2);
							break;
					case 2:	result = srint1 * srint2;
							askQuestion(problemType, srint1, srint2);
							break;
					case 3:	result = srint1 - srint2;
							askQuestion(problemType, srint1, srint2);
							break;
					case 4:	result = srint1 / srint2;
							askQuestion(problemType, srint1, srint2);
							break;
					case 5:	int randomProblemType = sinput.nextInt(4) + 1;
							switch(randomProblemType){
								case 1:	result = srint1 + srint2;
										askQuestion(randomProblemType, srint1, srint2);
										break;
								case 2:	result = srint1 * srint2;
										askQuestion(randomProblemType, srint1, srint2);
										break;
								case 3:	result = srint1 - srint2;
										askQuestion(randomProblemType, srint1, srint2);
										break;
								case 4:	result = srint1 / srint2;
										askQuestion(randomProblemType, srint1, srint2);
										break;
								default:break;
							}
							break;
					default: result = 0;
							break;
				}
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
	static void askQuestion(int problemType, int srint1, int srint2) {
		switch(problemType) {
			case 1:	System.out.println("How much is " + srint1 + " plus " + srint2 + "?");
					break;
			case 2:	System.out.println("How much is " + srint1 + " times " + srint2 + "?");
					break;
			case 3:	System.out.println("How much is " + srint1 + " minus " + srint2 + "?");
					break;
			case 4:	System.out.println("How much is " + srint1 + " divided by " + srint2 + "? (Input whole number answers only)");
					break;
			default: break;
		}
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
		System.out.println("Your total score was " + (int)(score*100) + "%\n");
		
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
	static int readDifficulty() {
		int difficultyLevel;

		do {
			System.out.print("Enter the difficulty level(1 - 4): ");
			difficultyLevel = sinput.nextInt();
		}while(difficultyLevel > 4 || difficultyLevel < 1);
		
		return difficultyLevel;
	}
	static int generateQuestionArgument(int difficultyLevel) {
		return (int)Math.pow(10.0, (double)difficultyLevel);
	}
	static int readProblemType() {
		int problemType;

		do {
			System.out.println("Enter the problem type(1 - 4)");
			System.out.println("1 - Addition");
			System.out.println("2 - Multiplication");
			System.out.println("3 - Subtraction");
			System.out.println("4 - Division");
			System.out.println("5 - Mixed Operation");
			problemType = sinput.nextInt();
		}while(problemType > 5 || problemType < 1);
		
		return problemType;
	}
}

package src.com.examSystem.onlineExam;

import java.util.Scanner;

import src.com.examSystem.api.Content;
import src.com.examSystem.api.Result;
import src.com.examSystem.api.ExamSystemUI;
import src.com.examSystem.api.TestCoOrdinator;
import src.com.examSystem.examFactory.TestCoOrdinatorFactory;

public class ExamSystemUICommandLineImpl implements ExamSystemUI {

	private Scanner scanner = new Scanner(System.in);

	public void interactWithUser() {
		String subjectName = null;
		String examType = "objective";
		TestMenu.displayTestMenu();
		subjectName = askForSubjectPreference();
		TestCoOrdinator testCoOrdinator = TestCoOrdinatorFactory.getCoOrdinator("online");
		try {
			testCoOrdinator.conductTest(subjectName, examType);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Content resultContent = testCoOrdinator.announceResult();
		displayResult(resultContent);
	}

	protected void displayResult(Content resultContent){
		resultContent.outputContent();
	}
	protected String askForSubjectPreference(){
		System.out.println("Select subject for online test :- ");
		return this.scanner.next();
	}
}

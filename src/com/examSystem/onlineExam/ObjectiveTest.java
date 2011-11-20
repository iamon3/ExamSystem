package src.com.examSystem.onlineExam;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import src.com.examSystem.api.Content;
import src.com.examSystem.api.Option;
import src.com.examSystem.api.Question;
import src.com.examSystem.api.Result;
import src.com.examSystem.api.Subject;
import src.com.examSystem.api.Summary;
import src.com.examSystem.api.Test;
import src.com.examSystem.examFactory.SubjectFactory;
import src.com.examSystem.examFactory.SummaryFactory;

public class ObjectiveTest implements Test {

	protected static Integer testId;
	protected Subject subject;
	protected Summary summary;
	protected int  noOfQns;
	protected long testDuration;
	protected long testStartTime;
	protected long testEndTime;

	public void finishTest() {
		// TODO Auto-generated method stub
	}

	public Result getTestResult() {
		// TODO Auto-generated method stub
		return null;
	}

	public Summary getTestSummary() {
		return this.summary;
	}

	public void initTest(String subjectPreference) {
		
		String summaryType = "readable";
		String questionType = "readable";
		String answerType = "readable";
		String optionType = "readable";
		String implementationType = "arrayList";
		
		
		subject =  SubjectFactory.getInstance(implementationType);
		subject.initExamQnsAnsOptions(subjectPreference, questionType, answerType, optionType);
		
		noOfQns = subject.getAllQuestions().size();
		
		summary = SummaryFactory.getInstance(summaryType);
		summary.setSummary(noOfQns);
		
		testDuration = (noOfQns * 60 * 1000);
	}

	protected void displayQuestionAndOptions(int qnsNo){
		Question qns;
		Option[] options;
		Content content;
		
		qns = subject.getQuestion(qnsNo);
		options = (Option[])(((List)subject.getOptions(qnsNo)).toArray());

		content = qns.getQuestion();
		content.outputContent();
		
		int optNo = 1;
		for (Option option : options) {
			content = option.getOption();
			System.out.println(optNo + ".");
			content.outputContent();
			optNo += 1;
		}
	}

	private String askForUserInput(Scanner scanner){
		String userInput;
		System.out.println("Select option (Enter -1 to finish test):- ");
		userInput = scanner.next();
		return userInput;
	}

	private boolean isInvalidOption(String userInput, int totalOptions){
		int userIp = Integer.parseInt(userInput);
		if(userIp >= 1 && userIp <= totalOptions){
			return false;
		}
	return true;
	}
	
	public void startTest() {
		long currentTime = Calendar.getInstance().getTimeInMillis();
		this.setTestStartTime(currentTime);
		this.setTestEndTime(this.getTestStartTime() + this.getTestDuration());

		Scanner scanner = new Scanner(System.in);
		String userInput = "1";
		int qnsNo = 0;
    int noOfQnsAttempted = 0;
       
        
		System.out.println("Staring Test. No Of Qns:- " +this.getNoOfQns()+ " Test Duration is " + this.getNoOfQns()+ " minutes");


		Thread timerThread = new TimerThread(this.getTestDuration());
		timerThread.start();

		while(timerThread.isAlive() && (false == userInput.equals("-1")) && qnsNo < this.getNoOfQns()){
			
			displayQuestionAndOptions(qnsNo);
			userInput = askForUserInput(scanner);

			if(false == userInput.equals("-1") && false == isInvalidOption(userInput, subject.getOptions(qnsNo).size()) && subject.checkAnswer(qnsNo,userInput) == true){
				noOfQnsAttempted += 1;
				summary.updateSummary(qnsNo , true, Integer.parseInt(userInput)); 
				qnsNo += 1;
			}
			else if(false == userInput.equals("-1") && false == isInvalidOption(userInput, subject.getOptions(qnsNo).size())){
				noOfQnsAttempted += 1;
				summary.updateSummary(qnsNo , false, Integer.parseInt(userInput));
				qnsNo += 1;
			}
			else{
				System.out.println("Invalid option");
			}
		}
		
		while(timerThread.isAlive() && (false == userInput.equals("-1")) && (noOfQnsAttempted >= this.getNoOfQns())){
			
			System.out.println("Still time remaining.Do you want to change any qns answer.Enter Yes => 1, Finish test => -1 . ) ");
			userInput = scanner.next();
			
			if(false == userInput.equals("-1") && true == userInput.equals("1")){
				
				qnsNo = askForQuestionNo(scanner);
				if(qnsNo >= 0 && qnsNo < this.noOfQns){
					displayQuestionAndOptions(qnsNo);	
					userInput = askForUserInput(scanner);
					
					if(userInput != "-1" && subject.checkAnswer(qnsNo,userInput) == true ){
						summary.updateSummary(qnsNo , true, Integer.parseInt(userInput));  
					}
					else if(false == userInput.equals("-1")){
						summary.updateSummary(qnsNo , false, Integer.parseInt(userInput));
					}
				}
				else{
					System.out.println("Invalid input. Enter Question in between 1 & " + this.noOfQns);
					continue;
				}
			}
			else if(false == userInput.equals("-1")){
				System.out.println("Wrong input. Enter only 1 or -1");
			}
		}
		
		if(timerThread.isAlive()){
			try{
				timerThread.interrupt();	
			}
			catch (Exception e) {
			   System.out.println("Timer thread closed");
			}
			
		}
		
		System.out.println("Test Finished. Thanks.");
	}
	
	private int askForQuestionNo(Scanner scanner){
		System.out.println("Which Question's answer you want to change:- ");
		return Integer.parseInt(scanner.next()) -1;
	}
	
	public static Integer getTestId() {
		return testId;
	}

	public static void setTestId(Integer testId) {
		ObjectiveTest.testId = testId;
	}

	public int getNoOfQns() {
		return noOfQns;
	}

	public void setNoOfQns(int noOfQns) {
		this.noOfQns = noOfQns;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Summary getSummary() {
		return summary;
	}

	public void setSummary(Summary summary) {
		this.summary = summary;
	}

	public long getTestDuration() {
		return testDuration;
	}

	public void setTestDuration(long testDuration) {
		this.testDuration = testDuration;
	}

	public long getTestEndTime() {
		return testEndTime;
	}

	public void setTestEndTime(long testEndTime) {
		this.testEndTime = testEndTime;
	}

	public long getTestStartTime() {
		return testStartTime;
	}

	public void setTestStartTime(long testStartTime) {
		this.testStartTime = testStartTime;
	}

}

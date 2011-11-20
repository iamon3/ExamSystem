package src.com.examSystem.examFactory;

import src.com.examSystem.api.Answer;
import src.com.examSystem.onlineExam.ReadableAnswer;

public abstract class AnswerFactory {
  public static Answer getInstance(String answerType){
	 Answer answer = null;
	 if(answerType.equals("readable")){
		 answer = new ReadableAnswer();
	 }
	 return answer;
  }
}

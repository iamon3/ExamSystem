package src.com.examSystem.examFactory;

import src.com.examSystem.api.Question;
import src.com.examSystem.onlineExam.ReadableQuestion;

public abstract class QuestionFactory {
	public static Question getInstance(String questionType){
		Question question = null;
		if(questionType.equals("readable")){
			question = new ReadableQuestion();
		}
		return question;
	}
}

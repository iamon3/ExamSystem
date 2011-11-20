package src.com.examSystem.api;

import java.util.Collection;

public interface Subject {
	
   void initExamQnsAnsOptions(String subjectPreference, String questionType, String answerType, String optionType);
   Content getSubject();
   Question getQuestion(Integer qnsNo);
   Collection getAllQuestions();
   Answer getAnswer(Integer qnsNo);
   boolean checkAnswer(Integer qnsNo, Object answer);  // this method should go in testEvaluator 
   Collection getAllAnswers();
   Collection<Option> getOptions(Integer qnsNo);
}

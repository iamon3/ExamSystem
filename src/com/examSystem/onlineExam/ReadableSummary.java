package src.com.examSystem.onlineExam;

import java.util.ArrayList;
import java.util.List;

import src.com.examSystem.api.Content;
import src.com.examSystem.api.Summary;

public class ReadableSummary implements Summary {

	private Integer noOfQnsAttempted;
	private Integer correctAnswers;
	private Integer wrongAnswers;
	private Integer[] userAnswers;
	private Boolean[] isCorrectAns;
	private Integer score;
	private ReadableContent summaryContent = new ReadableContent() ;

	@Override
	public String toString() {
		StringBuilder summary = new StringBuilder("Attempted Qns :- ");
		summary.append(noOfQnsAttempted.toString());
		summary.append(", Correct :- ").append(correctAnswers.toString());
		summary.append(", Wrong :- ").append(wrongAnswers.toString());
		summary.append(", Score :- ").append(score.toString());
		return summary.toString();
	}

	private void buildSummary(){
		int i = 0;
		//System.out.println("User Answer Length :- " + userAnswers.length);	
		for( i=0; i < userAnswers.length; i++){
          if(null != userAnswers[i]){
        	  noOfQnsAttempted += 1;
        	  if(true == isCorrectAns[i]){
        		  correctAnswers += 1;
        	  }
        	  else{
        		  wrongAnswers += 1;
        	  }
          }
		}
		 score = correctAnswers;
	}

	public Content getSummary() {
		buildSummary();
		summaryContent.setContent(this.toString());
		return summaryContent;
	}

	public void setSummary(Integer totalQns) {
		noOfQnsAttempted = 0;
		correctAnswers = 0;
		wrongAnswers = 0;
		score = 0;
		userAnswers = new Integer[totalQns];
		isCorrectAns = new Boolean[totalQns];
	}

	public void updateSummary(Integer qnsNo, boolean isCorrect, Integer userAnswer) {
		userAnswers[qnsNo] = userAnswer;
		isCorrectAns[qnsNo] = isCorrect;
	}

}

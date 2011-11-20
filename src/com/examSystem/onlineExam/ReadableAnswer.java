package src.com.examSystem.onlineExam;

import src.com.examSystem.api.Answer;
import src.com.examSystem.api.Content;

public class ReadableAnswer implements Answer {
	
    private ReadableContent answerContent;
    
    @Override
    public String toString() {
    	return answerContent.toString();
    }
    
	public void getAnswer() {
		this.answerContent.outputContent();
	}

	public void setAnswer(Content object) {
		if(true == (object instanceof ReadableContent)){
			this.answerContent = (ReadableContent) object;
		}
		else{
			System.out.println("Object is not of Readable Content type");
		}
	}
}

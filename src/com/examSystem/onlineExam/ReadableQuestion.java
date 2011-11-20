package src.com.examSystem.onlineExam;

import src.com.examSystem.api.Content;
import src.com.examSystem.api.Question;

public class ReadableQuestion implements Question {
    
	private ReadableContent questionContent;
	
	public Content getQuestion() {
		//this.questionContent.outputContent();
		return this.questionContent;
	}

	public void setQuestion(Content object) {
		if(true == (object instanceof ReadableContent)){
			this.questionContent = (ReadableContent) object;
		}
		else{
			System.out.println("Object is not of Readable Content type");
		}
	}

}

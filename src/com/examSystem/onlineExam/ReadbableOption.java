package src.com.examSystem.onlineExam;

import src.com.examSystem.api.Content;
import src.com.examSystem.api.Option;

public class ReadbableOption implements Option {

	private ReadableContent optionContent;
	
	public Content getOption() {
		//this.optionContent.outputContent();
		return this.optionContent;
	}

	public void setOption(Content object) {
		if(true == (object instanceof ReadableContent)){
			this.optionContent = (ReadableContent) object;
		}
		else{
			System.out.println("Object is not of Readable Content type");
		}
	}

}

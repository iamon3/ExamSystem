package src.com.examSystem.onlineExam;

import src.com.examSystem.api.Content;

public class ReadableContent implements Content {
	
	private StringBuilder text;

	@Override
    public String toString() {
    	return text.toString();
    }
	
	public ReadableContent() {
		text = new StringBuilder();
	}
	public void outputContent() {
		System.out.println(text.toString());
	}

	public void setContent(Object object) {
		if(true == (object instanceof String)){
			this.text.append((String) object);
		}
		else{
			System.out.println("Object is not of string type");
		}
	}

}

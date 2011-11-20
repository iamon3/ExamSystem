package src.com.examSystem.examFactory;

import src.com.examSystem.api.Content;
import src.com.examSystem.onlineExam.ReadableContent;

public abstract class ContentFactory {
  public static Content getInstance(String contentType){
	  Content content = null;
	  if(contentType.equals("readable")){
		  content = new ReadableContent();
	  }
	  return content;
  }
}

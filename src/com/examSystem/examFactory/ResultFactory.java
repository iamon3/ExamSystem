package src.com.examSystem.examFactory;

import src.com.examSystem.api.Result;
import src.com.examSystem.onlineExam.ReadableResult;

public abstract class ResultFactory {
  public static Result getInstance(String resultType){
	  Result result = null;
	  if(resultType.equals("readable")){
		 result = new ReadableResult(); 
	  }
	  return result;
  }
}

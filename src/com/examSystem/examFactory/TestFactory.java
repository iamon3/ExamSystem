package src.com.examSystem.examFactory;

import src.com.examSystem.api.Test;
import src.com.examSystem.onlineExam.ObjectiveTest;;

public abstract class TestFactory{
   public static Test getTestInstance(String typeOfTheTest){
	 Test test = null;
	 if(typeOfTheTest.equals("objective")){
		 test = new ObjectiveTest();
	 }
	 return test;
   }
}

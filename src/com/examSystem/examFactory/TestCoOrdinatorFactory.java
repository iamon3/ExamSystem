package src.com.examSystem.examFactory;

import src.com.examSystem.api.TestCoOrdinator;
import src.com.examSystem.onlineExam.TestCoOrdinatorOnlineImpl;

public abstract class TestCoOrdinatorFactory {
	public static TestCoOrdinator getCoOrdinator(String type){
		TestCoOrdinator testCoOrdinator = null;
		if(type.equals("online")){
			testCoOrdinator = new TestCoOrdinatorOnlineImpl();
		}
		return testCoOrdinator;
	}
}

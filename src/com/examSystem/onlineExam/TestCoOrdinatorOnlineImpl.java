package src.com.examSystem.onlineExam;

import src.com.examSystem.api.Content;
import src.com.examSystem.api.Result;
import src.com.examSystem.api.Test;
import src.com.examSystem.api.TestCoOrdinator;
import src.com.examSystem.examFactory.ResultFactory;
import src.com.examSystem.examFactory.TestFactory;

public class TestCoOrdinatorOnlineImpl implements TestCoOrdinator {
    
	private Test test;
	public Content announceResult() {
		String resultType = "readable";
		Result result = ResultFactory.getInstance(resultType);
		return result.giveResult(test.getTestSummary());
	}

	public void conductTest(String subjectPreference, String examtype) throws Exception {
       test = TestFactory.getTestInstance(examtype);
       test.initTest(subjectPreference);
       test.startTest();
	}

}

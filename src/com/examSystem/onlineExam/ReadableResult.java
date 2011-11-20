package src.com.examSystem.onlineExam;

import src.com.examSystem.api.Content;
import src.com.examSystem.api.Result;
import src.com.examSystem.api.Summary;

public class ReadableResult implements Result {

	public Content giveResult(Summary resultSummary) {
		return resultSummary.getSummary();
	}

}

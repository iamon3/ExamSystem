package src.com.examSystem.examFactory;

import src.com.examSystem.api.Summary;
import src.com.examSystem.onlineExam.ReadableSummary;

public abstract class SummaryFactory {
	public static Summary getInstance(String summaryType){
		Summary summary = null;
		if(summaryType.equals("readable")){
			summary = new ReadableSummary();
		}
		return summary;
	}
}

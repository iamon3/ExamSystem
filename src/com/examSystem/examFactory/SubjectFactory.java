package src.com.examSystem.examFactory;

import src.com.examSystem.api.Subject;
import src.com.examSystem.onlineExam.SubjectArrayListImpl;


public abstract class SubjectFactory {
	public static Subject getInstance(String implementationType){
		Subject subject = null;
		if(implementationType.equals("arrayList")){
			subject = new SubjectArrayListImpl();
		}
		return subject;
	}
}

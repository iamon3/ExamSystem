package src.com.examSystem.examFactory;

import src.com.examSystem.api.*;
import src.com.examSystem.onlineExam.*;

public abstract class ExamSystemUIFctory {
 public static ExamSystemUI getUI(String uiType){
   	 ExamSystemUI examSystemUI = null;
   	 if(uiType.equals("commandLine")){
   		 examSystemUI = new ExamSystemUICommandLineImpl();
   	 }
   	 return examSystemUI;
 }
}

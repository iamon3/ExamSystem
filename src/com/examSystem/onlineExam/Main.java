package src.com.examSystem.onlineExam;

import src.com.examSystem.api.*;
import src.com.examSystem.examFactory.*;

public class Main {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
      ExamSystemUI examSystemUI = ExamSystemUIFctory.getUI("commandLine");
      examSystemUI.interactWithUser();
	}
}

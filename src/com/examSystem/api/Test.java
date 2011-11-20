package src.com.examSystem.api;

public interface Test {
 void initTest(String subjectPreference);
 void startTest();
 void finishTest();
 Summary getTestSummary();
 Result getTestResult();
}

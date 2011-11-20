package src.com.examSystem.api;

public interface TestCoOrdinator {
   void conductTest(String subjectName, String examType) throws Exception;
   Content announceResult();
}

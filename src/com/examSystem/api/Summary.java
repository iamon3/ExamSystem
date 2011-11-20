package src.com.examSystem.api;

public interface Summary {
	Content getSummary();
	void setSummary(Integer totalQns);
	void updateSummary(Integer qnsNo ,boolean isCorrect,Integer userAnswer);
}

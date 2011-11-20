package src.com.examSystem.onlineExam;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import src.com.examSystem.api.Answer;
import src.com.examSystem.api.Content;
import src.com.examSystem.api.Option;
import src.com.examSystem.api.Question;
import src.com.examSystem.api.Subject;
import src.com.examSystem.examFactory.AnswerFactory;
import src.com.examSystem.examFactory.ContentFactory;
import src.com.examSystem.examFactory.OptionFactory;
import src.com.examSystem.examFactory.QuestionFactory;

public class SubjectArrayListImpl implements Subject {

	protected List<Question> questionSet;
	protected List<Answer> answerSet;
	protected List<Option[]> optionsSet;

	public SubjectArrayListImpl(){
		this.questionSet = new ArrayList<Question>();
		this.answerSet = new ArrayList<Answer>();
		this.optionsSet = new ArrayList<Option[]>();
	}
	public Collection getAllAnswers() {
		
		return null;
	}

	public Collection getAllQuestions() {
		return this.questionSet;
	}

	public Answer getAnswer(Integer qnsNo) {
		// TODO Auto-generated method stub
		return null;
	}

	public Collection<Option> getOptions(Integer qnsNo) {
		return Arrays.asList(this.optionsSet.get(qnsNo));
	}

	public Question getQuestion(Integer qnsNo) {
		return this.questionSet.get(qnsNo);
	}

	public Content getSubject() {
		// TODO Auto-generated method stub
		return null;
	}

	public void initExamQnsAnsOptions(String subjectPreference, String questionType, String answerType, String optionType) {
		String subjectFileName = (new StringBuilder(TestMenu.getSubjectName(subjectPreference))).append(".txt").toString();
		try {
			readFileAndPopulateQnsAnsOptions(subjectFileName,questionType,answerType, optionType);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void readFileAndPopulateQnsAnsOptions(String  subjectFileName,String questionType, String answerType, String optionType) throws IOException{
		String line;
		int typeOfLine = 1;

		File file = new File(subjectFileName);
		FileReader fileReader = new FileReader(file);
		BufferedReader bufferReader = new BufferedReader(fileReader);

		while((line = bufferReader.readLine()) != null){
			if(typeOfLine == 1){
				populateQuestion(line, questionType);
				typeOfLine += 1;   
			}
			else if(typeOfLine == 2){
				populateOptions(line,optionType);
				typeOfLine += 1; 
			}
			else{
				populateAnswer(line,answerType);
				typeOfLine = 1;
			}
		}
	}

	protected void populateAnswer(String line,String  answerType){
		Answer answer;
		Content content;
		
		answer =  AnswerFactory.getInstance(answerType);
		content = ContentFactory.getInstance(answerType);
		content.setContent(line);
		answer.setAnswer(content);
		
		this.answerSet.add(answer);
	}
	
	protected void populateQuestion(String line,String  questionType){
		Question question;
		Content content;
		
		question = QuestionFactory.getInstance(questionType);
		content = ContentFactory.getInstance(questionType);
		
		content.setContent(line);
		question.setQuestion(content);
		
		this.questionSet.add(question);
	}
   
	protected void populateOptions(String line,String  optionType){
		int i =0;
		
		String[] textOptions = line.split(",");
		Option[] options = new Option[textOptions.length];
		
		while(i < textOptions.length){
			populateEachOption(i, options, textOptions[i], optionType);
			i++;
		}
		this.optionsSet.add(options);
	}
	
	protected void populateEachOption(int i, Option[] options, String textOption, String optionType){
		Option option;
		Content content;

		option = OptionFactory.getInstance(optionType);
		content = ContentFactory.getInstance(optionType);
		content.setContent(textOption);
		option.setOption(content);
		options[i] = option;
	}
	
	public boolean checkAnswer(Integer qnsNo, Object answer) {
		if (answer instanceof String){
			return this.answerSet.get(qnsNo).toString().equals((String)answer);
		}
		return false;
	}
}

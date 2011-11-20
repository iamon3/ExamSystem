package src.com.examSystem.examFactory;

import src.com.examSystem.api.Option;
import src.com.examSystem.onlineExam.ReadbableOption;

public abstract class OptionFactory {
	public static Option getInstance(String optionType){
     Option option = null;
     if(optionType.equals("readable")){
    	 option = new ReadbableOption();
     }
     return option;
	}
}

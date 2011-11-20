package src.com.examSystem.onlineExam;

public class TestMenu {
   private static String[] availableSubjects = {"Java", "Algorithms"};
   private TestMenu(){   
   }
   public static void displayTestMenu(){
	   int i = 0;
	   for(i=0; i< availableSubjects.length;i++){
		   System.out.println((i+1)+ "] " + availableSubjects[i]);
	   }
   }
   
   public static String getSubjectName(String subjectPreference){
	   return availableSubjects[Integer.parseInt(subjectPreference) - 1];
   }
}

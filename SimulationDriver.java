package iVote;

import java.util.ArrayList;
import java.util.HashSet;

public class SimulationDriver {
	public static void main(String[] args){
		test();
	}
	
	/*
	 * Name			: test
	 * Arguments	: none
	 * Return		: void
	 * Function		: tester function to generate a beta run for iVote
	 */
	static void test(){
		int numStudents = 50;
		HashSet<Student> students = getRandStudent(numStudents);
		ArrayList<Student> studentsList = new ArrayList<Student>(students);
		ArrayList<String> choices = new ArrayList<>();
		
		choices.add("A. Naughty Dog");
		choices.add("B. Insomniac");
		choices.add("C. Sucker Punch");
		choices.add("D. Housemarque");
		choices.add("E. Sony");
		
		Question question1 = new MultipleQuestion("Who developed the greatest game ever made \"The Last of Us\"", choices);
		
		IVoteService iVote = new IVoteServiceMultiple(question1);
		generateRandChoices(question1, studentsList, iVote);
		iVote.displayResults();
		
		choices.clear();
		choices.add("True");
		choices.add("False");
		
		Question question2 = new SingleQuestion("Is The Last of Us the greatest game ever?", choices);
		iVote = new IVoteServiceSingle(question2);
		students = getRandStudent(numStudents);
		studentsList = new ArrayList<Student>(students);
		generateRandChoices(question2, studentsList, iVote);
		iVote.displayResults();
	}
	
	/*
	 * Name			: getRandStudent
	 * Arguments	: int
	 * Return		: HashSet<Student>
	 * Function		: generate a set of unique students
	 */
	static HashSet<Student> getRandStudent(int num){
		HashSet<Student> randStudents = new HashSet<>();
		for(int i=0; i<num; i++) {
			String studentID = "";
			for(int j = 0; j<6; j++) {
				studentID += (char)(Math.random() * ((100-50) +1) + 50);
			}
			if(!randStudents.contains(studentID)) {
				randStudents.add(new Student(studentID));
			}
			else {
				i--;
			}
		}
		return randStudents;		
	}
	
	/*
	 * Name			: generateRandChoices
	 * Arguments	: Question, ArrayList<Student>, IVoteService
	 * Return		: void
	 * Function		: generate a random list of picked answers
	 */
	static void generateRandChoices(Question question, ArrayList<Student> students, IVoteService iVoteService){
		ArrayList<String> answerSet = question.getChoices();
		ArrayList<String> picked = new ArrayList<>();
		for(int i = 0; i < students.size(); i++){
			int num = (int) (Math.random() * (answerSet.size()));
			for(int j = 0; j < num; j++){
				picked.add(answerSet.get((int)(Math.random()*(answerSet.size()))));
			}
			students.get(i).submitAnswer(picked, iVoteService);
			picked.clear();
		}
	}
}

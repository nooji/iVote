package iVote;
import java.util.ArrayList;

public class Student {
	private String ID;
	/*
	 * Name			: Student
	 * Arguments	: String ID
	 * Return		: none
	 * Function		: constructor
	 */
	public Student(String ID){
		this.ID = ID;
	}
	
	/*
	 * Name			: submitAnswer
	 * Arguments	: ArrayList<String>, IVoteService 
	 * Return		: void
	 * Function		: calls on iVoteService to submit answer
	 */
	public void submitAnswer(ArrayList<String> answers, IVoteService iVoteService) {
		iVoteService.retrieveAnswer(answers, ID);
	}
}

package iVote;

import java.util.ArrayList;

public class SingleQuestion implements Question {
	private String question;
	private ArrayList<String> choices;
	
	/*
	 * Name			: SingleQuestion
	 * Arguments	: String, ArrayList<String>
	 * Return		: none
	 * Function		: constructor
	 */
	public SingleQuestion(String question, ArrayList<String> choices){
		this.question = question;
		this.choices = choices;
	}
	
	/*
	 * Name			: getQuest
	 * Arguments	: none
	 * Return		: String
	 * Function		: getter to return question
	 */
	@Override
	public String getQuest() {
		return this.question;
	}

	/*
	 * Name			: getChoices
	 * Arguments	: none
	 * Return		: ArrayList<String>
	 * Function		: getter to get list of choices
	 */
	@Override
	public ArrayList<String> getChoices() {
		return this.choices;
	}
}

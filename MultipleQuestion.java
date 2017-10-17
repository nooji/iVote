package iVote;

import java.util.ArrayList;

public class MultipleQuestion implements Question{
	private String question;
	private ArrayList<String> choices;
	
	/*
	 * Name			: MultipleQuestion
	 * Arguments	: String, ArrayList<String>
	 * Return		: none
	 * Function		: constructor
	 */
	public MultipleQuestion(String question, ArrayList<String> choices){
		this.question = question;
		this.choices = choices;
	}
	
	/*
	 * Name			: getQuest
	 * Arguments	: none
	 * Return		: String
	 * Function		: getter for question
	 */
	@Override
	public String getQuest() {
		// TODO Auto-generated method stub
		return this.question;
	}

	/*
	 * Name			: getChoices
	 * Arguments	: none
	 * Return		: ArrayList<String>
	 * Function		: getter for list of choices
	 */
	@Override
	public ArrayList<String> getChoices() {
		// TODO Auto-generated method stub
		return this.choices;
	}
	
	/*
	 * Name			: setChoices
	 * Arguments	: ArrayList<String>
	 * Return		: void
	 * Function		: setter to set the choice list
	 */
	public void setChoices(ArrayList<String> choice){
		this.choices = choice;
	}
	
}

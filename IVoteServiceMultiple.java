package iVote;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class IVoteServiceMultiple implements IVoteService {
	private Question question;
	private HashMap<String, ArrayList<String>> submissions;
	private HashMap<String, Integer> results;
	
	/*
	 * Name			: IVoteServiceMultiple
	 * Arguments	: Question
	 * Return		: none
	 * Function		: constructor
	 */
	public IVoteServiceMultiple(Question question){
		this.question = question;
		submissions = new HashMap<>();
		results = new HashMap<>();
	}

	
	/*
	 * Name			: retrieveAnswer
	 * Arguments	: ArrayList<String>, String
	 * Return		: void
	 * Function		: submit choices to the submission set
	 */
	@Override
	public void retrieveAnswer(ArrayList<String> answers, String ID) {
		HashSet<String> submittedChoice = new HashSet<>();
		ArrayList<String> answerSet = new ArrayList<>();
		
		//if not empty remove previous answer
		if(submissions.get(ID) != null){
			submissions.remove(ID);
		}
		
		//add list of choices to the results HashMap
		ArrayList<String> choices = question.getChoices();
		for(int i = 0; i < choices.size(); i++){
			String temp = choices.get(i);
			if(!results.containsKey(temp)){
				results.put(temp, 0);
			}
		}
		for(int i = 0; i <answers.size(); i++){
			String temp = answers.get(i);
			if(!submittedChoice.contains(temp)){
				answerSet.add(temp);
				submittedChoice.add(temp);
			}
		}
		submissions.put(ID, answerSet);
	}

	
	/*
	 * Name			: displayResults
	 * Arguments	: none
	 * Return		: void
	 * Function		: display the results of iVote
	 */
	@Override
	public void displayResults() {
		Iterator<String> keyIter = submissions.keySet().iterator();
		results.clear();
		while(keyIter.hasNext()){
			ArrayList<String> choicesTemp = submissions.get(keyIter.next());
			for(int i = 0; i < choicesTemp.size(); i++){
				String key = choicesTemp.get(i).toString();
				if(!results.containsKey(key)){
					results.put(key, i);
				}
				else{
					results.put(key, results.get(key)+1);
				}
			}
		}
		
		keyIter = results.keySet().iterator();
		System.out.println("Results for \"" + question.getQuest()+ "\": ");
		while(keyIter.hasNext()){
			String key = keyIter.next();
			System.out.print(key + ": ");
			System.out.println(results.get(key));
		}
		System.out.println();
	}

		
}
 
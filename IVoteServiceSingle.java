package iVote;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class IVoteServiceSingle implements IVoteService{
	private Question question;
	private HashMap<String, String> submissions;
	private HashMap<String, Integer> results;
	
	/*
	 * Name			: IVoteServiceSingle
	 * Arguments	: Question
	 * Return		: none
	 * Function		: constructor
	 */
	public IVoteServiceSingle(Question question){
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
		if(submissions.get(ID)!= null){
			submissions.remove(ID);
		}
		if(!answers.isEmpty()){
			submissions.put(ID, answers.get(answers.size()-1));
		}
	}

	

	/*
	 * Name			: displayResults
	 * Arguments	: none
	 * Return		: void
	 * Function		: display the results of iVote
	 */
	@Override
	public void displayResults() {
		// TODO Auto-generated method stub
		Iterator<String> keyIter = submissions.keySet().iterator();
		results.clear();
		while(keyIter.hasNext()){
			String key = submissions.get(keyIter.next()).toString();
			if(!results.containsKey(key)){
				results.put(key,1);
			}
			else{
				results.put(key,results.get(key)+1);
			}
		}		
		keyIter = results.keySet().iterator();
		System.out.println("Results for \"" + question.getQuest()+ "\" is: ");
		while(keyIter.hasNext()){
			String key = keyIter.next();
			System.out.print(key + ": ");
			System.out.println((results.get(key)));
		}
		System.out.println();
	}
}

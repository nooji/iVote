package iVote;
import java.util.ArrayList;


public interface IVoteService {
	public void retrieveAnswer(ArrayList<String> answers, String ID);
	public void displayResults();
}

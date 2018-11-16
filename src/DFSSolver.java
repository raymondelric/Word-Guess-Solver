import java.util.*;

public class DFSSolver extends Solver{

	Random rand;

	public DFSSolver(){
		guessList = new ArrayList<>();
		memoMatch = new HashMap<>();
		rand = new Random();
		return;
	}

	public int findSecretWord(List<String> wordlist, Master master) {

		int countGuess = 1;

		while(true){
			int index = rand.nextInt(wordlist.size());
			String guess = wordlist.get(index);
			guessList.add(guess);

			int m = master.guess(guess);
            if(m == guess.length())   return countGuess;

            List<String> next = new ArrayList<>();

            for(String cand : wordlist){
            	if(findMatch( cand, guess) == m)	next.add(cand);
            }

            wordlist = next;

            countGuess++;
		}

	}

}
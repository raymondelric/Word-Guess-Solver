import java.util.*;

public class RandomSolver extends Solver{

	Random rand;

	public RandomSolver(){
		guessList = new ArrayList<>();
		rand = new Random();
		return;
	}

	public int findSecretWord(List<String> wordlist, Master master) {

		int countGuess = 1;

		while(true){
			int index = rand.nextInt(wordlist.size());

			guessList.add(wordlist.get(index));

			if(master.guess(wordlist.get(index)) == wordlist.get(index).length())	return countGuess;

			wordlist.remove(index);
			countGuess++;
		}

	}

}
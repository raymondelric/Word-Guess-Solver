import java.util.*;

public class Main{
	public static void main(String[] args){
		
		MinimaxSolver ms = new MinimaxSolver();
		
		TestData testdata = new TestData(4,200);
		// generate 200 unique 4-digit string(lowercase alphabet only)

		System.out.println(testdata.getList());
		// print out the generated list

		Master master = new Master(testdata.getSecret());
		// randomly select a key

		System.out.println(ms.findSecretWord(testdata.getList(), master));
		// print out the # of guess

		ms.showGuessList();
		// print out the every guess(the last is the answer)

		return;
	}
}
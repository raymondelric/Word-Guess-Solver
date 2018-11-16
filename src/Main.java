import java.util.*;

public class Main{

	public static String defualtSolver = "minimax"; 

	public static void main(String[] args){
		
		Solver solver = new MinimaxSolver();

		if(args.length > 0){
			if(args[0].equals("random"))	solver = new RandomSolver();
			if(args[0].equals("minimax"))	solver = new MinimaxSolver();
		}
		
		TestData testdata = new TestData(4,200);
		// generate 200 unique 4-digit string(lowercase alphabet only)

		System.out.println(testdata.getList());
		// print out the generated list

		Master master = new Master(testdata.getSecret());
		// randomly select a key

		System.out.println(solver.findSecretWord(testdata.getList(), master));
		// print out the # of guess

		solver.showGuessList();
		// print out the every guess(the last is the answer)

		return;
	}
}
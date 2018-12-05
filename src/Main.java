import java.util.*;

public class Main{

	public static String defualtSolver = "minimax"; 

	public static void main(String[] args){
		
		Solver solver = new MinimaxSolver();

		if(args.length > 0){
			if(args[0].equals("random"))	solver = new RandomSolver();
			if(args[0].equals("minimax"))	solver = new MinimaxSolver();
			if(args[0].equals("dfs"))		solver = new DFSSolver();
			if(args[0].equals("heuristic"))	solver = new HeuristicSolver();
		}
		
		int count = (args.length > 1) ? Integer.parseInt(args[1]) : 1;

		long startTime = System.nanoTime();

		for(int i = 0;i < count;i++){

			TestData testdata = new TestData(4,200);
			// generate 200 unique 4-digit string(lowercase alphabet only)

			// System.out.println(testdata.getList());
			// print out the generated list

			Master master = new Master(testdata.getSecret());
			// randomly select a key

			System.out.println(solver.findSecretWord(testdata.getList(), master));
			// print out the # of guess

			// solver.showGuessList();
			// print out the every guess(the last is the answer)

		}

		long endTime   = System.nanoTime();
		double totalTime = (double)(endTime - startTime) / 1_000_000_000;
		System.out.printf("%.3f\n", totalTime);

		return;
	}
}
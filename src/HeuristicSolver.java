import java.util.*;

public class HeuristicSolver extends Solver{
    
    public HeuristicSolver(){
        memoMatch = new HashMap<>();
        return;
    }

    
    public int findSecretWord(List<String> wordlist, Master master) {
        
        Set<String> candSet = new HashSet<>();
        this.guessList = new ArrayList<>();

        for(String word : wordlist) candSet.add(word);
        
        int countGuess = 1;
        
        while(countGuess < 100){

            Map<String, Map<Integer, Set<String>>> map = new HashMap<>();
            
            for(String cand : candSet){
                for(String test : candSet){

                    int match = findMatch(cand, test);
                    Map<Integer, Set<String>> tmpMap = map.getOrDefault(cand, new HashMap<>());
                    Set<String> tmpSet = tmpMap.getOrDefault(match, new HashSet<>());
                    tmpSet.add(test);
                    tmpMap.put(match, tmpSet);
                    map.put(cand, tmpMap);
                }
            }
            
            String guess = heuristic(map);
            this.guessList.add(guess);

            int m = master.guess(guess);
            if(m == guess.length())   return countGuess;
            
            candSet = map.get(guess).get(m);
            countGuess++;
        }
        return -1;
    }

    public String heuristic(Map<String, Map<Integer, Set<String>>> map){
        
        String res = "";
        int maxScore = 0;
        
        for(String cand : map.keySet()){
            
            int score = map.get(cand).size();
            
            if(score > maxScore){
                maxScore = score;
                res = cand;
            }
            
        }
        
        return res;
        
    }
}

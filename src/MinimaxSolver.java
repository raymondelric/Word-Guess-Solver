import java.util.*;

public class MinimaxSolver{
    
    public Map<String, Integer> memoMatch;
    public List<String> guessList;
    
    public MinimaxSolver(){

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
            
            String guess = minimax(map);
            this.guessList.add(guess);

            int m = master.guess(guess);
            if(m == guess.length())   return countGuess;
            
            candSet = map.get(guess).get(m);
            countGuess++;
        }
        return -1;
    }
    
    public void showGuessList(){
        
        if(this.guessList != null)   System.out.println(this.guessList);
        return;
    }

    public String minimax(Map<String, Map<Integer, Set<String>>> map){
        
        String res = "";
        int min = Integer.MAX_VALUE;
        
        for(String cand : map.keySet()){
            
            int max = 0;
            Map<Integer, Set<String>> tmpMap = map.get(cand);
            
            for(int i : tmpMap.keySet()){
                max = Math.max(max, tmpMap.get(i).size());
            }
            
            if(max < min){
                min = max;
                res = cand;
            }
            
        }
        
        return res;
        
    }
    
    public int findMatch(String a, String b){
        
        if(memoMatch.containsKey(a + "#" + b))  return memoMatch.get(a + "#" + b);
        
        int match = 0;
        
        for(int i = 0;i < a.length();i++){
            if(a.charAt(i) == b.charAt(i))  match++;
        }
        
        memoMatch.put(a+"#"+b, match);
        memoMatch.put(b+"#"+a, match);
        
        return match;
        
    }
}

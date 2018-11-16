import java.util.*;

public abstract class Solver{
	
	public List<String> guessList;
	public Map<String, Integer> memoMatch;

	public abstract int findSecretWord(List<String> wordlist, Master master);
	
	public void showGuessList(){
        if(this.guessList != null)   System.out.println(this.guessList);
        return;
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
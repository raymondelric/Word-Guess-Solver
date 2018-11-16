public class Master{
	String secret;

	public Master(String secret){
		this.secret = secret;
	}

	public int guess(String word){
		if(word.length() != secret.length())	return -1;

		int count = 0;
		for(int i = 0;i < word.length();i++){
			if(word.charAt(i) == secret.charAt(i))	count++;
		}
		return count;
	}
}
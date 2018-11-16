import java.io.*;
import java.util.*;

public class TestData{

	List<String> wordList;
	Set<String> wordSet;
	List<Integer> integerList;
	List<Character> charList;
	Random rand;
	static String defaultPath = "./../testdata/test.txt";

	public TestData(){
		this(defaultPath);
	}

	public TestData(String path){

		wordList = new ArrayList<>();
		wordSet = new HashSet<>();
		rand = new Random();

		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(path));
			String line = reader.readLine();
			while (line != null) {
				// System.out.println(line);
				wordList.add(line);
				wordSet.add(line);
				line = reader.readLine();
			}

			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return;
	}

	public TestData(int digit, int amount){

		wordList = new ArrayList<>();
		wordSet = new HashSet<>();
		rand = new Random();
		charList = Arrays.asList('a','b','c','d','e','f','g','h','i','j',
								 'k','l','m','n','o','p','q','r','s','t',
								 'u','v','w','x','y','z');

		for(int i = 0;i < amount;i++){
			wordList.add(generate(charList, digit));
		}
		return;
	}

	public String generate(List<Character> list,int digit){
		
		
		while(true){
			String res = "";
			for(int i = 0;i < digit;i++){
				res += list.get(rand.nextInt(list.size()));
			}

			if(!wordSet.contains(res)){
				wordSet.add(res);
				return res;
			}
		}
	}

	public List<String> getList(){
		return this.wordList;
	}

	public Set<String> getSet(){
		return this.wordSet;
	}

	public String getSecret(){
		return this.wordList.get(rand.nextInt(wordList.size()));
	}
}
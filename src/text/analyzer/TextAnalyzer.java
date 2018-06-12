package text.analyzer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class TextAnalyzer {
	
	public static void main(String[] args) {
		HashMap<Character, Float> characters = new HashMap();
		float charcount = 0;
		
		try{
			BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/war and peace text.txt"));
			BufferedWriter bw = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "/analysisResults.txt"));
			
			char[] linechars;
			
			String line;
			
			float start = System.nanoTime();
			while ((line = br.readLine()) != null) {
				if(!line.contains("CHAPTER")){
					linechars = line.toLowerCase().toCharArray();
					for(char c : linechars){
						if(!characters.containsKey(c)){
							characters.put(c, 1f);
						}
						else{
							characters.put(c, characters.get(c) + 1);
						}
						charcount++;
					}
				}
			}
			
			bw.write("Character analysis of \"War and Peace\":\n\n");
			
			Iterator<Entry<Character, Float>> entries = characters.entrySet().iterator();
			Entry<Character, Float> entry;
			while(entries.hasNext()){
				entry = entries.next();
				bw.write(entry.getKey() + " : " + entry.getValue()/charcount*100 + "%\n");
			}
			
			float end = System.nanoTime();
			
			bw.write("\nRuntime: " + (end - start)/1000000000 + "seconds");
			bw.close();
		}
		catch(FileNotFoundException e){}
		catch(IOException e){}
	}
}
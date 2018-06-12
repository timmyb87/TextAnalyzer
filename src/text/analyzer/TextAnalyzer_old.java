package text.analyzer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class TextAnalyzer_old {
	
	public static void main(String[] args) {
		float[] letters = new float[26];
		HashMap<String, Float> l = new HashMap(), percents = new HashMap();
		float charcount = 0, start = 0, end = 0, runtime = 0;
		
		float[] charpercent = new float[26];
		
		try{
			FileInputStream fs = new FileInputStream(new File("C:\\Users\\tbando2\\Google Drive\\pg2600.txt"));
			BufferedReader br = new BufferedReader(new InputStreamReader(fs));
			BufferedWriter bw = new BufferedWriter(new FileWriter(new File("C:\\Users\\tbando2\\Google Drive\\analysisResults.txt")));
			
			char[] linechars;
			
			String line = null;
			
			start = System.nanoTime();
			while ((line = br.readLine()) != null) {
				if(!line.contains("CHAPTER")){
					line = line.toLowerCase();
					linechars = line.toCharArray();
					for(char c : linechars){
						if(!l.containsKey("" + c)){
							l.put("" + c, 1f);
						}
						else{
							l.put("" + c, l.get("" + c) + 1);
						}
						
//						switch(c){
//							case 'a':
//								letters[0]++;
//								break;
//							case 'b':
//								letters[1]++;
//								break;
//							case 'c':
//								letters[2]++;
//								break;
//							case 'd':
//								letters[3]++;
//								break;
//							case 'e':
//								letters[4]++;
//								break;
//							case 'f':
//								letters[5]++;
//								break;
//							case 'g':
//								letters[6]++;
//								break;
//							case 'h':
//								letters[7]++;
//								break;
//							case 'i':
//								letters[8]++;
//								break;
//							case 'j':
//								letters[9]++;
//								break;
//							case 'k':
//								letters[10]++;
//								break;
//							case 'l':
//								letters[11]++;
//								break;
//							case 'm':
//								letters[12]++;
//								break;
//							case 'n':
//								letters[13]++;
//								break;
//							case 'o':
//								letters[14]++;
//								break;
//							case 'p':
//								letters[15]++;
//								break;
//							case 'q':
//								letters[16]++;
//								break;
//							case 'r':
//								letters[17]++;
//								break;
//							case 's':
//								letters[18]++;
//								break;
//							case 't':
//								letters[19]++;
//								break;
//							case 'u':
//								letters[20]++;
//								break;
//							case 'v':
//								letters[21]++;
//								break;
//							case 'w':
//								letters[22]++;
//								break;
//							case 'x':
//								letters[23]++;
//								break;
//							case 'y':
//								letters[24]++;
//								break;
//							case 'z':
//								letters[25]++;
//								break;
//						}
					}
				}
			}
			
			Iterator<Float> values = l.values().iterator();
			while(values.hasNext()){
				charcount += values.next();
			}
			
			Iterator<Entry<String, Float>> entries;
			entries = l.entrySet().iterator();
			Entry<String, Float> entry;
			while(entries.hasNext()){
				entry = entries.next();
				percents.put(entry.getKey(), l.get(entry.getKey())/charcount * 100 );
			}
			
//			for(int i = 0; i < letters.length; i++){
//				charcount += letters[i];
//			}
			
//			for(int i = 0; i < 26; i++){
//				charpercent[i] = letters[i]/charcount*100;
//			}
			
			end = System.nanoTime();
			runtime = (end - start)/1000000000;
			
			entries = percents.entrySet().iterator();
			
			bw.write("Character analysis of \"War and Peace\":");
			bw.newLine();
			
			float total = 0;
			while(entries.hasNext()){
				entry = entries.next();
				bw.write(entry.getKey() + ": " + entry.getValue() + "%");
				bw.newLine();
				total += entry.getValue();
			}
			
//			bw.write("Character analysis of \"War and Peace\":");
//			bw.newLine();
//			bw.write("a: " + charpercent[0] + "%");
//			bw.newLine();
//			bw.write("b: " + charpercent[1] + "%");
//			bw.newLine();
//			bw.write("c: " + charpercent[2] + "%");
//			bw.newLine();
//			bw.write("d: " + charpercent[3] + "%");
//			bw.newLine();
//			bw.write("e: " + charpercent[4] + "%");
//			bw.newLine();
//			bw.write("f: " + charpercent[5] + "%");
//			bw.newLine();
//			bw.write("g: " + charpercent[6] + "%");
//			bw.newLine();
//			bw.write("h: " + charpercent[7] + "%");
//			bw.newLine();
//			bw.write("i: " + charpercent[8] + "%");
//			bw.newLine();
//			bw.write("j: " + charpercent[9] + "%");
//			bw.newLine();
//			bw.write("k: " + charpercent[10] + "%");
//			bw.newLine();
//			bw.write("l: " + charpercent[11] + "%");
//			bw.newLine();
//			bw.write("m: " + charpercent[12] + "%");
//			bw.newLine();
//			bw.write("n: " + charpercent[13] + "%");
//			bw.newLine();
//			bw.write("o: " + charpercent[14] + "%");
//			bw.newLine();
//			bw.write("p: " + charpercent[15] + "%");
//			bw.newLine();
//			bw.write("q: " + charpercent[16] + "%");
//			bw.newLine();
//			bw.write("r: " + charpercent[17] + "%");
//			bw.newLine();
//			bw.write("s: " + charpercent[18] + "%");
//			bw.newLine();
//			bw.write("t: " + charpercent[19] + "%");
//			bw.newLine();
//			bw.write("u: " + charpercent[20] + "%");
//			bw.newLine();
//			bw.write("v: " + charpercent[21] + "%");
//			bw.newLine();
//			bw.write("w: " + charpercent[22] + "%");
//			bw.newLine();
//			bw.write("x: " + charpercent[23] + "%");
//			bw.newLine();
//			bw.write("y: " + charpercent[24] + "%");
//			bw.newLine();
//			bw.write("z: " + charpercent[25] + "%");
//			bw.newLine();
			
			bw.write("Total: " + total + "%");
			bw.newLine();
			bw.write("Runtime: " + runtime + "seconds");
			bw.close();
		}
		catch(FileNotFoundException e){}
		catch(IOException e){}
	}
}
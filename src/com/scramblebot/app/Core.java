package com.scramblebot.app;

public class Core extends Cypher {
	static String strWord = "text";
	
	public Core (String strInput, int cypherType, int encodeDecode, int charsToShift, boolean reverse) {
		
		if (boolReverse == true){
			strText = reverseWords(strInput);
		}
		
		if (cypherType == CEASAR){
			
			//call ceasar cypher
			Ceasar julius = new Ceasar(strInput, ENCODE, charsToShift);
			strWord = julius.strOutput; 
		} else if (cypherType == SQUARE){
			
			//call square cypher	
		
		} else {
			// handle error
		}
		
		//return strText;
	}
	
	
	//Uses the space character as a delimiter to reverse the order of words in the string 
	//argument that was passed to it, and returns the results as a string. 
	protected String reverseWords( String text){
		
		String strText = text;
		
		String[] strWords = strText.split(" ");
		StringBuilder sbReversed = new StringBuilder("");
		
		//loops through the strWords array in reverse, from end to beginning, and appends
		//each element to the StringBuilder sbReversed object, and inserts a space in between
		//each word -- reversing the word order.
		for (int i = strWords.length; i >= 0; i--){
			sbReversed.append(strWords[i]);
			
			//re-adds space between words. since element 0 of strWords array is the last
			//word, no space is needed after element 0
			if (i > 0){
				sbReversed.append(" ");
			}	
		}
		
		return sbReversed.toString();
	}

	public static void main(String[] args) {
		
		Core coreBot = new Core("Great googley moogley!", CEASAR, ENCODE, 1, false);
		System.out.println(strWord);
		
		Core coreBot2 = new Core (strWord, CEASAR, DECODE, 1, false);
		System.out.println(strWord);
	}

}

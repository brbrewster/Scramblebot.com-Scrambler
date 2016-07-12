package com.scramblebot.app;


public class Ceasar extends Cypher {
	
	int intCurrentChar;
	int intChars = charScramble.length - 1; //size of the array of characters
	int intRotate;
	char charCurrent;
	String strOutput;
	StringBuilder sbResult = new StringBuilder();
	
	Ceasar(){
		//do nothing
	}
	
	Ceasar(String text, int operation, int rotate) {
		intRotate = rotate;
		strText = text;
		if (operation == Cypher.ENCODE){
			strOutput = encode();
		} else if (operation == Cypher.DECODE){
			strOutput = decode();
		}
		
	}
	
	private String encode (){
		//main loop of ceasar cypher encode method cycles through each character in the 
		//string argument that has been passed to it, and replaces it with a new character 
		//based on it's relative position in the charScramble array; using the int intRotate 
		//argument as the number of characters to shift it to the right.
		for (int i = 0; i < strText.length(); i++){
			
			charCurrent =  strText.charAt(i);
			for (int x = 0; x <= intChars; x++){
			
				if (charCurrent == charScramble[x]){
					if ((x + intRotate) <= intChars ){
						sbResult.append(charScramble[x+intRotate]);
						} else {
							int y = (x + intRotate) - intChars;
							sbResult.append(charScramble[y]);
						}
				}	
			}
			
		}
	
		return sbResult.toString();
	}
	

	private String decode(){
		
		
		for (int i = 0; i < strText.length(); i++){
			charCurrent = strText.charAt(i);
			
			for (int x = 0; x < charScramble.length; x++){
				if (charCurrent == charScramble[x]){
										
					if (x - intRotate  >= 0){
						sbResult.append(charScramble[x - intRotate]);
					} else {
						
						

						int y = intRotate - x;
						int z = intChars - y;
						sbResult.append(charScramble[z]);				
					
					}
				}
			}
		}
		
		return sbResult.toString();
	}

	public static void main(String[] args){
			
		
		for (int rotate = 0; rotate <= 93; rotate++){
				
			Ceasar augustus = new Ceasar("Great googley moogley 2! wxyz", ENCODE, rotate);
			System.out.println(augustus.strOutput);
				
			Ceasar augustus2 = new Ceasar(augustus.strOutput, DECODE, rotate);
			
			if (augustus2.strOutput.matches("Great googley moogley 2! wxyz") == false) {
				System.out.println("Stahhhhhp!");
			}
			
			System.out.println(augustus2.strOutput);
			System.out.println(rotate + "\n------\n\n");			
			
		
		 }
	}

}

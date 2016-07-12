//Vigenere Square Cipher
package com.scramblebot.app;

public class Square extends Cypher {
	
	Square() {
		
		char[][] charSquare = new char[charScramble.length][charScramble.length];
		
		for(int x = 0; x < charScramble.length; x++){
			for(int y = 0; y < charScramble.length; y++){
				char elementOne = charScramble[x];
				char elementTwo = charScramble[y];
				charSquare[x][y] =  charScramble[y];
				System.out.print(charSquare[x][y]);
			}
			System.out.println();
		}
		
	}
	
	
	public static void main(String[] args) {
		Square ted = new Square();
	}
}

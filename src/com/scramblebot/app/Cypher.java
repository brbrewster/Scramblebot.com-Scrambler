package com.scramblebot.app;

import java.util.*;

public abstract class Cypher {
	
	public static int ENCODE = 1;
	public static int DECODE = 2;
	public static int CEASAR = 3;
	public static int SQUARE = 4;
	public boolean boolReverse = false;
	public String strText;
	
	char[] charScramble = new char[] {' ', '!', '\"', '#', '$', '%', '&', '\'', '(', ')',
			'*', '+', ',', '-', '.', '/', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
			':', ';', '<', '=', '>', '?', '@', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
			'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y',
			'Z', '[', '\\', ']', '^','_', '`', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
			'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y',
			'z', '{', '|', '}', '~' };
	
	Cypher(){
		//empty constructor
	}
	
	


}

package com.turing.dsa.tdd;

import java.util.StringTokenizer;

public class Transformer {

	public String transform(String input) {

		if(input == null || input.isEmpty())
		{
			return input;
		}
		else
		{
			String strArrs[] = input.split(" ");
			String output = "";
			for(String word : strArrs)
			{
				output += " "+transformWord(word);
			}
			return output.trim();
		}
		
	}

	private String transformWord(String input) {
		String firstLetter = input.charAt(0)+"";
		String remaining= input.substring(1);
		return firstLetter.toUpperCase()+ remaining;
	}
	
	public static void main(String[]args)
	{
		String input = "h";
		String arr[]= input.split(" ");
		System.out.println("Arr.length "+arr.length);
	}

}

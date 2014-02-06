package com.example.crystalball;

import java.util.Random;

public class CrystalBall 
{

	//Array of answers for crystal ball
	public String[] answers = {
					"It is certain",
					"It is decidedly so",
					"All signs say YES",
					"The stars are not aligned",
					"My reply is no",
					"It is doubtful",
					"Better not tell you now",
					"Concentrate and ask again",
					"Unable to answer now" };
	
	public String getAnswer()
	{
		//The button was clicked. Update string with answer text.
		String answer = "";
		
		//Randomly select an answer
		Random randomGenerator = new Random();
		int randNum = randomGenerator.nextInt( answers.length ); 
		
		answer = answers[ randNum ];
		
		return answer;
	}
	
}

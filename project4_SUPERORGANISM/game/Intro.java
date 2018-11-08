package game;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Intro {

	public static void play() {
		
		System.out.print("Play the intro? (y/n): ");
    	
		String[] answers = {
			"y","yes","n","no"
		};
		
		Set<String> ans = new HashSet<String>(Arrays.asList(answers));
		
		String current = "";
		while (!ans.contains(current))
			current = new Scanner(System.in).nextLine().toLowerCase();
		
		System.out.println();
		
		if (current.equals("y") || current.equals("yes"))
			introSequence();
	}
	
	private static void introSequence() {
			
	    System.out.println("\n\tYou are a wanderer in this land. Your people laugh at your dreams.");
	   
	    try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {}
	    
	    System.out.println("\n\tYou have read every story you could on the great beasts of old: Whales.");
	    try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {}
	    
	    System.out.println("\n\tIf only you could become one. That is your quest. You want to become a");
	    try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {}
	    
	    System.out.print("\n\t\t\t\t");
	    String word = "SUPERORGANISM";
	
	    for (int i = 0; i < word.length(); i++){
	        char c = word.charAt(i);
	        try {
				Thread.sleep(500);
				System.out.print(c);
			} catch (InterruptedException e) {}
	    }
	
	    try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {}	
	    
	    System.out.printf("\n\n");
	    
	    System.out.printf("\n\tYou have come to an old aquarium, perhaps the last of its kind, at the"
	    		+ "\n\tend of the world.");
	    try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {}
	    System.out.println("\n\n\tYou enter the grounds through the rusted wrought iron gate. Scattered"
	    		+ "\n\tthroughout the tall grass are statues celebrating a time long past, "
	    		+ "\n\tscenes of a healthy and living ocean.");
	    
	    try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {}
	    System.out.println("\n\tThe front door is almost off its hinges, you squeeze through crack it"
	    		+ "\n\tcreates with the frame.\n");
	    
	    try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {}
	}
}

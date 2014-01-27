package fr.clunven.images;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.springframework.core.io.ClassPathResource;

public class FromTexttoSQL {
	
	public static void main(String[] args) throws IOException {
		ClassPathResource cp = new ClassPathResource("fr.txt");
		
		
		Scanner sc = new Scanner(cp.getInputStream());
		while(sc.hasNextLine()) {
			String currentLine = sc.nextLine();
			System.out.println(currentLine);
		}
		
	}

}

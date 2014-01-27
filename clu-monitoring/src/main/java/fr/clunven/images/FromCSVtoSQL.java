package fr.clunven.images;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.springframework.core.io.ClassPathResource;

public class FromCSVtoSQL {
	
	private static final String COL = "INSERT INTO `REF_CITY` (`CITY`, `CITY_UP`, `ZIPCODE`, `INSEECODE`, `REGIONCODE`, `LATITUDE`, `LONGITUDE`) VALUES(";
	public static void main(String[] args) throws IOException {
		ClassPathResource cp = new ClassPathResource("ville.csv");
		
		BufferedWriter out = new BufferedWriter(new FileWriter("write.sql"));
		int idx = 0;
		Scanner sc = new Scanner(cp.getInputStream());
		while(sc.hasNextLine()) {
			String currentLine = sc.nextLine();
			String[] elements 	= currentLine.split(";");
			String villeName 	= elements[0].trim().replaceAll("'", "''");
			String cityMAJ		= elements[1].trim().replaceAll(" ", "-");
			StringBuilder strb = new StringBuilder(COL);
			strb.append("'" + villeName + "', '" + cityMAJ + "','");
			//ZIPCODE
			strb.append(elements[2].trim());
			strb.append("','");
			//INSEECODE
			strb.append(elements[3].trim());
			strb.append("','");
			// REGIONCODE
			strb.append(elements[4].trim());
			strb.append("','");
			//LATITUDE
			strb.append(elements[5].trim().replaceAll(",", "."));
			strb.append("','");
			//LONGITUDE
			strb.append(elements[6].trim().replaceAll(",", "."));
			strb.append("');");
			
			out.write(strb.toString());
			out.newLine();
			idx++;
		}
		out.close();
		System.out.println(idx + " ligne(s) ont été mise(s) a jour.");
		
	}

}

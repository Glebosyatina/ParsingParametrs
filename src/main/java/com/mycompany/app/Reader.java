package com.mycompany.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Reader{

	public static ArrayList<String> ReadFile(String filePath){
		ArrayList<String> result = new ArrayList<>();

		BufferedReader reader;

		try {
			//входные данные
			reader = new BufferedReader(new FileReader(filePath));

			//читаем построчно
			String line = reader.readLine();

			while (line != null){
				
				result.add(line);

				line = reader.readLine();
			}

			reader.close();
		} catch (IOException e){
			e.printStackTrace();
		}

		return result;
	}
}

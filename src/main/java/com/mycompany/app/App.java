package com.mycompany.app;

import java.util.*;
import java.io.*;

public class App {
    public static void main(String[] args) {
        
		String inputFile = args[0];        
       	
		ArrayList<String> lines = Reader.ReadFile(inputFile); 
		
		Statistic stat = new Statistic();

		int numLine = 0; //для отлова в каких строках проблемы
		for (String paramLine : lines){
		
			numLine++;
			
			String[] params = paramLine.split(" ");
			int len = params.length;
			if (len != 3){
				stat.addIncorrect(numLine, " - Мало параметров"); //не хватает параметров
				continue;
			}
			
			try{	
				//парсим параметры
				Integer id = Integer.valueOf(params[0]);
				String name = params[1]; 
				Double value = Double.valueOf(params[2]);
				if (id < 0 || value < 0){
					stat.addIncorrect(numLine, " - Параметр меньше нуля"); //неверное значение
					continue;
				}	
			
				Property prop = new Property(id, name, value);
				stat.addProperty(prop);
				stat.addCorrect();
			
			} catch(NumberFormatException e){
				stat.addIncorrect(numLine, " - Неверно введено число"); //если вместо числа введена строка
			}
		}
		
		try {
			//пишем отчет в файл
			String otchet = stat.getStatistics();
			FileOutputStream outStream = new FileOutputStream("otchet.txt");
			outStream.write(otchet.getBytes());
			outStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
    }
}



package com.mycompany.app;

import java.util.ArrayList;

public class Statistic{

		private int correctParams = 0;
		private int incorrectParams = 0;
		ArrayList<String> numIncorrectLines = new ArrayList<>();


        ArrayList<Property> listProperties = new ArrayList<>();

        public void addProperty(Property prop){
                listProperties.add(prop);
        }

        public void removeStatistics(){
                this.listProperties.clear();
        }

        public String getStatistics(){

                StringBuilder result = new StringBuilder();
				result.append(String.format("%10s%15s%13s","ID", "NAME", "VALUE\n"));
                for (Property prop : this.listProperties){
                        result.append(String.format("%10d ", prop.getId()));
                        result.append(String.format("%15s ", prop.getName()));
                        result.append(String.format("%10.1f ", prop.getValue()));
                        result.append("\n");
                }

                result.append("Всего записей - " + String.valueOf(this.correctParams+this.incorrectParams));
                
                
                result.append("\nКорректных записей - ");
                result.append(this.correctParams);
                
				result.append("\nНекорретных записей - ");
				result.append(this.incorrectParams + " ");
				result.append(this.incorrectParams != 0 ? "\n" + numIncorrectLines.toString() : "") ;
                return result.toString();
        }
		
		public void addIncorrect(int numLine, String err){
			incorrectParams++;	
			numIncorrectLines.add(String.valueOf(numLine) + err);
		}
		
		public void addCorrect() {
			correctParams++;
		}
		
}


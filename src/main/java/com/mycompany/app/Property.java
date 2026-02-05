package com.mycompany.app;

public class Property{
        private Integer id;
        private String name;
        private Double value;

        Property(Integer Id, String Name, Double Value){
                this.id = Id;
                this.name = Name;
                this.value = Value;
        }

		public Integer getId(){
			return this.id;
		}

		public String getName(){
			return this.name;
		}

		public Double getValue(){
			return this.value;
		}
}


package oops1;

class Vehicle {
	  int c;
       public Vehicle(){
    	   System.out.println("Default vehicle");
       }
       Vehicle(int c){
    	   System.out.println("Parameterised Vehicle "+c);
       }
}
class Car extends Vehicle{
	//int c;
	Car(){
		super();
 	   System.out.println("Default Car");
 	   
    }
	Car(int c){
		super(c);
		 System.out.println("Parameterised car "+c);
	}
	
}
class Bicycle{
	//int c;
	Bicycle(){
		//super();
 	   System.out.println("Default B");
 	   
    }
	Bicycle(int c){
		//.super(c);
		 System.out.println("Parameterised B "+c);
	}
	
}

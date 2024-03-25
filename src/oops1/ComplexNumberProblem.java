package oops1;

import java.util.Scanner;
class ComplexNumbers {
	// Complete this class
	int r;
	int i;
	public ComplexNumbers(int r,int i){
		this.r=r;
		this.i=i;
	}
	public void plus(ComplexNumbers c){
		
		this.r=this.r+c.r;
		this.i=this.i+c.i;
		
	}
	public void multiply(ComplexNumbers c) {
		int r1=this.r*c.r-this.i*c.i;
		int i1=this.r*c.i+this.i*c.r;
		this.r=r1;
		this.i=i1;
	}
	public void print() {
		System.out.println(this.r+" + i"+this.i);
	}

	
}

public class ComplexNumberProblem {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int real1 = s.nextInt();
		int imaginary1 = s.nextInt();

		int real2 = s.nextInt();
		int imaginary2 = s.nextInt();

		ComplexNumbers c1 = new ComplexNumbers(real1, imaginary1);
		ComplexNumbers c2 = new ComplexNumbers(real2, imaginary2);

		int choice = s.nextInt();

		 
		if(choice == 1) {
			// Add
			c1.plus(c2);
			c1.print();
		}
		else if(choice == 2) {
			// Multiply
			c1.multiply(c2);
			c1.print();
		}
		else {
			return;
		}
	}
}


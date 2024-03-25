package oops1;

public class Test {
     protected int a=10;
     protected int b=20;
     
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Temp te=new Temp();
//		te.temp();
		

	}

}
class Temp{
	public void temp() {
		Test t=new Test();
		t.a=20;
		t.b=t.a+t.b;
		System.out.println("Hi"+t.b+" "+t.a);
	}
}

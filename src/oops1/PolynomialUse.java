package oops1;
class Polynomial{
	private int []degCoef;
	public Polynomial(){
		degCoef=new int[10];
	}
	public void print() {
		String s="";
		if(degCoef[0]!=0) {
			 s=""+degCoef[0]+" ";
		}
		for(int i=1;i<degCoef.length;i++) {
			if(degCoef[i]!=0) {
				s+=degCoef[i]+"x"+i+" ";
			}
		}
		System.out.println(s);
	}
	private void increaseCapacity(int deg) {
		int []t=degCoef;
		degCoef=new int[deg+1];
		for(int i=0;i<t.length;i++) {
			degCoef[i]=t[i];
		}
	}
	public void setCoef(int deg,int coef) {
		if(deg>=degCoef.length) {
			increaseCapacity(deg);
		}
		degCoef[deg]=coef;
		
	}
    public int getCoef(int deg) {
		return degCoef[deg];
	}
    public Polynomial add(Polynomial p) {
    	Polynomial p3=new Polynomial();
    	if(this.degCoef.length>=p.degCoef.length) {
    		for(int i=0;i<p.degCoef.length;i++) {
    			p3.setCoef(i, this.getCoef(i)+p.getCoef(i));
    		}
    		for(int i=p.degCoef.length;i<this.degCoef.length;i++) {
    			p3.setCoef(i, this.getCoef(i));
    		}
    	}
    	else {
    		for(int i=0;i<this.degCoef.length;i++) {
    			p3.setCoef(i, this.getCoef(i)+p.getCoef(i));
    		}
    		for(int i=this.degCoef.length;i<p.degCoef.length;i++) {
    			p3.setCoef(i, p.getCoef(i));
    		}
    	}
    	
    	return p3;
    }
    public Polynomial subtract(Polynomial p) {
    	Polynomial p4=new Polynomial();
    	if(this.degCoef.length>=p.degCoef.length) {
    		for(int i=0;i<p.degCoef.length;i++) {
    			p4.setCoef(i, this.getCoef(i)-p.getCoef(i));
    		}
    		for(int i=p.degCoef.length;i<this.degCoef.length;i++) {
    			p4.setCoef(i, this.getCoef(i));
    		}
    	}
    	else {
    		for(int i=0;i<this.degCoef.length;i++) {
    			p4.setCoef(i, -this.getCoef(i)+p.getCoef(i));
    		}
    		for(int i=this.degCoef.length;i<p.degCoef.length;i++) {
    			p4.setCoef(i, p.getCoef(i));
    		}
    	}
    	
    	return p4;
    }
    public Polynomial multiply(Polynomial p) {
	     Polynomial p5=new Polynomial();
	     for(int i=0;i<this.degCoef.length;i++) {
	    	 for(int j=0;j<p.degCoef.length;j++) {
	    		 if(this.degCoef[i]!=0 && p.degCoef[j]!=0) {
	    			 if(p5.getCoef(i+j)==0) {
		    			 p5.setCoef(i+j, this.degCoef[i]*p.degCoef[j]); 
		    			 
		    		 }
		    		 else {
		    			 p5.setCoef(i+j, p5.getCoef(i+j)+this.degCoef[i]*p.degCoef[j]);
		    		 }
	    		 }
	    	 }
	     }
	     return p5;
     }
}

public class PolynomialUse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Polynomial p=new Polynomial();
//		p.setCoef(4, 2);
//		p.setCoef(1, 3);
//		p.setCoef(0, 6);
//		p.setCoef(1000, 6);
//		p.print();
		Polynomial p1=new Polynomial();
	    p1.setCoef(3, 2);
		p1.setCoef(1, 2);
		p1.setCoef(0, 1);
		p1.print();
		Polynomial p2=new Polynomial();
		p2.setCoef(1, 3);
		p2.setCoef(0, 2);
		p2.print();
//		Polynomial p3=p2.add(p1);
//		p3.print();
//		Polynomial p4=p2.subtract(p1);
//		p4.print();
		Polynomial p5=p2.multiply(p1);
		p5.print();
		
		

	}

}

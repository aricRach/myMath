package myMath;

/**
 * This class tests all the functions in Monom and Polynom calsses
 */

public class test {

	public static void main(String[] args) {
	// Tests on Class Monom:

	Monom m1 = new Monom(1, 2);
	Monom m2 = new Monom(5, 3);
	Monom m3 = new Monom(3, 4);
	Monom m4 = new Monom("7x^2");
	Monom m5 = new Monom(3, 0);
	Monom m6 = new Monom(0,7);
	
	
	Polynom first = new Polynom();
	
	first.add(m1);
	first.add(m2);
	first.add(m3);
	first.substract(m4);
	first.add(m5);
	first.add(m6);
	
	System.out.println("the first polynom should be : 3x^4+5x^3-6x^2+3");
	System.out.println(first);
	
	Polynom copy = new Polynom(first);
	System.out.println("the copy of first polynom is: "+copy);
	
	Polynom_able ForTesting = new Polynom();
	ForTesting = first.copy();
	System.out.println("this will be the copy of first, the result should be : 3x^4+5x^3-6x^2+3x^0");
	System.out.println(ForTesting);
	
	Polynom second = new Polynom("x^2+3x^0");
	System.out.println("this polynom should be : x^2+3");
	System.out.println(second);
	
	Polynom_able afterDerivative = first.derivative(); // first Polynom didn't changed (as Boaz Asked)
	System.out.println("the derivative of "+first);
	System.out.println("the result should be : 12x^3+15x^2-12x^1");
	System.out.println(afterDerivative);
	System.out.println("the first polynom should still be 3x^4+5x^3-6x^2+3");
	System.out.println("the first polynom is: "+first);
	
	first.multiply(second);
	System.out.println("the multiply between "+first+" and "+second+" should be : 3x^6+5x^5+3x^4+15x^3-15x^2+9");
	System.out.println(first);
	
	System.out.println("check if "+first +" is equal to "+second+" the result should be : false");
	System.out.println(first.equals(second));

	Polynom third = new Polynom("3x^6+5x^5+3x^4+15x^3-15x^2+9x^0");
	System.out.println("check if "+first+" is equal to " +third+" the result should be : true");
	System.out.println(first.equals(third));
	
	Polynom StringPoly4=new Polynom("5.0x^22+65.0x^2+55.0x^1+20.0x^0");
	System.out.println("poly 4: "+StringPoly4);
	
	Polynom StringPoly5=new Polynom("5.0x^22+65.0x^2+55.0x^1-20.0x^0");
	System.out.println("poly 5: "+StringPoly5);
	System.out.println("the substract : "+" ( " +StringPoly4+ " )" + " - "+ "( " +StringPoly5+ " )"+ "result should be : 40");
	StringPoly4.substract(StringPoly5);
	System.out.println("the substract is: "+StringPoly4);
	
	
	
	System.out.println("this is the third polynom "+third);
	System.out.println("this is the second polynom" +second);
	System.out.println("the subtract between third and second : ");
	System.out.println("the result should be : 3x^6+5x^5+3x^4+15x^3-16x^2+6x^0");
	third.substract(second);
	System.out.println(third);
	
	
	// Checking Root Function : 
	double eps = Double.MIN_VALUE;
	
	System.out.println("the root of "+third+" between -2.5 and -0.7 ");
	System.out.println("the result should be : -2.4220366166600584");
	System.out.println(third.root(-2.5, -0.7, eps));
	
	
	Polynom p4=new Polynom ("-1x^5+3x^2");
	System.out.println("the root of "+p4+" between -1 and 2");
	System.out.println("the result should be : 1.4422495703074083");
	System.out.println(p4.root(-1, 2, eps));
	
	Polynom poly=new Polynom("5x^2+6x^1");
	System.out.println("the area above the x axis of "+poly+" between -1.2 and 0");
	System.out.println("the result should be : 0");
	System.out.println(poly.area(-1.2, 0, 0.1));
	
	Polynom poly2=new Polynom("-1x^2+6x^1");
	System.out.println("the area above the x axis of "+poly2+" between 0 and 4");
	System.out.println("the result should be : 27.06000");
	System.out.println(poly2.area(0, 4, 0.1));
	
	Polynom poly3=new Polynom("-1x^3+6x^1");
	System.out.println("the area above the x axis of "+poly3+" between -2.449 and 2.449");
	System.out.println("the result should be : 8.9999 because it sums above the x axis");
	System.out.println(poly3.area(-2.449, 2.449, 0.1));
		
		Polynom check=new Polynom ("-0.1x^2-5x^1+2x^0");
		System.out.println("the result of the area under the xaxis and above the function : "+ check+" should be : : -264.0212959999859");
		System.out.println(check.areaUnderXaxis(-10, 10, 0.01));

		Polynom check2=new Polynom("x^2+10x^0");
		System.out.println("the result of the area under the xaxis and above the function :"+ check2+" should be : 0");
		System.out.println(check2.areaUnderXaxis(-10, 10, 0.01));
		
		Polynom matala1=new Polynom("0.2x^4-1.5x^3+3x^2-1x^1-5x^0");
		System.out.println("the result of the area under the xaxis and above the function : "+ matala1+" should be :-25.18374177435345");
		System.out.println(matala1.areaUnderXaxis(-2, 6, 0.01));
		
		//Showing the function chart in gui
		Polynom function = new Polynom("0.2x^4-1.5x^3+3x^2-1x^1-5x^0");
		chartExample.initGraph(-2, 6, function);
	
	}
}
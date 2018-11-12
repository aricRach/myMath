package myMath;

import java.util.ArrayList;

import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
/**
 * This class is for Visualing the graph between start and end points
 * @param start - left point
 * @param end - right point
 */

public class chartExample {

	protected static void initGraph(double start,double end,Polynom p) {

		// X axis 
		double[] x0Data = new double[] {start,end};
		double[] x1Data = new double[] { 0,0};

		// Y axis 

		double[] y1Data = new double[] { -30,30};
		double[] y0Data = new double[] { 0,0};
		if (p.f(start)>0 && p.f(end)<0 || p.f(start)>0 && p.f(end)<0) {

			y1Data= new double[]{ p.f(start),p.f(end)};
		}

		double eps=0.00001;
		int sizeArray=(int)((end-start)/eps); // parting the equation to many intervals for showing better

		double []x=new double[sizeArray];
		double []y=new double[sizeArray];

		ArrayList<Double> exPoints=new ArrayList<Double>(); // this arrayList contains Extreme points
		Polynom_able d=p.derivative();
		int arrayIndex=0;

		for(double i=start; i<end; i=i+eps) {

			if (i+eps<end) {

				if (d.f(i)>0 && d.f(i+eps)<0 || d.f(i)<0 && d.f(i+eps)>0) {
					exPoints.add(i);
				}
			}
			// System.out.println(arrayIndex);
			if (arrayIndex<sizeArray) {

				x[arrayIndex]=i;
				y[arrayIndex]=p.f(i);
				arrayIndex++;
			}


		}

		XYChart chart2 = QuickChart.getChart("Sample Chart", "X-Axis", "Y-Axis", "f(x)", x, y);
		chart2.addSeries("x", x0Data, x1Data);
		chart2.addSeries("y", y0Data, y1Data);

		// System.out.println("The number of Extreme points is "+exPoints.size());
		for(int i=0;i<exPoints.size();i++) {
			String str = "";
			str += i+1;
			// Extreme - Create 2 arrays for showing any point
			double[] ex = new double[1] ;
			double[] ey = new double[1] ;
			ex[0]=exPoints.get(i);
			ey[0]=p.f(exPoints.get(i));
			chart2.addSeries(str,ex,ey);
		}

		new SwingWrapper(chart2).displayChart();
	}
}


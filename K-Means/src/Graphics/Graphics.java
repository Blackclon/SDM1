package Graphics;

import org.math.plot.*;
import Generator.*;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

public class Graphics {
	
	private double[] x;
	private double[] y;
	double[] tempX = new double[1];
	double[] tempY = new double[1];
	//private Color[] color;
	
	public Graphics(List<Cluster> Input, int X, int Y)
	{
		
		//color = new Color[DataGenerator.getInstance().getNum_Cluster()];
		//CreateColors(DataGenerator.getInstance().getNum_Cluster());
		// create your PlotPanel (you can use it as a JPanel)
		Plot2DPanel plot = new Plot2DPanel();
		
		Color color[] = {Color.BLUE, Color.CYAN, Color.PINK, 
				Color.RED, Color.BLACK, Color.LIGHT_GRAY, Color.MAGENTA, 
				Color.ORANGE, Color.DARK_GRAY,Color.GRAY};
		
		// add a line plot to the PlotPanel
		for(int j = 0; j < Input.size(); j++)
		{
			x = null;
			y = null;
			x = new double[DataGenerator.getInstance().getNum_DataPoints()];
			y = new double[DataGenerator.getInstance().getNum_DataPoints()];
			tempX = null;
			tempY = null;
			tempX = new double[1];
			tempY = new double[1];
			for(int i = 0; i < Input.get(j).getNum_DataPoints(); i++)
			{
				
				x[i] = Input.get(j).DataInCluster().get(i).getData()[X-1];
				y[i] = Input.get(j).DataInCluster().get(i).getData()[Y-1];
			}
			tempX[0] = Input.get(j).get_Centroid().getData()[X-1];
			tempY[0] = Input.get(j).get_Centroid().getData()[Y-1];
			plot.addScatterPlot("DATA",color [j%10], x, y);
			plot.addScatterPlot("Means", Color.GREEN,tempX, tempY );
			
		}
		
		// put the PlotPanel in a JFrame, as a JPanel
		JFrame frame = new JFrame("a plot panel");
		frame.setSize(600, 600);
		frame.setContentPane(plot);
		frame.setVisible(true);
	}
	
	/*private void CreateColors(int numberOfCluster)
	{
		for(int i = 0; i < numberOfCluster; i++)
		{
			int tempH = (i%10) / 10 * (i %9)/10;
			int tempS = (i%10) / 10 * (i %3)/10;
			int tempB = (i%10) / 10 * (i %7)/10;
			Color.getHSBColor(tempH, tempS, tempB);
		}
	}*/
}

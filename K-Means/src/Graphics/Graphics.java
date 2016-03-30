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
	private double[] tempX = new double[1];
	private double[] tempY = new double[1];

	private Plot2DPanel plot = new Plot2DPanel();
	//private Color[] color;
	
	public Graphics()
	{

	}
	
	public void CreateGraphicWithDataPoints(List<Cluster> Input, int X, int Y)
	{
		//color = new Color[DataGenerator.getInstance().getNum_Cluster()];
		//CreateColors(DataGenerator.getInstance().getNum_Cluster());
		// create your PlotPanel (you can use it as a JPanel)
		Plot2DPanel plotD = new Plot2DPanel();
		
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
			plotD.addScatterPlot("Means", Color.GREEN,tempX, tempY );
			plotD.addScatterPlot("Data", color[j%11],x, y );
			
		}
		
		// put the PlotPanel in a JFrame, as a JPanel
		JFrame frame = new JFrame("Data Points");
		frame.setSize(600, 600);
		frame.setContentPane(plotD);
		frame.setVisible(true);	
	}
	
	public void CreateGraphicWithArrays(List<Double> values, Color r)
	{
		double[] length = new double[values.size()];
		double[] val = new double[values.size()];
		for(int i = 0; i < values.size(); i++)
		{
			val[i] = values.get(i);
			length[i] = i+1;
		}
		plot.addLinePlot("Step", r,length, val);
	}
	
	public void ExecuteGraphic()
	{
		JFrame frame = new JFrame("Objective Function");
		frame.setSize(600, 600);
		frame.setContentPane(plot);
		frame.setVisible(true);
	}
}

package Graphics;

import org.math.plot.*;
import Generator.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

public class Graphics {
	
	double[] x;
	double[] y;
	public Graphics(List<DataPoint> Input, int X, int Y)
	{
		// create your PlotPanel (you can use it as a JPanel)
		Plot2DPanel plot = new Plot2DPanel();
		x = new double[DataGenerator.getInstance().getNum_DataPoints()];
		y = new double[DataGenerator.getInstance().getNum_DataPoints()];
		// add a line plot to the PlotPanel
		for(int i = 0; i < DataGenerator.getInstance().getNum_DataPoints(); i++)
		{
			x[i] = Input.get(i).getData()[X-1];
			y[i] = Input.get(i).getData()[Y-1];
		}	
		plot.addScatterPlot("jo", x, y);

		// put the PlotPanel in a JFrame, as a JPanel
		JFrame frame = new JFrame("a plot panel");
		frame.setSize(600, 600);
		frame.setContentPane(plot);
		frame.setVisible(true);
		
	}
	

}

package Main;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


import javax.swing.JFrame;

import Generator.*;
import Graphics.*;

import org.math.plot.*;

public class MainClass {

	public static void main(String[] args) throws IOException
	{

/*		InputStreamReader isr = new InputStreamReader(System.in);
	    BufferedReader br = new BufferedReader(isr);
	    System.out.print("Number of Cluster: ");
	    String eingabe = br.readLine();
	    
	    
	    System.out.print("Number of Data Points: ");
	    String eingabe2 = br.readLine();
	    
	    
	    System.out.print("Enter X max: ");
	    String eingabe3 = br.readLine();
	    
	    
	    System.out.print("Enter Dtata Dimension: ");
	    String eingabe4 = br.readLine();
	    
	    
	    
	    int numCluster = Integer.parseInt(eingabe);
	    int numData = Integer.parseInt(eingabe2);
	    int Xmax = Integer.parseInt(eingabe3);
	    int dim = Integer.parseInt(eingabe4);
	    
	    if(numCluster > numData/2 || Xmax < 100)
	    {
	    	System.out.print("Wrong input data, please restart programm!");
	    	System.exit(0);
	    }
	    
		DataGenerator.getInstance().Init(numCluster, numData, Xmax, dim);
		
		List<DataPoint> test = DataGenerator.getInstance().getDataPoints();
        File logFile = new File("test.txt");
        // This will output the full path where the file will be written to...
        System.out.println(logFile.getCanonicalPath());

        BufferedWriter writer = new BufferedWriter(new FileWriter(logFile));

		for(int i = 0; i< DataGenerator.getInstance().getNum_DataPoints();i++)
		{
			double[] tempdouble = test.get(i).getData();
			for(int j = 0; j<2;j++)
			{
				double tempdoubleb = tempdouble[j];
				writer.write(Double.toString(tempdoubleb)+", ");
			}
			writer.write("\n");
		}*/
		
		double[] x = {1,2};
		double[] y = {3,4};

		// create your PlotPanel (you can use it as a JPanel)
		Plot2DPanel plot = new Plot2DPanel();

		// add a line plot to the PlotPanel
		plot.addScatterPlot("jo", x, y);

		// put the PlotPanel in a JFrame, as a JPanel
		JFrame frame = new JFrame("a plot panel");
		frame.setSize(600, 600);
		frame.setContentPane(plot);
		frame.setVisible(true);
	}
	
}
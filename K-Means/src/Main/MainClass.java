package Main;

import java.awt.Color;
import java.io.*;

import Graphics.*;

import java.util.ArrayList;
import java.util.List;


import javax.swing.JFrame;

import Generator.*;
import Algorithm.*;
//import Graphics.*;

import org.math.plot.*;


public class MainClass {

	public static void main(String[] args) throws IOException
	{

		List<Cluster> temp1 = new ArrayList<Cluster>();
		List<Cluster> temp2 = new ArrayList<Cluster>();
		List<Cluster> temp3 = new ArrayList<Cluster>();
		List<Cluster> temp4 = new ArrayList<Cluster>();
		InputStreamReader isr = new InputStreamReader(System.in);
	    BufferedReader br = new BufferedReader(isr);
	    System.out.print("Number of Cluster: ");
	    String eingabe = br.readLine();
	    
	    System.out.print("Number of Data Points: ");
	    String eingabe2 = br.readLine();
	    
	    System.out.print("Enter X max: ");
	    String eingabe3 = br.readLine();
	    
	    
	    System.out.print("Enter Data Dimension: ");
	    String eingabe4 = br.readLine(); 
	    
	    int numCluster = Integer.parseInt(eingabe);
	    int numData = Integer.parseInt(eingabe2);
	    int Xmax = Integer.parseInt(eingabe3);
	    int dim = Integer.parseInt(eingabe4);
	    
	    // could be extended(input thats not a number should be also lead to wrong input data.). 
	    if(numCluster > numData/2 || Xmax < 100)
	    {
	    	System.out.print("Wrong input data, please restart programm!");
	    	System.exit(0);
	    }

		DataGenerator.getInstance().Init(numCluster, numData, Xmax, dim);

		Calculus Calc1 = new Calculus(DataGenerator.getInstance().getDataPoints(),numCluster, Xmax);
		Calculus Calc2 = new Calculus(DataGenerator.getInstance().getDataPoints(),numCluster, Xmax);
		Calculus Calc3 = new Calculus(DataGenerator.getInstance().getDataPoints(),numCluster, Xmax);
		Calculus Calc4 = new Calculus(DataGenerator.getInstance().getDataPoints(),numCluster, Xmax);
		//HelpFunctions.txtOutput(DataGenerator.getInstance().getAllCluster(),"Initial");		

		List<Double> test1 = Calc1.ChoseAlgorythm(1, 1);
		List<Double> test2 = Calc2.ChoseAlgorythm(1, 2);
		List<Double> test3 = Calc3.ChoseAlgorythm(2, 1);
		List<Double> test4 = Calc4.ChoseAlgorythm(2, 2);
		temp1 = Calc1.getAllCluster();
		temp2 = Calc2.getAllCluster();
		temp3 = Calc3.getAllCluster();
		temp4 = Calc4.getAllCluster();
		

		System.out.print("Enter Dimension to plot as X-Coordinate: ");
		String eingabe7 = br.readLine();
		System.out.print("Enter Dimension to plot as Y-Coordinate: ");
		String eingabe8 = br.readLine();
		int A = Integer.parseInt(eingabe7);
		int B = Integer.parseInt(eingabe8);
		    
		Graphics Z = new Graphics();
		Z.CreateGraphicWithDataPoints(temp1, A, B);
		Z.CreateGraphicWithDataPoints(temp2, A, B);
		Z.CreateGraphicWithDataPoints(temp3, A, B);
		Z.CreateGraphicWithDataPoints(temp4, A, B);
		Z.CreateGraphicWithArrays(test1, Color.BLUE);
		Z.CreateGraphicWithArrays(test2, Color.GREEN);
		Z.CreateGraphicWithArrays(test3, Color.YELLOW);
		Z.CreateGraphicWithArrays(test4, Color.BLACK);
		
		Z.ExecuteGraphic();
		
		System.out.print("The End.");
	    String bla = br.readLine();
	}
}
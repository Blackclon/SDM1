package Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


import Generator.*;

public class MainClass {

	public static void main(String[] args) throws IOException
	{

		InputStreamReader isr = new InputStreamReader(System.in);
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
	    
	    if(numCluster > numData/2  || Xmax < numData/2)
	    {
	    	System.out.print("Wrong input data, please restart programm!");
	    	System.exit(0);
	    }
	    
		DataGenerator.getInstance().Init(numCluster, numData, Xmax, dim);
		
	}
	
}
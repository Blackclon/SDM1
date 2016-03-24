package Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import Generator.*;

public class MainClass {

	public static void main(String[] args) throws IOException
	{

		InputStreamReader isr = new InputStreamReader(System.in);
	    BufferedReader br = new BufferedReader(isr);
	    System.out.print("Number of Cluster: ");
	    String eingabe = br.readLine();
	    int numCluster = Integer.parseInt(eingabe);
	    
	    System.out.print("Number of Data Points: ");
	    String eingabe2 = br.readLine();
	    int numData = Integer.parseInt(eingabe2);
	    
	    System.out.print("Enter X max: ");
	    String eingabe3 = br.readLine();
	    int Xmax = Integer.parseInt(eingabe3);
	    
	    
		DataGenerator.getInstance().Init(numCluster, numData, Xmax);
		
	}
	
}
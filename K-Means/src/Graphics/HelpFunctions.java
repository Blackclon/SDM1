package Graphics;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import Generator.Cluster;
import Generator.DataPoint;

public class HelpFunctions {

	public static void txtOutput(List<Cluster> Input, String filename) throws IOException
	{
		for(int i=0;i<Input.size();i++)
		{
			File file = new File(filename+"_CLuster"+i);
	        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
	        List<DataPoint> tempPointList=Input.get(i).DataInCluster();
	        for(int j=0;j<tempPointList.size();j++)
	        {
	        	double[] temp_dArray = tempPointList.get(j).getData();
	        	for(int k=0;k<temp_dArray.length;k++)
	        	{
	        		writer.write(temp_dArray[k]+", ");
	        	}
		        writer.write("\n");
	        }
	        writer.close();
		}
	}
}

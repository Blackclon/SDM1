package Generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DataGenerator {

	//Singleton
	private static DataGenerator instance;
	private DataGenerator(){}
	public static DataGenerator getInstance () 
	{
	    if (DataGenerator.instance == null) 
	    {
	    	DataGenerator.instance = new DataGenerator();
	    }
	    return DataGenerator.instance;
	}
	
	private int Num_DataPoints;
	private int Num_Cluster;
	private int x_max;
	private List<DataPoint> DataPoints = new ArrayList<DataPoint>();
	private List<Cluster> AllCluster = new ArrayList<Cluster>();
	
	public void Init(int numCluster, int numDataPoints, int xmax, int Dim)
	{
		Num_DataPoints = numDataPoints;
		Num_Cluster = numCluster;
		x_max = xmax;
		CreateClusters();
		CreateData(Dim);
		FillDataPoints();
	}
	
	private void CreateClusters()
	{
		int average_Num_Points = 0;
		int count = 0;
		Random RandomGenerator = new Random();
		
		average_Num_Points = Num_DataPoints/Num_Cluster;
		
		int max_diff = average_Num_Points/2;
		for(int i = 0;i<Num_Cluster/2;i++)
		{
			int random = RandomGenerator.nextInt(max_diff);
			AllCluster.add(new Cluster(average_Num_Points-random));
			AllCluster.add(new Cluster(average_Num_Points+random));
			count = count + (average_Num_Points-random) + (average_Num_Points+random);
			
		}
		if((Num_Cluster%2)==1)		//if Num_Clusters is odd
		{
			count += average_Num_Points;
			AllCluster.add(new Cluster(average_Num_Points));
		}
		if(count != Num_DataPoints)
		{
			int temp = AllCluster.get(0).getNum_DataPoints();
			for(int h = 0; h < Num_DataPoints - count; h++ )
			{
				AllCluster.get(0).setNum_DataPoints(++temp);
			}
		}
	}
	
	private void CreateData(int dim)
	{
		boolean chaos = false;
		Random RandomGenerator = new Random();
		double factor = x_max/(Num_Cluster *3.0);
		for(int i = 0; i < Num_Cluster; i++)
		{
			//Meanvalues
			
			double[] random = new double[dim];
			double[] variation = new double[dim];
			for(int k = 0; k < dim; k++)
			{
				random[k] = RandomGenerator.nextInt(x_max);
				variation[k] = RandomGenerator.nextInt((int)factor) + 1;
			}
			for(int l = 0; l < dim; l++)
			{
				if(random[l] < 3 * factor){chaos = true; break;}
				if(random[l] > x_max - (3 * factor)){chaos = true; break;}
				
			}
			if(chaos == true)
			{
				chaos = false;
				i=i-1;
				continue;
			}
			
			
			for(int j = 0; j < AllCluster.get(i).getNum_DataPoints(); j++)
			{
				AllCluster.get(i).add_Point(new DataPoint(random,variation, dim));
			}
		}
		//System.out.println(count);
	}

	private void FillDataPoints() {
		for(int i = 0;i<Num_Cluster;i++)
		{
			for(int j=0; j<AllCluster.get(i).getNum_DataPoints();j++)
			{
				DataPoints.add(AllCluster.get(i).DataInCluster().get(j));
				

			}
		}
	}
	
	public List<DataPoint> getDataPoints() {
		return DataPoints;
	}
	public int getNum_Cluster() {
		return Num_Cluster;
	}
	public int getNum_DataPoints() {
		return Num_DataPoints;
	}
	public List<Cluster> getAllCluster() {
		return AllCluster;
	}
}

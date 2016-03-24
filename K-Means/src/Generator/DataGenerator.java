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
	private List<Cluster> AllClutser = new ArrayList<Cluster>();
	
	public void Init(int numCluster, int numDataPoints, int xmax)
	{
		Num_DataPoints = numDataPoints;
		Num_Cluster = numCluster;
		x_max = xmax;
		CreateClusters();
		CreateData();
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
			AllClutser.add(new Cluster(average_Num_Points-random));
			AllClutser.add(new Cluster(average_Num_Points+random));
			count = count + (average_Num_Points-random) + (average_Num_Points+random);
		}
		if((Num_Cluster%2)==1)		//if Num_Clusters is odd
		{
			count += average_Num_Points;
			if(count != Num_DataPoints)
			{
				AllClutser.add(new Cluster(average_Num_Points + (Num_DataPoints-count)));
			}
			else
			{
				AllClutser.add(new Cluster(average_Num_Points));
			}
		}
	}
	
	private void CreateData()
	{
		Random RandomGenerator = new Random();
		for(int i = 0; i < Num_Cluster; i++)
		{
			//Meanvalues
			int randomX = RandomGenerator.nextInt(x_max);
			int randomY = RandomGenerator.nextInt(x_max);
			
			if(randomX < 10){i=i-1;continue;}
			
			if(randomY < 10){i=i-1;continue;}
			
			for(int j = 0; j < AllClutser.get(i).getNum_DataPoints(); j++)
			{
				AllClutser.get(i).add_Point(new DataPoint((double)randomX, (double)randomY));
			}
		}
	}

	private void FillDataPoints() {
		for(int i = 0;i<AllClutser.size();i++)
		{
			for(int j=0; j<AllClutser.get(i).getNum_DataPoints();j++)
			{
				DataPoints.add(AllClutser.get(i).DataInCluster().get(j));
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
	public List<Cluster> getAllClutser() {
		return AllClutser;
	}
}

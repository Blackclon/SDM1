package Generator;

import java.util.*;

public class DataGenerator {

	private int x_max = 1000;
	private int Num_Clusters;
	private int Num_DataPoints;
	private List<Cluster> Clusters = new ArrayList<Cluster>();
	
	DataGenerator(int _Num_Clusters, int _Num_DataPoints)
	{
		Num_Clusters = _Num_Clusters;
		Num_DataPoints = _Num_DataPoints;
	}
	
	public void CreateClusters()
	{
		Random RandomGenerator = new Random();
		int average_Num_Points = Num_DataPoints/Num_Clusters;
		int max_diff = average_Num_Points/2;
		for(int i = 0;i<Num_Clusters/2;i++)
		{
			int random = RandomGenerator.nextInt(max_diff);
			Clusters.add(new Cluster(average_Num_Points-random));
			Clusters.add(new Cluster(average_Num_Points+random));
		}
		if((Num_Clusters%2)==1)		//if Num_Clusters is odd
		{
			Clusters.add(new Cluster(average_Num_Points));
		}
		
		//test
		System.out.println();
	}
}

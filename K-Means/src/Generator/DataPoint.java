package Generator;

public class DataPoint {

	private double[] Values;
	
	public DataPoint(double[] _Values)
	{
		Values = _Values;
	}
	
	double[] get_Values(){return Values;}
	void set_Values(double[] _Values){Values = _Values;}
}

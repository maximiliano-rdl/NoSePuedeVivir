package clima;

public class RangoTemperaturas {
	private int maximo;
	private int minimo;

	public RangoTemperaturas(int minimo, int maximo) {
		super();
		this.maximo = maximo;
		this.minimo = minimo;
	}
	
	public int getMaximo()
	{
		return maximo;
	}
	
	public int getMinimo()
	{
		return minimo;
	}

	public void setMaximo(int max)
	{
		maximo = max;
	}
	
	public void setMinimo(int min)
	{
		minimo = min;
	}
	
}

package clima;

import java.util.ArrayList;

public class Lugar {
	
	public static final int IGUAL = 0;
	public static final int MASHOSTIL = 1;
	public static final int MENOSHOSTIL = -1;
	public static final int NOCOMPARABLE = -2;
	
	private int noComparable;
	private int hostil;
	private int numero;
	private RangoTemperaturas extremos;
	ArrayList<RangoTemperaturas> listadoTemp;

	public Lugar(int numero) {
		super();
		this.noComparable = 0;
		this.setHostil(0);
		this.numero = numero;
		this.listadoTemp = new ArrayList<RangoTemperaturas>();
	}

	public void agregarTemperatura(RangoTemperaturas temp) {
		listadoTemp.add(temp);
		if (listadoTemp.size() == 1) {
			extremos = temp;
		} else {
			if (extremos.getMaximo() < temp.getMaximo())
				extremos.setMaximo(temp.getMaximo());
			if (extremos.getMinimo() > temp.getMinimo())
				extremos.setMinimo(temp.getMinimo());
		}
	}

	public int comparar(Lugar other) {
		if (other.extremos.getMaximo() == this.extremos.getMaximo()
				&& other.extremos.getMinimo() == this.extremos.getMinimo())
			return IGUAL;
		if (other.extremos.getMaximo() > this.extremos.getMaximo()
				&& other.extremos.getMinimo() < this.extremos.getMinimo())
			return MENOSHOSTIL;
		if (other.extremos.getMaximo() < this.extremos.getMaximo()
				&& other.extremos.getMinimo() > this.extremos.getMinimo())
			return MASHOSTIL;
		return NOCOMPARABLE;
	}
	
	public void incrementarNoComp()
	{
		noComparable++;
	}
	
	public void incrementarHostil()
	{
		hostil++;
	}
	
	public int getNoComparable()
	{
		return noComparable;
	}

	public int getHostil() {
		return hostil;
	}

	public void setHostil(int hostil) {
		this.hostil = hostil;
	}
}

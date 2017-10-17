package clima;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Clima {

	private Scanner sc;
	private PrintWriter writer;

	public Clima() {
		try {
			sc = new Scanner(new File("Clima.in"));
		} catch (FileNotFoundException e) {
			System.out.println("No se pudo encontrer el archivo");
			e.printStackTrace();
		}

		try {
			writer = new PrintWriter(new FileWriter("Clima.out"));
		} catch (IOException e) {
			System.out.println("No se pudo crear el archivo de salida");
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		Clima clima = new Clima();
		int cantLugares = clima.sc.nextInt();
		Lugar[] lugares = new Lugar[cantLugares];

		// cargo los lugares en el vector "lugares" junto con sus temperaturas
		for (int i = 0; i < cantLugares; i++) {
			Lugar l = new Lugar(i);
			int cantTemp = clima.sc.nextInt();
			for (int j = 0; j < cantTemp; j++) {
				RangoTemperaturas t = new RangoTemperaturas(clima.sc.nextInt(), clima.sc.nextInt());
				l.agregarTemperatura(t);
			}
			lugares[i] = l;
		}
		clima.sc.close();

		int res;

		for (int i = 0; i < cantLugares - 1; i++) {
			for (int j = i + 1; j < cantLugares; j++) {
				res = lugares[i].comparar(lugares[j]);

				switch (res) {
				case Lugar.MASHOSTIL:
					lugares[i].incrementarHostil();
					break;
				case Lugar.MENOSHOSTIL:
					lugares[j].incrementarHostil();
					break;
				case Lugar.NOCOMPARABLE:
					lugares[i].incrementarNoComp();
					lugares[j].incrementarNoComp();
					break;
				}
			}

		}

		// busco el mayor/los mayores
		int mayor = lugares[0].getHostil();

		for (int i = 0; i < cantLugares; i++) {
			if (mayor < lugares[i].getHostil())
				mayor = lugares[i].getHostil();
		}

		// muestro los mayores

		for (int i = 0; i < cantLugares; i++) {
			if (lugares[i].getHostil() == mayor)
				// System.out.println(i + 1 + " " + lugares[i].getNoComparable());
				clima.writer.println(i + 1 + " " + lugares[i].getNoComparable());
		}

		clima.writer.close();

	}

}

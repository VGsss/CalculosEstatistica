package calculos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class Calculos {

	@SuppressWarnings("serial")
	public static void main(String[] args) {

		System.out.println(distribuicaoFreq(new ArrayList<Double>(4) {
			{
				add(324.0);
				add(324.0);
				
				add(325.0);
				
				add(326.0);
				add(326.0);
				add(326.0);
				add(326.0);
				
				add(327.0);
				add(327.0);
				add(327.0);
				
				add(328.0);
				add(328.0);
				add(328.0);
				add(328.0);
				add(328.0);
				add(328.0);
				
				add(329.0);
				add(329.0);
				
				add(330.0);
				add(330.0);
			}
		}).size());//.forEach((k,v) -> System.out.println("key: "+k+" value:"+v));;

		
		
		
	}

	public int numeroClasses(int numerodeelementos) {
		return (int) (1 + 3.3 * (Math.log(numerodeelementos)));
	}
	
	public int amplitudeClasses(double max,double min, int numLinhas){
		return (int) (numLinhas != 0 ? (max - min)/numLinhas: 0) ;   //se numLinhas for 0 retornar 0
	}
	

	public static double media(double[] elementos) {
		double soma = 0;
		for (int i = 0; i < elementos.length; i++) soma += elementos[i];
		return soma / elementos.length;
	}

	public static int media(int[] elementos) {
		int soma = 0;
		for (int i = 0; i < elementos.length; i++) soma += elementos[i];
		return (int) soma / elementos.length;
	}

	public static double mediana(double[] elementos) {
		int meio = elementos.length / 2;
		if (elementos.length % 2 == 1) {
			return elementos[meio];
		} else {
			return (elementos[meio - 1] + elementos[meio]) / 2.0;
		}
	}

	public static int moda(int a[]) {
		int maxValue = 0, maxCount = 0;

		for (int i = 0; i < a.length; ++i) {
			int count = 0;
			for (int j = 0; j < a.length; ++j) {
				if (a[j] == a[i])
					++count;
			}
			if (count > maxCount) {
				maxCount = count;
				maxValue = a[i];
			}
		}

		return maxValue;
	}

	@SuppressWarnings("serial")
	public static LinkedHashMap<Double, ArrayList<Double>> distribuicaoFreq(ArrayList<Double> elementos) {
		LinkedHashMap<Double, ArrayList<Double>> saida = new LinkedHashMap<Double, ArrayList<Double>>();
		Collections.sort(elementos);
		ArrayList<Double> existentes = new ArrayList<>();

		// Dicionario
		// valor = valor utilizado ( diametro, idade, etc)
		// valor[0] = fi (Nº de vezes que aparece)
		// valor[1] = Fi/Fac ( Nº de vezes que aparece acumulado)
		// valor[2] = fri (Porcentagem do valor em relação ao somatório de
		// elementos de fi)

		// Preenche fi
		for (double elemento : elementos) {

			if (!existentes.contains(elemento)) {
				saida.put(elemento, new ArrayList<Double>(4) {
					{
						add(1.0);
						add(0.0);
						add(0.0);
						add(0.0);
					}
				});
				existentes.add(elemento);
			} else {
				saida.get(elemento).set(0, saida.get(elemento).get(0) + 1.0);
			}
		}

		if (saida.size > 8){
			
		}
		
		
		// Preenche Fi

		Iterator<ArrayList<Double>> it = saida.values().iterator();
		int anterior = 0;

		while (it.hasNext()) {
			ArrayList<Double> atual = it.next();

			if (anterior == 0) {
				atual.set(1, atual.get(0));
				anterior = atual.get(1).intValue();
			}
			else{
				atual.set(1, atual.get(0) + anterior);
				anterior = (int) (atual.get(0) + anterior);
			}
		}
		
		int efi = anterior;
		
		//Preenche fri
		
		it = saida.values().iterator();
		while (it.hasNext()) {
			ArrayList<Double> atual = it.next();
			atual.set(2, atual.get(0)/efi);
		}
		
		//Preenche Fri
		
		double anteriord = 0.0;
		it = saida.values().iterator();
		while (it.hasNext()) {
			ArrayList<Double> atual = it.next();

			if (anteriord == 0.0) {
				atual.set(3, atual.get(2));
				anteriord = atual.get(3);
			}
			else{
				atual.set(3, atual.get(2) + anteriord);
				anteriord = (atual.get(2) + anteriord);
			}
		}
		return saida;
	}

}

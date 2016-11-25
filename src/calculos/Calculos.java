package calculos;

//Feito por Rafael Bernardes Rodrigues - vg_rafael2@hotmail.com
//Se isso um dia gerar dinheiro para alguém, quero metade.
//Usar a vontade caso ajude outras pessoas.

//Made by Rafael Bernardes Rodrigues - vg_rafael@hotmail.com
//If anyone earns any money with this code, I wanna half.
//You can use freely if you help others with this code.

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;

import test.CalculosTest;

public class Calculos {

	public static void main(String[] args) {
		CalculosTest.testarTudo();
	}

	public int numeroClasses(int numerodeelementos) {
		return (int) (1 + 3.3 * (Math.log(numerodeelementos)));
	}

	public int amplitudeClasses(double max, double min, int numLinhas) {
		return (int) (numLinhas != 0 ? (max - min) / numLinhas : 0);
	}

	public static double media(double[] elementos) {
		double soma = 0;
		for (int i = 0; i < elementos.length; i++)
			soma += elementos[i];
		return soma / elementos.length;
	}

	public static int media(int[] elementos) {
		int soma = 0;
		for (int i = 0; i < elementos.length; i++)
			soma += elementos[i];
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

		if (saida.size() > 8) {

		}

		// Preenche Fi

		Iterator<ArrayList<Double>> it = saida.values().iterator();
		int anterior = 0;

		while (it.hasNext()) {
			ArrayList<Double> atual = it.next();

			if (anterior == 0) {
				atual.set(1, atual.get(0));
				anterior = atual.get(1).intValue();
			} else {
				atual.set(1, atual.get(0) + anterior);
				anterior = (int) (atual.get(0) + anterior);
			}
		}

		int efi = anterior;

		// Preenche fri

		it = saida.values().iterator();
		while (it.hasNext()) {
			ArrayList<Double> atual = it.next();
			atual.set(2, atual.get(0) / efi);
		}

		// Preenche Fri

		double anteriord = 0.0;
		it = saida.values().iterator();
		while (it.hasNext()) {
			ArrayList<Double> atual = it.next();

			if (anteriord == 0.0) {
				atual.set(3, atual.get(2));
				anteriord = atual.get(3);
			} else {
				atual.set(3, atual.get(2) + anteriord);
				anteriord = (atual.get(2) + anteriord);
			}
		}
		return saida;
	}

	public static int fatorial(int num) {
		return num <= 1 ? 1 : fatorial(num - 1) * num;
	}

	public static int totalAmostras(int n, int p) {
		return fatorial(n) / (fatorial(p) * fatorial(n - p));
	}

	public static double variancaAmostral(double somatorio, int qtdeElementos) {
		return somatorio / (qtdeElementos - 1);
	}

	public static double desvioPadraoAmostral(double somatorio, int qtdeElementos) {
		return Math.sqrt(somatorio / (qtdeElementos - 1));
	}

	public static double desvioPadrao(int desvio, int tamanho) {
		return desvio / Math.sqrt(tamanho);
	}

	public static double tabelaDistribuicaoNormalAcumulada(double valor) {

		double tabelaDistNA[][] = { { 0.5000, 0.5040, 0.5080, 0.5120, 0.5160, 0.5199, 0.5239, 0.5279, 0.5319, 0.5359 },
				{ 0.5398, 0.5438, 0.5478, 0.5517, 0.5557, 0.5596, 0.5636, 0.5675, 0.5714, 0.5753 },
				{ 0.5793, 0.5832, 0.5871, 0.5910, 0.5948, 0.5987, 0.6026, 0.6064, 0.6103, 0.6141 },
				{ 0.6179, 0.6217, 0.6255, 0.6293, 0.6331, 0.6368, 0.6406, 0.6443, 0.6480, 0.6517 },
				{ 0.6554, 0.6591, 0.6628, 0.6664, 0.6700, 0.6736, 0.6772, 0.6808, 0.6844, 0.6879 },
				{ 0.6915, 0.6950, 0.6985, 0.7019, 0.7054, 0.7088, 0.7123, 0.7157, 0.7190, 0.7224 },
				{ 0.7257, 0.7291, 0.7324, 0.7357, 0.7389, 0.7422, 0.7454, 0.7486, 0.7517, 0.7549 },
				{ 0.7580, 0.7611, 0.7642, 0.7673, 0.7704, 0.7734, 0.7764, 0.7794, 0.7823, 0.7852 },
				{ 0.7881, 0.7910, 0.7939, 0.7967, 0.7995, 0.8023, 0.8051, 0.8078, 0.8106, 0.8133 },
				{ 0.8159, 0.8186, 0.8212, 0.8238, 0.8264, 0.8289, 0.8315, 0.8340, 0.8365, 0.8389 },
				{ 0.8413, 0.8438, 0.8461, 0.8485, 0.8508, 0.8531, 0.8554, 0.8577, 0.8599, 0.8621 },
				{ 0.8643, 0.8665, 0.8686, 0.8708, 0.8729, 0.8749, 0.8770, 0.8790, 0.8810, 0.8830 },
				{ 0.8849, 0.8869, 0.8888, 0.8907, 0.8925, 0.8944, 0.8962, 0.8980, 0.8997, 0.9015 },
				{ 0.9032, 0.9049, 0.9066, 0.9082, 0.9099, 0.9115, 0.9131, 0.9147, 0.9162, 0.9177 },
				{ 0.9192, 0.9207, 0.9222, 0.9236, 0.9251, 0.9265, 0.9279, 0.9292, 0.9306, 0.9319 },
				{ 0.9332, 0.9345, 0.9357, 0.9370, 0.9382, 0.9394, 0.9406, 0.9418, 0.9429, 0.9441 },
				{ 0.9452, 0.9463, 0.9474, 0.9484, 0.9495, 0.9505, 0.9515, 0.9525, 0.9535, 0.9545 },
				{ 0.9554, 0.9564, 0.9573, 0.9582, 0.9591, 0.9599, 0.9608, 0.9616, 0.9625, 0.9633 },
				{ 0.9641, 0.9649, 0.9656, 0.9664, 0.9671, 0.9678, 0.9686, 0.9693, 0.9699, 0.9706 },
				{ 0.9713, 0.9719, 0.9726, 0.9732, 0.9738, 0.9744, 0.9750, 0.9756, 0.9761, 0.9767 },
				{ 0.9772, 0.9778, 0.9783, 0.9788, 0.9793, 0.9798, 0.9803, 0.9808, 0.9812, 0.9817 },
				{ 0.9821, 0.9826, 0.9830, 0.9834, 0.9838, 0.9842, 0.9846, 0.9850, 0.9854, 0.9857 },
				{ 0.9861, 0.9864, 0.9868, 0.9871, 0.9875, 0.9878, 0.9881, 0.9884, 0.9887, 0.9890 },
				{ 0.9893, 0.9896, 0.9898, 0.9901, 0.9904, 0.9906, 0.9909, 0.9911, 0.9913, 0.9916 },
				{ 0.9918, 0.9920, 0.9922, 0.9925, 0.9927, 0.9929, 0.9931, 0.9932, 0.9934, 0.9936 },
				{ 0.9938, 0.9940, 0.9941, 0.9943, 0.9945, 0.9946, 0.9948, 0.9949, 0.9951, 0.9952 },
				{ 0.9953, 0.9955, 0.9956, 0.9957, 0.9959, 0.9960, 0.9961, 0.9962, 0.9963, 0.9964 },
				{ 0.9965, 0.9966, 0.9967, 0.9968, 0.9969, 0.9970, 0.9971, 0.9972, 0.9973, 0.9974 },
				{ 0.9974, 0.9975, 0.9976, 0.9977, 0.9977, 0.9978, 0.9979, 0.9979, 0.9980, 0.9981 },
				{ 0.9981, 0.9982, 0.9982, 0.9983, 0.9984, 0.9984, 0.9985, 0.9985, 0.9986, 0.9986 },
				{ 0.9987, 0.9987, 0.9987, 0.9988, 0.9988, 0.9989, 0.9989, 0.9989, 0.9990, 0.9990 },
				{ 0.9990, 0.9991, 0.9991, 0.9991, 0.9992, 0.9992, 0.9992, 0.9992, 0.9993, 0.9993 },
				{ 0.9993, 0.9993, 0.9994, 0.9994, 0.9994, 0.9994, 0.9994, 0.9995, 0.9995, 0.9995 },
				{ 0.9995, 0.9995, 0.9995, 0.9996, 0.9996, 0.9996, 0.9996, 0.9996, 0.9996, 0.9997 },
				{ 0.9997, 0.9997, 0.9997, 0.9997, 0.9997, 0.9997, 0.9997, 0.9997, 0.9997, 0.9998 },
				{ 0.9998, 0.9998, 0.9998, 0.9998, 0.9998, 0.9998, 0.9998, 0.9998, 0.9998, 0.9998 },
				{ 0.9998, 0.9998, 0.9998, 0.9998, 0.9998, 0.9998, 0.9998, 0.9998, 0.9998, 0.9998 },
				{ 0.9998, 0.9998, 0.9999, 0.9999, 0.9999, 0.9999, 0.9999, 0.9999, 0.9999, 0.9999 },
				{ 0.9999, 0.9999, 0.9999, 0.9999, 0.9999, 0.9999, 0.9999, 0.9999, 0.9999, 0.9999 },
				{ 0.9999, 0.9999, 0.9999, 0.9999, 0.9999, 0.9999, 0.9999, 0.9999, 0.9999, 0.9999 },
				{ 1.0000, 1.0000, 1.0000, 1.0000, 1.0000, 1.0000, 1.0000, 1.0000, 1.0000, 1.0000 } };

		BigDecimal busca = new BigDecimal(valor);
		busca = busca.setScale(2, BigDecimal.ROUND_HALF_UP);
		int posicao = (int) (100 * busca.doubleValue()); // Gambiarra da
															// disgraçaaaaaaaaa

		return tabelaDistNA[posicao / 10][posicao % 10];
	}

	public static double tabelaDistribuicaoNormal(double valor) {

		double tabelaDistN[][] = {
				{ 0.00000, 0.00399, 0.00798, 0.01197, 0.01595, 0.01994, 0.02392, 0.02790, 0.03188, 0.03586 },
				{ 0.03983, 0.04380, 0.04776, 0.05172, 0.05567, 0.05962, 0.06356, 0.06749, 0.07142, 0.07535 },
				{ 0.07926, 0.08317, 0.08706, 0.09095, 0.09483, 0.09871, 0.10257, 0.10642, 0.11026, 0.11409 },
				{ 0.11791, 0.12172, 0.12552, 0.12930, 0.13307, 0.13683, 0.14058, 0.14431, 0.14803, 0.15173 },
				{ 0.15542, 0.15910, 0.16276, 0.16640, 0.17003, 0.17364, 0.17724, 0.18082, 0.18439, 0.18793 },
				{ 0.19146, 0.19497, 0.19847, 0.20194, 0.20540, 0.20884, 0.21226, 0.21566, 0.21904, 0.22240 },
				{ 0.22575, 0.22907, 0.23237, 0.23565, 0.23891, 0.24215, 0.24537, 0.24857, 0.25175, 0.25490 },
				{ 0.25804, 0.26115, 0.26424, 0.26730, 0.27035, 0.27337, 0.27637, 0.27935, 0.28230, 0.28524 },
				{ 0.28814, 0.29103, 0.29389, 0.29673, 0.29955, 0.30234, 0.30511, 0.30785, 0.31057, 0.31327 },
				{ 0.31594, 0.31859, 0.32121, 0.32381, 0.32639, 0.32894, 0.33147, 0.33398, 0.33646, 0.33891 },
				{ 0.34134, 0.34375, 0.34614, 0.34849, 0.35083, 0.35314, 0.35543, 0.35769, 0.35993, 0.36214 },
				{ 0.36433, 0.36650, 0.36864, 0.37076, 0.37286, 0.37493, 0.37698, 0.37900, 0.38100, 0.38298 },
				{ 0.38493, 0.38686, 0.38877, 0.39065, 0.39251, 0.39435, 0.39617, 0.39796, 0.39973, 0.40147 },
				{ 0.40320, 0.40490, 0.40658, 0.40824, 0.40988, 0.41149, 0.41309, 0.41466, 0.41621, 0.41774 },
				{ 0.41924, 0.42073, 0.42220, 0.42364, 0.42507, 0.42647, 0.42785, 0.42922, 0.43056, 0.43189 },
				{ 0.43319, 0.43448, 0.43574, 0.43699, 0.43822, 0.43943, 0.44062, 0.44179, 0.44295, 0.44408 },
				{ 0.44520, 0.44630, 0.44738, 0.44845, 0.44950, 0.45053, 0.45154, 0.45254, 0.45352, 0.45449 },
				{ 0.45543, 0.45637, 0.45728, 0.45818, 0.45907, 0.45994, 0.46080, 0.46164, 0.46246, 0.46327 },
				{ 0.46407, 0.46485, 0.46562, 0.46638, 0.46712, 0.46784, 0.46856, 0.46926, 0.46995, 0.47062 },
				{ 0.47128, 0.47193, 0.47257, 0.47320, 0.47381, 0.47441, 0.47500, 0.47558, 0.47615, 0.47670 },
				{ 0.47725, 0.47778, 0.47831, 0.47882, 0.47932, 0.47982, 0.48030, 0.48077, 0.48124, 0.48169 },
				{ 0.48214, 0.48257, 0.48300, 0.48341, 0.48382, 0.48422, 0.48461, 0.48500, 0.48537, 0.48574 },
				{ 0.48610, 0.48645, 0.48679, 0.48713, 0.48745, 0.48778, 0.48809, 0.48840, 0.48870, 0.48899 },
				{ 0.48928, 0.48956, 0.48983, 0.49010, 0.49036, 0.49061, 0.49086, 0.49111, 0.49134, 0.49158 },
				{ 0.49180, 0.49202, 0.49224, 0.49245, 0.49266, 0.49286, 0.49305, 0.49324, 0.49343, 0.49361 },
				{ 0.49379, 0.49396, 0.49413, 0.49430, 0.49446, 0.49461, 0.49477, 0.49492, 0.49506, 0.49520 },
				{ 0.49534, 0.49547, 0.49560, 0.49573, 0.49585, 0.49598, 0.49609, 0.49621, 0.49632, 0.49643 },
				{ 0.49653, 0.49664, 0.49674, 0.49683, 0.49693, 0.49702, 0.49711, 0.49720, 0.49728, 0.49736 },
				{ 0.49744, 0.49752, 0.49760, 0.49767, 0.49774, 0.49781, 0.49788, 0.49795, 0.49801, 0.49807 },
				{ 0.49813, 0.49819, 0.49825, 0.49831, 0.49836, 0.49841, 0.49846, 0.49851, 0.49856, 0.49861 },
				{ 0.49865, 0.49869, 0.49874, 0.49878, 0.49882, 0.49886, 0.49889, 0.49893, 0.49896, 0.49900 },
				{ 0.49903, 0.49906, 0.49910, 0.49913, 0.49916, 0.49918, 0.49921, 0.49924, 0.49926, 0.49929 },
				{ 0.49931, 0.49934, 0.49936, 0.49938, 0.49940, 0.49942, 0.49944, 0.49946, 0.49948, 0.49950 },
				{ 0.49952, 0.49953, 0.49955, 0.49957, 0.49958, 0.49960, 0.49961, 0.49962, 0.49964, 0.49965 },
				{ 0.49966, 0.49968, 0.49969, 0.49970, 0.49971, 0.49972, 0.49973, 0.49974, 0.49975, 0.49976 },
				{ 0.49977, 0.49978, 0.49978, 0.49979, 0.49980, 0.49981, 0.49981, 0.49982, 0.49983, 0.49983 },
				{ 0.49984, 0.49985, 0.49985, 0.49986, 0.49986, 0.49987, 0.49987, 0.49988, 0.49988, 0.49989 },
				{ 0.49989, 0.49990, 0.49990, 0.49990, 0.49991, 0.49991, 0.49992, 0.49992, 0.49992, 0.49992 },
				{ 0.49993, 0.49993, 0.49993, 0.49994, 0.49994, 0.49994, 0.49994, 0.49995, 0.49995, 0.49995 },
				{ 0.49995, 0.49995, 0.49996, 0.49996, 0.49996, 0.49996, 0.49996, 0.49996, 0.49997, 0.49997 },
				{ 0.49997, 0.49997, 0.49997, 0.49997, 0.49997, 0.49997, 0.49998, 0.49998, 0.49998, 0.49998 } };

		BigDecimal busca = new BigDecimal(valor);
		busca = busca.setScale(2, BigDecimal.ROUND_HALF_UP);
		int posicao = (int) (100 * busca.doubleValue()); // Gambiarra da
															// disgraçaaaaaaaaa

		return tabelaDistN[posicao / 10][posicao % 10];
	}

	public static double probabilidade(int espacoAmostral, int evento) {
		if (evento == 0)
			return 0.0;
		if (evento == espacoAmostral)
			return 100.0;

		return evento / espacoAmostral;

	}

	public static ArrayList<Integer> uniaoProb(ArrayList<Integer> a, ArrayList<Integer> b) {
		ArrayList<Integer> saida = new ArrayList<>();
		for (int atualA : a) {
			if (!saida.contains(atualA))
				saida.add(atualA);
		}
		for (int atualB : b) {
			if (!saida.contains(atualB))
				saida.add(atualB);
		}

		return saida;
	}

	public static ArrayList<Integer> intersecProb(ArrayList<Integer> a, ArrayList<Integer> b) {
		ArrayList<Integer> saida = new ArrayList<>();
		for (int atualA : a) {
			if (b.contains(atualA) && b != null)
				saida.add(atualA);
		}
		return saida;
	}

	public static double distribuicaoBinominal(double probSucesso, double probFracasso, int nProvas,
			int nVezesDesejaOcorrer) {
		return (fatorial(nProvas) / (fatorial(nVezesDesejaOcorrer) * fatorial(nProvas - nVezesDesejaOcorrer)))
				* Math.pow(probSucesso, nVezesDesejaOcorrer) * Math.pow(probFracasso, (nProvas - nVezesDesejaOcorrer));
	}

	public static double distribuicaoPoisson(int nOcorrencias, double taxaUnidadeTempo, double numUnidadesTempo) {
		double mediaOcorrenciasintervalo = taxaUnidadeTempo * numUnidadesTempo;
		return Math.pow(Math.E, -mediaOcorrenciasintervalo) * Math.pow(mediaOcorrenciasintervalo, nOcorrencias)
				/ fatorial(nOcorrencias);
	}

	@SuppressWarnings("serial")
	public static LinkedHashMap<Double, ArrayList<Double>> correlaçãoLinearTabela(ArrayList<Double> elementosA,
			ArrayList<Double> elementosB) {
		LinkedHashMap<Double, ArrayList<Double>> saida = new LinkedHashMap<Double, ArrayList<Double>>();

		if (elementosA.size() != elementosB.size())
			return null;

		// Dicionario
		// index = Numero Identificador (gerado automaticamente)
		// valor[0] = valores a serem comparados (elementosA) Valores X
		// valor[1] = valores a serem comparados (elementosB) Valores Y
		// valor[2] = valor de X * Y
		// valor[3] = valor de X²
		// valor[4] = valor de Y²
		
		// ultimo index vai ser sempre o somatorio de todos seguindo essa ordem:
		// valor[0] = somatorio de X
		// valor[1] = somatorio de Y
		// valor[2] = somatorio de X * Y
		// valor[3] = somatorio de X²
		// valor[4] = somatorio de Y²

		// popular index e Valores X

		int i = 0; // ta aqui fora por frescura do java (mentira, é por que é o
					// que deu certo)
		for (double elemento : elementosA) {
			saida.put((double) i, new ArrayList<Double>(5) {
				{
					add(elemento);
					add(0.0);
					add(0.0);
					add(0.0);
					add(0.0);
				}
			});
			i++;
		}

		// popular Valores Y

		Iterator<ArrayList<Double>> it = saida.values().iterator();

		i = 0;
		while (it.hasNext()) {
			ArrayList<Double> atual = it.next();
			atual.set(1, elementosB.get(i));
			i++;
		}

		// calcula valores de X * Y, X² e Y²

		it = saida.values().iterator();
		while (it.hasNext()) {
			ArrayList<Double> atual = it.next();
			atual.set(2, atual.get(0) * atual.get(1));
			atual.set(3, Math.pow(atual.get(0), 2));
			atual.set(4, Math.pow(atual.get(1), 2));
		}

		// calcula os somatorios

		double somaX = 0.0;
		double somaY = 0.0;
		double somaXY = 0.0;
		double somaXquadrado = 0.0;
		double somaYquadrado = 0.0;

		it = saida.values().iterator();
		while (it.hasNext()) {
			ArrayList<Double> atual = it.next();
			somaX += atual.get(0);
			somaY += atual.get(1);
			somaXY += atual.get(2);
			somaXquadrado += atual.get(3);
			somaYquadrado += atual.get(4);
		}

		// Gambiarra pra resolver a treta:
		// Local variable X defined in an enclosing scope must be final or
		// effectively final

		final Double somaXfinal = new Double(somaX);
		final Double somaYfinal = new Double(somaY);
		final Double somaXYfinal = new Double(somaXY);
		final Double somaXquadradofinal = new Double(somaXquadrado);
		final Double somaYquadradofinal = new Double(somaYquadrado);

		saida.put((double) saida.size(), new ArrayList<Double>(5) {
			{
				add(somaXfinal);
				add(somaYfinal);
				add(somaXYfinal);
				add(somaXquadradofinal);
				add(somaYquadradofinal);
			}
		});

		return saida;
	}

	public static double correlacaoLinear(LinkedHashMap<Double, ArrayList<Double>> tabela) {
		int n = tabela.size() - 1;

		ArrayList<Double> ultimo = new ArrayList<Double>();

		Iterator<ArrayList<Double>> it = tabela.values().iterator();
		while (it.hasNext()) ultimo = it.next();
		
		double somaX = ultimo.get(0);
		double somaY = ultimo.get(1);
		double somaXY = ultimo.get(2);
		double somaXquadrado = ultimo.get(3);
		double somaYquadrado = ultimo.get(4);

		return (n * somaXY - somaX * somaY)
				/ Math.sqrt(((n * somaXquadrado) - Math.pow(somaX, 2)) * ((n * somaYquadrado) - Math.pow(somaY, 2)));
	}

	public static double correlacaoLinear(int n, double somaX, double somaY, double somaXY, double somaXquadrado,
			double somaYquadrado) {
		return (n * somaXY - somaX * somaY)
				/ Math.sqrt(((n * somaXquadrado) - Math.pow(somaX, 2)) * ((n * somaYquadrado) - Math.pow(somaY, 2)));
	}

	public static double[] regressaoLinear(LinkedHashMap<Double, ArrayList<Double>> tabela) {
		int n = tabela.size() - 1;

		ArrayList<Double> ultimo = new ArrayList<Double>();

		Iterator<ArrayList<Double>> it = tabela.values().iterator();
		while (it.hasNext()) ultimo = it.next();

		double somaX = ultimo.get(0);
		double somaY = ultimo.get(1);
		double somaXY = ultimo.get(2);
		double somaXquadrado = ultimo.get(3);

		double a = ((n * somaXY) - (somaX * somaY)) / ((n * somaXquadrado) - Math.pow(somaX, 2));

		double b = (somaY - (a * somaX)) / n;

		return new double[] { a, b };
	}

	public static double[] regressaoLinear(int n, double somaX, double somaY, double somaXY, double somaXquadrado) {

		double a = ((n * somaXY) - (somaX * somaY)) / ((n * somaXquadrado) - Math.pow(somaX, 2));
		double b = (somaY - (a * somaX)) / n;
		return new double[] { a, b };
	}

	public static double desvioPadraoEstimado(LinkedHashMap<Double, ArrayList<Double>> tabela) {
		int n = tabela.size() - 1;

		ArrayList<Double> ultimo = new ArrayList<Double>();

		Iterator<ArrayList<Double>> it = tabela.values().iterator();
		while (it.hasNext()) ultimo = it.next();
		
		double somaX = ultimo.get(0);
		double somaY = ultimo.get(1);
		double somaXY = ultimo.get(2);
		double somaXquadrado = ultimo.get(3);
		double somaYquadrado = ultimo.get(4);
		double a = (n * somaXY - somaX * somaY) / ((n * somaXquadrado) - Math.pow(somaX, 2));
		double b = (somaY - (a * somaX)) / n;
		return Math.sqrt(((somaYquadrado - (b * somaY)) - ((a * somaXY))) / (n - 2));
	}

	public static double desvioPadraoEstimado(int n, double somaX, double somaY, double somaXY, double somaXquadrado,
			double somaYquadrado) {
		double[] rl = regressaoLinear(n, somaX, somaY, somaXY, somaXquadrado);

		return Math.sqrt(((somaYquadrado - (rl[1] * somaY)) - ((rl[0] * somaXY))) / (n - 2));
	}
	
	public static double estatisticaTestePadronizada(double mediaHipo, double mediaAmostral, double desvioPadraoAmostra, double vezesTestado){
		
		return ((mediaAmostral - mediaHipo)/ (desvioPadraoAmostra / (Math.sqrt(vezesTestado))));
	}
	
	
	

}

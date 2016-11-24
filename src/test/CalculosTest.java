package test;

import java.util.ArrayList;

import calculos.Calculos;

@SuppressWarnings("serial")
public class CalculosTest {

	public static void testarTudo() {

		System.out.println("Teste para Distribui��o de Frequencias: ");
		Calculos.distribuicaoFreq(new ArrayList<Double>() {
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
		}).forEach((k, v) -> System.out.println("key: " + k + " value:" + v));

		System.out.println(
				"\nTeste da Tabela de Distribuicao para o numero 0,22 : " + Calculos.tabelaDistribuicaoNormal(0.22));

		System.out.println("\nTeste Uni�o para {1,2,3,4} e {2,4,5} : " + Calculos.uniaoProb(new ArrayList<Integer>() {
			{
				add(1);
				add(2);
				add(3);
				add(4);
			}
		}, new ArrayList<Integer>() {
			{
				add(2);
				add(4);
				add(5);
			}
		}));

		System.out.println(
				"\nTeste Intersec��o para {1,2,3,4} e {2,4,5} : " + Calculos.intersecProb(new ArrayList<Integer>() {
					{
						add(1);
						add(2);
						add(3);
						add(4);
					}
				}, new ArrayList<Integer>() {
					{
						add(2);
						add(4);
						add(5);
					}
				}));

		System.out.println("\nTeste distribui��o Binominal com valores N=5, K=3, P=0.5, Q=0,5 : "
				+ Calculos.distribuicaoBinominal(0.5, 0.5, 5, 3));

		System.out.println("\nTeste distribui��o de Poisson com valores X = 3, Lambda = 1, t = 4 : "
				+ Calculos.distribuicaoPoisson(3, 1, 4));

		System.out.println("\nTeste para Correla��o Linear Tabela: ");
		Calculos.correla��oLinearTabela(new ArrayList<Double>() {
			{
				add(5.0);
				add(8.0);
				add(7.0);
				add(10.0);
				add(6.0);
				add(7.0);
				add(9.0);
				add(3.0);
				add(8.0);
				add(2.0);
			}
		}, new ArrayList<Double>() {
			{
				add(6.0);
				add(9.0);
				add(8.0);
				add(10.0);
				add(5.0);
				add(7.0);
				add(8.0);
				add(4.0);
				add(6.0);
				add(2.0);
			}
		}).forEach((k, v) -> System.out.println("key: " + k + " value:" + v));

		System.out.println("\nTeste para Correla��o Linear: ");
		System.out.println(Calculos.correlacaoLinear(Calculos.correla��oLinearTabela(new ArrayList<Double>() {
			{
				add(5.0);
				add(8.0);
				add(7.0);
				add(10.0);
				add(6.0);
				add(7.0);
				add(9.0);
				add(3.0);
				add(8.0);
				add(2.0);
			}
		}, new ArrayList<Double>() {
			{
				add(6.0);
				add(9.0);
				add(8.0);
				add(10.0);
				add(5.0);
				add(7.0);
				add(8.0);
				add(4.0);
				add(6.0);
				add(2.0);
			}
		})));
		
		System.out.println("\nTeste para Regress�o Linear: ");
		System.out.println(Calculos.regressaoLinear(Calculos.correla��oLinearTabela(new ArrayList<Double>() {
			{
				add(1.0);
				add(2.0);
				add(3.0);
				add(4.0);
				add(5.0);
			}
		}, new ArrayList<Double>() {
			{
				add(1.0);
				add(2.0);
				add(4.0);
				add(5.0);
				add(8.0);
			}
		})));
		
		System.out.println("\nTeste para Desvio Padr�o Estimado: ");
		System.out.println(Calculos.desvioPadraoEstimado(Calculos.correla��oLinearTabela(new ArrayList<Double>() {
			{
				add(1.0);
				add(2.0);
				add(3.0);
				add(4.0);
				add(5.0);
			}
		}, new ArrayList<Double>() {
			{
				add(1.0);
				add(2.0);
				add(4.0);
				add(5.0);
				add(8.0);
			}
		})));
		
		
	}

}

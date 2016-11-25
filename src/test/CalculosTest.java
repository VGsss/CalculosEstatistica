package test;

import java.util.ArrayList;

import calculos.Calculos;

@SuppressWarnings("serial")
public class CalculosTest {

	public static void testarTudo() {

		System.out.println("Teste para Distribuição de Frequencias: ");
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

		System.out.println("\nTeste União para {1,2,3,4} e {2,4,5} : " + Calculos.uniaoProb(new ArrayList<Integer>() {
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
				"\nTeste Intersecção para {1,2,3,4} e {2,4,5} : " + Calculos.intersecProb(new ArrayList<Integer>() {
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

		System.out.println("\nTeste distribuição Binominal com valores N=5, K=3, P=0.5, Q=0,5 : "
				+ Calculos.distribuicaoBinominal(0.5, 0.5, 5, 3));

		System.out.println("\nTeste distribuição de Poisson com valores X = 3, Lambda = 1, t = 4 : "
				+ Calculos.distribuicaoPoisson(3, 1, 4));

		
		ArrayList<Double> listaAtesteCL = new ArrayList<Double>() {
			{
				add(1.0);
				add(2.0);
				add(3.0);
				add(4.0);
				add(5.0);
			}
		};
		
		
		ArrayList<Double> listaBtesteCL = new ArrayList<Double>() {
			{
				add(1.0);
				add(2.0);
				add(4.0);
				add(5.0);
				add(8.0);
			}
		};

		System.out.println("\nTeste para Correlação Linear Tabela: ");
		Calculos.correlaçãoLinearTabela(listaAtesteCL ,listaBtesteCL ).forEach((k, v) -> System.out.println("key: " + k + " value:" + v));

		System.out.println("\nTeste para Correlação Linear: ");		
		System.out.println(Calculos.correlacaoLinear(Calculos.correlaçãoLinearTabela(listaAtesteCL,listaBtesteCL)));
		
		System.out.println("\nTeste para Regressão Linear: ");
		System.out.println("Valor de A : " + Calculos.regressaoLinear(Calculos.correlaçãoLinearTabela(listaAtesteCL,listaBtesteCL))[0]);
		System.out.println("Valor de B : " + Calculos.regressaoLinear(Calculos.correlaçãoLinearTabela(listaAtesteCL,listaBtesteCL))[1]);
		
		System.out.println("\nTeste para Desvio Padrão Estimado: ");
		System.out.println(Calculos.desvioPadraoEstimado(Calculos.correlaçãoLinearTabela(listaAtesteCL,listaBtesteCL)));
		
		System.out.println("\nTeste para Estatística Teste Padronizada: ");
		System.out.println(Calculos.estatisticaTestePadronizada(30, 28.5, 3.5, 36));
		
		System.out.println(
				"\nTeste da Tabela de Distribuicao para o numero : " + Calculos.tabelaDistribuicaoNormal(Calculos.estatisticaTestePadronizada(30, 28.5, 3.5, 36)));
		
		
		
	}

}

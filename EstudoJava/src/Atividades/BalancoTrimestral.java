package Atividades;

public class BalancoTrimestral {

	public static void main(String[] args) {
		
		int gastosJaneiro = 1500;
		int gastosFevereiro = 2300;
		int gastosMarco = 1700;
		
		int gastosTrimestrais = gastosFevereiro + gastosJaneiro + gastosMarco;
		
		System.out.println(gastosTrimestrais);
		
		String mediaMensal = "Media mensal: " + gastosTrimestrais / 3;
		
		System.out.println(mediaMensal);
		
	}

}

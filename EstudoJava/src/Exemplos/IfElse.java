package Exemplos;

public class IfElse {

	public static void main(String[] args) {
		
		int idade = 15;
		int mes = 1;
		boolean amigoDono = true;
		
		if (idade < 18) {
			System.out.println("N�o pode entrar");
		} else {
			System.out.println("Pode entrar");
		}
		
		/* compara��o usando operadores logicos*/
		if (idade < 18 && amigoDono == false) {
			System.out.println("N�o pode entrar");
		} else {
			System.out.println("Pode entrar");
		}
		
		/* compara��o usando ! */
		if (idade < 18 && !amigoDono) {
			System.out.println("N�o pode entrar");
		} else {
			System.out.println("Pode entrar");
		}
		
		/* comparando valor de variavel*/
		if (mes == 1) {
			System.out.println("Voc� deveria estar de ferias");
		} else {
			System.out.println("V� estudar");
		}
	}

}

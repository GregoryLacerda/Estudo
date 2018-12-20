package Exemplos;

public class IfElse {

	public static void main(String[] args) {
		
		int idade = 15;
		int mes = 1;
		boolean amigoDono = true;
		
		if (idade < 18) {
			System.out.println("Não pode entrar");
		} else {
			System.out.println("Pode entrar");
		}
		
		/* comparação usando operadores logicos*/
		if (idade < 18 && amigoDono == false) {
			System.out.println("Não pode entrar");
		} else {
			System.out.println("Pode entrar");
		}
		
		/* comparação usando ! */
		if (idade < 18 && !amigoDono) {
			System.out.println("Não pode entrar");
		} else {
			System.out.println("Pode entrar");
		}
		
		/* comparando valor de variavel*/
		if (mes == 1) {
			System.out.println("Você deveria estar de ferias");
		} else {
			System.out.println("Vá estudar");
		}
	}

}

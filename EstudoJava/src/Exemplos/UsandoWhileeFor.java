package Exemplos;

public class UsandoWhileeFor {

	public static void main(String[] args) {
		int idade = 15;
		int j = 0;
		
		
		/*loop até que idade chegue aos 18*/
		while (idade < 18){
			System.out.println(idade);
			idade = idade + 1;
		}
		
		/*loop até que chegue a 10*/
		while (j < 10) {
			System.out.println(j);
			j = j + 1;
		}
		
		/* loop com o for mostando que ele usa uma variavel especificamento para o loop*/
		for (int i = 0; i < 10; i++) {
			System.out.println("ola " + i);
		}
		
		/*parar a execução com o break*/
		for (int i = 0; i < 100; i++) {
			if (i >50 && i < 60) {
				continue;
			}
			System.out.println(i);
		}

	}

}

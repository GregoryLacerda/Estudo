package Atividades;

public class FixacaoDeSintaxe {

	public static void main(String[] args) {
		
		/*Impimir numeros entre 150 e 300
		for (int i = 0; i <= 300; i++) {
			if (i >= 150 && i <= 300) {
				System.out.println(i);
			}
			
		}*/
		
		/* imprimir soma de 1 até 1000
		for (int i = 1; i < 1000; i++) {
			i += i;
			System.out.println(i);
		}*/
		
		/* imprimir os multipos de 3
		for (int i = 0; i < 100; i++) {
			if (i % 3 == 0) {
				System.out.println(i);
			}
		}*/
		
		
		int fatorial = 1;
		int f;
		for (int n = 0; n <= 10; n++) {
			
		 f = fatorial * (fatorial - n);
		 	fatorial++;
		 	System.out.println(f);
		}
		
		
	}

}

import java.util.Scanner;


public class EjThreads1 extends Thread{

	public static int numero = 0;
	private String nombre;
	
	public EjThreads1(String nombre)
	{
		this.nombre = nombre;
	}
	
	public void run(){
		try {
			if(nombre.equals("Thread 2"))Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for (int i = 1; i <= numero; i++) {
			if(i%2 == 0 && nombre.equals("Thread 1")){
				System.out.println(i);
				try {
					Thread.sleep(20);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(i%2 == 1 && nombre.equals("Thread 2")){
				System.out.println(i);
				try {
					Thread.sleep(20);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}         
	
	public static void main(String[] args){
		System.out.println("Ingrese un numero");
		Scanner entradaEscaner = new Scanner(System.in); 
	    numero = Integer.parseInt(entradaEscaner.nextLine());
		EjThreads1 t = new EjThreads1("Thread 1");   
		EjThreads1 t1 = new EjThreads1("Thread 2");
		t.start();    
		t1.start();
	}
	
}

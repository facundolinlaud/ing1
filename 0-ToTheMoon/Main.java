import java.io.*;
import java.util.Scanner;

public class Main{
	public static class Suelo {
	    private
	        double dureza;
	    	double porosidad;
	    public Suelo(){}
	    
	    public Suelo(double dureza, double porosidad){
	    	this.dureza = dureza; 
	    	this.porosidad = porosidad;
	    }

	    public double getDureza(){
	        return dureza;
	    }
	    public double getPorosidad(){
	        return porosidad;
	    }

	    @Override
	    public String toString(){
	        return "\nAnalisis del suelo: \n" + "Dureza : " + dureza + " %" + "\nPorosidad: " + porosidad + " %";
	    }   
	    
	}
	public static class Cientifico {

	    Cientifico(){}

	    boolean esSueloDuro(Suelo s){
	    	double dureza = s.getDureza(); 
	    	double porosidad = s.getPorosidad();
	    	if (dureza > porosidad) return true;

	    	return false;
	    }
	}

	public static class Excavadora {

		static final int RPM_SUELO_DURO = 150;
		static final int RPM_SUELO_BLANDO = 100;

	    public Excavadora(){}
	     
	    public void excavar(boolean esDuro){

	    	if (esDuro)
	    		System.out.println ("----- Excavando suelo duro ----- \n"); 
	    	else
	    		System.out.println ("----- Excavando suelo blando ----- \n"); 

			boolean clockwise = esDuro;
			girarMecha(esDuro, clockwise);
			cerrarPinzas();
			girarMecha(esDuro, !clockwise);

			System.out.println ("----- Fin de la excavacion ----- \n"); 

		}
		
		private void cerrarPinzas(){
			System.out.println ("... Activando cierre de pinzas...\n"); 
			esperarHardware(1);
			System.out.println ("----- Muestra recogida ----- \n"); 
		}

		private void girarMecha(boolean esDuro, boolean clockwise){
			String agujas; 
			String rpm;

			if (clockwise)
				agujas = "... Girando la pinza en el sentido de las agujas del reloj "; 
			else 
				agujas = "... Girando la pinza en sentido contrario de las agujas del reloj "; 

			if (esDuro)
				rpm = "a la velocidad de " + RPM_SUELO_DURO + " RPM ... \n";
			else
				rpm = "a la velocidad de " + RPM_SUELO_BLANDO + " RPM ... \n";

			System.out.println (agujas + rpm); 

			if (esDuro)
				esperarHardware(4); // simulacion de tiempo que tarda la excavacion
			else 
				esperarHardware(3);
		}

		private void esperarHardware(int segundos) {
		    try {
		        Thread.sleep(segundos*1000);
		    } catch (InterruptedException e) {
		    	System.err.format("IOException: %s%n", e);
		    }
		}
	}


	public static double ingresarValor(){
		Scanner input = new Scanner(System.in);
		double valor = 0;
		boolean valorCorrecto = false;

		while( !valorCorrecto ){
			valorCorrecto = true;
			try {
		    	valor = input.nextDouble(); 
		  	} catch (Exception e) {
		   		System.out.println ("VALOR INCORRECTO: Ingresa un numero!"); 
		   		valorCorrecto = false;
		  	}
		  	input.nextLine();
		  	if (valorCorrecto){
		  		if (valor < 0 || valor > 100) {
		  			valorCorrecto = false;
		  			System.out.println ("VALOR INCORRECTO: Ingrese un porcentaje! (numero entre 0 y 100)"); 
		  		}
		  	}
		}

		return valor;
	}

	public static void main (String[] args){
		System.out.println("------------ To The Moon Software ------------");

		System.out.println("1) Ingrese dureza% del suelo a excavar -------- ");
		double dureza = ingresarValor();
		System.out.println("2) Ingrese porosidad% del suelo a excavar -------- ");
		double porosidad = ingresarValor();

		Suelo terreno = new Suelo(dureza, porosidad);
		Cientifico expertoEnSuelos = new Cientifico();
		boolean esDuro = expertoEnSuelos.esSueloDuro(terreno);

		System.out.println(terreno.toString());

		Excavadora maquina = new Excavadora();
		maquina.excavar(esDuro);
	}
}





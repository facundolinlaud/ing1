import java.util.*;
import java.io.*;
import java.util.Scanner;
import java.lang.Math;

public class Mainv2{
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

	    List<Boolean> esSueloDuro(Suelo s){
	    	double dureza = s.getDureza(); 
	    	double porosidad = s.getPorosidad();

	    	Boolean esDuro = true;
	    	Boolean esIntermedio = true;
	    	Boolean esBlando = true;

	    	if (Math.abs(dureza-porosidad) < 15) return Arrays.asList(!esDuro, esIntermedio, !esBlando);

	    	if (dureza > porosidad) 
	    		return Arrays.asList(esDuro, !esIntermedio, !esBlando);
	    	else	    		
	    		return Arrays.asList(!esDuro, !esIntermedio, esBlando);
	    }
	}

	public static class Excavadora {

		static final int RPM_SUELO_DURO = 150;
		static final int RPM_SUELO_BLANDO = 100;
		static final int RPM_SUELO_INTERMEDIO_ABAJO = 150;
		static final int RPM_SUELO_INTERMEDIO_ARRIBA = 100;

	    public Excavadora(){}
	     
	    public void excavar(List<Boolean> tiposDeSuelo){
	    	Boolean esDuro = tiposDeSuelo.get(0);
	    	Boolean esIntermedio = tiposDeSuelo.get(1);
	    	Boolean esBlando = tiposDeSuelo.get(2);
	    	
	    	if (esDuro){
	    		System.out.println ("----- Excavando suelo duro ----- \n"); 
	    	} else{
	    		if (esIntermedio)
	 				System.out.println ("----- Excavando suelo intermedio ----- \n"); 
	 			else 
	 				System.out.println ("----- Excavando suelo blando ----- \n"); 
	    	}
	    	//si es duro o intermedio primero se gira la mecha en sentido de las agujas del reloj
			boolean clockwise = esDuro || esIntermedio;
			girarMecha(esDuro, esIntermedio, esBlando, clockwise);
			cerrarPinzas();
			girarMecha(esDuro, esIntermedio, esBlando, !clockwise);

			System.out.println ("----- Fin de la excavacion ----- \n"); 

		}
		
		private void cerrarPinzas(){
			System.out.println ("... Activando cierre de pinzas...\n"); 
			esperarHardware(1);
			System.out.println ("----- Muestra recogida ----- \n"); 
		}

		private void girarMecha(boolean esDuro, boolean esIntermedio, boolean esBlando, boolean clockwise){
			String agujas; 
			String rpm;
			if (clockwise)
				agujas = "... Girando la pinza en el sentido de las agujas del reloj "; 
			else 
				agujas = "... Girando la pinza en sentido contrario de las agujas del reloj "; 

			if (esDuro){
				rpm = "a la velocidad de " + RPM_SUELO_DURO + " RPM ... \n";
			}else{		
				if (esBlando){
					rpm = "a la velocidad de " + RPM_SUELO_BLANDO + " RPM ... \n";
				}else{
					if(clockwise)
						rpm = "a la velocidad de " + RPM_SUELO_INTERMEDIO_ABAJO + " RPM ... \n";
					else
						rpm = "a la velocidad de " + RPM_SUELO_INTERMEDIO_ARRIBA + " RPM ... \n";
				}
			}

			System.out.println (agujas + rpm); 

			if (esDuro || (esIntermedio && !clockwise))
				esperarHardware(4); // simulacion de tiempo que tarda la excavacion (10 minutos)
			else 
				esperarHardware(3); // 5 minutos
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
		
		List tiposDeSuelo = expertoEnSuelos.esSueloDuro(terreno);

		System.out.println(terreno.toString());

		Excavadora maquina = new Excavadora();
		maquina.excavar(tiposDeSuelo);
	}
}





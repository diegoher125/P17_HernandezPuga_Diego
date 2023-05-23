package main.java.ieseuropa;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class P17_HernandezPuga_Diego {
	
	private static void mostrarPiramide(int altura) {
		for(int i=0;i<altura;i++) {
			for(int j=0;j<(altura-i);j++) {
				System.out.print(" ");
			}
			System.out.print("*");
			for(int k=0;k<(i*2);k++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	private static int pedirInt(String texto) {
		Scanner teclado = new Scanner(System.in);
		int numero = 0;
		boolean datoValido = false;
		do {
			try {
				System.out.println(texto);
				numero = teclado.nextInt();
				datoValido = true;
			}catch (Exception e) {
				System.out.println("Dato incorrecto");
				teclado.next();
			}
		}while(!datoValido);
		return numero;
	}
	
	private static void parte2() throws ExcepcionSize {
		int altura = pedirInt("Pon la altura");
		if(altura <= 10 && altura >= 1) {
			mostrarPiramide(altura);
		}else {
			throw new ExcepcionSize();
		}
	}
	
	private static void parte4() {
		int alumnos = pedirInt("Introduce el número de alumnos:");
		pedirAlumnos(alumnos);
	}
	
	private static void pedirAlumnos(int alumnos) {
		ArrayList<Float> notas = new ArrayList<>();
		for(int i=0;i<alumnos;i++) {
			notas.add(pedirFloat("Introduce la nota del alumno " + (i+1) + ":"));
			System.out.println("La nota media es " + (Math.round(hacerMedia(notas) * 100.0) / 100.0));
		}
	}
	
	private static float hacerMedia(ArrayList<Float> notas) {
		float suma = 0;
		for(float nota: notas) {
			suma += nota;
		}
		return suma/notas.size();
	}
	
	private static float pedirFloat(String texto) {
		Scanner teclado = new Scanner(System.in);
		float numero = 0;
		boolean datoValido = false;
		do {
			try {
				System.out.println(texto);
				numero = teclado.nextFloat();
				datoValido = true;
			}catch (Exception e) {
				System.out.println("Dato incorrecto");
				teclado.next();
			}
		}while(!datoValido);
		return numero;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			parte2();
		}catch(ExcepcionSize es) {
			
		}
		
		parte4();
	}

}

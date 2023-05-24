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
	
	private static Mamut pedirMamut(int num) {
		String nombre = pedirString("Introduzca el nombre del mamut " + num + ":");
		boolean sexo = false;
		Mamut mamut = new Mamut();
		try {
			sexo = pedirSexo();
			mamut = new Mamut(nombre, sexo);
		}catch (ExceptionSexoNoValido esnv) {
			
		}
		
		
		return mamut;
	}
	
	private static String pedirString(String texto) {
		Scanner teclado = new Scanner(System.in);
		String str = "";
		boolean datoValido = false;
		do {
			try {
				System.out.println(texto);
				str = teclado.nextLine();
				datoValido = true;
			}catch (Exception e) {
				System.out.println("Dato incorrecto");
				teclado.next();
			}
		}while(!datoValido);
		return str;
	}
	
	private static boolean pedirSexo() throws ExceptionSexoNoValido {
		Scanner teclado = new Scanner(System.in);
		String sex = "";
		
		while(!sex.equalsIgnoreCase("H") && !sex.equalsIgnoreCase("M")) {
			sex = pedirString("Introduzca el sexo(Macho: M, Hembra: H):");
			sex.toUpperCase();
			if(sex.equalsIgnoreCase("M") || sex.equalsIgnoreCase("H")) {
				System.out.println("Sexo bien introducido");
			}else {
				throw new ExceptionSexoNoValido();
			}
			
		}
		if(sex.equalsIgnoreCase("M")) {
			return true;
		}else {
			return false;
		}
	}
	
	private static boolean isSexoValido(String sex) {
		if(!sex.equalsIgnoreCase("H") && !sex.equalsIgnoreCase("M")) {
			return false;
		}else {
			return true;
		}
	}
	
	private static void parte3() throws ExceptionImposibleAparear {
		Mamut mamut1 = pedirMamut(1);
		Mamut mamut2 = pedirMamut(2);
		if(!mamut1.equals(mamut2)) {
			System.out.println("Apareamiento correcto");
			Mamut mamutHijo = aparear(mamut1, mamut2);
		}else {
			throw new ExceptionImposibleAparear();
		}
		
	}
	
	private static Mamut aparear(Mamut mamut1, Mamut mamut2) {
		String nombre = pedirString("Introduzca el nombre del nuevo mamut:");
		boolean sexo = false;
		try {
			sexo = pedirSexo();
		}catch (ExceptionSexoNoValido esnv) {
			
		}
		return new Mamut(nombre, sexo);
	}
	
	private static void parte4() {
		int alumnos = pedirInt("Introduce el número de alumnos:");
		pedirAlumnos(alumnos);
	}
	
	private static void pedirAlumnos(int alumnos) {
		ArrayList<Float> notas = new ArrayList<>();
		for(int i=0;i<alumnos;i++) {
			float nota = pedirNota(i+1);
			notas.add(nota);
			System.out.println("La nota media es " + (Math.round(hacerMedia(notas) * 100.0) / 100.0));
		}
	}
	
	private static float pedirNota(int i) {
		float nota = -1;
		while(nota < 0 || nota > 10) {
			try {
				nota = pedirFloat("Introduce la nota del alumno " + i + ":");
				if(nota < 0 || nota > 10) {
					throw new ExceptionNoValidNote();
				}
			}catch (ExceptionNoValidNote envn) {
				
			}
		}
		return nota;
	}
	
	private static float hacerMedia(ArrayList<Float> notas) {
		float suma = 0;
		for(float nota: notas) {
			suma += nota;
		}
		return suma/notas.size();
	}
	
	private static float pedirFloat(String texto) throws ExceptionNoValidNote {
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
		try {
			parte3();
		}catch (ExceptionImposibleAparear eia) {
			
		}
		parte4();
	}

}

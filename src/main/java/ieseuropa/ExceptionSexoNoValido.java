package main.java.ieseuropa;

public class ExceptionSexoNoValido extends Exception {
	
	public ExceptionSexoNoValido() {
		System.out.println("ExceptionSexoNoValido: El sexo solo es macho o hembra, no hay mas");
	}

}

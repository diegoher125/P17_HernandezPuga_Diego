package main.java.ieseuropa;

public class Mamut {
	
	private String nombre;
	private boolean macho;
	
	public Mamut(String nombre, boolean macho) {
		this.nombre = nombre;
		this.macho = macho;
	}
	
	public Mamut() {
		this.nombre = "";
		this.macho = false;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isMacho() {
		return macho;
	}

	public void setMacho(boolean macho) {
		this.macho = macho;
	}
	
	@Override
	public boolean equals(Object o) {
		if (macho = ((Mamut)o).isMacho()) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return "Mamut [nombre=" + nombre + ", macho=" + macho + "]";
	}

}

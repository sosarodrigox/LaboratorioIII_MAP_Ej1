
public class Mascota {

	private String nombre;
	private String raza;
	private int edad;
	private Integer nroMascota; //Se genera automáticamente
	
	public Mascota(String nombre, String raza, int edad, Integer nroMascota) {
		super();
		this.nombre = nombre;
		this.raza = raza;
		this.edad = edad;
		this.nroMascota = nroMascota;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "N° de Mascota=" + nroMascota + ". Nombre=" + nombre + " - Raza=" + raza + " - Edad=" + edad;
	}

	public Integer getNroMascota() {
		return nroMascota;
	}

	public void setNroMascota(Integer nroMascota) {
		this.nroMascota = nroMascota;
	}
	
}

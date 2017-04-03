package pkagesocio;
import java.util.GregorianCalendar;
import java.io.*;
class socio implements Serializable
{
	private String nombre;
	private String apellido;
	private String apellido2;
	private String nif;
	private GregorianCalendar nacimiento;
	//constructor //el GregorianCalendar ha de tener este formato al pasarlo al constructor: ("dd, mm,yyyy")
	public socio (String nombre, String apellido, String apellido2, String nif, GregorianCalendar nacimiento)
	{
		this.nombre=nombre;
		this.apellido=apellido;
		this.apellido2=apellido2;
		this.nif=nif;
		this.nacimiento=nacimiento;
	}
	public void mostrar()
	{
		System.out.println("Nombre: "+nombre);
		System.out.println("Primer apellido "+apellido);
		System.out.println("Segundo apellido "+apellido2);
		System.out.println("NIF/DNI: "+nif);
		System.out.println("Fecha de nacimiento: "+nacimiento.toString());
	}
}

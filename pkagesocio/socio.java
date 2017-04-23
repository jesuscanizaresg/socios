package pkagesocio;
import java.util.GregorianCalendar;
import java.io.*;
public class socio implements Serializable //javier Moreno
{
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String dni;
	private GregorianCalendar nacimiento;
	//constructor //el GregorianCalendar ha de tener este formato al pasarlo al constructor: ("dd, mm,yyyy")
	public socio (String nombre, String apellido, String apellido2, String dni, GregorianCalendar nacimiento)
	{
		this.nombre=nombre;
		this.apellido1=apellido1;
		this.apellido2=apellido2;
		this.dni=dni;
		this.nacimiento=nacimiento;
	}
	public void mostrar()
	{
		System.out.println("Nombre: "+nombre);
		System.out.println("Primer apellido "+apellido1);
		System.out.println("Segundo apellido "+apellido2);
		System.out.println("NIF/DNI: "+dni);
		System.out.println("Fecha de nacimiento: "+nacimiento.toString());
	}
}

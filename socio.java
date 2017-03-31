import java.util.GregorianCalendar;
class socio implements Serializable
{
	private String nombre;
	private String apellido;
	private String apellido2;
	private String nif;
	private GFregorianCalendar nacimiento;
	//constructor
	public socio (String nombre, String apellido, String apellido2, String nif, String nacimiento)
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
	}
}

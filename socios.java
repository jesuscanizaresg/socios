import pkagesocios.*;
import java.io.*;
class socios//solo main y métodos
{
	public static File f; //Necesitamos un File f static para trabajar con los métodos, lo dejo aquí. Que el editor de la clase socios
	//lo tenga en cuenta.
	
	public static void main (String[]args)
	{
	



	}



	//METODO PARA ESCRIBIR SOCIOS NUEVOS A FICHERO JESUS CAÑIZARES_______________________________________________________
	public void writeSocios() throws IOException
	{
		if (f.exists())
		{
			f = new File ("socios.dat");
			FileOutputStream fos = new FileOutputStream (f,true);
			ObjectOutputStream oos = new ObjectOutputStream (fos);
			BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
			int introMenu = 1;
			
			while (intro == 1)
			{
				System.out.println("Introduzca valores para realizar alta socio, linea vacia para terminar");
				System.out.println("Nombre socio");
				String nombre = br.nextLine();
				System.out.println("Apellido1");
				String apellido1 = br.nextLine();
				System.out.println("Apellido2");
				String apellido2 = br.nextLine();
				System.out.println("Dni socio");
				String dni = br.nextLine();
				System.out.println("Introduzca día de nacimiento");
				int dia = Integer.parseInt(br.nextLine());
				System.out.println("Introduzca mes de nacimiento, formato numérico de dos cifras");
				int mes = Integer.parseInt(br.nextLine()-1);
				System.out.println("Introduzca año de nacimiento, formato numérico de cuatro cifras");
				int ano = Integer.parseInt(br.nextLine());
				GregorianCalendar gc = new GregorianCalendar(dia,mes,ano);
				socio s = new socio ( nombre,apellido1,apellido2,dni,gc);
					oos.writeObject(s);			

				System.out.println("Introducir nuevo socio---> Pulse 1");
				System.out.println("Terminar la edición de socios --> Pulse 2");
				introMenu=Integer.parseInt(br.nextLine());
			}
		}
	}
//___________________________________fin método escribir a fichero_____________________


	

}

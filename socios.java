import pkagesocio.*;
import java.io.*;
import java.util.GregorianCalendar;
public class socios//solo main y métodos//javier Moreno
{
	public static File f; //Necesitamos un File f static para trabajar con los métodos

	public static void main (String[]args)
	{
		int x=3;
		x=menu();
		while (x!=0)
		{
			switch (x)
			{
				case 1: writeSocios();
						break;
				case 2: readSocios();
						break;
				default:System.out.println("Introduce un valor válido");
						break;
			}
			x=menu();		
		}	
	}
	//METODO PARA ESCRIBIR SOCIOS NUEVOS A FICHERO JESUS CAÑIZARES_______________________________________________________
	static void writeSocios() throws IOException
	{
		if (f.exists())
		{
			f = new File ("socios.txt");
			FileOutputStream fos = new FileOutputStream (f,true);
			ObjectOutputStream oos = new ObjectOutputStream (fos);
			BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
			int introMenu = 1;
			
			while (introMenu == 1)
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
	}//___________________________________fin método escribir a fichero_____________________

	//METODO PARA MOSTRAR RAUL NAJERA
	static void readSocios() throws IOException
	{
		FileInputStream fis=new FileInputStream("socios.dat");
		ObjectInputStream ois=new ObjectInputStream(fis);
		try
		{
		while (true)
			{
			socio s=(socio)ois.readObject();
			s.mostrar();
			}
		}
		catch (EOFException e)
		{
			System.out.println("Fin de fichero");
		}
		catch (ClassNotFoundException e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			if (ois != null)
			{
				ois.close();
				fis.close();
				System.exit(0);
			}
		}
	} //fin metodo leer fichero
	static int menu() 
	{	//javier Moreno
		int menu = 0;
		BufferedReader br1 = new BufferedReader (new InputStreamReader(System.in));
		System.out.println("------------Bienvenido a tu registro de socios------------");
		System.out.println("¿Qué quieres hacer?");
		System.out.println("1. Introducir un socio nuevo");
		System.out.println("2. Consultar los socios");
		System.out.println ("0. Para salir");
		menu=Integer.parseInt(br.nextLine());
		return menu;
		

	}
}

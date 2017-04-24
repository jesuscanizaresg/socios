import pkagesocio.*;
import java.io.*;
import java.util.GregorianCalendar;
public class socios
{					
	static File f = new File("socios.dat"); //Necesitamos un File f static para trabajar con los métodos
	static FileOutputStream fos;
	static ObjectOutputStream oos;
	public static BufferedReader br = new BufferedReader (new InputStreamReader(System.in)); //BufferedReader para todo el programa
	public static void main (String[]args) 
	{										//_______________________________Main: javier Moreno_______________________________
		int x=3;
		x=menu();
		while (x!=0)
		{
			switch (x)
			{
				case 1: 
						{
							writeSocios();
							break;
						}
						//catch(IOException e){e.printStackTrace();}
						
				case 2: try
						{
							readSocios();
							break;	
						}
						catch(IOException e){e.printStackTrace();}

				default:System.out.println("Introduce un valor válido");
						break;
			}
			x=menu();		
		}	
	}//_______________________________fin main_______________________________

	//METODO PARA ESCRIBIR SOCIOS NUEVOS A FICHERO JESUS CAÑIZARES_______________________________________________________
	static void writeSocios() 
	{
			int introMenu = 1;

			try
			{
				fos = new FileOutputStream (f,true);
				oos = new ObjectOutputStream (fos);
			}
			catch(FileNotFoundException fnf)
			{
			System.err.println("Archivo no encontrado");
			}
			catch(IOException e)
			{
			e.printStackTrace();
			}
			
			while (introMenu == 1)
			{
				System.out.println("Introduzca valores para realizar alta socio, linea vacia para terminar");
				System.out.println("Nombre socio");
				try
				{
				String nombre = br.readLine();
				System.out.println("Apellido1");
				String apellido1 = br.readLine();
				System.out.println("Apellido2");
				String apellido2 = br.readLine();
				System.out.println("Dni socio");
				String dni = br.readLine();
				System.out.println("Introduzca día de nacimiento");
				int dia = Integer.parseInt(br.readLine());
				System.out.println("Introduzca mes de nacimiento, formato numérico de dos cifras");
				int mes = Integer.parseInt(br.readLine())-1;
				//mes=mes-1;
				System.out.println("Introduzca año de nacimiento, formato numérico de cuatro cifras");
				int ano = Integer.parseInt(br.readLine());
				GregorianCalendar gc = new GregorianCalendar(ano,mes,dia);
				socio s = new socio (nombre,apellido1,apellido2,dni,gc);
					oos.writeObject(s);		
					
				

				System.out.println("Introducir nuevo socio---> Pulse 1");
				System.out.println("Terminar la edición de socios --> Pulse 2");
				introMenu=Integer.parseInt(br.readLine());
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}	
			}
			
			if (oos!=null)
			{	
				try
					{
					oos.close();
					fos.close();
					}
				catch (IOException e1)
				{
						e1.printStackTrace();
				}
			}
	}//___________________________________fin método escribir a fichero_____________________

	//_______________________________METODO PARA MOSTRAR RAUL NAJERA_______________________________
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
	{	//Menu: _______________________________javier Moreno_______________________________
		int menu = 0;
		System.out.println("------------Bienvenido a tu registro de socios------------");
		System.out.println("¿Qué quieres hacer?");
		System.out.println("1. Introducir un socio nuevo");
		System.out.println("2. Consultar los socios");
		System.out.println ("0. Para salir");
		try
		{
			menu=Integer.parseInt(br.readLine());	
		}
		catch(IOException e){e.printStackTrace();}
		return menu;
	}
}

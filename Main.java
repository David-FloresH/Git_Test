import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static Scanner sc = new Scanner(System.in);

	static Alumno [] alumno = new Alumno [10];
	static Empleado [] empleado = new Empleado [10];
	static Carros [] carro = new Carros [10];
	static Persona [] persona = new Persona [10];
	
	
	static int [] liga_1 = new int [10];
	static int [] liga_2 = new int [10];
	static int raiz = -1;
	static int disponible = 0; 
	static int disponible2=0;
	static int disponible3=0;
	static int actual = -1; 
	static int anterior = -1; 
	static int ultimo = -1;
	static int siguiente=-1;
	
	
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		
		
		
		//       [[[TRABAJO FINAL]]]
		
		
		/*		
		Diccionario de Datos
======================================================================================================
Variable................. Tipo de Datos.............. Uso de la Variable
======================================================================================================
Objeto................... Nodo....................... Array de 10 del objeto Objeto
liga_1................... Integer.................... Array para la liga 1 (es decir al elemento que sigue)
liga_2................... Integer.................... Array para la liga 2 (es decir al elemento anterior)
disponible............... Integer.................... Variable que te ayuda a indicar el elemento disponible
actual................... Integer.................... Variable que te ayuda a indicar el elemento actual
anterior................. Integer.................... Variable que te ayuda a indicar el elemento anterior
frente................... Integer.................... Te ayuda a encontrar el "frente" de la lista
icont.................... Integer.................... Contador para inicializacion e impresion
dato..................... Integer.................... Dato a a�adir a la lista
op....................... Integer.................... Opcion a leer dentro del ciclo
i........................ Integer.................... Variable simple que sirve ya sea para impresion en un ciclo for o recorrer un arreglo
p........................ Integer.................... Valor que sirve como variable para el ciclo donde se inicializa la liga_1
o........................ Integer.................... Valor que sirve como variable para el ciclo donde se inicializa la liga_2
dato..................... Integer.................... Variable que nos permite ingresar el dato deseado en altas por ATRAS
dato4.................... Integer.................... Variable que nos permite ingresar el dato deseado en altas por EN FRENTE
dato2.................... Integer.................... Variable que nos permite buscar el dato deseado en bajas
dato3.................... Integer.................... Variable que nos permite buscar el dato deseado en cambios
buscar................... Integer.................... Variable que nos permite buscar el dato en busqueda
nuevo.................... Integer.................... Valor nuevo a asignar en cambios
encontre................. Boolean.................... Variable que nos permite saber si se encontre el valor o no en bajas
encontre3................ Boolean.................... Variable que nos permite saber si se encontre el valor o no en cambios
encontre2................ Boolean.................... Variable que nos permite saber si se encontre el valor o no en buscar


*/
		
		int p=0, o=0;
		
		
		for(int i=0; i<10;i++) //si se inicializa asi el objeto cuando tiene varios atributos?
		{
			alumno[i]=new Alumno();
			empleado[i]=new Empleado();
			carro[i]=new Carros();	 // como inicializar variable tipo persona?, es el ultimo
			
		}
		

		//INICIALIZO LIGAS, SE QUEDA IGUAL
		for (p=0;p<=8;p++){
			liga_1 [p] = p+1;
		}
		//System.out.println(p);
		liga_1 [p] = -1;
	
		for(o=0;o<10;o++)
		{
			liga_2[o] = -1;
			//System.out.println(liga_2[o]);
		}

		int op=1;
		do{
			System.out.println("[[ \t\t\tCONTROL DE ACCESO CETYS\t\t\t ]]");
			System.out.println("===================================================================");
			System.out.println("Que desea hacer?");
			System.out.println("1 - ALTAS"); //ver algoritmo
			System.out.println("2 - CAMBIOS");//ez, nomas buscar nombre y decir que cosa de la personad deseas cambiar
			System.out.println("3 - CONSULTAS PERSONAS"); // BUSCAR
			System.out.println("4 - CONSULTAS CARROS"); //BUSCAR
			System.out.println("5 - LISTAR"); //esto es poner de que posicion informacion y liga al siguiente (y creo que anterior y actual)
			System.out.println("6 - SALIR");

			System.out.println("INGRESE OPCION: ");
			op=sc.nextInt();
			int x=0;
			switch(op)
			{
				case 1: //[[ALTAS POR EN FRENTE]] TERMINADO//
									
					System.out.println("[[[ALTAS]]]");
					System.out.println("============================");
					System.out.println("Que desea dar de alta?");
					System.out.println("1 - ALUMNO");
					System.out.println("2 - EMPLEADO");
					System.out.println("3 - CARRO");
					System.out.println("INGRESE OPCION: ");
					
					int opalta;
					opalta=sc.nextInt();
					switch(opalta) 
					{
					case 1: 
							x= AltaAlumno();
							if(x==-3) 
							{
								System.out.println("[[ERROR: No hay espacio en la lista.]]");
							}
							if(x==-1)
							{
								System.out.println("[[ERROR: Matricula duplicada.]]");
							}
							if(x==-2) 
							{
								System.out.println("[[ERROR: Vigencia expirada.]]");
							}
							if(x==-4)
							{
								System.out.println("[[Alta Conluida.]]");
							}
							break;
					
					case 2: 
							x= AltaEmpleado();
							if(x==-3) 
							{
								System.out.println("[[ERROR: No hay espacio en la lista.]]");
							}
							if(x==-1)
							{
								System.out.println("[[ERROR: N�mero de empleado duplicado.]]");
							}
							if(x==-2) 
							{
								System.out.println("[[ERROR: Vigencia expirada.]]");
							}
							if(x==-4)
							{
								System.out.println("[[Alta Conluida.]]");
							}
							break;
					case 3: 
							x=AltaCarro();
							if(x==-3) 
							{
								System.out.println("[[ERROR: No hay espacio en la lista.]]");
							}
							if(x==-1)
							{
								System.out.println("[[ERROR: N�mero de empleado duplicado.]]");
							}
							if(x==-2) 
							{
								System.out.println("[[ERROR: Vigencia expirada.]]");
							}
							if(x==-4)
							{
								System.out.println("[[Alta Conluida.]]");
							}
							break;
					}//fin switch alta
					break; //case altas
					
	
				case 2: // CAMBIOS//
					System.out.println("[[[CAMBIOS]]]");
					System.out.println("============================");
					System.out.println("A quien deseas realizar cambios?");
					System.out.println("1 - ALUMNO");
					System.out.println("2 - EMPLEADO");
					System.out.println("3 - CARRO");
					System.out.println("INGRESE OPCION: ");
					
					int opcam;
					opcam=sc.nextInt();
					switch(opcam)
					{
					case 1: 
							x=CambiosAlumno();
							if(x==-3) 
							{
								System.out.println("[[Lista vacia.]]");
							}
							if(x==-2)
							{
								System.out.println("[[No se encontro el valor.]]");
							}
							if(x==-4)
							{
								System.out.println("Cambio realizado.");
							}
							break;
					
					case 2: 
							x=CambiosEmpleado();
							if(x==-3) 
							{
								System.out.println("[[Lista vacia.]]");
							}
							if(x==-2)
							{
								System.out.println("[[No se encontro el valor.]]");
							}
							if(x==-4)
							{
								System.out.println("Cambio realizado.");
							}
							break;
							
					case 3: 
							x=CambiosCarro(); 
							if(x==-3) 
							{
								System.out.println("[[Lista vacia.]]");
							}
							if(x==-2)
							{
								System.out.println("[[No se encontro el valor.]]");
							}
							if(x==-4)
							{
								System.out.println("Cambio realizado.");
							}
							break;
					}
					break; //case cambios
	
				
				case 3: //CONSULTAS PERSONAS//
					
					System.out.println("[[CONSULTAS PERSONAS]]");
					System.out.println("==================================");
					System.out.println("A quien deseas consultar?");
					System.out.println("1 - ALUMNO");
					System.out.println("2 - EMPLEADO");
					System.out.println("INGRESE OPCION: ");
					
					int opcon;
					opcon=sc.nextInt();
					switch(opcon)
					{
					case 1: 
						x=ConsultaAlumno();
						if(x==-3) 
						{
							System.out.println("[[Lista Vacia]]");
						}
						if(x==-2)
						{
							System.out.println("[[No se encontro el valor.]]");
						}
						if(x==-4)
						{
							System.out.println("[[Matricula encontrada.]]");
						}
						break;
						
					case 2: 
						x=ConsultaEmpleado();
						if(x==-3) 
						{
							System.out.println("[[Lista Vacia]]");
						}
						if(x==-2)
						{
							System.out.println("[[No se encontro el valor.]]");
						}
						if(x==-4)
						{
							System.out.println("[[Numero de empelado encontrado.]]");
						}																	
						break;
					}
					break;
	
				case 4: 
					x=ConsultaCarro();
					if(x==-3) 
					{
						System.out.println("[[Lista Vacia]]");
					}
					if(x==-2)
					{
						System.out.println("[[No se encontro el valor.]]");
					}
					if(x==-4)
					{
						System.out.println("[[Placas encontradas.]]");  
					}																	
					break;
					
				case 5: 
					
					System.out.println("[[LISTADO]]");
					System.out.println("==================================");
					System.out.println("Que datos deseas desplegar?");
					System.out.println("1 - ALUMNOS");
					System.out.println("2 - EMPLEADOS");
					System.out.println("3 - CARROS");
					System.out.println("4 - ALUMNO CON CARROS ASOCIADOS");
					System.out.println("5 - CARRO CON PERSONAS ASOCIADOS");
					System.out.println("INGRESE OPCION: ");
					
					int oplist;
					oplist=sc.nextInt();
						
					switch(oplist)
					{
					
					case 1: 
						
						System.out.println("LISTADO DE ALUMNOS: ");
						for(int k=0; k<10; k++)
						{
							System.out.println("[[ Matricula ]] [[ " +alumno[k].getMatricula()+ " ]] [[ Nombre ]] [[ " +alumno[k].getNombre()+ " "
									+alumno[k].getPaterno()+ " " +alumno[k].getMaterno()+ " ]] [[ Telefono ]] [[ " +alumno[k].getTelefono()+ 
									" ]] [[ A�o de Vigencia]] [[ " +alumno[k].getVigente()+ " ]] [[ Liga 1: " +liga_1[k]+ " ]] [[ Liga 2: " +liga_2[k]+ " ]]");
						}
						break;
						
					case 2: 
						System.out.println("LISTADO DE EMPLEADOS: ");
						for(int k=0; k<10; k++)
						{
							System.out.println("[[ Numero de Empleado ]] [[ " +empleado[k].getNumemp()+ " ]] [[ Nombre ]] [[ " +empleado[k].getNombre()+ " "
									+empleado[k].getPaterno()+ " " +empleado[k].getMaterno()+ " ]] [[ Telefono ]] [[ " +empleado[k].getTelefono()+ 
									" ]] [[ A�o de Vigencia]] [[ " +empleado[k].getVigente()+ " ]]");
						}
						
						
					case 3:
						System.out.println("LISTADO DE CARROS: ");
						for(int k=0; k<10; k++)
						{
							System.out.println("[[ Placas ]] [[ " +carro[k].getPlacas()+ " ]] [[ Aseguradora ]] [[ " +carro[k].getAseguradora()+ " ]] [[ Tarjeta de Circulacion ]] [[ " +carro[k].getTarcirc()+
									" ]] [[ A�o de Vencimiento]] [[ " +carro[k].getAnoven()+ " ]] [[ Numero de Poliza ]] [[ " +carro[k].getNumpoliza()+ " ]] [[ A�o de Vigencia ]] [[ " +carro[k].getAnovigencia()+
									" ]] [[ Numero de Acceso ]] [[ " + carro[k].getPermiso()+ "]]");
						}
						
					case 4:
						AlumnoCarro[] alumnoConCarros= new AlumnoCarro[10]; 
						System.out.println("ALUMNOS CON CARROS ASOCIADOS: ");
						for (int i=0;i<10;i++){ 
							alumnoConCarros[i] = new AlumnoCarro();
							alumnoConCarros[i].setNombre(alumno[i].getNombre()+" "+alumno[i].getPaterno()+" "+alumno[i].getMaterno());
							alumnoConCarros[i].setMatricula(alumno[i].getMatricula());
							int[] carros = new int[10];
							int cont=0;
							for(Carro c: carro){ //te da el carro
								for(int num: carro.getLo_Maneja()){ // te da la matricula del que maneja ese carro
									if(num == alumnoConCarros[i].getMatricula()){ // si la matricula es tu matricula, metemos laplaca del carro
										carros[cont]=c.getPlacas(); // metemos la placa al arreglo
										cont++;
									}
								}
							}
							alumnoConCarros[i].setCarros(carros);
						}

					}
					break;
					case 5:
					for(int k=0; k<10; k++)
					{
						System.out.println("[[ Placas ]] [[ " +carro[k].getPlacas()+ " ]] [[ Personas ]] [[ " +carro[k].getLo_Maneja().toString() + "]]");
					}
					break;
				case 6: break;
			
			
			}//fin switch	
			
		}//fin while
		
		System.out.println("Fin del programa.");
	}//fin main

	
	
	//ALTAS 
	
	public static int AltaAlumno()
	{
		
		int matri;
		String nom, pat, mat;
		int vig, tel;
		
		System.out.println("Disponible: " +disponible);
		if(disponible==-1) //NO HAY ESPACIO
		{
			valor=-3;
			return valor;
			
		}
		
		System.out.println("Ingrese matricula: ");
		matri=sc.nextInt();
		System.out.println("Ingrese nombre: ");
		sc.nextLine();
		nom=sc.nextLine();
		System.out.println("Ingrese paterno: ");
		pat=sc.nextLine();
		System.out.println("Ingrese materno: ");
		mat=sc.nextLine();
		System.out.println("Ingrese telefono: ");
		tel=sc.nextInt();
		System.out.println("Ingrese vigencia: ");
		vig=sc.nextInt();
		if(vig!=2020)
		{
			valor=-2;
			return valor;
		}
		
		if(raiz==-1)//mi arbol esta vacio
		{
			
			raiz = disponible;
			alumno[disponible].setMatricula(matri);
			alumno[disponible].setNombre(nom);
			alumno[disponible].setPaterno(pat);
			alumno[disponible].setMaterno(mat);
			alumno[disponible].setTelefono(tel);
			alumno[disponible].setVigente(vig);
			System.out.println("Disponible: " +disponible);
			System.out.println(matri+ " " +nom+ " "+pat+ " "+mat+ " "+tel+" "+vig);
			int temp2=disponible;
			disponible = liga_1 [ disponible]; // siguiente disponible
			liga_1 [ temp2 ] = -1; // menores
			liga_2 [ temp2 ] = -1; // mayores
			return(-4); //que era el return 0, pq no valor negativo? pq se manda aqui?? esto va afuera?			
			
		}//fin arbol vacio
		
		
		actual = raiz; 

		// el resto va dentro del if?
		
		while(true) // for ever & ever
		{
		
			if (matri==alumno[actual].getMatricula())
			{
				return (-1); // duplicado
			}
				
			if (matri < alumno[actual].getMatricula())
			{
				if (liga_1[actual] != -1) 
				{
					actual = liga_1[actual] ;
					continue;
				}
				else			 // ya no tiene mas hijos por la izquierda
				{				/// ligamos por la izquierda
				    liga_1[actual]=disponible;
				    break;
				}
			}
				
			else // TIENE QUE SER MAYOR!
			{
				if (liga_2[actual] != -1) 
				{
					actual = liga_2[actual] ;
					continue;
				}
				else 			// ya no tiene mas hijos por la derecha
				{    			/// ligamos por la derecha`
				     liga_2[actual] = disponible;
				     break;
				}
			}//fin else
			
		}//fin while
		
		
		//por ahi disponible se hace -1
		
		
		alumno[disponible].setMatricula(matri);
		alumno[disponible].setNombre(nom);
		alumno[disponible].setPaterno(pat);
		alumno[disponible].setMaterno(mat);
		alumno[disponible].setTelefono(tel);
		alumno[disponible].setVigente(vig);
		int temp = disponible;
		disponible = liga_1 [ disponible ]; // siguiente disponible
		liga_1 [ temp ] = -1; // menores
		liga_2 [ temp ] = -1; // mayores
		return (-4); //que es? pq return 0
		
		
	}//Fin Alta Alumno
	
	
	public static int AltaEmpleado()
	{
		int numemp;
		String nom, pat, mat;
		int vig, tel;
		
		System.out.println("Disponible: " +disponible2);
		if(disponible2==-1) //NO HAY ESPACIO
		{
			valor=-3;
			return valor;
			
		}
		
		System.out.println("Ingrese n�mero de empleado: ");
		numemp=sc.nextInt();
		System.out.println("Ingrese nombre: ");
		sc.nextLine();
		nom=sc.nextLine();
		System.out.println("Ingrese paterno: ");
		pat=sc.nextLine();
		System.out.println("Ingrese materno: ");
		mat=sc.nextLine();
		System.out.println("Ingrese telefono: ");
		tel=sc.nextInt();
		System.out.println("Ingrese vigencia: ");
		vig=sc.nextInt();
		if(vig!=2020)
		{
			valor=-2;
			return valor;
		}
		
		
		
		if(raiz==-1)//mi arbol esta vacio
		{
			
			raiz = disponible2;
			empleado[disponible2].setNumemp(numemp);
			empleado[disponible2].setNombre(nom);
			empleado[disponible2].setPaterno(pat);
			empleado[disponible2].setMaterno(mat);
			empleado[disponible2].setTelefono(tel);
			empleado[disponible2].setVigente(vig);
			System.out.println("Disponible: " +disponible2);
			System.out.println(numemp+ " " +nom+ " "+pat+ " "+mat+ " "+tel+" "+vig);
			int temp2 = disponible2;
			disponible2 = liga_1 [ disponible2]; // siguiente disponible
			liga_1 [ temp2 ] = -1; // menores
			liga_2 [ temp2 ] = -1; // mayores
			return(-4); //que era el return 0, pq no valor negativo? pq se manda aqui?? esto va afuera?			
			
		}//fin arbol vacio
		
		
		actual = raiz; 

		
		// el resto va dentro del if?
		
		while(true) // for ever & ever
		{
		
			if (numemp==empleado[actual].getNumemp())
			{
				return (-1); // duplicado
			}
				
			if (numemp < empleado[actual].getNumemp())
			{
				if (liga_1[actual] != -1) 
				{
					actual = liga_1[actual] ;
					continue;
				}
				else			 // ya no tiene mas hijos por la izquierda
				{				/// ligamos por la izquierda
				    liga_1[actual]=disponible2;
				    break;
				}
			}
				
			else // TIENE QUE SER MAYOR!
			{
				if (liga_2[actual] != -1) 
				{
					actual = liga_2[actual] ;
					continue;
				}
				else 			// ya no tiene mas hijos por la derecha
				{    			/// ligamos por la derecha`
				     liga_2[actual] = disponible2;
				     break;
				}
			}//fin else
			
		}//fin while
		
		empleado[disponible2].setNumemp(numemp);
		empleado[disponible2].setNombre(nom);
		empleado[disponible2].setPaterno(pat);
		empleado[disponible2].setMaterno(mat);
		empleado[disponible2].setTelefono(tel);
		empleado[disponible2].setVigente(vig);
		int temp = disponible2;
		disponible2 = liga_1 [ disponible2 ]; // siguiente disponible
		liga_1 [ temp ] = -1; // menores
		liga_2 [ temp ] = -1; // mayores
		return (-4); //que es? pq return 0
		
		
	}//Fin Alta Empleado
	

	public static int AltaCarro()
	{
	
		
		if(disponible3==-1) //NO HAY ESPACIO
		{
			valor=-3;
			return valor;
			
		}
		
		int plac, tarcirc, anoven, numpoliza, anovigencia, permiso;
		String aseguradora;
		int numper;
		
		System.out.println("INGRESA PLACAS: ");
		plac=sc.nextInt();
		System.out.println("INGRESA TARJETA DE CIRCULACION: ");
		tarcirc=sc.nextInt();
		System.out.println("INGRESA A�O DE VENCIMIENTO: ");
		anoven=sc.nextInt();
		System.out.println("INGRESA NUMERO DE POLIZA: ");
		numpoliza=sc.nextInt();
		System.out.println("INGRESA A�O DE VIGENCIA: ");
		anovigencia=sc.nextInt();
		if(anovigencia != 2020)
		{
			valor=-2;
			return(valor);
		}
		System.out.println("INGRESA NUMERO DE ACCESO: ");
		permiso=sc.nextInt();
		System.out.println("INGRESA AGENCIA ASEGURADORA: ");
		sc.nextLine();
		aseguradora=sc.nextLine();
		
		
		System.out.println("QUIEN LO MANEJA: ");
		System.out.println("Cuantas personas manejan el carro?");

		while(true)
		{
			
			numper=sc.nextInt();
			if(numper==3 || numper==2 || numper==1)
			{
				break;
			}
			else
			{
				System.out.println("No mas de 3 personas por carro.");
				continue;
			}
				
		}
		int [] maneja = new int [10];
		for(int i=0; i<numper; i++)
		{
			System.out.println("Ingresa numero de empleado o matricula: ");
			maneja[i]=sc.nextInt();
		}
		
		if(plac==carro[actual].getPlacas()) //DUPLICADOS
		{
			valor=-1;
			return valor;
		}
		
		if(raiz==-1)//mi arbol esta vacio
		{
			
			raiz = disponible3;
			carro[disponible3].setPlacas(plac);
			carro[disponible3].setTarcirc(tarcirc);
			carro[disponible3].setAnoven(anoven);
			carro[disponible3].setNumpoliza(numpoliza);
			carro[disponible3].setAnovigencia(anovigencia);
			carro[disponible3].setPermiso(permiso);
			carro[disponible3].setAseguradora(aseguradora);
			carro[disponible3].setLo_Maneja(maneja);
			int temp2 = disponible3;
			disponible = liga_1 [ disponible3]; // siguiente disponible
			liga_1 [ temp2 ] = -1; // menores
			liga_2 [ temp2 ] = -1; // mayores
			return(-4); //que era el return 0, pq no valor negativo? pq se manda aqui?? esto va afuera?			
			
		}//fin arbol vacio
		
		
		actual = raiz; //pq me sale error?? esta mal inicializado actual? dice que es unreachale por el return, entonces donde va esto?

		// el resto va dentro del if?
		
		while(true) // for ever & ever
		{
		
			if (plac==carro[actual].getPlacas())
			{
				return (1); // que es el 1? que no se regresaban valores negativos?
			}
				
			if (plac < carro[actual].getPlacas())
			{
				if (liga_1[actual] != -1) 
				{
					actual = liga_1[actual] ;
					continue;
				}
				else			 // ya no tiene mas hijos por la izquierda
				{				/// ligamos por la izquierda
				    liga_1[actual]=disponible3;
				    break;
				}
			}
				
			else // TIENE QUE SER MAYOR!
			{
				if (liga_2[actual] != -1) 
				{
					actual = liga_2[actual] ;
					continue;
				}
				else 			// ya no tiene mas hijos por la derecha
				{    			/// ligamos por la derecha`
				   //  int tempo = -1; //dice que no la usamos, no sale en el pseudocodigo
				     liga_2[actual] = disponible3;
				     break;
				}
			}//fin else
			
		}//fin while
		
		carro[disponible3].setPlacas(plac);
		carro[disponible3].setTarcirc(tarcirc);
		carro[disponible3].setAnoven(anoven);
		carro[disponible3].setNumpoliza(numpoliza);
		carro[disponible3].setAnovigencia(anovigencia);
		carro[disponible3].setPermiso(permiso);
		carro[disponible3].setAseguradora(aseguradora);
		disponible = liga_1 [ disponible3]; // siguiente disponible
		liga_1 [ disponible3 ] = -1; // menores
		liga_2 [ disponible3 ] = -1; // mayores
		return (-4); //que es? pq return 0
		
		
	}//Fin Alta Carro
	

	//CAMBIOS
	
	public static int CambiosAlumno () 
	{
		String nom, pat, mat;
		int vig;
		if (raiz == -1 ) // lista vacia
		{
			return (-3);
		}
		
		System.out.println("INGRESA MATRICULA: ");
		int matri;
		matri=sc.nextInt();
		
		actual = raiz;
		while (true)
		{

			if (matri == alumno[actual].getMatricula())	
			{
				System.out.println("Matricula: " +alumno[actual].getMatricula());
				System.out.println("Telefono: " +alumno[actual].getTelefono());
				System.out.println("INGRESA NUEVO NOMBRE: ");
				sc.nextLine();
				nom=sc.nextLine();
				alumno[actual].setNombre(nom);
				System.out.println("INGRESA NUEVO PATERNO: ");
				pat=sc.nextLine();
				alumno[actual].setPaterno(pat);
				System.out.println("INGRESA NUEVO MATERNO: ");
				mat=sc.nextLine();
				alumno[actual].setMaterno(mat);
				System.out.println("INGRESA NUEVO VIGENTE: ");
				vig=sc.nextInt();
				alumno[actual].setVigente(vig);
				return(-4);
			}	
				
			if (matri < alumno[actual].getMatricula())
			{
				if (liga_1[actual] != -1) 
				{
					actual = liga_1[actual];
					continue;
				}
				else 
				{
				    return(-2); //no se encontro?
				   
				}
			}
			else // TIENE QUE SER MAYOR!
			{
				if (liga_2[actual] != -1) 
				{
					actual = liga_2 [ actual ] ;
					continue;
				}
				else 
				{
				     return (-2); //no se encontro?
				}
			}
		}//fin while
				     
	}//fin cambios alumno
	
	
	public static int CambiosEmpleado () 
	{
		String nom, pat, mat;
		int tel, vig;
		if (raiz == -1 ) // lista vacia
		{
			return (-3);
		}
		
		System.out.println("INGRESA NUMERO DE EMPLEADO: ");
		int num;
		num=sc.nextInt();
		
		actual = raiz;
		while (true)
		{

			if (num == empleado[actual].getNumemp())	
			{
				System.out.println("Numero de Empleado: " +empleado[actual].getNumemp());
				System.out.println("INGRESA NUEVO NOMBRE: ");
				nom=sc.nextLine();
				empleado[actual].setNombre(nom);
				System.out.println("INGRESA NUEVO PATERNO: ");
				pat=sc.nextLine();
				empleado[actual].setPaterno(pat);
				System.out.println("INGRESA NUEVO MATERNO: ");
				mat=sc.nextLine();
				empleado[actual].setMaterno(mat);
				System.out.println("INGRESA NUEVO TELEFONO: ");
				tel=sc.nextInt();
				empleado[actual].setTelefono(tel);
				System.out.println("INGRESA NUEVO VIGENTE: ");
				vig=sc.nextInt();
				empleado[actual].setVigente(vig);
				return(-4);
			}	
				
			if (num < empleado[actual].getNumemp())
			{
				if (liga_1[actual] != -1) 
				{
					actual = liga_1[actual];
					continue;
				}
				else 
				{
				    return(-2); //no se encontro?
				   
				}
			}
			else // TIENE QUE SER MAYOR!
			{
				if (liga_2[actual] != -1) 
				{
					actual = liga_2 [ actual ] ;
					continue;
				}
				else 
				{
				     return (-2); //no se encontro?
				}
			}
		}//fin while
				     
	}//fin cambios empleado
	
	
	public static int CambiosCarro () 
	{
		int plac, tarcirc, anoven, numpoliza, anovigencia, permiso;
		String aseguradora;
		int numper;
		if (raiz == -1 ) // lista vacia
		{
			return (-3);
		}
		
		System.out.println("INGRESA PLACAS: ");
		plac=sc.nextInt();
		
		actual = raiz;
		while (true)
		{

			if (plac == carro[actual].getPlacas())	
			{
				System.out.println("Placas: " +carro[actual].getPlacas());
				System.out.println("INGRESA NUEVA TARJETA DE CIRCULACION: ");
				tarcirc=sc.nextInt();
				carro[actual].setTarcirc(tarcirc);
				System.out.println("INGRESA NUEVO A�O DE VENCIMIENTO: ");
				anoven=sc.nextInt();
				carro[actual].setAnoven(anoven);
				System.out.println("INGRESA NUEVO NUMERO DE POLIZA: ");
				numpoliza=sc.nextInt();
				carro[actual].setNumpoliza(numpoliza);
				System.out.println("INGRESA NUEVO A�O DE VIGENCIA: ");
				anovigencia=sc.nextInt();
				carro[actual].setAnovigencia(anovigencia);
				System.out.println("INGRESA NUEVO NUMERO DE ACCESO: ");
				permiso=sc.nextInt();
				carro[actual].setPermiso(permiso);
				System.out.println("INGRESA NUEVA AGENCIA ASEGURADORA: ");
				sc.nextLine();
				aseguradora=sc.nextLine();
				carro[actual].setAseguradora(aseguradora);
				System.out.println("Cuantas personas manejan el carro?");

				while(true)
				{
					
					numper=sc.nextInt();
					if(numper==3 || numper==2 || numper==1)
					{
						break;
					}
					else
					{
						System.out.println("No mas de 3 personas por carro.");
						continue;
					}
						
				}
				int [] maneja = new int [numper];
				for(int i=0; i<numper; i++)
				{
					System.out.println("Ingresa numero de empelado o matricula: ");
					maneja[i]=sc.nextInt();
				}
				
				
				
				return(-4);
			}	
				
			if (plac < carro[actual].getPlacas())
			{
				if (liga_1[actual] != -1) 
				{
					actual = liga_1[actual];
					continue;
				}
				else 
				{
				    return(-2); //no se encontro?
				   
				}
			}
			else // TIENE QUE SER MAYOR!
			{
				if (liga_2[actual] != -1) 
				{
					actual = liga_2 [ actual ] ;
					continue;
				}
				else 
				{
				     return (-2); //no se encontro?
				}
			}
		}//fin while
				     
	}//fin cambios empleado
	
	
	//CONSULTA
	
	
	public static int ConsultaAlumno() 
	{
		if (raiz == -1 ) // lista vacia
		{
			return (-3);
		}
		
		System.out.println("INGRESA MATRICULA: ");
		int matri;
		matri=sc.nextInt();
		
		actual = raiz;
		while (true)
		{

			if (matri == alumno[actual].getMatricula())	
			{
				System.out.println("Matricula: " +alumno[actual].getMatricula());
				System.out.println("Nombre: " +alumno[actual].getNombre()+ " " +alumno[actual].getPaterno()+ " " +alumno[actual].getMaterno());
				System.out.println("Telefono: " +alumno[actual].getTelefono());
				System.out.println("Vigente: " +alumno[actual].getVigente());
				return(-4);
			}	
				
			if (matri < alumno[actual].getMatricula())
			{
				if (liga_1[actual] != -1) 
				{
					actual = liga_1[actual];
					continue;
				}
				else 
				{
				    return(-2); //no se encontro?
				   
				}
			}
			else // TIENE QUE SER MAYOR!
			{
				if (liga_2[actual] != -1) 
				{
					actual = liga_2 [ actual ] ;
					continue;
				}
				else 
				{
				     return (-2); //no se encontro?
				}
			}
		}//fin while
				     
	}//fin consulta alumno
	
	
	public static int ConsultaEmpleado() 
	{
		if (raiz == -1 ) // lista vacia
		{
			return (-3);
		}
		
		System.out.println("INGRESA NUMERO DE EMPLEADO: ");
		int num;
		num=sc.nextInt();
		
		actual = raiz;
		while (true)
		{

			if (num == empleado[actual].getNumemp())	
			{
				System.out.println("Matricula: " +empleado[actual].getNumemp());
				System.out.println("Nombre: " +empleado[actual].getNombre()+ " " +empleado[actual].getPaterno()+ " " +empleado[actual].getMaterno());
				System.out.println("Telefono: " +empleado[actual].getTelefono());
				System.out.println("Vigente: " +empleado[actual].getVigente());
				return(-4);
			}	
				
			if (num < empleado[actual].getNumemp())
			{
				if (liga_1[actual] != -1) 
				{
					actual = liga_1[actual];
					continue;
				}
				else 
				{
				    return(-2); //no se encontro?
				   
				}
			}
			else // TIENE QUE SER MAYOR!
			{
				if (liga_2[actual] != -1) 
				{
					actual = liga_2 [ actual ] ;
					continue;
				}
				else 
				{
				     return (-2); //no se encontro?
				}
			}
		}//fin while
				     
	}//fin consulta empleado
	
	
	public static int ConsultaCarro() 
	{
		if (raiz == -1 ) // lista vacia
		{
			return (-3);
		}
		
		System.out.println("CONSULTA // INGRESA PLACAS: ");
		int plac;
		plac=sc.nextInt();
		
		actual = raiz;
		while (true)
		{

			if (plac == carro[actual].getPlacas())	
			{
				System.out.println("Placas: " +carro[actual].getPlacas());
				System.out.println("Aseguradora: " +carro[actual].getAseguradora());
				System.out.println("Tarjeta de Circulacion: " +carro[actual].getTarcirc());
				System.out.println("A�o vencimiento: " +carro[actual].getAnoven());
				System.out.println("Numero de Poliza: " +carro[actual].getNumpoliza());
				System.out.println("A�o de Vigencia: " +carro[actual].getAnovigencia());
				System.out.println("Numero de Control: " +carro[actual].getPermiso());
				System.out.println("Lo maneja: " +carro[actual].getLo_Maneja());
				return(-4);
			}	
				
			if (plac < carro[actual].getPlacas())
			{
				if (liga_1[actual] != -1) 
				{
					actual = liga_1[actual];
					continue;
				}
				else 
				{
				    return(-2); //no se encontro?
				   
				}
			}
			else // TIENE QUE SER MAYOR!
			{
				if (liga_2[actual] != -1) 
				{
					actual = liga_2 [ actual ] ;
					continue;
				}
				else 
				{
				     return (-2); //no se encontro?
				}
			}
		}//fin while
				     
	}//fin consulta carro
	

}//fin clase

//despues de dar de alta dos alumnos me dice que no hay espacio en la lista, disponible se hace = -1, pero pq?




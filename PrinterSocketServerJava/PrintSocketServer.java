
import java.net.*;
import java.io.*;

public class PrintSocketServer {

	// Crea el socket de servidor y un hilo para cada cliente que reciba
	public void run(){
		try {
			// Socket de servidor en el puerto 7654
			ServerSocket ss = new ServerSocket(7654);
			System.out.println("Socket servidor esta lista en el puerto: " + ss );
			// A la espera de mensajes
			for(;;){// Permanece aqu� hasta que se efect�e una conexi�n
				Socket sockEntrada = ss.accept();
				System.out.println("Socket recibido: " + sockEntrada);

				//
				BufferedReader lector=null;
				PrintWriter escritor=null;
				String text;
				try {//Escucha la entrada de datos
					lector = new BufferedReader(new InputStreamReader ( 
					sockEntrada.getInputStream() ) );
				} catch (IOException e) {
					System.out.println("El servidor no lee la entrada :" + e);
				}
				
				try {//Responde al cliente (salida)
					escritor = new PrintWriter ( new BufferedWriter (
					new OutputStreamWriter ( 
					sockEntrada.getOutputStream() ) ),true );
				} catch (IOException e) {
					System.out.println("El servidor no escribe en la salida:"+e);
				}
				
				try {
					System.out.println("Texto leido:");
					//escritor.println("Se ha escuchado:");
					String t="";
					while ( (text = lector.readLine()) != null ) {
						t=t+text;
						System.out.println(text);
						escritor.println(text);
					}
					// Contesta al cliente
					//escritor.println("Escuchado: "+t+"\n");
					//escritor.flush();
					System.out.println("Peticion atendida");
				} catch (Exception e) {
					System.out.println ("Error: " + e );
				}
				//
			}
		} catch (Exception e) {
			System.out.println ("�Error!: " + e );
		}
	}
	
	public static void main(String[] args) {
		PrintSocketServer servidor = new PrintSocketServer();
		System.out.print("172.22.90.1");
		servidor.run();
	}
}

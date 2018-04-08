
import java.net.*;
import java.io.*;

public class PrintSocketClient {
	
	public static void main(String[] args) {
		PrintWriter pwr 		= null;
		String texto = "Hola a todos\ng";//que tal \n
		String resp="";
		Socket s;
		try {
			s = new Socket( "127.0.0.1",25003 );//7654 //4321
			
			//Escribir (enviar) el texto en el servidor
			pwr = new PrintWriter( new BufferedWriter( new OutputStreamWriter( 
			s.getOutputStream() )), true);
			pwr.println( texto.trim() );
			
			
			//Leer la respuesta del servidor
			BufferedReader br = new BufferedReader(	
			new InputStreamReader ( s.getInputStream() ) );
			
			//System.out.println("Respuesta:"+br.readLine());
			//System.out.println("Respuesta:"+br.readLine());
			System.out.println(texto);

			//pwr.close();
			//br.close();
			s.close();
			System.out.println(" transfer complete");
			
		} catch( IOException e ) {
			System.out.println( e );
		}
	}	
}

package db_connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Scanner;

public class Conecta_db{
	
	public static String executa_pesquisa(String in){		
		String dados = null;
		
		try {  
	          URL url = new URL(in);  
	          URI uri = url.toURI();  
	          BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));  
	          String s;  
	          while ((s = br.readLine()) != null) {  
	                dados += s;  
	          }  
	          br.close();
	          dados = separa_dados(dados);
	          return dados;
	      } catch (MalformedURLException excecao) {  
	          return excecao.toString();  
	      } catch (URISyntaxException excecao) {  
	    	  return excecao.toString();    
	      } catch (IOException excecao) {  
	    	  return excecao.toString();  
	      }  	
	}
	
	public static String separa_dados(String in){
		Scanner dados = new Scanner(in);
		
		String[] tokens = null;
		String data = "";
		
		while (dados.hasNextLine() ){
			tokens = dados.nextLine().split("<body>");
		}	
		
		dados = new Scanner(tokens[1]);
		
		while (dados.hasNextLine() ){
			tokens = dados.nextLine().split("</body>");
		}	
		
		dados = new Scanner(tokens[0]);
	
		while (dados.hasNextLine()){
			tokens = dados.nextLine().split("<br />");
		}
		for(int i = 0; i<=tokens.length-1;i++){
				data += tokens[i] + "\n";
		}	
		return data;
	}
	
	public static String conserta_url(String in){
		Scanner dados = new Scanner(in);
		String nova = "";
		boolean primeira = true;
		
		while (dados.hasNext()){
			if(primeira){
				nova += dados.next();
				primeira = false;
			}else nova += "%20" + dados.next();
		}	
		return nova;
	}
}
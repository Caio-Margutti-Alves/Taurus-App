package each.taurus;

import java.util.ArrayList;
import java.util.Scanner;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import db_connection.Conecta_db;

public class Materia extends Activity {

	private String url_sala = "http://10.0.2.2/android_connect/getdisc.php?prof="; //Url com a variavel necessária pra pesquisa php daquele dado

	private ArrayAdapter<String> fileList = null;
	private ArrayList<String> result = new ArrayList<String>();	
	private ListView lista;
	private String[] ids;
	 
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sal);
		
		//Pega a variável passada pelo prédio
		Intent extras = getIntent();
		String prof = extras.getStringExtra("nm_prof");
		url_sala += prof; 	//Acrescenta na String que indica o php correspondente
	    
		lista = (ListView) findViewById(R.id.list);
		pesquisa();
		lista.setOnItemClickListener( new OnItemClickListener() { //Parte que bota oq acontece se o user clica num item.
		    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		        String disc = ids[(int) id];
		        pesquisa_reservas(disc);
		    }});
	 }
	
	public void pesquisa(){
		url_sala = Conecta_db.conserta_url(url_sala);	//Como a url n pode ter espaços, esse metodo acrescenta"%20" onde tem (espaço na tabela ASCII)
		Scanner dados = new Scanner(Conecta_db.executa_pesquisa(url_sala));
		Scanner aux = new Scanner(Conecta_db.executa_pesquisa(url_sala));
		int i=0;
	
		while (aux.hasNextLine()) {	//Conta quantos registros retornou o arquivo
			aux.nextLine();
			i++;
		}
		
		ids = new String[i];
		i=0;
		while (dados.hasNextLine()) {
			String[] tokens = dados.nextLine().split(";");
			result.add(tokens[1]);	//Divide os dados pelos ";" que tem no arquivo
			ids[i] = tokens[1];		//Faz um array com ids dos registro, ou do dado que precise pra próxima pesquisa
			i++;
		}

		fileList = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,result); //Lista ligada de arrays que pega os registros e os bota num item 
	    lista.setAdapter(fileList); //Atualiza a lista
	}
	
	public void pesquisa_reservas(String in){
		Intent reserva = new Intent(Materia.this,Mat_prof.class); //Passa o id, ou nome da sala pro próximo Activity
        reserva.putExtra("disciplina",in);
        Materia.this.startActivity(reserva);    
	}
}
	

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

public class Reservas_sala extends Activity {

	private String url_reserva = "http://10.0.2.2/android_connect/reservas.php?sala=";

	private ArrayAdapter<String> fileList = null;
	private ArrayList<String> result = new ArrayList<String>();	
	private ListView lista;
	//private int[] ids;
	 
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sal);
		
		Intent extras = getIntent();
		String sala = extras.getStringExtra("id_sala");
		url_reserva += sala;
	
		lista = (ListView) findViewById(R.id.list);
		pesquisa();
		lista.setOnItemClickListener( new OnItemClickListener() {
		    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		        /*String sala = String.valueOf(ids[(int) id]);
		        pesquisa_reservas(predio);*/
		    }});
	 }
	
	public void pesquisa(){
		url_reserva = Conecta_db.conserta_url(url_reserva);
		Scanner dados = new Scanner(Conecta_db.executa_pesquisa(url_reserva));
		
		while (dados.hasNextLine()) {
			String[] tokens = dados.nextLine().split(";");
			result.add("Professor: "  +tokens[4]+"\n"+
						"Disciplina: " + tokens[2]+ "\n"+
						"Horário: "+ tokens[0]+"\n"+
						"Data: " + tokens[1]);
		}

		fileList = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,result);  
	    lista.setAdapter(fileList); 
	}
}
	

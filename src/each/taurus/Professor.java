package each.taurus;

import java.util.ArrayList;
import java.util.Scanner;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import db_connection.Conecta_db;

public class Professor extends Activity {
	
	private String url_professor = "http://10.0.2.2/android_connect/getprof.php";

	private ArrayAdapter<String> fileList = null;
	private ArrayList<String> result = new ArrayList<String>();	
	private ListView lista ; 
	private String[] ids;
	 
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sal);
		
		lista = (ListView) findViewById(R.id.list);
		pesquisa();
		
		lista.setOnItemClickListener( new OnItemClickListener() {
		    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		        String prof = ids[(int) id];
		        pesquisa_prof(prof);
		    }});
		
	 }
	
	public void pesquisa(){
		Scanner dados = new Scanner(Conecta_db.executa_pesquisa(url_professor));
		Scanner aux = new Scanner(Conecta_db.executa_pesquisa(url_professor));
		int i=0;
		
		while (aux.hasNextLine()) {
			aux.nextLine();
			i++;
		}
		ids = new String[i];
		i=0;
		while (dados.hasNextLine()) {
			String[] tokens = dados.nextLine().split(";");
			result.add(tokens[1]);
			ids[i] = tokens[1];
			i++;
		}

		fileList = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,result);  
	    lista.setAdapter(fileList); 
	}
	
	public void pesquisa_prof(String in){
		Intent disc = new Intent(Professor.this,Mat_prof.class);
        disc.putExtra("nm_prof",in);
        Professor.this.startActivity(disc);    
	}
}
	
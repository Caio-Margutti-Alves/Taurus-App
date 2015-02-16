package each.taurus;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
 
public class Principal extends Activity {
 
 
  public void gradeHoraria(View view) {
	    Intent intent = new Intent(Principal.this, GradeHoraria.class);
	    Principal.this.startActivity(intent);
	}
  public void professor(View view) {
	  	Intent intent = new Intent(Principal.this, Professor.class);
	    Principal.this.startActivity(intent);
	}
  public void sala(View view) {
	  	Intent intent = new Intent(Principal.this, Predio.class);
	    Principal.this.startActivity(intent);
	}
  public void disciplina(View view) {
	  	Intent intent = new Intent(Principal.this, Disciplina.class);
	    Principal.this.startActivity(intent);
	}
  
  public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.principal);
   }
 
  
}
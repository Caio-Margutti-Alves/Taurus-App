package each.taurus;


import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Spinner;

public class GradeHoraria extends Activity {
	private Spinner spinner1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grade_horaria);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_grade_horaria, menu);
        addListenerOnSpinnerItemSelection();
        return true;
    }
    
    public void addListenerOnSpinnerItemSelection() {
    	spinner1 = (Spinner) findViewById(R.id.spinner1);
    	spinner1.setOnItemSelectedListener(new CustomOnItemSelectedListener());
      }
}

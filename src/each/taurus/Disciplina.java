package each.taurus;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class Disciplina extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disc);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_disc, menu);
        return true;
    }
}

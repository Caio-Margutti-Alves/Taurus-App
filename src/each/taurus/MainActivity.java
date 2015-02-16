package each.taurus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends Activity {
	
	public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
     
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
     
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
	         						public void run() {
					                    finish();
					                    Intent intent = new Intent(MainActivity.this, Principal.class);
					                    MainActivity.this.startActivity(intent);
				               		}
            					}, 5000); 
        }
}

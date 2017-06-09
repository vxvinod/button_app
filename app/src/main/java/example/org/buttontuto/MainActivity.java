package example.org.buttontuto;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button ourButton;
    private TextView ourMessage;
    private Integer numTapped;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ourButton = (Button) findViewById(R.id.button);
        ourMessage = (TextView) findViewById(R.id.textView);
        numTapped = 0;
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        View.OnClickListener ourOnClickListener = new View.OnClickListener(){

            @Override
            public void onClick(View v){
                numTapped = numTapped+1;
                ourMessage.setText("button is tapped " + numTapped+" Times");
            }

        };

        ourButton.setOnClickListener(ourOnClickListener);



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Toast toast = Toast.makeText(this, "settings is tapped "+ ourMessage.getText(), Toast.LENGTH_LONG);
            toast.show();
            numTapped = 0;
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

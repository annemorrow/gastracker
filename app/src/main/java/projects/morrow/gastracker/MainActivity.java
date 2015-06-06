package projects.morrow.gastracker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends Activity {
    public final static String EXTRA_FLOAT_MPG = "projects.morrow.gastracker.EXTRA_FLOAT_MPG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void submitData(View view) {
        EditText milesText = (EditText) findViewById(R.id.enter_miles);
        String milesString = milesText.getText().toString();
        Float miles = Float.parseFloat(milesString);
        EditText gallonsText = (EditText) findViewById(R.id.enter_gas);
        String gallonsString = gallonsText.getText().toString();
        Float gallons = Float.parseFloat(gallonsString);
        Float mpg = miles / gallons;
        Intent intent = new Intent(this, DisplayLatestMPG.class);
        intent.putExtra(EXTRA_FLOAT_MPG, mpg);
        startActivity(intent);
    }

}

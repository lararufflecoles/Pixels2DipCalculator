package es.rufflecol.lara.pixels2dipcalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textViewThisDevice = (TextView) findViewById(R.id.this_device);
        textViewThisDevice.setText(R.string.this_device);

        TextView textViewDensity = (TextView) findViewById(R.id.density);
        textViewDensity.setText(R.string.density);
    }
}
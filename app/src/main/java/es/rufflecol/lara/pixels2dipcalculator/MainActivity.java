package es.rufflecol.lara.pixels2dipcalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final float MDPI = 160;
    public static final float HDPI = 240;
    public static final float XHDPI = 320;
    public static final float XXHDPI = 480;
    public static final float XXXHDPI = 640;

    private String selectedItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.density_list, R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item); // Specify the layout to use when the list of choices appears
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedItem = (String) parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        Button calculateButton = (Button) findViewById(R.id.calculate_button);
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText pixelValueEditText = (EditText) findViewById(R.id.integer_entry);
                String userEntry = pixelValueEditText.getText().toString();
                int pixels = Integer.parseInt(userEntry);
                float screenDensity = 0;

                if (selectedItem.equals("MDPI")) {
                    screenDensity = MDPI;
                } else if (selectedItem.equals("HDPI")) {
                    screenDensity = HDPI;
                } else if (selectedItem.equals("XHDPI")) {
                    screenDensity = XHDPI;
                } else if (selectedItem.equals("XXHDPI")) {
                    screenDensity = XXHDPI;
                } else if (selectedItem.equals("XXXHDPI")) {
                    screenDensity = XXXHDPI;
                }

                float densityIndependentPixels = (pixels * 160) / screenDensity;
                String display = densityIndependentPixels + " Dip";

                TextView displayResultText = (TextView) findViewById(R.id.display_result);
                displayResultText.setText(display);
            }
        });
    }
}

//              Toast.makeText(MainActivity.this, "Dip: " + Integer.parseInt(enteredInteger.getText().toString()), Toast.LENGTH_SHORT).show();
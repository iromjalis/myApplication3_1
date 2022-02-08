package fi.irinaromjalis.myapplication3_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView result;
    private RadioButton  hex, bin;
    private RadioGroup radioGroup;

    Counter count = new Counter(-15, 20, 0, 7);

    private Button plus, minus;
    private ImageButton reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.radiogroup);
        plus = (Button) findViewById(R.id.plus);
        minus = (Button) findViewById(R.id.minus);
        reset = (ImageButton) findViewById(R.id.reset);
        result = findViewById(R.id.result);

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int value = count.increment(Integer.parseInt(result.getText().toString()));
                result.setText(value+ "");
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int value = count.decrement(Integer.parseInt(result.getText().toString()));
                result.setText(value + "");
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int value = count.reset();

                result.setText(value + "");
            }
        });
    }

    public void checkButton(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.bin:
                if (checked)
                    result.setText(Integer.toBinaryString(Integer.parseInt(result.getText().toString())));
                    break;
            case R.id.hex:
                if (checked)
                    result.setText(Integer.toHexString(Integer.parseInt(result.getText().toString())));
                    break;
        }
    }
}

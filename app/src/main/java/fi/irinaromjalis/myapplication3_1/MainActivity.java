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
    private RadioGroup radioGroup;
    public  int counterValue, value;


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
                counterValue = Integer.parseInt(result.getText().toString());

                value = count.increment(counterValue);
                String res = Integer.toString(value);
                result.setText(res);
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counterValue = Integer.parseInt(result.getText().toString());

                value = count.decrement(counterValue);
                String res = Integer.toString(value);
                result.setText(res);
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int value = count.reset();
                String res = Integer.toString(value);
                result.setText(res);
            }
        });
    }

    public void checkButton(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        counterValue = Integer.parseInt(result.getText().toString());

        switch(view.getId()) {
            case R.id.bin:
                if (checked)
                result.setText(Integer.toBinaryString(counterValue));
                    break;

            case R.id.hex:
                if (checked)
                    result.setText(Integer.toHexString(counterValue));
                    break;
        }
    }
}

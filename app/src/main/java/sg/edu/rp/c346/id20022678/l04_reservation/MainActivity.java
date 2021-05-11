package sg.edu.rp.c346.id20022678.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    TextView txtName;
    TextView noPhone;
    TextView sizePpl;
    DatePicker dp;
    TimePicker tp;
    Button btnReset;
    Button btncfm;
    CheckBox checkSmk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtName = findViewById(R.id.textName);
        noPhone = findViewById(R.id.sad);
        sizePpl = findViewById(R.id.editSize);
        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);
        btncfm = findViewById(R.id.btnConfim);
        btnReset = findViewById(R.id.btnReset);
        checkSmk = findViewById(R.id.checkSmoke);


        dp.updateDate(2021, 5, 1 );
        tp.setCurrentHour(19);
        tp.setCurrentMinute(30);

        tp.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                if(((tp.getCurrentHour()) >= 8) && ((tp.getCurrentHour()) <= 20)
                && ((tp.getCurrentMinute()) <= 59)){
                }
                else {
                    tp.setCurrentHour(19);
                    tp.setCurrentMinute(30);
                    Toast.makeText(MainActivity.this, "Please select an apporiate time between 8AM & 8:59PM", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tp.setCurrentHour(19);
                tp.setCurrentMinute(30);
                dp.updateDate(2021 , 5 , 1);
            }
        });

        btncfm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = "";
                if ((txtName.getText().toString().isEmpty()) || (noPhone.getText().toString().isEmpty())
                        || (sizePpl.getText().toString().isEmpty())){
                    Toast.makeText(MainActivity.this, "Please fill up the fields", Toast.LENGTH_LONG).show();
                }
                else if((dp.getYear() < 2021) || ((dp.getMonth() < 4 )) || (dp.getDayOfMonth() < 11 )) {
                    Toast.makeText(MainActivity.this, "Please fill in a vaild date", Toast.LENGTH_SHORT).show();
                }
                else {
                    text = txtName.getText().toString() + " book a table of " + sizePpl.getText().toString();
                    if (checkSmk.isChecked()){
                        text = text + " at smoking area.";
                    }
                    else {
                        text = text + " at not smoking area.";
                    }

                }
                Toast.makeText(MainActivity.this, text, Toast.LENGTH_LONG).show();
            }
        });
    }
}
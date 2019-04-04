import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int money = 100000;
    int vznos;
    int procent = 1;
    int prosh_procent;
    int kurs = 100;
    int nach_kurs = 100;
    public int vnesti(int mon){
        int vznos = mon/kurs;
        return vznos;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView textView = findViewById(R.id.textView);
        final EditText editText2 = findViewById(R.id.editText2);
        final TextView textView2 = findViewById(R.id.textView2);
        Thread thread = new Thread() {
            public void run() {
                while (true) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            textView2.setText(Integer.toString(kurs));
                        }
                    });
                    kurs = nach_kurs;
                    Random random_procent = new Random();
                    procent = random_procent.nextInt(100);
                    kurs *= procent;
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        };

        thread.start();

        Button button = (Button) findViewById(R.id.Button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String edit = editText2.getText().toString();
                int dengivbanke = vnesti(Integer.parseInt(edit));
                textView.setText("Tvoi den'gi     " + dengivbanke);
            }
        });


    }
}


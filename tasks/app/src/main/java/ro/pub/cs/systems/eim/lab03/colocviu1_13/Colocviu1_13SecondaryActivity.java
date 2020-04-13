package ro.pub.cs.systems.eim.lab03.colocviu1_13;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Colocviu1_13SecondaryActivity extends AppCompatActivity {
    private TextView text;
    private Button register_button, cancel_button;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {

            switch(view.getId()) {
                case R.id.button_register:
                    setResult(RESULT_OK, null);
                    break;
                case R.id.button_cancel:
                    setResult(RESULT_CANCELED, null);
                    break;
            }
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);
        register_button = (Button)findViewById(R.id.button_register);
        cancel_button = (Button)findViewById(R.id.button_cancel);

        register_button.setOnClickListener(buttonClickListener);
        cancel_button.setOnClickListener(buttonClickListener);

        Intent intent = getIntent();
        Bundle data = intent.getExtras();

        text = (TextView) findViewById(R.id.text);

        if (intent != null) {
            String str = intent.getStringExtra("text");
            assert str != null;
            if (!str.equals("")) {
                text.setText(str);
            } else {
                text.setText(new String("no text found"));
            }
        }
    }
}

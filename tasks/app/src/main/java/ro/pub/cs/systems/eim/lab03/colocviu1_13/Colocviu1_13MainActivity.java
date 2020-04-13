package ro.pub.cs.systems.eim.lab03.colocviu1_13;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Colocviu1_13MainActivity extends AppCompatActivity {
    private Button northButton, southButton, eastButton, westButton, navigateButton;
    private TextView pressedButtons;
    private String pressedTextSave = "pressed";
    private String tag = "colocviu";

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {

            switch(view.getId()) {
                case R.id.button_north:
                    pressedButtons.setText(pressedButtons.getText() + ", " + "North");
                    break;
                case R.id.button_east:
                    pressedButtons.setText(pressedButtons.getText() + ", " + "East");
                    break;
                case R.id.button_west:
                    pressedButtons.setText(pressedButtons.getText() + ", " + "West");
                    break;
                case R.id.button_south:
                    pressedButtons.setText(pressedButtons.getText() + ", " + "South");
                    break;
                case R.id.button_navigate:
                    break;
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        northButton = (Button)findViewById(R.id.button_north);
        eastButton = (Button)findViewById(R.id.button_east);
        westButton = (Button)findViewById(R.id.button_west);
        southButton = (Button)findViewById(R.id.button_south);
        navigateButton = (Button)findViewById(R.id.button_navigate);
        pressedButtons = (TextView) findViewById(R.id.pressed_buttons);

        northButton.setOnClickListener(buttonClickListener);
        eastButton.setOnClickListener(buttonClickListener);
        westButton.setOnClickListener(buttonClickListener);
        southButton.setOnClickListener(buttonClickListener);
        navigateButton.setOnClickListener(buttonClickListener);
        Log.d("colocviu", "onCreate called");
        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey(pressedTextSave)) {
                pressedButtons.setText(savedInstanceState.getString(pressedTextSave));
            } else {
                pressedButtons.setText("");
            }
        } else {
            pressedButtons.setText("");
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        Log.d("colcviu", "onSaveInstanceState called");
        savedInstanceState.putString(pressedTextSave, pressedButtons.getText().toString());
        Log.d("colcviu", "saving.. " + pressedButtons.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        Log.d("colcviu", "onRestoreInstanceState called");
        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey(pressedTextSave)) {
                pressedButtons.setText(savedInstanceState.getString(pressedTextSave));
            } else {
                pressedButtons.setText("");
            }
        } else {
            pressedButtons.setText("");
        }
    }

    @Override
    public void onRestart() {
        super.onRestart();
        Log.d(tag, "onRestart() method was invoked");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(tag, "onStart() method was invoked");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(tag, "onResume() method was invoked");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(tag, "onPause() method was invoked");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(tag, "onStop() method was invoked");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(tag, "onDestroy() method was invoked");
    }

}


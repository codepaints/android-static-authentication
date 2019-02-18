package me.jatinsoni.moduleoneassignment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // set up the credentials constants
    private static final String USERNAME = "edureka";
    private static final String PASSWORD = "edureka123";

    // widget members
    EditText username, password;
    TextView feedbackMessage;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get all widgets
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        loginButton = findViewById(R.id.sign_in_button);
        feedbackMessage = findViewById(R.id.feedback_message);

        // hide and clear feedback message onCreate
        feedbackMessage.setText("");
        feedbackMessage.setVisibility(View.GONE);

        // set the button click listener
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // show a toast message on button click, just to cross check the click
                Toast.makeText(MainActivity.this, "Button Clicked!", Toast.LENGTH_SHORT).show();

                // convert credentials value to string
                String currentUsername = username.getText().toString();
                String currentPassword = password.getText().toString();

                // check for empty fields. If any than show the message
                if (currentUsername.trim().length() == 0 || currentPassword.trim().length() == 0) {

                    feedbackMessage.setText(getResources().getString(R.string.missing_field_message));
                    feedbackMessage.setTextColor(getResources().getColor(R.color.colorWarning));
                    feedbackMessage.setVisibility(View.VISIBLE);

                }
                // if both fields has value than move on
                else {

                    //verify the credentials
                    if (currentUsername.equals(USERNAME) && currentPassword.equals(PASSWORD)) {

                        // set message text
                        feedbackMessage.setText(getResources().getString(R.string.success_message));
                        // set the success color
                        feedbackMessage.setTextColor(getResources().getColor(R.color.colorSuccess));
                        // make it visible
                        feedbackMessage.setVisibility(View.VISIBLE);
                        // set button state to disabled
                        loginButton.setEnabled(false);

                    }
                    // display message if wrong credentials
                    else {

                        // set message text
                        feedbackMessage.setText(getResources().getString(R.string.failure_message));
                        // set the warning color
                        feedbackMessage.setTextColor(getResources().getColor(R.color.colorWarning));
                        // make it visible
                        feedbackMessage.setVisibility(View.VISIBLE);

                        //clear the input values
                        username.setText("");
                        password.setText("");

                    }

                }

            }
        });

    }
}

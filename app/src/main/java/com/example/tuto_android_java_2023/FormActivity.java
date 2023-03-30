package com.example.tuto_android_java_2023;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FormActivity extends AppCompatActivity {

    private int LAUNCH_SECOND_ACTIVITY = 1;

    private final String TAG = FormActivity.class.getSimpleName();
    private Button btnValidate;

    private  EditText editNom, editPrenom, editAge;

    public static final String KEY_INFO = "key info";
    public static final String KEY_PERSON = "key person";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        btnValidate = findViewById(R.id.button_val);

        editPrenom = findViewById(R.id.et_form_prenom);
        editNom = findViewById(R.id.et_form_nom);
        editAge = findViewById(R.id.et_form_age);




      /*  if(getIntent().getExtras() != null) {
            // Get intent extras from Activity 1
            String message = getIntent().getStringExtra(SecondActivity.KEY_NAME);

            editPrenom.setText(message);

        }*/



        btnValidate.setOnClickListener(v -> {
            //INSTANCE MUST BE OUTSIDE



            Intent secondActivityIntent = new Intent(
                    this, SecondActivity.class

            );

            startActivityForResult(secondActivityIntent, LAUNCH_SECOND_ACTIVITY);

            //setResult(Activity.RESULT_OK, secondActivityIntent);
            //finish();

/*
            String nom = editNom.getText().toString().trim();
            String prenom = editPrenom.getText().toString().trim();
            String ageStr = editAge.getText().toString().trim();*/

                  /*  if (!ageStr.isEmpty() && !nom.isEmpty() && !prenom.isEmpty()) {
                        int age = Integer.parseInt(ageStr);


                        Person person = new Person(nom, prenom, age);
                        String message = "Bonjour " + prenom + " " + nom + " tu es " + (age > 18 ? "majeur" : "mineur");
                        //Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
                        Intent secondActivityIntent = new Intent(
                               this, SecondActivity.class

                        );
                        //secondActivityIntent.putExtra(KEY_INFO, message);
                        //secondActivityIntent.putExtra(KEY_INFO, person);
                        startActivity(secondActivityIntent);
                        finish();
                    }*/

                }
        );
    }

    //LOG for each method of life cycle


    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onReStart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "destroy");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // check that it is the SecondActivity with an OK result
        if (requestCode == LAUNCH_SECOND_ACTIVITY) {
            if (resultCode == RESULT_OK) { // Activity.RESULT_OK

                // get String data from Intent
                String returnString = data.getStringExtra(SecondActivity.KEY_NAME);

                editPrenom.setText(returnString);
            } else if(resultCode == RESULT_CANCELED) {
                Log.w(TAG, "COUCOU warning");
                String msg = data == null ? "cancelled via back" : "cancelled via button";
                Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
            }
        }
    }
}
package sg.edu.rp.c346.id22021506.demomyprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etGPA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.editTextText);
        etGPA = findViewById(R.id.editTextText3);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //get user input from editText and store it in a variable
        String strName = etName.getText().toString();
        float GPA = Float.parseFloat(etGPA.getText().toString());
        //obtain the SharePreferences instance
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        //obtain an instance of the SharedPreference Editor for update later
        SharedPreferences.Editor prefEdit = prefs.edit();
        //add tge key-value pair
        prefEdit.putString("Names", strName);
        prefEdit.putFloat("GPA", Float.parseFloat(String.valueOf(GPA)));
        //call commit() to save the changes made to the SharedPreference
        prefEdit.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //obtain the SharedPreferences instance
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        //retrieve the saved data from the SharedPreferences with a default value if no matching data
        String msg = prefs.getString("Names", "");
        float msg2 = prefs.getFloat("GPA", 0.0f);
        //update the UI element with the value
        etName.setText(msg);
        etGPA.setText(String.valueOf(msg2));
    }
}
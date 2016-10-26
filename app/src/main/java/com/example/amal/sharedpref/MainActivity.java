package com.example.amal.sharedpref;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class MainActivity extends Activity {

    Button saveButton,removeButton;
    EditText text;
    SharedPreferences sp;
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        saveButton=(Button)findViewById(R.id.saveButton);
        removeButton=(Button)findViewById(R.id.removeButton);
        text=(EditText)findViewById(R.id.text);

        sp=getSharedPreferences("testPrefs",MODE_PRIVATE);
        editor=sp.edit();

        if(sp.contains("name")){
            text.setText(sp.getString("name","null"));
        }
    }

    public void buttonAction(View view) {

        if(view.getId()==R.id.saveButton){
            editor.putString("name",text.getText().toString());
            editor.commit();
            Toast.makeText(getApplicationContext(),"Preferences Saved",Toast.LENGTH_LONG).show();
        }

        if(view.getId()==R.id.removeButton){
            editor.clear();
            editor.commit();
            Toast.makeText(getApplicationContext(),"Preferences Removed",Toast.LENGTH_LONG).show();
        }
    }
}

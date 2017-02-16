package app.first.sandy.session8assignment2;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener{

    EditText name;
    EditText numb;
    EditText age;
    EditText city;
    Button show;
    Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name= (EditText)findViewById(R.id.name);
        numb = (EditText)findViewById(R.id.numb);
        age =(EditText)findViewById(R.id.age);
        city=(EditText)findViewById(R.id.city);
        show=(Button) findViewById(R.id.show);
        save=(Button) findViewById(R.id.save);
        show.setOnClickListener(this);
        save.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.save){
            saveData();
        }
        if (v.getId()==R.id.show){
            showData();
        }

    }

    private void saveData(){

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        SharedPreferences.Editor editor=preferences.edit();
        editor.putString("name",name.getText().toString());
        editor.putString("age",age.getText().toString());
        editor.putString("phone",numb.getText().toString());
        editor.putString("city",city.getText().toString());
        editor.commit();

        Toast.makeText(this,"Preferences Saved",Toast.LENGTH_SHORT).show();
    }

     private void showData(){
         SharedPreferences preferences =PreferenceManager.getDefaultSharedPreferences(MainActivity.this);

         String name = preferences.getString("name", "Default");
         String age = preferences.getString("age", "Default");
         String phone = preferences.getString("phone", "Default");
         String city = preferences.getString("city", "Default");

         StringBuilder builder = new StringBuilder();

         builder.append("Name: " + name + "\n");
         builder.append("Age: " + age + "\n");
         builder.append("Phone: " + phone + "\n");
         builder.append("City: " + city + "\n");

         Toast.makeText(this,builder.toString(),Toast.LENGTH_SHORT).show();
     }

}


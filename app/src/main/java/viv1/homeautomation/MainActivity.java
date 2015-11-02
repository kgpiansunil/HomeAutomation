package viv1.homeautomation;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    Button submit_button;
    EditText user_name,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*Intent webpage=new Intent();
        webpage.setClass(this, WebPageActivity.class);
        startActivity(webpage);*/
        setContentView(R.layout.activity_main);

        user_name= (EditText) findViewById(R.id.editText2);
        submit_button= (Button) findViewById(R.id.button);
        password=(EditText) findViewById(R.id.editText);

        submit_button.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View view)
                    {
                        //Log.v("EditText", user_name.getText().toString());

                        if(user_name.getText().toString().equals("") && user_name.getText().toString().equals("")){
                            Intent online_offline=new Intent(view.getContext(),online_offlineActivity.class);
                            startActivity(online_offline);
                        }else {
                            Toast.makeText(MainActivity.this, "Wrong username or password!", Toast.LENGTH_SHORT).show();

                        }
                    }
                });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onKeyDown(int keyCode, KeyEvent event)  {
        //exit application on back button
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);



        }

        return super.onKeyDown(keyCode, event);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

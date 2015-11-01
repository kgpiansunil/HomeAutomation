package viv1.homeautomation;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class DeviceNameActivity extends ActionBarActivity {

    private Button submit_button;
    private EditText Name;
    private EditText Address;
    private String string_num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_name);

        Address= (EditText) findViewById(R.id.editText2);
        submit_button= (Button) findViewById(R.id.button);
        Name=(EditText) findViewById(R.id.editText);


        Intent intent=getIntent();
        Bundle extras= intent.getExtras();
        if(extras!=null) {
            string_num = extras.getString("num");
        }
        
        submit_button.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View view)
                    {
                        //Log.v("EditText", user_name.getText().toString());

                        Intent roomActivity=new Intent(view.getContext(),RoomActivity.class);
                        String name=Name.getText().toString();
                        String address=Address.getText().toString();

                        roomActivity.putExtra("name",name);
                        roomActivity.putExtra("address",address);
                        roomActivity.putExtra("string_num",string_num);
                        startActivity(roomActivity);
                    }
                });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_device_name, menu);
        return true;
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

package viv1.homeautomation;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;


public class online_offlineActivity extends ActionBarActivity {

    Button online;
    Button offline;
    EditText online_url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online_offline);

        online=(Button) findViewById(R.id.button2);
        offline=(Button) findViewById(R.id.button3);
        online_url=(EditText) findViewById(R.id.editText_online);


        offline.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View view)
                    {
                        if (!isNetworkAvailable() || isMobileNetwork()){
                            Toast.makeText(online_offlineActivity.this, "Connect to Wifi!", Toast.LENGTH_SHORT).show();
                        }else{
                            Intent room=new Intent(view.getContext(),RoomActivity.class);
                            startActivity(room);
                        }
                    }
                });

        online.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View view)
                    {
                       // Intent scanWifidevices=new Intent(view.getContext(),CheckWifiNetworkActivity.class);

                        //startActivity(scanWifidevices);
                        if (!isNetworkAvailable()){
                            Toast.makeText(online_offlineActivity.this, "Connect to Internet!", Toast.LENGTH_SHORT).show();
                        }else{
                            Intent room=new Intent(view.getContext(),RoomActivity2.class);
                            startActivity(room);
                        }


                    }
                });
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    private boolean isMobileNetwork() {

       // boolean mobileDataAllowed = Settings.Secure.getInt(getContentResolver(), "mobile_data", 1) == 1;
        //^^^^^USE ABOVE IF BELOW FAILS^^^^APPARANTLY IT FAILS FOR LOLLIPOP
        //http://stackoverflow.com/questions/12806709/how-to-tell-if-mobile-network-data-is-enabled-or-disabled-even-when-connected

        boolean mobileDataEnabled = false; // Assume disabled
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        try {
            Class cmClass = Class.forName(cm.getClass().getName());
            Method method = cmClass.getDeclaredMethod("getMobileDataEnabled");
            method.setAccessible(true); // Make the method callable
            // get the setting for "mobile data"
            mobileDataEnabled = (Boolean)method.invoke(cm);
        } catch (Exception e) {
            // Some problem accessible private API
            // TODO do whatever error handling you want here
        }
        return mobileDataEnabled;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_online_offline, menu);
        return true;
    }

    public boolean onKeyDown(int keyCode, KeyEvent event)  {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
                Intent i = new Intent(online_offlineActivity.this, MainActivity.class);
                startActivity(i);
                return true;

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

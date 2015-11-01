package viv1.homeautomation;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.view.ViewGroup.LayoutParams;

import java.util.List;


public class DisplayResults extends ActionBarActivity {

    String networkPass;
    String networkSSID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_results);
        /*RelativeLayout relLayout = (RelativeLayout) findViewById(R.id.rel_lay_display);
        LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        Button button = new Button(this);
        button.setText("I'm a button!");
        Button button2 = new Button(this);
        button2.setText("I'm a button2!");

// add whatever other attributes you want to the button
        relLayout.addView(button,lp);
        relLayout.addView(button2,lp);*/

        networkSSID = "Flat no 3";          //initializing
        networkPass = "9036398599";         //initializing

        final Button butt4 = (Button) findViewById(R.id.button4);
        final Button butt5 = (Button) findViewById(R.id.button5);
        final Button butt6 = (Button) findViewById(R.id.button6);
        final Button butt7 = (Button) findViewById(R.id.button7);
        final Button butt8 = (Button) findViewById(R.id.button8);
        final Button butt9 = (Button) findViewById(R.id.button9);
        final Button butt10 = (Button) findViewById(R.id.button10);
        final Button butt11 = (Button) findViewById(R.id.button11);
        final Button butt12= (Button) findViewById(R.id.button12);
        final Button butt13 = (Button) findViewById(R.id.button13);

        //Enable Wifi
        WifiManager wifiManager = (WifiManager)getSystemService(Context.WIFI_SERVICE);
        wifiManager.setWifiEnabled(true);


//        conf.SSID = "\"" + networkSSID + "\"";   // Please note the quotes. String should
//
//        conf.wepKeys[0] = "\"" + networkPass + "\"";
//        conf.wepTxKeyIndex = 0;
//        conf.allowedKeyManagement.set(WifiConfiguration.KeyMgmt.NONE);
//        conf.allowedGroupCiphers.set(WifiConfiguration.GroupCipher.WEP40);
//        conf.preSharedKey = "\""+ networkPass +"\"";
//
//        wifiManager.addNetwork(conf);

        final List<WifiConfiguration> list = wifiManager.getConfiguredNetworks();

        int buttonNum=3;
        for( WifiConfiguration i : list ) {
                 //display only top 10
            if(i.SSID != null) {
                buttonNum++;
                if(buttonNum>13) break;
                String buttid="button"+buttonNum;
                int resID = getResources().getIdentifier(buttid, "id", "viv1.homeautomation");
                Button b= (Button) findViewById(resID);
                b.setText((i.SSID).replace("\"",""));
                b.setVisibility(View.VISIBLE);

            }
        }


        butt4.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View view)
                    {showPopUp2(view,4);



                    }
                });

        butt5.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View view)
                    {
                        showPopUp2(view,5);




                    }
                });

        butt6.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View view)
                    {
                        showPopUp2(view,6);



                    }
                });

        butt7.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View view)
                    {
                        showPopUp2(view,7);


                    }
                });

        butt8.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View view)
                    {
                        showPopUp2(view,8);



                    }
                });

        butt9.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View view)
                    {
                        showPopUp2(view,9);


                    }
                });

        butt10.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View view)
                    {
                        showPopUp2(view,10);


                    }
                });

        butt11.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View view)
                    {
                        showPopUp2(view,11);



                    }
                });

        butt12.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View view)
                    {
                        showPopUp2(view,12);



                    }
                });
        butt13.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View view)
                    {
                        showPopUp2(view,13);


                    }
                });


        /*for( WifiConfiguration i : list ) {
            if(i.SSID != null && i.SSID.equals("\"" + networkSSID + "\"")) {
                wifiManager.disconnect();
                wifiManager.enableNetwork(i.networkId, true);
                wifiManager.reconnect();

                break;
            }
        }*/



    }


    private void showPopUp2(final View view,final int numB) {

        AlertDialog.Builder helpBuilder = new AlertDialog.Builder(this);
        helpBuilder.setTitle("Connect to Wifi");
        helpBuilder.setMessage("Enter password");
        final EditText input = new EditText(this);
        input.setSingleLine();
        input.setText("");
        helpBuilder.setView(input);

        helpBuilder.setNeutralButton("Submit", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Do nothing
                networkPass=input.getText().toString();

                WifiConfiguration conf = new WifiConfiguration();

                String buttid="button"+numB;
                int resID = getResources().getIdentifier(buttid, "id", "viv1.homeautomation");
                Button b= (Button) findViewById(resID);
                conf.SSID = "\"" +b.getText() + "\"";
                conf.wepKeys[0] = "\"" + networkPass + "\"";
                conf.wepTxKeyIndex = 0;
                conf.preSharedKey = "\""+ networkPass +"\"";

                WifiManager wifiManager = (WifiManager)getSystemService(Context.WIFI_SERVICE);
                wifiManager.addNetwork(conf);

                List<WifiConfiguration> list = wifiManager.getConfiguredNetworks();

                    for( WifiConfiguration i : list ) {
                        if(i.SSID != null &&(i.SSID).equals("\"" +b.getText()+"\"")) {



                            wifiManager.disconnect();
                            wifiManager.enableNetwork(i.networkId, true);
                            wifiManager.reconnect();
                            goToRoom(view);
                            break;
                        }
                    }
                }
        });

        // Remember, create doesn't show the dialog
        AlertDialog helpDialog = helpBuilder.create();
        helpDialog.show();

    }
    public void goToRoom(View view){
        Intent room=new Intent(view.getContext(),RoomActivity.class);
        startActivity(room);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_display_results, menu);
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

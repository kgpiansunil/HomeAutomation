package viv1.homeautomation;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.List;


public class RoomActivity extends ActionBarActivity {

    private Button add_button;
    private Button remove_button;
    private Button butt16;
    private Button butt17;
    private Button butt18;
    private Button butt19;
    private Button butt20;
    private Button butt21;
    private Button butt22;
    private Button butt23;
    private Button butt24;
    private Button butt25;
    private String string_name;
    private String string_address;
    private int room_num=0;
    private int button_number=15;

    private String[] room_name=new String[12] ;
    private String[] room_address=new String[12] ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);

        add_button=(Button) findViewById(R.id.button15);
       // remove_button=(Button) findViewById(R.id.button14);
        butt16=(Button) findViewById(R.id.button16);
        butt17=(Button) findViewById(R.id.button17);
        butt18=(Button) findViewById(R.id.button18);
        butt19=(Button) findViewById(R.id.button19);
        butt20=(Button) findViewById(R.id.button20);
        butt21=(Button) findViewById(R.id.button21);
        butt22=(Button) findViewById(R.id.button22);
        butt23=(Button) findViewById(R.id.button23);
        butt24=(Button) findViewById(R.id.button24);
        butt25=(Button) findViewById(R.id.button25);


//        Intent intent=getIntent();
//        Bundle extras= intent.getExtras();
//        if(extras!=null){
//            string_name=extras.getString("name");
//            string_address=extras.getString("address");
//            device_num=extras.getString("string_num");
//
//                        int tempMaxnum=Integer.parseInt(device_num);
//                    for(int i=16;i<=tempMaxnum;i++) {
//                        String buttid = "button" + device_num;
//                        int resID = getResources().getIdentifier(buttid, "id", "viv1.homeautomation");
//                        Button b = (Button) findViewById(resID);
//                        b.setText(string_name);
//                        b.setVisibility(View.VISIBLE);
//                    }
//        }

        add_button.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View view)
                    {

//                        String buttid="button"+device_num;
//                        int resID = getResources().getIdentifier(buttid, "id", "viv1.homeautomation");
//                        Button b= (Button) findViewById(resID);
//                       // b.setText();
//                        b.setVisibility(View.VISIBLE);
//                        if(device_num!=null){
//                            button_number =Integer.parseInt(device_num);
//                            button_number++;
//
//                        }else button_number++;
                        showPopUp2(view);




                    }
                });

//        remove_button.setOnClickListener(
//                new View.OnClickListener()
//                {
//                    public void onClick(View view)
//                    {
//                        Intent connectToUrl=new Intent(view.getContext(),DisplayResults.class);
//                        //String url=online_url.getText().toString();
//                        //connectToUrl.putExtra("url",url );
//                        startActivity(connectToUrl);
//
//                    }
//                });

        //TO DO....
        //USE A LOOP FOR VISITING PAGES AND EDITING

        for(int i=16;i<=25;i++){

            final int j=i;      //cannot use i inside inner class unless declared final, and final variable cannot be re assigned...so using j like this.
            String bid = "button" + i;
            int resID = getResources().getIdentifier(bid, "id", "viv1.homeautomation");
            Button b = (Button) findViewById(resID);
            b.setOnClickListener(
                    new View.OnClickListener()
                    {
                        public void onClick(View view)
                        {
                            goToAddress(view, j-15);
                        }
                    });

            //Long Click behaviour

            b.setOnLongClickListener(new View.OnLongClickListener() {
                public boolean onLongClick(View view) {
                    showEditPopUp(view,j-15);
                    return true;  // avoid extra click events
                }
            });

        }


    }


    public void openPage(int i, String s, View view){
        Intent connectToUrl=new Intent(view.getContext(),WebPageActivity.class);
          String url="http://www.google.com";
         connectToUrl.putExtra("url",url );
        startActivity(connectToUrl);

    }
    private void showPopUp2(final View view) {

        AlertDialog.Builder helpBuilder = new AlertDialog.Builder(this);
        helpBuilder.setTitle("New Location");
        helpBuilder.setMessage("Enter details");
//        final EditText input = new EditText(this);
//        input.setSingleLine();
//        input.setText("");
//        helpBuilder.setView(input);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);

        final EditText input = new EditText(this);
        input.setHint("Name");
        layout.addView(input);

        final EditText input2 = new EditText(this);
        input2.setHint("Url Address");
        layout.addView(input2);

        helpBuilder.setView(layout);

        helpBuilder.setNeutralButton("Submit", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                room_num++;
                if(room_num>10) Toast.makeText(RoomActivity.this, "Cannot Add more!", Toast.LENGTH_SHORT).show();
                else {
                    room_name[room_num] = input.getText().toString();
                    room_address[room_num] = input2.getText().toString();

                    int temp_b = room_num + 15;
                    String buttid = "button" + temp_b;
                    int resID = getResources().getIdentifier(buttid, "id", "viv1.homeautomation");
                    Button b = (Button) findViewById(resID);
                    b.setText(room_name[room_num]);
                    b.setVisibility(View.VISIBLE);
                }

            }
        });

        // Remember, create doesn't show the dialog
        AlertDialog helpDialog = helpBuilder.create();
        helpDialog.show();

    }

    private void showEditPopUp(final View view, final int num) {

        AlertDialog.Builder helpBuilder = new AlertDialog.Builder(this);
        helpBuilder.setTitle("Edit Location");
        helpBuilder.setMessage("Enter details");
//        final EditText input = new EditText(this);
//        input.setSingleLine();
//        input.setText("");
//        helpBuilder.setView(input);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);

        final EditText input = new EditText(this);
        input.setText(room_name[num]);
        layout.addView(input);

        final EditText input2 = new EditText(this);
        input2.setText(room_address[num]);
        layout.addView(input2);

        helpBuilder.setView(layout);

        helpBuilder.setNeutralButton("Submit", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                    room_name[num] = input.getText().toString();
                    room_address[num] = input2.getText().toString();

                    int temp_b = num + 15;
                    String buttid = "button" + temp_b;
                    int resID = getResources().getIdentifier(buttid, "id", "viv1.homeautomation");
                    Button b = (Button) findViewById(resID);
                    b.setText(room_name[num]);
                    b.setVisibility(View.VISIBLE);


            }
        });

        // Remember, create doesn't show the dialog
        AlertDialog helpDialog = helpBuilder.create();
        helpDialog.show();

    }

    public void goToAddress(View view,int num){
        Intent room_url=new Intent(view.getContext(),WebPageActivity.class);
        String url=room_address[num];
        room_url.putExtra("url",url );
        int temp=1;
        room_url.putExtra("offline",temp);
        startActivity(room_url);
    }

    public boolean onKeyDown(int keyCode, KeyEvent event)  {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
                Intent i = new Intent(RoomActivity.this, online_offlineActivity.class);
                startActivity(i);
                return true;

        }

        return super.onKeyDown(keyCode, event);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_room, menu);
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

package viv1.homeautomation;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class WebPageActivity extends ActionBarActivity {
    WebView home_page;
    String url_value;
    int backpage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_page);

        //find WebView component
        home_page = (WebView) findViewById(R.id.WebView1);
        home_page.setWebViewClient(new WebViewClient());
        home_page.getSettings().setBuiltInZoomControls(true);
        home_page.getSettings().setJavaScriptEnabled(true);
        Intent intent=getIntent();
        Bundle extras= intent.getExtras();
        if(extras!=null){
            url_value=extras.getString("url");
            backpage=extras.getInt("offline");
            url_value="http://"+url_value;
        }


        home_page.loadUrl(url_value);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_web_page, menu);
        return true;
    }

    public boolean onKeyDown(int keyCode, KeyEvent event)  {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            if(backpage==0) {
                Intent i = new Intent(WebPageActivity.this, online_offlineActivity.class);
                startActivity(i);
                return true;
            }else{
                Intent i = new Intent(WebPageActivity.this, RoomActivity.class);
                startActivity(i);
                return true;
            }
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

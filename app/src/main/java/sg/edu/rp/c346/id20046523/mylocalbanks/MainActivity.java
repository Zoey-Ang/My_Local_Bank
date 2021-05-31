package sg.edu.rp.c346.id20046523.mylocalbanks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvDBS, tvOCBC, tvUOB;
    String bankChose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDBS =findViewById(R.id.bankDBS);
        registerForContextMenu(tvDBS);

        tvOCBC=findViewById(R.id.bankOCBC);
        registerForContextMenu(tvOCBC);

        tvUOB=findViewById(R.id.bankUOB);
        registerForContextMenu(tvUOB);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0,0,0,getString(R.string.website));
        menu.add(0,1,1,getString(R.string.contact));
        menu.add(0,2,2,getString(R.string.fav));

        if(v==tvDBS)
        {
            bankChose=getString(R.string.dbs);
        }
        else if(v==tvOCBC)
        {
            bankChose=getString(R.string.ocbc);
        }
        else if(v==tvUOB)
        {
            bankChose=getString(R.string.uob);
        }

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        boolean colour;
        if(bankChose.equalsIgnoreCase(getString(R.string.dbs)))
        {
            if(id==0)
            {
                Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.dbsLink)));
                startActivity(intentWeb);
                return true;
            }
            else if(id==1)
            {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse(getString(R.string.tel) + getString(R.string.dbsNum)));
                startActivity(intentCall);
            }
            else if(id==2)
            {
                if(tvDBS.getCurrentTextColor()== Color.RED)
                {
                    tvDBS.setTextColor(Color.BLACK);
                }
                else if (tvDBS.getCurrentTextColor()==Color.BLACK)
                {
                    tvDBS.setTextColor(Color.RED);
                }
            }
        }
        else if(bankChose.equalsIgnoreCase(getString(R.string.ocbc)))
        {
            if(id==0)
            {
                Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.ocbcLink)));
                startActivity(intentWeb);
                return true;
            }
            else if(id==1)
            {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse(getString(R.string.tel) + getString(R.string.ocbcNum)));
                startActivity(intentCall);
            }
            else if(id==2)
            {
                if(tvOCBC.getCurrentTextColor()== Color.RED)
                {
                    tvOCBC.setTextColor(Color.BLACK);
                }
                else if (tvOCBC.getCurrentTextColor()==Color.BLACK)
                {
                    tvOCBC.setTextColor(Color.RED);
                }
            }
        }
        else if(bankChose.equalsIgnoreCase(getString(R.string.uob)))
        {
            if(id==0)
            {
                Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.uobLink)));
                startActivity(intentWeb);
                return true;
            }
            else if(id==1)
            {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse(getString(R.string.tel) + getString(R.string.uobNum)));
                startActivity(intentCall);
            }
            else if(id==2)
            {
                if(tvUOB.getCurrentTextColor()== Color.RED)
                {
                    tvUOB.setTextColor(Color.BLACK);
                }
                else if (tvUOB.getCurrentTextColor()==Color.BLACK)
                {
                    tvUOB.setTextColor(Color.RED);
                }
            }
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int languageId= item.getItemId();
        if(languageId== R.id.engLang)
        {
            tvDBS.setText(getString(R.string.dbs));
            tvOCBC.setText(getString(R.string.ocbc));
            tvUOB.setText(getString(R.string.uob));
        }
        else
        {
            tvDBS.setText(getString(R.string.chiDBS));
            tvOCBC.setText(getString(R.string.chiOCBC));
            tvUOB.setText(getString(R.string.chiUOB));
        }

        return super.onOptionsItemSelected(item);
    }
}
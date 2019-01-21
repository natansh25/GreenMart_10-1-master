package infinity1087.android.com.examplehr.NavigationScreens;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import infinity1087.android.com.examplehr.R;

public class HelpActivity extends AppCompatActivity {

    Button btn_legal;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        builder = new AlertDialog.Builder(this);
        btn_legal = (Button) findViewById(R.id.btn_legal);
        btn_legal.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                LayoutInflater li = LayoutInflater.from(HelpActivity.this);
                View promptsView = li.inflate(R.layout.dialog_privacy, null);
                builder.setView(promptsView);
                builder.setCancelable(false)
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();

                            }
                        })
                        .setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();

                            }
                        });

                AlertDialog alert = builder.create();
                //Setting the title manually
                alert.setTitle("Privacy Policies");
                alert.show();
            }
        });
    }
}

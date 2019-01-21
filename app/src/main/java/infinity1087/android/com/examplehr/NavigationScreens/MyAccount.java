package infinity1087.android.com.examplehr.NavigationScreens;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import infinity1087.android.com.examplehr.R;

public class MyAccount extends AppCompatActivity {

    //TODO
    AlertDialog.Builder builder;
    Button btn_changepass, btn_add_add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_accountupdate);
        builder = new AlertDialog.Builder(this);

        //to remove title from toolbar
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        btn_add_add = (Button)findViewById(R.id.btn_addnew_address);
        btn_add_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater li = LayoutInflater.from(MyAccount.this);
                View promptsView = li.inflate(R.layout.activity_add_newaddress, null);
                builder.setView(promptsView);
                builder .setCancelable(false)
                        .setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
//                                results.setText(userin.getText());
                                Toast.makeText(getApplicationContext(),"Address Successfully changed",
                                        Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                                Toast.makeText(getApplicationContext(),"Cancelled!",
                                        Toast.LENGTH_SHORT).show();
                            }
                        });
                AlertDialog alert = builder.create();
                //Setting the title manually
                alert.setTitle("Add NewAddress");
                alert.show();
            }
        });


        btn_changepass = (Button)findViewById(R.id.btn_changepass);
        btn_changepass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater li = LayoutInflater.from(MyAccount.this);
                View promptsView = li.inflate(R.layout.new_password, null);
                builder.setView(promptsView);
                builder .setCancelable(false)
                        .setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
//                                results.setText(userin.getText());
                                Toast.makeText(getApplicationContext(),"Password Successfully changed",
                                        Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                                Toast.makeText(getApplicationContext(),"Cancelled!",
                                        Toast.LENGTH_SHORT).show();
                            }
                        });
                AlertDialog alert = builder.create();
                //Setting the title manually
                alert.setTitle("Change Password");
                alert.show();
            }
        });
    }

    public void btn_accupdate(View view) {

        Intent i = new Intent(MyAccount.this,MyAccountnew.class);
        startActivity(i);
    }


}

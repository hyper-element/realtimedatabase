package element.hyper.example_realtimedatabase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import model.Details;

public class MainActivity extends AppCompatActivity {

    private EditText et_msg;
    private Button btn_send;
    private Button btn_generate_obj;
    private FirebaseDatabase database;
    private DatabaseReference myRef;
    private DatabaseReference myRef1;
    private int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        et_msg = (EditText) findViewById(R.id.et_msg);
        btn_send = (Button) findViewById(R.id.btn_send);
        btn_generate_obj = (Button) findViewById(R.id.btn_generate_obj);

        database = FirebaseDatabase.getInstance();
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);

        myRef = database.getReference("details");
        myRef1 = database.getReference("details").child("msg");

        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = et_msg.getText().toString();
                if (!TextUtils.isEmpty(msg)) {
                    myRef1.setValue(msg);
                } else {
                    Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_generate_obj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = 5;
                String name = "Smit";
                String surname = "Satodia";
                String extra = "This is just testing";

                Details details = new Details(id, name, surname, extra);
                String key = i + "";
                i = i + 1;
                myRef.child(key).setValue(details);
            }
        });
    }
}

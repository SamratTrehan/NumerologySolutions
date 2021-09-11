package spark.india.numerologysolutions;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.india.numerologysolutions.R;

import java.util.Calendar;

public class info extends AppCompatActivity {
    String dks;
    int d,y,m;
    int day,month,year;
    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage("Are you sure you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", (dialog, id) -> info.this.finish())
                .setNegativeButton("No", null)
                .show();

    }

    private DatePickerDialog.OnDateSetListener dat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        EditText fn = findViewById(R.id.editTextTextPersonName);


        ImageButton b = findViewById(R.id.button);
        Button b2= findViewById(R.id.button2);
       
        


        b2.setOnClickListener(view -> {
            Calendar cal= Calendar.getInstance();
            d= cal.get(Calendar.DAY_OF_MONTH);
            m= cal.get(Calendar.MONTH);
            y= cal.get(Calendar.YEAR);

            DatePickerDialog dpd= new DatePickerDialog(info.this, android.R.style.Theme_Holo_Dialog_MinWidth, dat,y,m,d);
            dpd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT)); dpd.show();
        });

        dat = (datePicker, y, m, d) -> {
            m=m+1;
            dks= d + "/"+m+"/"+y;
            day=d;
            month=m;
            year=y;
            b2.setText(dks);

        };
        

        b.setOnClickListener(view -> {


            if (TextUtils.isEmpty(fn.getText()))Toast.makeText(getApplicationContext(), "Please Enter All the Details.", Toast.LENGTH_SHORT).show();
            else if (TextUtils.isEmpty(dks))Toast.makeText(getApplicationContext(), "Please Enter All the Details.", Toast.LENGTH_SHORT).show();


            else {
                String a = fn.getText().toString();
                int nn = 0, length = a.length();
                char[] b1 = a.toCharArray();
                for (int i = 0; i < length; i++) {
                    if (b1[i] == 'A' || b1[i] == 'a' || b1[i] == 'I' || b1[i] == 'i' || b1[i] == 'J' || b1[i] == 'j' || b1[i] == 'Q' || b1[i] == 'q' || b1[i] == 'Y' || b1[i] == 'y')
                        nn += 1;
                    if (b1[i] == 'B' || b1[i] == 'b' || b1[i] == 'K' || b1[i] == 'k' || b1[i] == 'R' || b1[i] == 'r')
                        nn += 2;
                    if (b1[i] == 'C' || b1[i] == 'c' || b1[i] == 'G' || b1[i] == 'g' || b1[i] == 'L' || b1[i] == 'l' || b1[i] == 'S' || b1[i] == 's')
                        nn += 3;
                    if (b1[i] == 'D' || b1[i] == 'd' || b1[i] == 'M' || b1[i] == 'm' || b1[i] == 'T' || b1[i] == 't')
                        nn += 4;
                    if (b1[i] == 'E' || b1[i] == 'e' || b1[i] == 'N' || b1[i] == 'n' || b1[i] == 'X' || b1[i] == 'x' || b1[i] == 'H' || b1[i] == 'h')
                        nn += 5;
                    if (b1[i] == 'U' || b1[i] == 'u' || b1[i] == 'V' || b1[i] == 'v' || b1[i] == 'W' || b1[i] == 'w')
                        nn += 6;
                    if (b1[i] == 'O' || b1[i] == 'o' || b1[i] == 'Z' || b1[i] == 'z') nn += 7;
                    if (b1[i] == 'F' || b1[i] == 'f' || b1[i] == 'P' || b1[i] == 'p') nn += 8;
                }
                int sum, cond = day + month + year, driver, py = day + month + y;
                int da = day, mo = month, ye = year;
                int day2 =day, month2=month;


            //Name Number
            for(int i=0;i<3;i++)
            {
                for(sum=0 ;nn!=0 ;nn/=10){
                    sum+=nn %10;
                }
                nn=sum;
            }

            //Driver
            for(int i=0;i<2;i++)
            {
                for(sum=0 ;day!=0 ;day/=10){
                    sum+=day %10;
                }
                day=sum;
            }driver=day;

            //Conductor
            for(int i=0;i<4;i++)
            {
                for(sum=0 ;cond!=0 ;cond/=10){
                    sum+=cond %10;
                }
                cond=sum;
            }

            //Personal Year
            for(int i=0;i<4;i++)
            {
                for(sum=0 ;py!=0 ;py/=10){
                    sum+=py %10;
                }
                py=sum;
            }

                //Gird Numbers
                int[] gri ={0,0,0,0,0,0,0,0,0,0};

                for (int extra; da != 0; da /= 10) {
                    extra = da % 10;
                    for (int i = 1; i < 10; i++) {
                        if (extra == i) gri[i]++;
                    }
                }
                for (int extra; mo != 0; mo /= 10) {
                    extra = mo % 10;
                    for (int i = 1; i < 10; i++) {
                        if (extra == i) gri[i]++;
                    }
                }
                for (int extra; ye != 0; ye /= 10) {
                    extra  = ye % 10;
                    for (int i = 1; i < 10; i++) {
                        if (extra == i) gri[i]++;
                    }
                }
                for (int i = 1; i < 10; i++){
                    if(cond==i)gri[i]++;
                }
                for (int i = 1; i < 10; i++){
                    if(driver==i)gri[i]++;
                }
                for (int i = 1; i < 10; i++){
                    if(nn==i)gri[i]++;
                }
                for (int i = 1; i < 10; i++){
                    if(py==i)gri[i]++;
                }




                Intent i = new Intent(info.this, overall.class);
                i.putExtra("nn", String.valueOf(nn));
                i.putExtra("driver", String.valueOf(driver));
                i.putExtra("cond", String.valueOf(cond));
                i.putExtra("py", String.valueOf(py));
                i.putExtra("grid",gri);
                i.putExtra("day",day2);
                i.putExtra("month",month2);

                startActivity(i);
                finish();
            }
        });
    }
}
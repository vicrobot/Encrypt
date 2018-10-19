package com.vicrobot.ankit.encrypt;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static java.lang.System.in;


public class MainActivity extends AppCompatActivity {

    String var = "";
    String var1 = "";
    int varw = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    public void copy(View view){
        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("paste",var1);
        clipboard.setPrimaryClip(clip);
        Toast.makeText(this,"Copied !!",Toast.LENGTH_SHORT).show();
    }

    public void select(View view){
        EditText et = findViewById(R.id.id2);
        var = et.getText().toString();
        var1 = encrypt(var);
        TextView tv = findViewById(R.id.id7);
        tv.setText(var1);
    }
    public void cl1(View view){
        EditText et = findViewById(R.id.id2);
        var = et.getText().toString();
        var1 = decrypt(var);
        TextView tv = findViewById(R.id.id7);
        tv.setText(var1);
    }
    public void select1(View view){
        setContentView(R.layout.var1);
    }
    public void select2(View view){
        setContentView(R.layout.activity_main);
    }

    public String encrypt(String vv){
        String foo = "ABCDEFyz1234KLMNOxSTYZ aPQ!$'@#^&ghiUVWXjk><}{[lmno.:;?pquv5%67IJwbcde890,]rst()~ABC";
        String st = "";
        char [] foo2 = vv.toCharArray();

        for(int i =0; i<vv.length();i++){
            try {
                int k = foo.indexOf(foo2[i]);
                st += foo.charAt(k + 3);
            }catch(Exception e) {
                st += foo2[i]+"";
            }
        }
        return st;
    }
    public String decrypt(String vr){
        String foo = "DEFyz1234KLMNOxSTYZ aPQ!$'@#^&ghiUVWXjk><}{[lmno.:;?pquv5%67IJwbcde890,]rst()~ABC";
        String st = "";
        char [] foo2 = vr.toCharArray();

        for(int i =0; i<vr.length();i++){
            try {
                if((foo2[i]+" ").equals("D ")){ st += "A"; continue;}
                int k = foo.indexOf(foo2[i]);
                st += foo.charAt(k - 3);
            }catch(Exception e) {
                st += foo2[i]+"";
            }
        }
        return st;
    }
}

package com.gdmec.s07150713.mycontacts;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/11/3.
 */
public class ContactsMessageActivity extends AppCompatActivity{
    private TextView nameEditText;
    private TextView mobileEditText;
    private TextView qqEditText;
    private TextView danweiEditText;
    private TextView adderssEditText;
    private User user;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts_message);
        setTitle("联系人信息");
        nameEditText=(TextView) findViewById(R.id.name);
        mobileEditText=(TextView) findViewById(R.id.mobile);
        danweiEditText=(TextView) findViewById(R.id.danwei);
        qqEditText=(TextView) findViewById(R.id.qq);
        adderssEditText=(TextView) findViewById(R.id.address);
        Bundle localBundle =getIntent().getExtras();
        int id= localBundle.getInt("user_ID");
        ContactsTable ct=new ContactsTable(this);
        user = ct.getUserByID(id);
        nameEditText.setText("姓名:"+user.getName());
        mobileEditText.setText("电话:"+user.getMobile());
        qqEditText.setText("qq:"+user.getQq());
        danweiEditText.setText("单位:"+user.getDanwei());
        adderssEditText.setText("地址:"+user.getAddress());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(Menu.NONE,1,Menu.NONE,"返回");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case 1:
                finish();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}

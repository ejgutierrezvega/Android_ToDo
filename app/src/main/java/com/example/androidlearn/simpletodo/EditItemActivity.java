package com.example.androidlearn.simpletodo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class EditItemActivity extends AppCompatActivity {
    String itemValue;
    int itemPos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        itemValue = getIntent().getStringExtra("itemValue");
        itemPos = getIntent().getIntExtra("itemPos", -1);

        EditText etEditItem = (EditText)findViewById(R.id.etEditItem);
        etEditItem.setText("");
        etEditItem.append(itemValue);
    }

    public void onSaveEditItem(View view) {
        EditText etEditItem = (EditText)findViewById(R.id.etEditItem);
        Intent data = new Intent();
        data.putExtra("itemValue", etEditItem.getText().toString());
        data.putExtra("itemPos", itemPos);
        setResult(RESULT_OK, data);
        this.finish();
    }
}

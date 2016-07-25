package com.codepath.simpletodo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class EditItemActivity extends AppCompatActivity {

    EditText etEditItem;
    int itemPos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);

        String itemText = getIntent().getStringExtra("item_text");
        itemPos = getIntent().getIntExtra("item_pos", 0);

        etEditItem = (EditText) findViewById(R.id.etEditItem);
        etEditItem.setText(itemText);
        etEditItem.setSelection(itemText.length());
    }

    public void saveEdit(View v) {
        Intent data = new Intent();
        data.putExtra("item_text", etEditItem.getText().toString());
        data.putExtra("item_pos", itemPos);
        setResult(RESULT_OK, data);
        finish();
    }

}

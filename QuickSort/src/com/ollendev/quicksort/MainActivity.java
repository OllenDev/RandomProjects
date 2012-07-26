package com.ollendev.quicksort;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {
	EditText mNumbersToSortView;
	TextView mSortedNumbersView;
	Button mSortButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mNumbersToSortView = (EditText) findViewById(R.id.etUnsorted);
        mSortedNumbersView = (TextView) findViewById(R.id.tvSorted);
        mSortButton = (Button) findViewById(R.id.bSort);
        mSortButton.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true; //Test
    }

	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.bSort:
			String numbers = mNumbersToSortView.getText().toString();
			int[] array = new int[numbers.length()];
			for(int i=0; i < numbers.length(); i++) {
				array[i] = Integer.parseInt(String.valueOf(numbers.charAt(i)));
			}
			QuickSort.sort(array, 0, array.length-1);
			StringBuilder builder = new StringBuilder();
			for (int i=0; i<array.length; i++) {
				builder.append(String.valueOf(array[i]));
			}
			mSortedNumbersView.setText(builder.toString());
		}
	}
}

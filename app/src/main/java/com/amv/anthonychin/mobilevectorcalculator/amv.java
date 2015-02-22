package com.amv.anthonychin.mobilevectorcalculator;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;


public class amv extends Activity {

    private EditText firstInputOne;
    private EditText firstInputTwo;
    private EditText secondInputOne;
    private EditText secondInputTwo;
    private EditText thirdInputOne;
    private EditText thirdInputTwo;
    private TextView textView;

    private int typeOfComputation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_amv);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }

        typeOfComputation = 1; // current default addition

        firstInputOne = (EditText)findViewById(R.id.first_vector_1);
        firstInputTwo = (EditText)findViewById(R.id.first_vector_2);
        secondInputOne = (EditText)findViewById(R.id.second_vector_1);
        secondInputTwo = (EditText)findViewById(R.id.second_vector_2);
        thirdInputOne = (EditText)findViewById(R.id.third_vector_1);
        thirdInputTwo = (EditText)findViewById(R.id.third_vector_2);
        textView = (TextView)findViewById(R.id.compute);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_amv, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_amv, container, false);
            return rootView;
        }
    }

    public void toAdd (View view) {
        typeOfComputation = 1;
        thirdInputOne.setVisibility(View.VISIBLE);
        thirdInputTwo.setVisibility(View.VISIBLE);
    }

    public void toDot (View view) {
        typeOfComputation = 2;
        thirdInputOne.setVisibility(View.GONE);
        thirdInputTwo.setVisibility(View.GONE);
    }

    public void toScalar (View view) {
        typeOfComputation = 3;
        thirdInputOne.setVisibility(View.GONE);
        thirdInputTwo.setVisibility(View.GONE);

    }
    public void computeValue (View view) {
        if (typeOfComputation == 1) {
            computeAdd();
        } else if (typeOfComputation == 2) {
            computeDot();
        } else {
            computeScalar();
        }
    }

    public void onToggleClicked(View view) {
        // Is the toggle on?
        boolean on = ((ToggleButton) view).isChecked();
        if (on) {
            // Enable vibrate
        } else {
            // Disable vibrate
        }
    }

    private void computeAdd() {
        boolean ThreeVectorAddition = false;
        Vector thirdVector = null;

        //Check if any of the inputs are empty
        if (!thirdInputOne.getText().toString().equals("") &&
                !thirdInputTwo.getText().toString().equals("")) {
            ThreeVectorAddition = true;

            double thirdVectorX = Double.parseDouble(thirdInputOne.getText().toString());
            double thirdVectorY = Double.parseDouble(thirdInputTwo.getText().toString());

            thirdVector = new Vector(thirdVectorX, thirdVectorY);
        }

        if(firstInputOne.getText().toString().equals("") 		||
                firstInputTwo.getText().toString().equals("")	||
                secondInputOne.getText().toString().equals("")	||
                secondInputTwo.getText().toString().equals("")  ) {

            textView.setText("Error: Please enter a number");
            textView.setVisibility(View.VISIBLE);

        } else {
            double firstVectorX = Double.parseDouble(firstInputOne.getText().toString());
            double firstVectorY = Double.parseDouble(firstInputTwo.getText().toString());
            double secondVectorX = Double.parseDouble(secondInputOne.getText().toString());
            double secondVectorY = Double.parseDouble(secondInputTwo.getText().toString());

            Vector firstVector = new Vector(firstVectorX, firstVectorY);
            Vector secondVector = new Vector(secondVectorX, secondVectorY);
            Vector sum = null;

            if (ThreeVectorAddition) {
                sum = firstVector.add(secondVector, thirdVector);
            } else {
                sum = firstVector.add(secondVector);
            }

            textView.setText(sum.getX() + "i + " + sum.getY() +"j");
            textView.setVisibility(View.VISIBLE);

        }
    }

    private void computeDot() {
        if(firstInputOne.getText().toString().equals("") 		||
                firstInputTwo.getText().toString().equals("")	||
                secondInputOne.getText().toString().equals("")	||
                secondInputTwo.getText().toString().equals("")  ) {

            textView.setText("Error: Please enter a number");
            textView.setVisibility(View.VISIBLE);

        } else {
            double firstVectorX = Double.parseDouble(firstInputOne.getText().toString());
            double firstVectorY = Double.parseDouble(firstInputTwo.getText().toString());
            double secondVectorX = Double.parseDouble(secondInputOne.getText().toString());
            double secondVectorY = Double.parseDouble(secondInputTwo.getText().toString());

            Vector firstVector = new Vector(firstVectorX, firstVectorY);
            Vector secondVector = new Vector(secondVectorX, secondVectorY);
            double dot = firstVector.dot(secondVector);

            textView.setText(dot + "");
            textView.setVisibility(View.VISIBLE);
        }
    }

    private void computeScalar() {
        if(firstInputOne.getText().toString().equals("") 		||
                firstInputTwo.getText().toString().equals("")	||
                secondInputOne.getText().toString().equals("")	||
                secondInputTwo.getText().toString().equals("")  ) {

            textView.setText("Error: Please enter a number");
            textView.setVisibility(View.VISIBLE);

        } else {
            double firstVectorX = Double.parseDouble(firstInputOne.getText().toString());
            double firstVectorY = Double.parseDouble(firstInputTwo.getText().toString());
            double secondVectorX = Double.parseDouble(secondInputOne.getText().toString());
            double secondVectorY = Double.parseDouble(secondInputTwo.getText().toString());

            Vector firstVector = new Vector(firstVectorX, firstVectorY);
            Vector secondVector = new Vector(secondVectorX, secondVectorY);
            Vector cross = firstVector.cross(secondVector);

            textView.setText(cross.getX() + "i +" + cross.getY() + "j" + cross.getZ() + "k");
            textView.setVisibility(View.VISIBLE);
        }
    }
//    public void sendMessage (View view) {
//        Intent intent = new Intent(this, DisplayMessageActivity.class);
//        EditText editText = (EditText) findViewById(R.id.edit_message);
//    }
}

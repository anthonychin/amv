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
    private TextView textOne;
    private TextView textTwo;
    private TextView textThree;
    private TextView textFour;
    private TextView textFive;
    private TextView textSix;

    private int typeOfComputation;
    private boolean polar;

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
        polar = false; //polar is false at the beginning

        firstInputOne = (EditText)findViewById(R.id.first_vector_1);
        firstInputTwo = (EditText)findViewById(R.id.first_vector_2);
        secondInputOne = (EditText)findViewById(R.id.second_vector_1);
        secondInputTwo = (EditText)findViewById(R.id.second_vector_2);
        thirdInputOne = (EditText)findViewById(R.id.third_vector_1);
        thirdInputTwo = (EditText)findViewById(R.id.third_vector_2);
        textView = (TextView)findViewById(R.id.compute);
        textOne = (TextView)findViewById(R.id.text1);
        textTwo = (TextView)findViewById(R.id.text2);
        textThree = (TextView)findViewById(R.id.text3);
        textFour = (TextView)findViewById(R.id.text4);
        textFive = (TextView)findViewById(R.id.text5);
        textSix = (TextView)findViewById(R.id.text6);

        setIAndJ();
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
        setTextBoxAndInputBoxVisibility();
    }

    public void toDot (View view) {
        typeOfComputation = 2;
        setTextBoxAndInputBoxVisibility();
    }

    public void toScalar (View view) {
        typeOfComputation = 3;
        setTextBoxAndInputBoxVisibility();

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
        boolean on = ((ToggleButton) view).isChecked();
        if (on) {
            polar = true;
            setMagnitudeAndDegree();
        } else {
            polar = false;
            setIAndJ();
        }
    }

    private void computeAdd() {
        boolean ThreeVectorAddition = false;
        Vector thirdVector = null;
        PolarVector thirdVectorPolar = null;
        //Check if any of the inputs are empty
        if (!thirdInputOne.getText().toString().equals("") &&
                !thirdInputTwo.getText().toString().equals("")) {
            ThreeVectorAddition = true;

            double thirdVectorX = Double.parseDouble(thirdInputOne.getText().toString());
            double thirdVectorY = Double.parseDouble(thirdInputTwo.getText().toString());

            if (polar) {
                thirdVectorPolar = new PolarVector(thirdVectorX, thirdVectorY);
            } else {
                thirdVector = new Vector(thirdVectorX, thirdVectorY);
            }
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

            if (polar) {
                PolarVector firstVector = new PolarVector(firstVectorX, firstVectorY);
                PolarVector secondVector = new PolarVector(secondVectorX, secondVectorY);

                PolarVector sum = null;

                if (ThreeVectorAddition) {
                    sum = firstVector.add(secondVector, thirdVectorPolar);
                } else {
                    sum = firstVector.add(secondVector);
                }

                textView.setText(sum.getR() + " Magnitude : " + sum.getT() + " Degree");
                textView.setVisibility(View.VISIBLE);
            } else {
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

            double dot = 0;
            if (polar) {
                PolarVector firstVector = new PolarVector(firstVectorX, firstVectorY);
                PolarVector secondVector = new PolarVector(secondVectorX, secondVectorY);
                dot = firstVector.dot(secondVector);
            } else {
                Vector firstVector = new Vector(firstVectorX, firstVectorY);
                Vector secondVector = new Vector(secondVectorX, secondVectorY);
                dot = firstVector.dot(secondVector);
            }

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

            if (polar) {
                PolarVector firstVector = new PolarVector(firstVectorX, firstVectorY);
                PolarVector secondVector = new PolarVector(secondVectorX, secondVectorY);
                PolarVector cross = firstVector.cross(secondVector);

                textView.setText(cross.getR() + " Magnitude : " + cross.getT() + " Degree");
            } else {
                Vector firstVector = new Vector(firstVectorX, firstVectorY);
                Vector secondVector = new Vector(secondVectorX, secondVectorY);
                Vector cross = firstVector.cross(secondVector);

                textView.setText(cross.getX() + "i +" + cross.getY() + "j" + cross.getZ() + "k");
            }

            textView.setVisibility(View.VISIBLE);
        }
    }

    private void setIAndJ() {
        textOne.setText("i");
        textTwo.setText("j");
        textThree.setText("i");
        textFour.setText("j");
        textFive.setText("i");
        textSix.setText("j");
    }

    private void setMagnitudeAndDegree() {
        textOne.setText("Magnitude");
        textTwo.setText("Degree");
        textThree.setText("Magnitude");
        textFour.setText("Degree");
        textFive.setText("Magnitude");
        textSix.setText("Degree");
    }

    private void setTextBoxAndInputBoxVisibility() {
        textOne.setVisibility(View.VISIBLE);
        textTwo.setVisibility(View.VISIBLE);
        textThree.setVisibility(View.VISIBLE);
        textFour.setVisibility(View.VISIBLE);
        thirdInputOne.setVisibility(View.VISIBLE);
        thirdInputTwo.setVisibility(View.VISIBLE);

        if (typeOfComputation == 1) {
            textFive.setVisibility(View.VISIBLE);
            textSix.setVisibility(View.VISIBLE);
        } else {
            textFive.setVisibility(View.GONE);
            textSix.setVisibility(View.GONE);
            thirdInputOne.setVisibility(View.GONE);
            thirdInputTwo.setVisibility(View.GONE);
        }
    }
}

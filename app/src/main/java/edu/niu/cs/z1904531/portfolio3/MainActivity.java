package edu.niu.cs.z1904531.portfolio3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.BreakIterator;

public class MainActivity extends AppCompatActivity {

    private RadioGroup pattyRG;

    private CheckBox baconCB;

    private RadioGroup cheeseRG;

    private SeekBar sauceSB;

    private Burger burger;

    private TextView caloriesTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //set up the connection between variables and items on screen
        pattyRG = findViewById(R.id.pattyRadioGroup);

        baconCB = findViewById(R.id.baconCheckBox);

        cheeseRG = findViewById(R.id.cheeseRadioGroup);

        sauceSB = findViewById(R.id.sauceSeekBar);

        caloriesTV = findViewById(R.id.caloriesTextView);

        //create the burger object
        burger = new Burger();

        //display the initial number of calories for the burger
        displayCalories();

        //set up the listener for the patty and cheese radio group
        pattyRG.setOnCheckedChangeListener(pattyListener);

        baconCB.setOnClickListener(baconListener);

        //anonymous
        cheeseRG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                switch (checkedId){
                    case R.id.noCheeseRadioButton:
                        burger.setCheeseCalories(0);
                        break;
                    case R.id.cheddarRadioButton:
                        burger.setCheeseCalories(Burger.CHEDDAR);
                        break;
                    case R.id.mozzarellaRadioButton:
                        burger.setCheeseCalories(Burger.MOZZARELLA);
                        break;
                }//end switch

                //display updated number of calories
                displayCalories();
            }
        });//end cheeseListener

        // set up the listener for the seekbar
        sauceSB.setOnSeekBarChangeListener(sauceListener);

    }//end onCreate
    

    private RadioGroup.OnCheckedChangeListener pattyListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
            switch (checkedId){
                case R.id.beefRadioButton:
                    burger.setPattyCalories(Burger.BEEF);
                    break;
                case R.id.turkeyRadioButton:
                    burger.setPattyCalories(Burger.TURKEY);
                    break;
                case R.id.veggieRadioButton:
                    burger.setPattyCalories(Burger.VEGGIE);
                    break;
            }//end switch

            //display updated number of calories
            displayCalories();

        }//end onCheckedChanged

    };//end pattyListener

    private SeekBar.OnSeekBarChangeListener sauceListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            burger.setSauceCalories(progress);
            displayCalories(); // get the actual update
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) { }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) { }
    }; // end onSeekBarChangeListener


    private View.OnClickListener baconListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if( ((CheckBox)view).isChecked()){
                burger.setBaconCalories(true);
            }else{
                burger.setBaconCalories(false);
            }

            //display the updated number of calories
            displayCalories();
        }//end onClick
    };//end OnClickListener



    private void displayCalories(){
        //build a string with the information
        String caloriesText = "Calories: " + burger.calcTotalCalories();

        //display the string in the TextView
        caloriesTV.setText(caloriesText);

    }//end displayCalories

}// end MainActivity
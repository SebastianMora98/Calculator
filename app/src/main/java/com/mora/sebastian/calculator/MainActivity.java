package com.mora.sebastian.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import android.support.v7.widget.PopupMenu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // operations guarda operacion a realizar
    private String operations = "";

    // el valor actual de la operacion
    float value = 0;

    // instancia de los botones para el teclado numerico
    Button one, two, three, four, five, six, seven, eight, nine, zero;

    // instancia de los botones para los simbolos
    Button point, equals ,del, percent, c;

    ImageButton divide, multiply, subtract, sum;

    // boton que abre el menu
    ImageButton menu;

    //textos

    TextView inputTextView, resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // funcion que relaciona los componentes de la vista mediante su id con cada objeto Button
        assingComponents();
        buttonEvents();

    }

    void calculateValue(){

    }

    void addEventKeyboard(Button button, final String addValue){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operations+=addValue;
                inputTextView.setText(operations);
                calculateValue();
            }
        });
    }

    void addEventKeyboard(ImageButton button, final String addValue){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operations+=addValue;
                inputTextView.setText(operations);
                calculateValue();
            }
        });
    }

    void buttonEvents(){
        //eventos de los botones del teclado numerico

        addEventKeyboard(one,"1");
        addEventKeyboard(two,"2");
        addEventKeyboard(three,"3");
        addEventKeyboard(four,"4");
        addEventKeyboard(five,"5");
        addEventKeyboard(six,"6");
        addEventKeyboard(seven,"7");
        addEventKeyboard(eight,"8");
        addEventKeyboard(nine,"9");

        //eventos simbolos
        addEventKeyboard(point,".");
        addEventKeyboard(zero,"0");
        addEventKeyboard(subtract,"-");
        addEventKeyboard(divide,"/");
        addEventKeyboard(multiply,"*");
        addEventKeyboard(sum,"+");
        addEventKeyboard(percent,"%");

        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operations = "";
                inputTextView.setText("");
                calculateValue();
            }
        });

        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(operations.length()==1){
                    operations = "";
                    inputTextView.setText("");
                }else if(operations!="" && operations.length() > 1){
                    operations = operations.substring(0, operations.length()-1);
                }

                inputTextView.setText(operations);
                calculateValue();
            }
        });

        // despliega el menu al dar click en el boton menu
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creating the instance of PopupMenu
                PopupMenu popup = new PopupMenu(MainActivity.this, menu);
                //Inflating the Popup using xml file
                popup.getMenuInflater()
                        .inflate(R.menu.popup_menu, popup.getMenu());

                //registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(
                                MainActivity.this,
                                "You Clicked : " + item.getTitle(),
                                Toast.LENGTH_SHORT
                        ).show();
                        return true;
                    }
                });

                popup.show(); //showing popup menu
            }
        });
    }

    void assingComponents(){

        one = (Button) findViewById(R.id.idButton1);
        two = (Button) findViewById(R.id.idButton2);
        three = (Button) findViewById(R.id.idButton3);
        four = (Button) findViewById(R.id.idButton4);
        five = (Button) findViewById(R.id.idButton5);
        six = (Button) findViewById(R.id.idButton6);
        seven = (Button) findViewById(R.id.idButton7);
        eight = (Button) findViewById(R.id.idButton8);
        nine = (Button) findViewById(R.id.idButton9);
        zero = (Button) findViewById(R.id.idButton0);

        point = (Button) findViewById(R.id.idButtonPoint);
        divide = (ImageButton) findViewById(R.id.idButtonDivide);
        multiply = (ImageButton) findViewById(R.id.idButtonMultiply);
        sum = (ImageButton) findViewById(R.id.idButtonSum);
        subtract = (ImageButton) findViewById(R.id.idButtonSubtract);

        del = (Button) findViewById(R.id.idButtonDel);
        percent = (Button) findViewById(R.id.idButtonPercent);
        c =(Button) findViewById(R.id.idButtonC);

        inputTextView = (TextView) findViewById(R.id.idTextViewInput);
        resultTextView = (TextView) findViewById(R.id.idTextViewResult);

        menu = (ImageButton) findViewById(R.id.idButtonMenu);
    }

}



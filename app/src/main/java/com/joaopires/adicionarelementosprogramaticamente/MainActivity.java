package com.joaopires.adicionarelementosprogramaticamente;

import android.app.ActionBar;
import android.content.Context;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    protected Spinner numDeElementos;
    protected LinearLayout layout;
    protected Context context;
    protected EditText[] editTextArray;
    protected LinearLayout.LayoutParams parametros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        context = this;
        Button inserir = (Button)findViewById(R.id.butao);
        layout = (LinearLayout)findViewById(R.id.linear_layout);
        numDeElementos = (Spinner)findViewById(R.id.spinner_num_de_elementos);
        ArrayList<String> num = new ArrayList<>();
        num.add("1");
        num.add("2");
        num.add("3");
        num.add("4");
        num.add("5");
        num.add("6");
        num.add("7");
        num.add("8");
        num.add("10");
        num.add("11");
        num.add("12");
        num.add("13");
        num.add("14");
        num.add("15");
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, num);
        numDeElementos.setAdapter(stringArrayAdapter);

        parametros = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)      ;

        inserir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editTextArray = new EditText[Integer.parseInt(String.valueOf(numDeElementos.getSelectedItem()))];//Array de EditTexts. Tantos quantos quisermos (o numero selecionado)
                //O Array é feito porque vamos querer aceder à informação que o user introduzio, logo temos de ter todos criados.
                //Caso não quisessemos aceder à infromação não seria necessário criar o array, seria criado sempre um novo EditText com o mesmo nome sempre
                // que quisessemos adicionar um ao Layout, tal como é feito com o InputTextLayout
                //Visto que não necessitamos de aceder a eles, apenas queremos que estajam lá, criamos sempre um novo (TextInputLayout textInputLayout = new TextInputLayout(context))

                for (int i = 0; i < Integer.parseInt(String.valueOf(numDeElementos.getSelectedItem())); i++) {

                    editTextArray[i] = new EditText(context);//Criar o EditText
                    editTextArray[i].setLayoutParams(parametros);//Definir o match_patent e wrap_content
                    editTextArray[i].setHint(String.valueOf(i));//Definir o hint

                    TextInputLayout textInputLayout = new TextInputLayout(context);//Criar um TextInputLayout onde vamos inserir o EditText. Opcional apenas para que o texto da hint seja mostrado mesmo depois do o user carragar no EditText
                    textInputLayout.setLayoutParams(parametros);//Definir o match_patent e wrap_content
                    textInputLayout.addView(editTextArray[i]);//Inserir o EditText no InputTextLayout

                    layout.addView(textInputLayout);//Inserir o InputTextLayout com o EditText no LinearLayout
                }
            }
        });

        Button ver = new Button(this);
        ver.setLayoutParams(parametros);
        ver.setText("VER");
        layout.addView(ver);
        ver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String teste = editTextArray[1].getText().toString();
                Toast.makeText(context, teste, Toast.LENGTH_SHORT).show();
            }
        });

    }
}
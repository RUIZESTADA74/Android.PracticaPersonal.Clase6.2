package JR.TokioSchool;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    // DEFINIR OBJETOS

    EditText et_nombre;
    RadioGroup rg_estadocivil;
    Spinner sp_ciudades;
    CheckBox cb_futbol, cb_balencesto, cb_tenis;
    Button b_guardar;
    Spinner sp_datosusuario;
    ArrayList<usuario> datos=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    // FLUJO DEL PROGRAMA

        recuperarcomponentes();
        liseners();
    }

    private void liseners() {
        // CONVERSION DE LOS DATOS A UNA VARIABLE MENSAJE Y PRESENTAR POR LOG.

        b_guardar.setOnClickListener(view -> {
                    String nombre = et_nombre.getText().toString();
                    String estadocivil = ((RadioButton) findViewById(rg_estadocivil.getCheckedRadioButtonId())).getText().toString();
                    String ciudad = sp_ciudades.getSelectedItem().toString();
                    ArrayList deporteseleccionado = new ArrayList<>();
                    if (cb_futbol.isChecked()) {
                        deporteseleccionado.add("Futbol");
                    }
                    if (cb_balencesto.isChecked()) {
                        deporteseleccionado.add("Baloncesto");
                    }
                    if (cb_tenis.isChecked()) {
                        deporteseleccionado.add("Tenis");
                    }
                    String mensaje = "NOMBRE: " + nombre + "\nDELEGACION: " + ciudad + "\nE.CIVIL:" + estadocivil + "\nDEPORTES: " + deporteseleccionado;
                    Log.d("depurando",mensaje);

         // GENERAR USUARIO, CREAR UN ADAPTADOR Y PASAR VARIABLES AL SPINNER

                    usuario usuario = new usuario(nombre,ciudad,estadocivil,deporteseleccionado);
                    datos.add(usuario);
                    sp_datosusuario.setAdapter(new ArrayAdapter<usuario>(this,android.R.layout.simple_list_item_1,datos));

                    // **** objetivo marcado del ejercicio: PRESENTAR POR LOG LOS TODOS LOS DATOS DEL USUARIO GUARDADOS EN EL ****

                    String datosdelusuario = String.valueOf(usuario);
                    Log.d("depurando",datosdelusuario);
                    });

        //  CHEQUEO DE LOS DATOS PULSADOS, CONVERTIRLOS A STRING Y PRESENTARLOS POR LOG.

        rg_estadocivil.setOnCheckedChangeListener((radioGroup, i) -> { // CHEKEAR RADIOGROUP Y PASAR LOS DATOS DEL BOTON A LA VARIABLE RB
                    RadioButton rb = findViewById(i);
                    Log.d("depurando", rb.getText().toString());
                });

        sp_ciudades.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {  //CHEQUEAR EL ITEM DEL SPINNER Y CREAR UN ADAPTADOR PARA PRESENTAR POR LOG
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            Log.d("depurando", ((TextView) view).getText().toString());
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });

            // UTILIZANDO UN ESCUCHADOR PARA TODOS LOS CHECK´S DE DEPORTES EN UNA VARIABLE b Y PRESENTARLOS POR LOG.

            CompoundButton.OnCheckedChangeListener escuchadorCb = new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    if (b) {
                        Log.d("depurando", compoundButton.getText().toString());
                    }
                }
            };
            cb_futbol.setOnCheckedChangeListener(escuchadorCb);
            cb_balencesto.setOnCheckedChangeListener(escuchadorCb);
            cb_tenis.setOnCheckedChangeListener(escuchadorCb);

            }

        private void recuperarcomponentes () {

            // CASTEAR OBJETOS A SUS IDENTIFICADORES

            et_nombre = (EditText) findViewById(R.id.et_nombre);
            rg_estadocivil = (RadioGroup) findViewById(R.id.rg_estadocivil);
            sp_ciudades = (Spinner) findViewById(R.id.sp_ciudades);
            cb_futbol = (CheckBox) findViewById(R.id.cb_futbol);
            cb_balencesto = (CheckBox) findViewById(R.id.cb_baloncesto);
            cb_tenis = (CheckBox) findViewById(R.id.cb_tennis);
            b_guardar = (Button) findViewById(R.id.b_guardar);
            sp_datosusuario = (Spinner) findViewById(R.id.sp_datosusuario);
        }
    }

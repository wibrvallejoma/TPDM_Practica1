package mx.edu.ittepic.tpdm_u1_practica;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button mostrar_mensaje;
    private TextView mensaje_final;
    private EditText mensaje_entrante;
    private String cadena="";
    private RadioGroup colores;
    private RadioButton color_seleccionado;
    private Switch letras_capitales;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mostrar_mensaje = findViewById(R.id.boton_mostrar);
        mensaje_final = findViewById(R.id.mensaje_final);
        mensaje_entrante = findViewById(R.id.mensaje_entrante);

        colores = findViewById(R.id.radioColores);
        letras_capitales = findViewById(R.id.letras_capitales);

        mostrar_mensaje.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                cadena = mensaje_entrante.getText().toString();
                int colorId = colores.getCheckedRadioButtonId();

                color_seleccionado = findViewById(colorId);

                switch (color_seleccionado.getText().toString()){
                    case "Rojo":
                        mensaje_final.setTextColor(Color.RED);
                        break;
                    case "Azul":
                        mensaje_final.setTextColor(Color.BLUE);
                        break;
                    case "Verde":
                        mensaje_final.setTextColor(Color.GREEN);
                        break;
                    default:
                        mensaje_final.setTextColor(Color.BLACK);
                        break;
                }
                if(letras_capitales.isChecked()){
                    mensaje_final.setText(cadena.toUpperCase());
                }else {
                    mensaje_final.setText(cadena);
                }

            }
        });
    }
}

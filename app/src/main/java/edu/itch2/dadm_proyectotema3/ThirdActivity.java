package edu.itch2.dadm_proyectotema3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ThirdActivity extends AppCompatActivity {

    //DECLARAMOS LAS VARIABLES DEL DISEÑO
    private EditText editTextUrl, editTextNumero, editTextDireccionCorreo, editTextAsuntoCorreo, editTextCuerpoCorreo;
    private Button btnUrl, btnCamara, btnLlamada, btnEnviarCorreo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        //INICIALIZAMOS LAS VARIABLES DEL EDITTEXT Y BOTON QUE NOS ENVIA A EL NAVEGADOR WEB CON LA PAGINA QUE LE MANDAMOS POR MEDIO DEL EDITTEXT
        btnUrl = findViewById(R.id.btnUrl);
        editTextUrl = findViewById(R.id.editTextUrl);

        //INICIALIZAMOS LA VARIABLE DEL BOTON DE LA CAMARA
        btnCamara = findViewById(R.id.btnCamara);

        //INICIALIZAMOS LAS VARIABLES DEL EDITTEXT Y EL BOTON QUE NOS REALIZARAN LA LLAMADA
        btnLlamada = findViewById(R.id.btnLlamada);
        editTextNumero = findViewById(R.id.editTextNumero);

        //INICIALIZAMOS LAS VARIABLES DEL EDITTEXT Y EL BOTON QUE NOS REALIZARAN EL ENVIO DEL CORREO
        editTextDireccionCorreo = findViewById(R.id.editTextDireccionCorreo);
        editTextAsuntoCorreo = findViewById(R.id.editTextAsuntoCorreo);
        editTextCuerpoCorreo = findViewById(R.id.editTextCuerpoCorreo);
        btnEnviarCorreo = findViewById(R.id.btnEnviarCorreo);


        //LE PONEMOS UN ESCUCHADOR AL BOTON PARA QUE REALICE LA APERTURA DEL NAVEGADOR Y MUESTRE LA PAGINA QUE ENVIAMOS
        btnUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //GUARDAMOS LA URL QUE NOS MANDEN POR EL EDITTEXT
                String url = editTextUrl.getText().toString();
                //HACEMOS UN IF PARA CHECAR QUE LO QUE EL EDITTEXT NO ESTE VACIO NI SEA NULO
                if (url != null && !url.isEmpty()) {
                    //CREAMOS EL INTENTO CON EL ACTION VIEW PARA ABRIR EL NAVEGADOR CON LA URI Y CONCATENANDO LA URL QUE NOS MANDARON POR EL EDITTEXT
                    Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse("http://"+url));
                    //INICIAMOS EL INTENTO
                    startActivity(intentWeb);
                } else {
                    //MOSTRAMOS UN MENSAJE EN CASO DE QUE EL EDITTEXT ESTE VACIO
                    Toast.makeText(ThirdActivity.this, "Inserta una URL", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //LE PONEMOS EL ESCUCHADOR AL BOTON PARA QUE ABRA LA CAMARA
        btnCamara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //CREAMOS EL INTENTO CON EL MEDIA ACTION IMAGE CAPTURE PARA PODER ABRIR LA CAMARA
                Intent intentCamara = new Intent("android.media.action.IMAGE_CAPTURE");
                //INICIAMOS NUESTRO INTENTO
                startActivity(intentCamara);
            }
        });

        //LE PONEMOS UN ESCUCHADOR AL BOTON DE LA LLAMADA PARA QUE PONGA EL NÚMERO PARA LLAMAR
        btnLlamada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numeroTel = editTextNumero.getText().toString();
                if (numeroTel != null && !numeroTel.isEmpty()){
                    Intent intentLlamada = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: "+numeroTel));
                    startActivity(intentLlamada);
                } else {
                    Toast.makeText(ThirdActivity.this, "Inserte un número", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //LE PONEMOS EL ESCUCHADOR AL BOTON PARA ENVIAR UN EMAIL CON SU DESTINATARIO, ASUNTO Y CUERPO DEL CORREO
        btnEnviarCorreo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //GUARDAMOS LO QUE RECIBIMOS EN LOS EDITTEXT Y LO UTILIZAMOS COMO DIRECCION, ASUNTO Y CUERPO DEL CORREO
                String email = editTextDireccionCorreo.getText().toString();
                String asunto = editTextAsuntoCorreo.getText().toString();
                String cuerpo = editTextCuerpoCorreo.getText().toString();
                if (editTextDireccionCorreo != null && !email.isEmpty()){
                    if (editTextAsuntoCorreo != null && !asunto.isEmpty()){
                        if (editTextCuerpoCorreo != null && !cuerpo.isEmpty()){
                            //CREAMOS EL INTENTO PARA ENVIAR EL CORREO
                            Intent intentEmailCompleto = new Intent(Intent.ACTION_SEND, Uri.parse("mailto:"+email));
                            //ESPECIFICAMOS EL TIPO DEL DATO QUE RECIBIRA PARA ASI ENVIARLO COMO TEXTO EN LOS DATOS DEL CORREO
                            intentEmailCompleto.setType("plain/text");
                            //UTILIZAMOS EL PUT EXTRA PARA CADA UNO DE LOS DATOS QUE ENVIAREMOS AL CORREO
                            intentEmailCompleto.putExtra(Intent.EXTRA_SUBJECT, asunto);
                            intentEmailCompleto.putExtra(Intent.EXTRA_TEXT, cuerpo);
                            intentEmailCompleto.putExtra(Intent.EXTRA_EMAIL, new String[]{email});
                            //INICIAMOS EL INTENTO EN ESTE CASO CON LA OPCION ESPECIAL DE ESCOGER EL CLIENTE DE CORREO QUE DESEEMOS UTILIZAR
                            startActivity(Intent.createChooser(intentEmailCompleto, "elige cliente de correo"));
                        } else {
                            //MOSTRAMOS UN MENSAJE EN CASO DE QUE UN EDITTEXT ESTE VACIO
                            Toast.makeText(ThirdActivity.this, "Llena el campo de cuerpo", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        //MOSTRAMOS UN MENSAJE EN CASO DE QUE UN EDITTEXT ESTE VACIO
                        Toast.makeText(ThirdActivity.this, "Llena el campo de asunto", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    //MOSTRAMOS UN MENSAJE EN CASO DE QUE UN EDITTEXT ESTE VACIO
                    Toast.makeText(ThirdActivity.this, "Llena el campo de direccion", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
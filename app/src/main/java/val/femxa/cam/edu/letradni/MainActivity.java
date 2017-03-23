package val.femxa.cam.edu.letradni;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void calcularDNI (View vista)
    {
        EditText cajaDNI =(EditText)findViewById(R.id.numeros);
        String dni =cajaDNI.getText().toString();


        ObtenerLetraDNI obtenerLetraDNI=new ObtenerLetraDNI(this);
        obtenerLetraDNI.execute(dni);//El dni es el string de los parametros del ObtenerLetraDNI
        Log.d("MENSAJE","ObtenerLetraDNI llamado");//HILOOOOO
    }

    public void mostrarToast (String letra)
{

    Toast toast = Toast.makeText(this,"Su letra es: "+letra, Toast.LENGTH_LONG);
    toast.show();
}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}

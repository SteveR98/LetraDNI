package val.femxa.cam.edu.letradni;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Administrador on 22/03/2017.
 *
 */



public class ObtenerLetraDNI extends AsyncTask<String,Void,String> {

    private MainActivity mainActivity;

    public ObtenerLetraDNI (MainActivity mainActivity)
    {
        this.mainActivity = mainActivity;




    }


    private final static String DIR_SERVLET="http://femxa-ebtm.rhcloud.com/CalcularLetraDni?dni=";

    //http://localhost:8090/LetraDNI/CalcularLetraDNI?dni=
    //http://femxa-ebtm.rhcloud.com/CalcularLetraDni?dni=

    @Override
    protected String doInBackground(String... params)
    {
      String letraDNI=null;
        String dni= params[0];
        HttpURLConnection http=null;
        try {

            String servicio =DIR_SERVLET+dni;
            URL url =new URL(servicio);
            http=(HttpURLConnection) url.openConnection();


            if (http.getResponseCode()==HttpURLConnection.HTTP_OK)
            {
                InputStream is =http.getInputStream();
                InputStreamReader isr=new InputStreamReader(is);
                BufferedReader br=new BufferedReader(isr);
                letraDNI=br.readLine();

            }
        }
        catch (Throwable throwable)
        {
            Log.d("MENSAJE","ERROR",throwable);

            throwable.printStackTrace();
        }
        finally {
            http.disconnect();
        }
        return letraDNI;

    }

    @Override
    protected void onPostExecute(String letra)
    {
        Log.d("MENSAJE","La invocacion al servlet acabó");
        Log.d("MENSAJE","Letra recibida= "+letra);

        mainActivity.mostrarToast(letra);

    }


}

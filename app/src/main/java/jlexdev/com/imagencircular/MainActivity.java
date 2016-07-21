package jlexdev.com.imagencircular;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

/** FUENTE:
 *
 *  http://xurxodeveloper.blogspot.pe/2015/04/android-tip-como-crear-imagenes-circulares.html
 */
public class MainActivity extends AppCompatActivity {

    private Drawable originalDrawable;
    private ImageView imagen;

    private Bitmap originalBitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Obtengo el Drawable Original
        originalDrawable = getResources().getDrawable(R.drawable.jobs);

        imagen = (ImageView)findViewById(R.id.img_jobs);
//      imagen.setImageDrawable(originalDrawable);


        // Convierto a Bitmap
        originalBitmap = ((BitmapDrawable)originalDrawable).getBitmap();

        /** Adicional */ // Para el caso que la imagen no es cuadrada
        if(originalBitmap.getWidth() > originalBitmap.getHeight()){
            originalBitmap = Bitmap.createBitmap(originalBitmap, 0, 0,
                    originalBitmap.getHeight(),
                    originalBitmap.getHeight());

        } else if(originalBitmap.getWidth() < originalBitmap.getHeight()){
            originalBitmap = Bitmap.createBitmap(originalBitmap, 0, 0,
                    originalBitmap.getWidth(),
                    originalBitmap.getWidth());
        }



        // Creo Drawable Redondeado
        RoundedBitmapDrawable roundedDrawable =
                RoundedBitmapDrawableFactory.create(getResources(), originalBitmap);

        // Asigno CornerRadius
        roundedDrawable.setCornerRadius(originalBitmap.getHeight());

        imagen.setImageDrawable(roundedDrawable); // Reemplazo linea superior
    }
}

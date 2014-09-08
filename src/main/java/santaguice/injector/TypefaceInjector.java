package santaguice.injector;

import java.lang.annotation.Annotation;

import android.app.Activity;
import android.graphics.Typeface;
import android.widget.TextView;

import santaguice.annotations.InjectTypeface;


public class TypefaceInjector extends Injector{

	@Override
	public void injectProperties(Object container,Object obj, Annotation annot) {
		String typeFaceName = ((InjectTypeface) annot).typefaceName();
		TextView b = (TextView) obj;
		Activity currentAct=(Activity)container;
		
		Typeface desiredTypeface = Typeface.createFromAsset( currentAct.getAssets(),typeFaceName);

		b.setTypeface(desiredTypeface);
		
		System.out.println("Setted typeface "+typeFaceName);
	}

}

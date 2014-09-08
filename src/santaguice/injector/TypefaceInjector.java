package santaguice.injector;

import java.lang.annotation.Annotation;

import santaguice.annotations.InjectTypeface;
import test.application.TextView;
import test.application.TypeFace;

public class TypefaceInjector extends Injector{

	@Override
	public void injectProperties(Object container,Object obj, Annotation annot) {
		String typeFaceName = ((InjectTypeface) annot).typefaceName();
		TextView b = (TextView) obj;

		TypeFace desiredTypeface = TypeFace.createFromAssets(typeFaceName);

		b.setTypeFace(desiredTypeface);
		
		System.out.println("Setted typeface "+typeFaceName);
	}

}

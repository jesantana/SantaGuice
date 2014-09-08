package santaguice.injector;

import java.lang.annotation.Annotation;

import santaguice.injector.Injector;
import android.view.View;
import android.view.View.OnClickListener;

public class ContainerAsOnClickListenerInjector extends Injector{

	@Override
	public void injectProperties(Object container, Object obj,Annotation annot) {
			View view=(View)obj;
			OnClickListener currentAct=(OnClickListener)container;
			view.setOnClickListener(currentAct);
			
			System.out.println("Injected this as on ClickListener");
	}

}

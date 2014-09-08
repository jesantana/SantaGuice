package santaguice.injector;

import java.lang.annotation.Annotation;
import test.application.View;

public class ContainerAsOnClickListenerInjector extends Injector{

	@Override
	public void injectProperties(Object container, Object obj,
			Annotation annot) {
			
		
			View view=(View)obj;
			
			view.setOnClickListener(container);
			
			System.out.println("Injected this as on ClickListener");
	}

}

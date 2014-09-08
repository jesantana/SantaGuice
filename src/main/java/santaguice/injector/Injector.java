package santaguice.injector;

import java.lang.annotation.Annotation;


public abstract class Injector {
	
	public abstract void injectProperties(Object container, Object obj,Annotation annot);
	
}

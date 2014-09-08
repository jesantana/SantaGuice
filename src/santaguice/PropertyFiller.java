package santaguice;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashMap;

import santaguice.annotations.InjectContainerAsOnClickListener;
import santaguice.annotations.InjectTypeface;
import test.application.Activity;
import santaguice.injector.ContainerAsOnClickListenerInjector;
import santaguice.injector.Injector;
import santaguice.injector.TypefaceInjector;


public class PropertyFiller {

	
	HashMap<Class<? extends Annotation>, Injector> injectorMap;
	private static PropertyFiller singleInstance;
	
	
	public static PropertyFiller getInstance()
	{
		if(singleInstance==null)
		{
			singleInstance=new PropertyFiller();
		}
		
		return singleInstance;
	}
	
	private PropertyFiller(){
		
		injectorMap=new HashMap<Class<? extends Annotation>, Injector>();
		
		//Initialization with all the annotations we want to discover and all the actions we want to take when we find them
		injectorMap.put(InjectTypeface.class, new TypefaceInjector());
		injectorMap.put(InjectContainerAsOnClickListener.class, new ContainerAsOnClickListenerInjector());
	}
	
	
	public void injectAllFoundProperties(Object targetActivity) throws RuntimeException
	{
		try{
		
			Field[] allFields = targetActivity.getClass().getDeclaredFields();
			
			for (int i = 0; i < allFields.length; i++) {
				Field currentField = allFields[i];
				
				for(Class<? extends Annotation> currentAnnotation: injectorMap.keySet())
				{
					Annotation foundAnnotation=currentField.getAnnotation(currentAnnotation);
					if (foundAnnotation != null) {
						currentField.setAccessible(true);
						Object obj=currentField.get(targetActivity);
						injectorMap.get(currentAnnotation).injectProperties(targetActivity ,obj, foundAnnotation);
					}
				}
			}
		}
		catch(IllegalAccessException ex)
		{
			throw new RuntimeException(ex);
		}
	}


}

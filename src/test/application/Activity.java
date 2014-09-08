package test.application;

import santaguice.PropertyFiller;
import test.annotations.InjectContainerAsOnClickListener;
import test.annotations.InjectTypeface;

public class Activity {

	@InjectTypeface(typefaceName = "fonts/showg.ttf")
	@InjectContainerAsOnClickListener
	protected Button but;

	protected void init() {
		but = new Button();
		PropertyFiller inj=PropertyFiller.getInstance();
		
		try {
			inj.injectAllFoundProperties(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args)
	{
		Activity act=new Activity();
		
		act.init();
	}

}

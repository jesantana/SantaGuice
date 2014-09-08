SantaGuice
==========

This project is inspired on RoboGuice. It is intended to let the user define new annotations to eliminate boilerplate code when creating an activity. So far, there are only two annotations implemented, but you are able to define your own one and implement its functionality

Example

    package santaguice;
    
    import santaguice.annotations.InjectContainerAsOnClickListener;
    import santaguice.annotations.InjectTypeface;
    import android.app.Activity;
    
    public class ExampleActivity extends Activity {
    
    	@InjectView(R.id.btnComenzar)
    	@InjectContainerAsOnClickListener
    	private Button btnComenzar;
    	
    	@InjectView(R.id.btnPuntuacion)
    	@InjectTypeface(typefaceName="myCustomFont")
    	private Button btnPuntuaciones;
    	
    	...
    	
    }

SantaGuice
==========

This project is inspired on RoboGuice. It is intended to let the user define new annotations to eliminate boilerplate code when creating an activity. So far, there are only two annotations implemented, but you are able to define your own one and implement its functionality

Example

    public class ExampleActivity extends Activity {

    	@InjectView(R.id.btnComenzar)
    	@InjectContainerAsOnClickListener
    	private Button btnComenzar;
    	
    	@InjectView(R.id.btnPuntuacion)
    	@InjectTypeface(typefaceName="myCustomFont")
    	private Button btnPuntuaciones;
    	
    	
    	@Override
    	protected void onCreate(Bundle savedInstanceState) {
    		super.onCreate(savedInstanceState);
    		
    		setContentView(R.layout.select_activity);
    		
    		//Launch injector scan for annotated properties
    		PropertyFiller.getInstance().injectAllFoundProperties(this);
    	}
    }

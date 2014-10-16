package pk.edu.iba.locationtwo;

import java.security.Provider;

import android.app.Activity;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class LocationActivity extends Activity {

    private TextView txtLong;
	private TextView txtLat;
	private TextView txtSpeed;
	private TextView txtAccuracy;
	private LocationManager LM;

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.location);
        
        txtLong = (TextView) findViewById(R.id.txtLong);
        txtLat = (TextView) findViewById(R.id.txtLat);
        txtSpeed = (TextView) findViewById(R.id.txtSpeed);
        txtAccuracy = (TextView) findViewById(R.id.txtAccuracy);
        
        LM = (LocationManager) getSystemService(LOCATION_SERVICE);
        
        Criteria criteria = new Criteria();
		criteria.setAccuracy(Criteria.ACCURACY_COARSE);
		
		String provider = LM.getBestProvider(criteria, true);
		
		
		
		LocationListener listener = new LocationListener() {
			
			@Override
			public void onStatusChanged(String provider, int status, Bundle extras) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onProviderEnabled(String provider) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onProviderDisabled(String provider) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onLocationChanged(Location location) {
				txtLong.setText(String.valueOf(location.getLongitude()));
				txtLat.setText(String.valueOf(location.getLatitude()));
				txtSpeed.setText(String.valueOf(location.getSpeed()));
				txtAccuracy.setText(String.valueOf(location.getAccuracy()));
			}
		};
		
		LM.requestLocationUpdates(provider, 0, 0, listener);
        
    }
}

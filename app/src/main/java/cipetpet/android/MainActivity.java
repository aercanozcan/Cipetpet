package cipetpet.android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import net.hockeyapp.android.CrashManager;
import net.hockeyapp.android.UpdateManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //random shite!

        checkForUpdates();
    }

    @Override
    public void onResume() {
      super.onResume();
      checkForCrashes();
    }

    @Override
    public void onPause() {
      super.onPause();
      unregisterManagers();
    }

    @Override
    public void onDestroy() {
      super.onDestroy();
      unregisterManagers();
    }

    private void checkForCrashes() {
      CrashManager.register(this);
    }

    private void checkForUpdates() {
      // TODO: Remove this for store builds!
      UpdateManager.register(this);
    }

    private void unregisterManagers() {
      UpdateManager.unregister();
    }
}

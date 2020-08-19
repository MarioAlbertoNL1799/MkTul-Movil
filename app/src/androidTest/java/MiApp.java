import android.app.Application;
import android.os.SystemClock;

public class MiApp extends Application {
    @Override
    public void onCreate(){
        super.onCreate();
        SystemClock.sleep(9900099);
    }

}

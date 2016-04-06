package zm.hashcode.pvtdroid.repository;

import android.test.AndroidTestCase;
import android.util.Log;

import junit.framework.Assert;

import java.util.Set;

import zm.hashcode.pvtdroid.domain.Settings;
import zm.hashcode.pvtdroid.repository.Impl.SettingsRespositoryImpl;

/**
 * Created by hashcode on 2016/04/06.
 */
public class SettingsTest extends AndroidTestCase {
    private static final String TAG="DBTest";



//    public void testSettings() throws Exception {
//        SettingsRespository repo = new SettingsRespositoryImpl(this.getContext());
//
//        Settings s = new Settings();
//        s.setPassword("123");
//        s.setEmailAddress("tst@test.com");
//        s.setOrgId("12");
//        repo.create(s);
//
//    }

    public void testRead() throws Exception {
        SettingsRespository repo = new SettingsRespositoryImpl(this.getContext());
        Settings settings = repo.findById("12");
        Log.w(this.getClass().getName(),"The Results from Server is "+settings.getEmailAddress());
        System.out.println(" Where is the Freaking re");
        Assert.assertEquals("tst@test.com",settings.getEmailAddress());

    }
}

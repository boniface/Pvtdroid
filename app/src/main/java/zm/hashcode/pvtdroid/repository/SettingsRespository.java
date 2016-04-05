package zm.hashcode.pvtdroid.repository;

import zm.hashcode.pvtdroid.domain.Person;
import zm.hashcode.pvtdroid.domain.Settings;

/**
 * Created by hashcode on 2016/04/05.
 */
public interface SettingsRespository {
    void create(Settings settings);
    Settings findById(String id);
    void update(Settings settings);
    void delete(Settings settings);
}

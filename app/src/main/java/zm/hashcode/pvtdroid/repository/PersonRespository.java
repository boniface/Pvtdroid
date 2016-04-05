package zm.hashcode.pvtdroid.repository;

import zm.hashcode.pvtdroid.domain.Person;

/**
 * Created by hashcode on 2016/04/05.
 */
public interface PersonRespository {
    void create(Person person);
    Person findById(String id);
    void update(Person person);
    void delete(Person person);

}

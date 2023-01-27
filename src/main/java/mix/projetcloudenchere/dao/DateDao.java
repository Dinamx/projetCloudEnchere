package mix.projetcloudenchere.dao;

import java.sql.Timestamp;

public class DateDao {
    public Timestamp getNow(){
        return new Timestamp(System.currentTimeMillis());

    }
}

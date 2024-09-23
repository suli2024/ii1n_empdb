package lan.zold;

import java.sql.Connection;

public interface iDatabase {
    public Connection connectDb();
    public void closeDb(Connection connection);
}

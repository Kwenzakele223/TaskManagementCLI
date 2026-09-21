import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseSchema
{
    public Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:taskMananger.db");
        return connection;
    }

    public void createUsersTable() throws SQLException
    {
        try(Connection connection = getConnection();
            Statement statement = connection.createStatement();) {

            String users = """
                
                    CREATE TABLE IF NOT EXISTS users(
                id INTEGER PRIMARY KEY,
                name TEXT NOT NULL,
                password TEXT NOT NULL)""";

            statement.executeUpdate(users);

        }
    }

    public void createTasksTable() throws SQLException
    {
        try(Connection connection = getConnection();
        Statement statement = connection.createStatement();)
        {
            String tasks = """
                    CREATE TABLE IF NOT EXISTS tasks(
                    id INTEGER PRIMARY KEY,
                    title TEXT NOT NULL,
                    description TEXT NOT NULL,
                    completed INTEGER NOT NULL DEFAULT 0,
                    user_id INTEGER NOT NULL,
                    FOREIGN KEY (user_id) REFERENCES users(id)
                    )""";

            statement.executeUpdate(tasks);
        }
    }
}

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserRepository
{
    // Handle storing and retrieving data from the database

    public void saveUser(User user) throws SQLException
    {
        DatabaseSchema databaseSchema = new DatabaseSchema();

        String insert = """
                INSERT INTO users (name, password)
                VALUES (?,?)
                """;

        try(Connection connection = databaseSchema.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(insert))
        {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPassword());

            preparedStatement.executeUpdate();
        }
    }


    public User findUserByName(String name) throws SQLException
    {
        DatabaseSchema databaseSchema = new DatabaseSchema();

        String select = """
                SELECT *
                FROM users
                WHERE name = ?
                """;

        try(Connection connection = databaseSchema.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(select))
        {
            preparedStatement.setString(1, name);

            try(ResultSet resultSet = preparedStatement.executeQuery())
            {
                if(resultSet.next())
                {
                    int id = resultSet.getInt("id");
                    String userName = resultSet.getString("name");
                    String password = resultSet.getString("password");

                    return new User(id, userName, password);
                }
            }
        }

        return null;
    }
}
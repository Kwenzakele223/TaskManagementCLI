import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TaskRepository
{
    // Create a task for a specific user
    public void saveTask(Task task) throws SQLException
    {
        DatabaseSchema databaseSchema = new DatabaseSchema();

        String insert = """
                INSERT INTO tasks (title, description, completed, user_id)
                VALUES (?, ?, ?, ?)
                """;

        try (Connection connection = databaseSchema.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insert))
        {
            preparedStatement.setString(1, task.getTitle());
            preparedStatement.setString(2, task.getDescription());
            preparedStatement.setBoolean(3, task.isCompleted());
            preparedStatement.setInt(4, task.getUserId());

            preparedStatement.executeUpdate();
        }
    }


    // Get all tasks belonging to a specific user
    public List<Task> findTasksByUserId(int userId) throws SQLException
    {
        DatabaseSchema databaseSchema = new DatabaseSchema();

        String select = """
                SELECT *
                FROM tasks
                WHERE user_id = ?
                """;

        List<Task> tasks = new ArrayList<>();

        try (Connection connection = databaseSchema.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(select))
        {
            preparedStatement.setInt(1, userId);

            try (ResultSet resultSet = preparedStatement.executeQuery())
            {
                while (resultSet.next())
                {
                    int id = resultSet.getInt("id");
                    String title = resultSet.getString("title");
                    String description = resultSet.getString("description");
                    int taskUserId = resultSet.getInt("user_id");

                    Task task = new Task(
                            id,
                            title,
                            description,
                            taskUserId
                    );

                    boolean completed = resultSet.getBoolean("completed");

                    if (completed)
                    {
                        task.markComplete();
                    }

                    tasks.add(task);
                }
            }
        }

        return tasks;
    }


    // Mark a task as completed
    public boolean completeTask(int taskId, int userId) throws SQLException
    {
        DatabaseSchema databaseSchema = new DatabaseSchema();

        String update = """
            UPDATE tasks
            SET completed = 1
            WHERE id = ? AND user_id = ?
            """;

        try (Connection connection = databaseSchema.getConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement(update))
        {
            preparedStatement.setInt(1, taskId);
            preparedStatement.setInt(2, userId);

            int rowsAffected =
                    preparedStatement.executeUpdate();

            return rowsAffected > 0;
        }
    }


    // Delete a task belonging to a specific user
    public boolean deleteTask(int taskId, int userId) throws SQLException
    {
        DatabaseSchema databaseSchema = new DatabaseSchema();

        String delete = """
            DELETE FROM tasks
            WHERE id = ? AND user_id = ?
            """;

        try (Connection connection = databaseSchema.getConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement(delete))
        {
            preparedStatement.setInt(1, taskId);
            preparedStatement.setInt(2, userId);

            int rowsAffected =
                    preparedStatement.executeUpdate();

            return rowsAffected > 0;
        }
    }
}
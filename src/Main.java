import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;


public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        DatabaseConnection dataSource = new DatabaseConnection();

        View view = new View();
        View2 view2 = new View2();
        Controller controller = new Controller(view, view2, dataSource);
    }
}
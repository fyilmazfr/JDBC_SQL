import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ExecuteUpdate01 {

    public static void main(String[] args) throws SQLException {

        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "5314x1453");
        Statement statement = connection.createStatement();

        //1. Örnek: companies table'ından number_of_employees değeri ortalama çalışan sayısından az olan number_of_employees değerlerini 16000 olarak UPDATE edin.
        int updateEdilenSatirSayisi = statement.executeUpdate("UPDATE companies SET number_of_employees = 16000 WHERE number_of_employees < (SELECT AVG(number_of_employees) FROM companies)");
                 //bunu bir int atadik ki kac satiri update ettik gorelim diye
        System.out.println("updateEdilenSatirSayisi = " + updateEdilenSatirSayisi);

        connection.close();
        statement.close();
    }
}

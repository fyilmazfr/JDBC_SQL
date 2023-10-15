import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Execute01 {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //1.adim: Driver ' a kaydol ve yolunu goster, bu bolum artik yazilmiyor java kendi kutuphanesinden getiriyor
        Class.forName("org.postgresql.Driver");
        //JDBC 4 sonrasi bu satira ihtiyacimiz yok.

        //2.adim Database'e baglan
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "5314x1453");

        //driver manager'dan get connection methodunu cagirdik bu method maven'da otomatik var
        //gerekli username id ve password girdikten sonra bunu connection konteynrina atiyoruz

        //3.adim: Statement olustur
        Statement statement = connection.createStatement();

        //4.adim: QUERY calistir (sql 'i calistir)


         //ornek;1 bir tablo olusturduk
        boolean sql1 = statement.execute("CREATE TABLE workers (worker_id VARCHAR(20), worker_name VARCHAR(20), worker_salary INT)");

        //execute() methodu parantez içerisinde belirtilen String sql komutunu database'de uygular.

        //ornek2; var olan tabloya add ile sutun ekledik
        boolean sql2 = statement.execute("ALTER TABLE workers add worker_adress Varchar(100)");

        //ornek3; workers table'ini siliniz
        boolean sql3 = statement.execute("Drop table workers");


         /*
            execute methodu () DDL(create,drop,alter,truncate) ile kullanildiginda data donmeyecegi icin herzaman false doner
            execute() methodu DQL(Select)  ile kullanildiginda data cagirirsa 'true cagirmazsa false doner
       */
        //5.ADIM baglantiyi kapat
        connection.close();
        statement.close();
    }
}






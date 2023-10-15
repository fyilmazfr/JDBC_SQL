import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCUtils {
    private static Connection connection;  //metodumuzu static yaparak heryerden ulasabilecegiz BU ISLEMI EN SON 17.satirdan sonra yapiyoruz
    private static Statement statement;  //bu kisimda 2. methodumuz icin


    //1.METHOD CONNECTION OLUSTURMA; bu method database ile baglanti kurup Connection data doner
    public static Connection connecToDatabase() { //burda connectToDatabase adi ile bir method olusturduk ki her defasinda hem bunu class'imiza yazmayalim
        //bu cagiracagiz method sayesinde

        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "5314x1453");
        } catch (SQLException e) {
            throw new RuntimeException(e);//burda try catch exception sectik cunku methodu sectigimiz yerde bir exception atamasin diye
        }

        return connection; // BU method bize bir connection donecek

    }

    /*medunna ya baglanmak icin bu methodu kullanacagiz ihtiyac halinde ac veya kapa ,ustteki connectodatabase direk local database e baglanmak icin

    public static Connection connecToDatabase() { //burda connectToDatabase adi ile bir method olusturduk ki her defasinda hem bunu class'imiza yazmayalim
        //bu cagiracagiz method sayesinde

        try {
            connection = DriverManager.getConnection("jdbc:postgresql://medunna.com:5432/medunna_db_v2", "select_user", "1234");
        } catch (SQLException e) {
            throw new RuntimeException(e);//burda try catch exception sectik cunku methodu sectigimiz yerde bir exception atamasin diye
        }

        return connection; // BU method bize bir connection donecek

    }

     */


    //2. METHODUMUZ STATEMENT OLUSTURMA ; bu method connectToDataBase() methodunu icinde cagirarak bir statement objesi olusturup return yapar
    public static Statement createStatement() {
        try {
            statement = connecToDatabase().createStatement();
            //statement = connection.createStatement(); 31.satir ;basta bu sekilde yaptik. Fakat bu da kendimizi tekrar etlek oldugundan daha basit bir sekilde 30.satiri yaptik , yani direk connetToDataBase i cagirip statement yaptik
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return statement;

    }

    //3.METHODUMUZ   //her defasinda execute yapmamak icin bir method olusturcagiz

    public static boolean execute(String sql) {// bize boolean donecek ve kullanici bir string girecek


        try {
            return createStatement().execute(sql);// yukardan createstatement methodunu cagirdik ve ona execute verdik
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }//bu method bir SQL query'yi calistirip data donuyorsa true, donmuyorsa false verir
    }


    //4.METHODUMUZ executeUpdate


    // 5. METHOD  ;Bu method bir SQL query'yi çalıştırıp sonucu ResultSet olarak döner
    public static ResultSet executeQuery(String sql)  {


        try {
            return createStatement().executeQuery(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    //6. METHOD;  Bu method istediğimiz bir table'ın isteğimiz bir sütunu list olarak alip bize  döner
    public static List<Object> getColumnList(String tableName, String columnName) throws SQLException {

        List<Object> list = new ArrayList<>();

        ResultSet resultSet = executeQuery("select " + columnName + " from " + tableName);

        while (resultSet.next()) {
            list.add(resultSet.getObject(1));
        }

        return list;

    }

    //7.method bu method baglantiyi kapatir
    public static void closeConnection(){
        try {
            connection.close();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }


}

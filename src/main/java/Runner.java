import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Runner {// JDBCUtils class'inda olusturdugumuz methodlari burda calistirmak icin bir runner class olusturduk
    public static void main(String[] args) throws SQLException {


        //JDBCUtils.connecToDatabase();
        //JDBCUtils.createStatement().execute("select * from companies"); //JDBCUtils class'inda iki methodu birlestirdigimiz icin burda 7.satiri kapattik. acada biliriz

        //execute methodunu calistiralim
         JDBCUtils.execute("select * from companies"); //7. ve 8. satiri kapattik. cunku olusturdugumuz bu method her ikisinide kapsiyor
        System.out.println(JDBCUtils.execute("select * from companies"));//bunu da sout'da gormek istersek. bize true dondurecektir


        //campanies table'inin tum sutunlarini yazdirdik
        ResultSet resultSet=JDBCUtils.executeQuery("select * from companies");

        List<String> list=new ArrayList<>();
        while(resultSet.next()){
            System.out.println(resultSet.getString("company"));// burda hangi sutunu bize getirmesini istiyorsak onun numarasini ,yada sutun ismini yaziyoruz
        }

        //istersek company sutununun degerlerini bir list icerisine al
        List<Object> cOMPANYlIST=JDBCUtils.getColumnList("companies","company");
        System.out.println("companyList=" +cOMPANYlIST );
              //bu method bir arraylist dondurur

        //baglantiyi kapat
        JDBCUtils.closeConnection();





    }
}

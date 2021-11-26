package Repository;

import java.util.ArrayList;
import java.util.List;

public class CreateDatabase {
    public static String createDataBaseSql(){
        return "DROP TABLE IF EXISTS demo; " +
                "CREATE TABLE demo (ID integer primary key" +
                ", Name varchar(20), " +
                "Hint varchar(200) );" +
                "";
    }

    public static String selectFromDataBase(){
        return "SELECT * FROM demo";
    }

    public static List<String> LocalData(){
        List<String> array = new ArrayList<>();
        array.add("INSERT INTO demo values(1, 'SQL', 'Data Science');");
        array.add("INSERT INTO demo values(2, 'MySQL', 'JavaEE');");
        array.add("INSERT INTO demo values(3, 'MySQL', 'JavaSE');");
        array.add("INSERT INTO demo values(4, 'MySQL', 'JAVASCRIPT');");
        array.add("INSERT INTO demo values(5, 'PostSQL', 'GoLang');");

        return array;
    }
}

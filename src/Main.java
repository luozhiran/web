import services.dao.DatabaseConnectionFactory;
import services.javabean.Emp;
import services.utils.Format;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        insert();
        query();
    }


    private static void insert() {

        Emp emp = null;
        for (int i = 0; i < 5; i++) {
            emp = new Emp();
            emp.setEmpno(1000 + i);
            emp.setEname("name - " + i);
            emp.setJob("程序员 - " + i);
            emp.setHiredate(new Date());
            emp.setSola(500 * i);
            try {
                DatabaseConnectionFactory.getDatabaseConnection().doCreate(emp);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    private static void query() {
        try {
            List<Emp> all = DatabaseConnectionFactory.getDatabaseConnection().findAll("");
            Iterator<Emp> iter = all.iterator();
            while (iter.hasNext()) {
                Emp emp = iter.next();
                System.out.println(emp.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

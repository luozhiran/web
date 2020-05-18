package services.dao;

import org.omg.CORBA.PRIVATE_MEMBER;
import services.javabean.Emp;

import java.util.List;

public class EmpDaoProxy implements IEmpDao {

    private DatabaseConnection dbc = null;
    private IEmpDao dao = null;


    public EmpDaoProxy() {
        dbc = new MySqlDatabaseConnection();//进行数据库连接
        dao = new EmpDaoImpl(dbc.getConnection());
    }

    @Override
    public boolean doCreate(Emp emp) throws Exception {
        boolean flag = false;
        try {
            if (dao.findById(emp.getEmpno()) == null) {
                flag = dao.doCreate(emp);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception();
        } finally {
            dbc.close();
        }

        return flag;
    }

    @Override
    public List<Emp> findAll(String keyWord) throws Exception {
        List<Emp> all = null;
        try {
            all = dao.findAll(keyWord);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception();
        } finally {
            dbc.close();
        }
        return all;
    }

    @Override
    public Emp findById(int empno) throws Exception {
        Emp emp = null;
        try {
            emp = dao.findById(empno);
        } catch (Exception e) {
            throw new Exception();
        } finally {
            dbc.close();
        }
        return emp;
    }
}

package services.dao;

import com.mysql.cj.protocol.Resultset;
import services.javabean.Emp;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


/**
 * 对数据库进行增删改查
 */
public class EmpDaoImpl implements IEmpDao {

    private Connection conn;//数据库连接对象
    private PreparedStatement preparedStatement;//数据库操作对象

    public EmpDaoImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public boolean doCreate(Emp emp) throws Exception {
        boolean flag = false;
        String sql = "INSERT INTO emp(empno,ename,job,hiredate,sola) VALUES(?,?,?,?,?)";
        preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1, emp.getEmpno());
        preparedStatement.setString(2, emp.getEname());
        preparedStatement.setString(3, emp.getJob());
        preparedStatement.setDate(4, new Date(emp.getHiredate().getTime()));
        preparedStatement.setFloat(5, emp.getSola());
        if (preparedStatement.executeUpdate() > 1) {
            flag = true;
        }
        preparedStatement.close();
        return flag;
    }

    @Override
    public List<Emp> findAll(String keyWord) throws Exception {
        List<Emp> all = new ArrayList<>();
        String sql = "SELECT empno,ename,job,hiredate,sola From emp WHERE ename LIKE ? OR job LIKE ?";
        preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1, "%" + keyWord + "%");
        preparedStatement.setString(2, "%" + keyWord + "%");
        ResultSet resultset = preparedStatement.executeQuery();
        Emp emp = null;
        while (resultset.next()) {
            emp = new Emp();
            emp.setEmpno(resultset.getInt(1));
            emp.setEname(resultset.getString(2));
            emp.setJob(resultset.getString(3));
            emp.setHiredate(resultset.getDate(4));
            emp.setSola(resultset.getFloat(5));
            all.add(emp);
        }
        preparedStatement.close();

        return all;
    }

    @Override
    public Emp findById(int empno) throws Exception {
        Emp emp = null;
        String sql="SELECT empno,ename,job,hiredate,sola FROM emp WHERE empno = ?";
        preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1,empno);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()){
            emp = new Emp();
            emp.setEmpno(rs.getInt(1));
            emp.setEmpno(rs.getInt(1));
            emp.setEname(rs.getString(2));
            emp.setJob(rs.getString(3));
            emp.setHiredate(rs.getDate(4));
            emp.setSola(rs.getFloat(5));
        }

        return emp;
    }
}

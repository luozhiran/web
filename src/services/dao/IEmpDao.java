package services.dao;

import services.javabean.Emp;

import java.util.List;

public interface IEmpDao {

    /**
     * 数据库的增加操作，一般以doXX的方式命名
     *
     * @param emp
     * @return
     */
    boolean doCreate(Emp emp) throws Exception;

    /**
     * 查询全部数据，一般以findXxx的方式命名
     *
     * @param keyWord
     * @return
     * @throws Exception
     */
    List<Emp> findAll(String keyWord) throws Exception;


    /**
     * 根据雇员编号查询雇员信息
     *
     * @param empno
     * @return
     * @throws Exception
     */
    Emp findById(int empno) throws Exception;
}

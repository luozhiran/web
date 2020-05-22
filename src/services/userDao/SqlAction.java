package services.userDao;

import java.util.List;

public interface SqlAction<T> {

    /**
     * 数据库的增加操作,一般以doXX的命名方式
     *
     * @param t
     * @return
     */
    boolean doCreate(T t);


    /**
     * 查询全部数据，一般以findXxx的方式命名
     *
     * @param keyWord
     * @return
     */
    List<T> findAll(String keyWord);


    /**
     * 根据编号查询
     *
     * @param id
     * @return
     */
    T findById(int id);

    T findByAccountName(String name);
}

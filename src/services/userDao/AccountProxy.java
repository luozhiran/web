package services.userDao;

import services.javabean.Account;

import java.sql.Connection;
import java.util.List;

public class AccountProxy implements SqlAction<Account> {
    private SqlConnectionImpl mConn;
    private SqlAction<Account> mSqlAction;

    public AccountProxy() {
        mConn = new SqlConnectionImpl();
        mSqlAction = new AccountDao(mConn.getConnection());

    }

    @Override
    public boolean doCreate(Account account) {
        boolean flag = false;
        if (mSqlAction.findById(account.getId()) == null) {
            flag = mSqlAction.doCreate(account);
        }
        mConn.close();
        return flag;
    }

    @Override
    public List<Account> findAll(String keyWord) {
        List<Account> all = null;
        all = mSqlAction.findAll(keyWord);
        mConn.close();
        return all;
    }

    @Override
    public Account findById(int id) {
        Account account = mSqlAction.findById(id);
        mConn.close();
        return account;
    }

    @Override
    public Account findByAccountName(String name) {
        Account account = mSqlAction.findByAccountName(name);
        mConn.close();
        return account;
    }
}

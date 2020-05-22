package services.userDao;

import com.mysql.cj.protocol.Resultset;
import services.javabean.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AccountDao implements SqlAction<Account> {

    private Connection mCoon;
    private PreparedStatement mPreparedStatement;

    public AccountDao(Connection connection) {
        mCoon = connection;
    }

    @Override
    public boolean doCreate(Account account) {
        boolean flag = false;

        String sql = "INSERT INTO account(name,pwd,createtime) value(?,?,?)";
        try {
            mPreparedStatement = mCoon.prepareStatement(sql);
            mPreparedStatement.setString(1, account.getAccountName());
            mPreparedStatement.setString(2, account.getPwd());
            mPreparedStatement.setString(3, new SimpleDateFormat("yyyy-DD-mm HH:ss").format(new Date()));
            if (mPreparedStatement.executeUpdate() > 1) {
                flag = true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (mPreparedStatement != null) {
                try {
                    mPreparedStatement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return flag;
    }

    @Override
    public List<Account> findAll(String keyWord) {
        List<Account> list = new ArrayList<>();
        String sql = "SELECT * From account Where name LIKE ? ";
        try {
            mPreparedStatement = mCoon.prepareStatement(sql);
            mPreparedStatement.setString(1, "%" + keyWord + "%");
            ResultSet resultset = mPreparedStatement.executeQuery();
            Account account = null;
            while (resultset.next()) {
                account = new Account();
                account.setAccountName(resultset.getString(1));
                account.setPwd(resultset.getString(2));
                account.setCreateTime(resultset.getString(3));
                account.setId(resultset.getInt(4));
                list.add(account);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (mPreparedStatement != null) {
                try {
                    mPreparedStatement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return list;
    }

    @Override
    public Account findById(int id) {
        Account account = null;
        String sql = "SELECT * From account WHERE id = ?";
        try {
            mPreparedStatement = mCoon.prepareStatement(sql);
            mPreparedStatement.setInt(1, id);
            ResultSet resultSet = mPreparedStatement.executeQuery();
            while (resultSet.next()) {
                account = new Account();
                account.setAccountName(resultSet.getString(1));
                account.setPwd(resultSet.getString(2));
                account.setCreateTime(resultSet.getString(3));
                account.setId(resultSet.getInt(4));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (mPreparedStatement != null) {
                try {
                    mPreparedStatement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return account;
    }

    @Override
    public Account findByAccountName(String name) {
        Account account = null;
        String sql = "SELECT * From account WHERE name = ?";
        try {
            mPreparedStatement = mCoon.prepareStatement(sql);
            mPreparedStatement.setString(1, name);
            ResultSet resultSet = mPreparedStatement.executeQuery();
            while (resultSet.next()) {
                account = new Account();
                account.setAccountName(resultSet.getString(1));
                account.setPwd(resultSet.getString(2));
                account.setCreateTime(resultSet.getString(3));
                account.setId(resultSet.getInt(4));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (mPreparedStatement != null) {
                try {
                    mPreparedStatement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return account;
    }
}

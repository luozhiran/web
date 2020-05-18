package services.dao;

public class DatabaseConnectionFactory {

    public static IEmpDao getDatabaseConnection() {
        return new EmpDaoProxy();
    }
}

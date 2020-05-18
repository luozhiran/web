package services.javabean;

import java.util.HashMap;
import java.util.Map;

public class RegisterBean {
    private String name;
    private String email;
    private String pwd;
    private Map<String, String> error;

    public RegisterBean() {
        this.name = "";
        this.email = "";
        this.pwd = "";
        this.error = new HashMap<>();
    }


    public boolean isValidate() {
        boolean flag = true;
        if (!this.name.matches("\\w{6,15}")) {
            flag = false;
            this.name = "";
            error.put("errorName", "用户名是6-15位的字母或数字");
        }

        if (!email.matches("\\w+@\\w+\\.\\w+\\.?\\w")) {
            flag = false;
            this.email = "";
            error.put("errorEmail", "输入的email地址不合法");
        }

        return false;
    }


    public String showErrorMsg(String key) {
        String value = error.get(key);
        return value == null ? "" : value;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}

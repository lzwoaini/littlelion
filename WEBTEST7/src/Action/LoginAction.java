package Action;

import JavaBean.Conn;
import JavaBean.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import java.sql.ResultSet;

public class LoginAction extends ActionSupport {
    private User user;
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    public String execute(){
        if(user==null) return INPUT;
        try {
            Conn conn = new Conn();
            ResultSet res = conn.executeQuery("select * from user where name = '"+user.getName()+"'");
            if(res.next()){
                if(res.getString("password").equals(user.getPassword())){
                    ActionContext.getContext().getSession().put("user",user);
                    return SUCCESS;
                }
                else return ERROR;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return ERROR;
    }
    public String logout(){
        ServletActionContext.getRequest().getSession().setAttribute("user",null);
        return INPUT;
    }
    public void validate(){
        if(user==null){
            return ;
        }
        if(user.getName()==null||user.getName().trim().equals("")){
            addFieldError("user.name","用户名不能为空!");

        }
        if(user.getPassword()==null||user.getPassword().trim().equals("")){
            addFieldError("user.password","密码不能为空!");
        }
    }
}

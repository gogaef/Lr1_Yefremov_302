package classes;
import javax.annotation.ManagedBean;
import javax.enterprise.context.Dependent;
import Interfaces.IUser;
import annotations.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@ManagedBean
@Dependent
@User("Client")
public class Client implements IUser
{
    private Map values=new HashMap();
    
    @Override
    public void Inicialization(ResultSet result)
    {
        try {
            this.values.put("idClient", result.getString(1));
            this.values.put("Name",result.getString(2));
            this.values.put("Password",result.getString(3));
            this.values.put("age",result.getString(4));
        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public String getPermission()
    {
        return "Client";
    }
    
    
    @Override
    public Map<String,String> getValues()
    {
        return values;
    }
    
  
    
}
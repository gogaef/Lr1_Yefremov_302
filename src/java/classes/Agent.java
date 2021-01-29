
package classes;
import Interfaces.IUser;
import annotations.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.ManagedBean;
import javax.enterprise.context.Dependent;

@ManagedBean
@Dependent
@User("Agent")
public class Agent implements IUser {
    
    private Map values = new HashMap();
    
    @Override
    public void Inicialization(ResultSet result)
    {
        try {
            this.values.put("idAgent", result.getString(1));
            this.values.put("Name",result.getString(2));
            this.values.put("Password",result.getString(3));
            this.values.put("age",result.getString(4));
            this.values.put("raiting",result.getString(4));
            this.values.put("procent",result.getString(6));
        } catch (SQLException ex) {
            Logger.getLogger(Agent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public String getPermission()
    {
        return "Agent";
    }
    
    @Override
    public Map<String,String> getValues()
    {
        return values;
    }
    
}


package classes;
import Serv.ProcessCreatingIsurance;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ManagerQuery {
    
    private Connection conn;
    
    
    public ManagerQuery(String path)
    {
        try    
        {
	    Class.forName("org.sqlite.JDBC").getDeclaredConstructor().newInstance();
	    try 
            {
                Connection conn = DriverManager.getConnection(path);
	        this.conn=conn;
	    }
            catch(Exception ex)
            {
	        this.conn=null;
            }
	}
        catch(Exception ex)
        {
	    this.conn=null;
        }
    
    }
    
    public ResultSet select(String table)
    {
        try
        {
            return conn.createStatement().executeQuery("SELECT * FROM " + table);
        }
        catch(Exception ex)
        {
            return null;
        }
        
    }
    
    public ResultSet selectWhereOne(String table, String column, String value)
    {
        try
        {
            return conn.createStatement().executeQuery("SELECT * FROM " + table + " WHERE "+ column + " = " + value);
        }
        catch (SQLException ex) 
        {
            Logger.getLogger(ManagerQuery.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    
    public ResultSet selectWhereThree(String table, String column1, String value1 , String column2, String value2, String column3, String value3)
    {
        try
        {
            return conn.createStatement().executeQuery("SELECT * FROM " + table + " WHERE (" + column1 + " " + value1+ ") AND (" + column2 + " " + value2 + 
                    ") AND (" + column3 + " " + value3 + ");");
        }
        catch (SQLException ex) 
        {
            Logger.getLogger(ManagerQuery.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    
    public int updateAgent(int idAgent, Float agentProcent ,int idAgreement)
    {
        String query = "UPDATE Contract SET idAgent = ?, percentForAgent = ? WHERE idContract = ?";
        try (PreparedStatement preStatement= conn.prepareStatement(query);)
        {
            preStatement.setInt(1,idAgent);
            preStatement.setFloat(2, percentForAgent);
            preStatement.setInt(3, idContract);
            
            return preStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ManagerQuery.class.getName()).log(Level.SEVERE, null, ex);
            return 111;
        }
        
    }
    
    public int insertAgreement(Integer idClient, Integer idAgent, Integer summa, Float agentProcent)
    {
        try
        {
            String query = "insert into Contract(idClient,idAgent,summa,percentForAgent) values (?,?,?,?)";
            try(PreparedStatement preStatement = conn.prepareStatement(query))
            {
                preStatement.setInt(1, idClient);
                preStatement.setInt(2, idAgent);
                preStatement.setInt(3,price);
                preStatement.setFloat(4, percentForAgent);
                return preStatement.executeUpdate();
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(ManagerQuery.class.getName()).log(Level.SEVERE, null, ex);
            return 111;
        }
    }
    
    public int DeleteAgreement(int idAgreement)
    {
        String query ="DELETE FROM Contract WHERE idContract = ?";
        try(PreparedStatement preStatement = conn.prepareStatement(query))
        {
            preStatement.setInt(1, idAgreement);
            return preStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ManagerQuery.class.getName()).log(Level.SEVERE, null, ex);
            return 111;
        }
    }
}

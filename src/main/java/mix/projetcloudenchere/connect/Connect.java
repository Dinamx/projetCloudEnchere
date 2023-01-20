package mix.projetcloudenchere.connect;

import java.sql.*;

public class Connect {
    Connection con;
    Statement stat;
    ResultSet res;
    PreparedStatement stm;

    public Connect() {
        try {
            Class.forName("org.postgresql.Driver");
            this.con = DriverManager.getConnection("jdbc:postgresql://dumbo.db.elephantsql.com:5432/dwujqywc", "dwujqywc", "vDkbmEKvvGSIMUAEwxQCTVIdMTtX2nST");
//            this.con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cloudenchere", "postgres", "root");
        }
        catch (Exception e)
        {
        }
        finally
        {
        }
    }

    public Connect(String req) throws Exception{
        try {


            Class.forName("org.postgresql.Driver");
            this.con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cloudenchere","postgres","root");
            this.stm= this.con.prepareStatement(req);
            this.stat= this.con.createStatement();
            System.out.println(req);
            this.res=stat.executeQuery(req);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        finally{

        }

    }

    public Connect(String req,String difference){
        try {

            System.out.println(req);
            Class.forName("org.postgresql.Driver");
            this.con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cloudenchere","postgres","root");
            this.stm= this.con.prepareStatement(req);
            System.out.println(req);
            this.stat= this.con.createStatement();


        }
        catch (Exception e)
        {
            e.getMessage();
            e.printStackTrace();

        }
        finally{

        }
    }
    public ResultSet getResultset(){
        return this.res;
    }
    public Statement getStat(){
        return this.stat;
    }
    public void close()throws Exception{
        con.close();
    }
    public void getCommit() throws Exception
    {
        this.stat.executeQuery("commit");
    }


    public Connection getcon() {
        return con;
    }

    public void setcon(Connection con) {
        this.con = con;
    }

    public PreparedStatement getStm() {
        return stm;
    }

    public void setStm(PreparedStatement stm) {
        this.stm = stm;
    }

    public ResultSet getRes() {
        return res;
    }

    public void setRes(ResultSet res) {
        this.res = res;
    }

    public void Execute() throws Exception{
        try{
            this.res=this.stm.executeQuery();
        }
        catch(Exception sqle){
            throw sqle;
        }
    }
    public void Close()throws Exception{
        this.con.close();
    }
    public PreparedStatement prepareStatement(String query) throws SQLException{
        return this.con.prepareStatement(query);
    }

}


package dao;

import JDBC.JDBCTool;
import module.Dish;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class dishDAO {
    public static List<Dish> getDishList() throws SQLException {
        List<Dish> dishs = new ArrayList<Dish>();
        try {
            Connection conn = JDBCTool.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM dish");
            while(rs.next()) {
                String DishID = rs.getString("DishID");
                String Name = rs.getString("Name");
                double Price = rs.getDouble("Price");
                boolean Availability = rs.getBoolean("Availability");
                String D_RestaurantID = rs.getString("D_RestaurantID");
                Dish d = new Dish(DishID, Name, Price, Availability, D_RestaurantID);
                dishs.add(d);
            }
            rs.close();
            st.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dishs;
    }

    public Dish getDishByID(String DishID) throws SQLException {
        List<Dish> dishs = getDishList();
        Dish dish = null;
        for(Dish d : dishs) {
            if(d.getDishId().equals(DishID)) {
                dish = d;
            }
        }
        return dish;
    }

    public List<Dish> getDishesByRestaurantID(String RestaurantID) throws SQLException {
        List<Dish> dishes = new ArrayList<Dish>();
        try {
            Connection conn = JDBCTool.getConnection();
            Statement st = conn.createStatement();
            String statement = "SELECT * FROM dish WHERE dish.D_RestaurantID = '" + RestaurantID + "'";
            ResultSet rs = st.executeQuery(statement);
            while(rs.next()) {
                String DishID = rs.getString("DishID");
                String DName = rs.getString("Name");
                double Price = rs.getDouble("Price");
                boolean Availability = rs.getBoolean("Availability");
                String D_RestaurantID = rs.getString("D_RestaurantID");
                Dish d = new Dish(DishID, DName, Price, Availability, D_RestaurantID);
                dishes.add(d);
            }
            rs.close();
            st.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  dishes;
    }

    public List<Dish> getDishesByName(String Name) throws SQLException{
        List<Dish> dishes = new ArrayList<Dish>();
        try {
            Connection conn = JDBCTool.getConnection();
            Statement st = conn.createStatement();
            String statement = "SELECT * FROM dish WHERE Name LIKE '%"+Name+"%'";
            ResultSet rs = st.executeQuery(statement);
            while(rs.next()) {
                String DishID = rs.getString("DishID");
                String DName = rs.getString("Name");
                double Price = rs.getDouble("Price");
                boolean Availability = rs.getBoolean("Availability");
                String D_RestaurantID = rs.getString("D_RestaurantID");
                Dish d = new Dish(DishID, DName, Price, Availability, D_RestaurantID);
                dishes.add(d);
            }
            rs.close();
            st.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dishes;
    }

    public boolean insertDish(Dish r) throws SQLException {
        try {
            Connection conn = JDBCTool.getConnection();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO dish VALUES (?,?,?,?,?)");
            ps.setString(1, r.getDishId());
            ps.setString(2, r.getDishName());
            ps.setDouble(3,r.getDishPrice());
            ps.setBoolean(4,r.isDishAvailability());
            ps.setString(5,r.getD_RestaurantId());
            return ps.execute();
        }catch (SQLException s){
            s.printStackTrace();
            return false;
        }
    }

    public boolean updateDish(Dish r)  {
        try {
            Connection conn = JDBCTool.getConnection();
            PreparedStatement ps = conn.prepareStatement("update dish set Name=?," +
                    "Price=?,Availability=?,D_RestaurantID=? where DishID = ?");
            ps.setString(2, r.getDishName());
            ps.setDouble(3,r.getDishPrice());
            ps.setBoolean(4,r.isDishAvailability());
            ps.setString(5,r.getD_RestaurantId());
            ps.setString(1, r.getDishId());
            return ps.execute();
        }catch (SQLException s){
            s.printStackTrace();
            return false;
        }
    }

    public boolean deleteDishByID(String DishID) {
        try {
            Connection conn = JDBCTool.getConnection();
            PreparedStatement ps = conn.prepareStatement("DELETE FROM dish WHERE DishID = ?");
            ps.setString(1,DishID);
            return ps.execute();
        }catch (SQLException s){
            s.printStackTrace();
            return false;
        }
    }
}

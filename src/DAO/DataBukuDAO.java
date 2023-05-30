/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.*;
import java.util.*;
import javax.print.attribute.ResolutionSyntax;
import model.*;
import koneksi.Connector;

/**
 *
 * @author PC PRAKTIKUM
 */
public class DataBukuDAO implements DataBukuInterface{
    Connection connection;
    
    final String select = "SELECT * FROM dataperpus";
    final String insert = "INSERT INTO dataperpus (judul, genre, penulis, penerbit, lokasi, stock) VALUES (?, ?, ?, ?, ?, ?);";
    final String update = "UPDATE dataperpus SET judul=?, penulis=?, penerbit=?, lokasi=?, stock=?;";
    final String delete = "DELETE FROM dataperpus WHERE id=?;";
    final String search = "SELECT * FROM dataperpus WHERE judul ='?'";
    
    public DataBukuDAO(){
        connection = Connector.connection();
    }
    
    @Override
    public void insert(DataBuku p){
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, p.getJudul());
            statement.setString(2, p.getGenre());
            statement.setString(3, p.getPenulis());
            statement.setString(4, p.getPenerbit());
            statement.setString(5, p.getLokasi());
            statement.setInt(6, p.getStock());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            while(rs.next()){
                p.setId(rs.getInt(1));
            }
        } catch(Exception e){
            e.printStackTrace();
        } finally {
            try{
                statement.close();
            } catch(SQLException e){
                e.printStackTrace();
            }
        }
    }
    
    @Override
    public void update(DataBuku p){
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(update);
            statement.setString(1, p.getJudul());
            statement.setString(2, p.getGenre());
            statement.setString(3, p.getPenulis());
            statement.setString(4, p.getPenerbit());
            statement.setString(5, p.getLokasi());
            statement.setInt(6, p.getStock());
            statement.setInt(6, p.getId());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
        } catch(Exception e){
            e.printStackTrace();
        } finally {
            try{
                statement.close();
            } catch(SQLException e){
                e.printStackTrace();
            }
        }
    }
    
    @Override
    public void delete(int id){
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(delete);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch(SQLException e){
            
        }
    }
    
    @Override
    public List<DataBuku> getAll(){
        List<DataBuku> dp = null;
        
        try{
            dp = new ArrayList<DataBuku>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while(rs.next()){
                DataBuku buku = new DataBuku();
                buku.setId(rs.getInt("id"));
                buku.setJudul(rs.getString("judul"));
                buku.setGenre(rs.getString("genre"));
                buku.setPenulis(rs.getString("penulis"));
                buku.setPenerbit(rs.getString("penerbit"));
                buku.setLokasi(rs.getString("lokasi"));
                buku.setStock(rs.getInt("stock"));
                dp.add(buku);
            }
        } catch(SQLException e){
            System.out.println("Error");
        }
        
        return dp;
    }

    @Override
    public List<DataBuku> getSearch() {
        List<DataBuku> dp = null;
        
        return dp;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.util.List;
import DAO.*;
import view.Main;
import model.*;
        
/**
 *
 * @author PC PRAKTIKUM
 */
public class DataBukuController {
    Main frame;
    DataBukuInterface impldatabuku;
    List<DataBuku> dp;
    
    public DataBukuController(Main frame){
        this.frame = frame;
        impldatabuku = new DataBukuDAO();
        dp = impldatabuku.getAll();
    } 
    
    public void isiTabel(){
        dp = impldatabuku.getAll();
        ModelTabelBuku mp = new ModelTabelBuku(dp);
        frame.getTabelBuku().setModel(mp);
        System.out.println("ok");
    }
    
    public void insert(){
        DataBuku buku = new DataBuku();
        buku.setJudul(frame.getTfJudul().getText());
        buku.setGenre(frame.getTfGenre().getText());
        buku.setPenulis(frame.getTfPenulis().getText());
        buku.setPenerbit(frame.getTfPenerbit().getText());
        buku.setLokasi(frame.getTfLokasi().getText());
//        buku.setStock(String.valueOf(frame.getTfStock().getText()));
    }
    
    public void update(){
        DataBuku buku = new DataBuku();
        buku.setJudul(frame.getTfJudul().getText());
        buku.setGenre(frame.getTfGenre().getText());
        buku.setPenulis(frame.getTfPenulis().getText());
        buku.setPenerbit(frame.getTfPenerbit().getText());
        buku.setLokasi(frame.getTfLokasi().getText());
        buku.setStock(Integer.parseInt((frame.getTfStock().getText())));
    }
    
    public void delete(){
        int id = Integer.parseInt(frame.getTfID().getText());
        impldatabuku.delete(id);
    }
    
    
}

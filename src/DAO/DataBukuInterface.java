/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import model.DataBuku;
import java.util.List;

/**
 *
 * @author PC PRAKTIKUM
 */
public interface DataBukuInterface {
    public void insert(DataBuku p);
    public void update(DataBuku p);
    public void delete(int id);
    public List<DataBuku> getAll();
    public List<DataBuku> getSearch();
}

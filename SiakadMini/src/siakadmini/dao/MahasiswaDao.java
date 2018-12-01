/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siakadmini.dao;

import siakadmini.entity.Mahasiswa;
import siakadmini.lib.ManajerKoneksi;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author yunhasnawa
 */
public class MahasiswaDao 
{
    private final Connection koneksi;
    
    public MahasiswaDao()
    {
        this.koneksi = ManajerKoneksi.getKoneksi();
    }
    
    public ArrayList<Mahasiswa> selectWhere(String where)
    {
        String sql = "SELECT * FROM mahasiswa";
        
        if(where != null)
            sql += (" " + where);
        
        ResultSet hasil = this.buatResultSet(sql);
        
        ArrayList<Mahasiswa> mahasiswaTerpilih = new ArrayList<>();
        
        try
        {
        while(hasil.next())
        {
            Mahasiswa mhs = new Mahasiswa();
            mhs.setNim(hasil.getInt("nim"));
            mhs.setNama(hasil.getString("nama"));
            mhs.setAlamat(hasil.getString("alamat"));
            
            mahasiswaTerpilih.add(mhs);
        }
        }
        catch(SQLException ex)
        {
            System.out.println("Terjadi error! Errornya: ");
            System.out.println(ex.getMessage());
        }
        
        return mahasiswaTerpilih;
    }
    
    private ResultSet buatResultSet(String sql)
    {  
        ResultSet hasil;
        
        try 
        {
            Statement statement = this.koneksi.createStatement();
        
            hasil = statement.executeQuery(sql);
        } 
        catch (SQLException ex) 
        {
            System.out.println("Gagal mengeksekusi SQL! SQL-nya:");
            System.out.println(sql);
            System.out.println("Errornya: ");
            System.out.println(ex.getMessage());
            
            hasil = null;
        }
        
        return hasil;
    }
    
    public ArrayList<Mahasiswa> findAll()
    {
        ArrayList<Mahasiswa> semua = this.selectWhere(null);
        
        return semua;
    }
    
    public boolean insertOne(Mahasiswa mahasiswa)
    {
        Integer nim = mahasiswa.getNim();
        String nama = mahasiswa.getNama();
        String alamat = mahasiswa.getAlamat();
        
        String sql = "INSERT INTO mahasiswa (nim, nama, alamat) VALUES('" + nim + "', '" + nama + "', '" + alamat + "');";
        
        try
        {
            Statement statement = this.koneksi.createStatement();

            statement.executeUpdate(sql);
            
            return true;
        }
        catch(SQLException ex)
        {
            return false;
        }
    }
}

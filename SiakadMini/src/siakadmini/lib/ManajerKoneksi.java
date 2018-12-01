/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siakadmini.lib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yunhasnawa
 */
public class ManajerKoneksi {

    private static final String FILE_PROPERTIES = "siakadmini.properties";
    private static Connection koneksi;

    public static Connection getKoneksi() {
        if (ManajerKoneksi.koneksi == null) {
            ManajerKoneksi.buatKoneksi();
        }

        return ManajerKoneksi.koneksi;
    }

    private static boolean cekDriver() 
    {
        try 
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Cek driver OK.");

            return true;
        } 
        catch (ClassNotFoundException ex) {
            System.out.println("Cek driver gagal! Errornya:");
            System.out.println(ex.getMessage());

            return false;
        }
    }

    private static void buatKoneksi() 
    {
        if(!ManajerKoneksi.cekDriver())
            System.exit(1);
        
        Properties props = ManajerKoneksi.muatProperties();
        
        String url = props.getProperty("jdbc.url");
        String user = props.getProperty("user");
        String password = props.getProperty("password");
        
        try 
        {
            ManajerKoneksi.koneksi = DriverManager.getConnection(url, user, password);
            System.out.println("Buat koneksi OK.");
        } 
        catch (SQLException ex) 
        {
            System.out.println("Buat koneksi GAGAL! Errornya:");
            System.out.println(ex.getMessage());
            System.exit(1); // Hentikan aplikasi!
        }
    }

    private static Properties muatProperties()
    {
        // Membuat objek properties baru yang masih kosong.
        Properties props = new Properties();
        
        // Memuat (load) nilai-nilai dari file properties ke object props
        try(FileInputStream fis = new FileInputStream(ManajerKoneksi.FILE_PROPERTIES))
        {
            props.load(fis); // Mengisi properties dari stream
            fis.close();
            
            System.out.println("Memuat file properties OK.");
        } 
        catch (FileNotFoundException ex) 
        {
            System.out.println("Memuat file properties GAGAL! Errornya:");
            System.out.println(ex.getMessage());
        } 
        catch (IOException ex) {
            System.out.println("Memuat file properties GAGAL! Errornya:");
            System.out.println(ex.getMessage());
        }
        
        return props;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siakadmini.entity;

/**
 *
 * @author yunhasnawa
 */
public class Mahasiswa 
{
    private Integer nim;
    private String nama;
    private String alamat;

    public Mahasiswa(Integer nim, String nama, String alamat) 
    {
        this.nim = nim;
        this.nama = nama;
        this.alamat = alamat;
    }

    public Mahasiswa() 
    {
    }

    public Integer getNim() {
        return nim;
    }

    public void setNim(Integer nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    
    
}

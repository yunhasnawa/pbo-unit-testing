/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siakadmini.form;

import siakadmini.dao.MahasiswaDao;
import siakadmini.entity.Mahasiswa;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author yunhasnawa
 */
public class FormUtama extends javax.swing.JFrame implements ListSelectionListener{

    private final MahasiswaDao daoMahasiswa;
    private ArrayList<Mahasiswa> listMahasiswa;
    private DefaultTableModel modelTblDataMahasiswa;
    
    public FormUtama() 
    {
        initComponents();
        
        this.daoMahasiswa = new MahasiswaDao();
        
        this.siapkanTblDataMahasiswa();
        this.muatUlangListMahasiswa();
    }
    
    private void siapkanTblDataMahasiswa()
    {
        // Persiapkan table model terlebih dahulu
        String[] daftarKolom = new String[]{"Nim", "Nama", "Alamat"};
        int jumlahBaris = 0;
        this.modelTblDataMahasiswa = new DefaultTableModel(daftarKolom, jumlahBaris);
        this.tblDataMahasiswa.setModel(this.modelTblDataMahasiswa);
        
        // Tangani even ketika tabel diklik baris-barisnya
        this.tblDataMahasiswa.getSelectionModel().addListSelectionListener(this);
    }
    
    private void resetKomponen()
    {
        this.txtNim.setText("");
        this.txtNama.setText("");
        this.txtAlamat.setText("");
        
        this.btnSimpan.setText("Simpan!");
    }
    
    private void muatUlangListMahasiswa()
    {
        if(this.listMahasiswa == null)
            this.listMahasiswa = new ArrayList<>();
        
        this.listMahasiswa.clear();
        
        ArrayList<Mahasiswa> semuaMhs = this.daoMahasiswa.selectAll();
        
        for(Mahasiswa m : semuaMhs)         
            this.listMahasiswa.add(m);
    }
    
    private void muatUlangTblDataMahasiswa()
    {   
        // Bersihkan tabel
        while(this.modelTblDataMahasiswa.getRowCount() > 0)
        {
            this.modelTblDataMahasiswa.removeRow(0);
        }
        
        // Tambahkan baris tabel satu persatu
        for(Mahasiswa m : this.listMahasiswa)
        {
            Object[] dataBaris = new Object[]{
                m.getNim(),
                m.getNama(),
                m.getAlamat()
            };
            
            this.modelTblDataMahasiswa.addRow(dataBaris);
        }
    }
    
    private Mahasiswa entityMahasiswaDariKomponen()
    {
        if(this.txtNim.getText().isEmpty())
            return null; // Tidak berhasil membuat entity dari komponen
        
        Integer nim = Integer.parseInt(this.txtNim.getText());
        String nama = this.txtNama.getText();
        String alamat = this.txtAlamat.getText();
        
        Mahasiswa m = new Mahasiswa(nim, nama, alamat);
        
        return m;
    }
    
    private void updateMahasiswa(Mahasiswa m)
    {
        // Update data mahasiswa dilakukan disini..
        this.daoMahasiswa.update(m);
    }
    
    private void tambahMahasiswa(Mahasiswa m)
    {
        if(this.daoMahasiswa.insertOne(m))
        {
            JOptionPane.showMessageDialog(
                    this, 
                    "Data mahasiswa berhasil ditambahkan.", 
                    "Informasi", 
                    JOptionPane.INFORMATION_MESSAGE
            );
        }
        else
        {
            JOptionPane.showMessageDialog(
                    this, 
                    "Data mahasiswa gagal ditambahkan!", 
                    "Galat", 
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblDataMahasiswa = new javax.swing.JTable();
        btnRefresh = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtNim = new javax.swing.JTextField();
        txtNama = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtAlamat = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnSimpan = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblDataMahasiswa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblDataMahasiswa);

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        jLabel1.setText("Nim:");

        jLabel2.setText("Nama:");

        jLabel3.setText("Alamat:");

        btnSimpan.setText("Simpan!");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnRefresh)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNim)
                            .addComponent(txtAlamat)
                            .addComponent(txtNama)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnHapus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSimpan)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpan)
                    .addComponent(btnHapus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRefresh)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        
        this.muatUlangListMahasiswa();
        this.muatUlangTblDataMahasiswa();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        
        Mahasiswa m = this.entityMahasiswaDariKomponen();
        if(m == null) return; // Jangan lakukan apa-apa
        
        if(this.btnSimpan.getText().equals("Simpan!"))
            this.tambahMahasiswa(m);
        else if(this.btnSimpan.getText().equals("Update!"))
            this.updateMahasiswa(m);
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        
        Mahasiswa m = this.entityMahasiswaDariKomponen();
        if(m == null) return; // Jangan lakukan apa-apa
        
        this.daoMahasiswa.deleteOne(m);
    }//GEN-LAST:event_btnHapusActionPerformed
    
    @Override
    public void valueChanged(ListSelectionEvent e) 
    {
        int row = this.tblDataMahasiswa.getSelectedRow();
        
        if(row < 0 || row > this.listMahasiswa.size())
        {
            this.resetKomponen();
            return;
        }
        
        Mahasiswa mhsTerpilih = this.listMahasiswa.get(row);
        
        this.txtNim.setText(mhsTerpilih.getNim().toString());
        this.txtNama.setText(mhsTerpilih.getNama());
        this.txtAlamat.setText(mhsTerpilih.getAlamat());
        
        this.btnSimpan.setText("Update!");
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormUtama().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDataMahasiswa;
    private javax.swing.JTextField txtAlamat;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtNim;
    // End of variables declaration//GEN-END:variables

    
}

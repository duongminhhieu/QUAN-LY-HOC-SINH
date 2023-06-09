/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package school.form;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import school.Student;

/**
 *
 * @author ASUS
 */
public class ImportExportStudent extends javax.swing.JPanel {

    /**
     * Creates new form ImportExportStudent
     */
    public ImportExportStudent() {
        initComponents();
    }

    List<Student> list = new ArrayList<Student>();

    public static void exportToCSV(List<Student> students, String filePath) throws IOException {
//        BufferedWriter writer = new BufferedWriter(
//                new OutputStreamWriter(new FileOutputStream(filePath), StandardCharsets.UTF_8)
//        );

        Path path = Paths.get(filePath);

        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {

            // Ghi tiêu đề của các cột
            writer.write("MaHS,TenHS,Điểm,Địa chỉ,Ghi chú,Hình ảnh");
            writer.newLine();

            // Ghi dữ liệu của các sinh viên
            for (Student student : students) {
                writer.write(student.getId() + ",");
                writer.write(student.getName() + ",");
                writer.write(student.getScore() + ",");
                writer.write(student.getAddress() + ",");
                writer.write(student.getDescription() + ",");
                writer.write(student.getImage());

                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void importFromCSV(List<Student> students, String filePath) throws FileNotFoundException {

        String id, name, address, des, image;
        double score;
        try {
            FileInputStream fis = new FileInputStream(new File(filePath));
            InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
            BufferedReader reader = new BufferedReader(isr);
            System.out.println(reader.readLine()); // bỏ dòng tiêu đề
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");

                id = values[0];
                name = values[1];
                score = Double.parseDouble(values[2]);
                address = values[3];
                des = values[4];
                image = values[5];
                Student st = new Student(id, name, score, image, address, des);
                students.add(st);
            }

        } catch (Exception e) {
            e.printStackTrace();
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

        jLabel1 = new javax.swing.JLabel();
        importBtn = new javax.swing.JButton();
        pathImport = new javax.swing.JTextField();
        exportBtn = new javax.swing.JButton();
        pathExport = new javax.swing.JTextField();
        btnFileExport = new javax.swing.JButton();
        btnFileImport = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("IMPORT/EXPORT FILE CSV DANH SÁCH HỌC SINH");

        importBtn.setText("IMPORT");
        importBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                importBtnMouseClicked(evt);
            }
        });

        pathImport.setEditable(false);

        exportBtn.setText("EXPORT");
        exportBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exportBtnMouseClicked(evt);
            }
        });
        exportBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportBtnActionPerformed(evt);
            }
        });

        pathExport.setEditable(false);

        btnFileExport.setText("Chọn nơi lưu");
        btnFileExport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFileExportMouseClicked(evt);
            }
        });

        btnFileImport.setText("Chọn file csv");
        btnFileImport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFileImportMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(176, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(172, 172, 172))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(pathExport, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(exportBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(btnFileImport, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(pathImport, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(importBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnFileExport, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(162, 162, 162))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(76, 76, 76)
                .addComponent(btnFileImport)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pathImport, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(importBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(69, 69, 69)
                .addComponent(btnFileExport)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pathExport, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exportBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(219, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    private void exportBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_exportBtnActionPerformed

    private void exportBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exportBtnMouseClicked
        // TODO add your handling code here:

        if (pathExport.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn nơi xuất file");
        } else {
            try {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream("students.bin"));
                try {
                    list = (List) ois.readObject();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ImportExportStudent.class.getName()).log(Level.SEVERE, null, ex);
                }
                String filePath = pathExport.getText();
                exportToCSV(list, filePath);
                System.out.println("Exported successfully!");
                JOptionPane.showMessageDialog(this, "Xuất file thành công vào đường dẫn: " + filePath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }//GEN-LAST:event_exportBtnMouseClicked

    private void btnFileExportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFileExportMouseClicked
        // TODO add your handling code here:
        // Hiển thị hộp thoại chọn thư mục
        JFileChooser directoryChooser = new JFileChooser();
        directoryChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int userSelection = directoryChooser.showSaveDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File directoryToSave = directoryChooser.getSelectedFile();
            pathExport.setText(directoryToSave.getAbsolutePath() + "\\export.csv");
        }
    }//GEN-LAST:event_btnFileExportMouseClicked

    private void btnFileImportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFileImportMouseClicked
        // TODO add your handling code here:
        //

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Choose CSV File");
        fileChooser.setFileFilter(new FileNameExtensionFilter("CSV files (*.csv)", "csv"));

        int userSelection = fileChooser.showOpenDialog(null);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File csvFile = fileChooser.getSelectedFile();
            pathImport.setText(csvFile.getAbsolutePath());
            System.out.println("Selected file: " + csvFile.getAbsolutePath());
        }
    }//GEN-LAST:event_btnFileImportMouseClicked

    private void importBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_importBtnMouseClicked
        // TODO add your handling code here:
        if (pathImport.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn file!");
        } else {
            try {

                importFromCSV(list, pathImport.getText());
                try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("students.bin"))) {
                    oos.writeObject(list);
                    JOptionPane.showMessageDialog(this, "Import thành công !");
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(this, "Import KHÔNG thành công !!!!");
                    e.printStackTrace();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_importBtnMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFileExport;
    private javax.swing.JButton btnFileImport;
    private javax.swing.JButton exportBtn;
    private javax.swing.JButton importBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField pathExport;
    private javax.swing.JTextField pathImport;
    // End of variables declaration//GEN-END:variables
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package school.form;

import java.awt.Component;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;
import school.Student;

/**
 *
 * @author ASUS
 */
public class ListStudent extends javax.swing.JPanel {

    private List<Student> list;

    /**
     * Creates new form ListStudent
     */
    public ListStudent() {
        initComponents();
        init();

    }

    private void init() {

        table.fixTable(jScrollPane1);
        resizeColumnWidth(table);

        table.setAutoCreateRowSorter(true);
        table.setFillsViewportHeight(true);
        try {
            readFile();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ListStudent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void resizeColumnWidth(JTable table) {
        final TableColumnModel columnModel = table.getColumnModel();
        for (int column = 0; column < table.getColumnCount(); column++) {
            int width = 15; // Min width
            for (int row = 0; row < table.getRowCount(); row++) {
                TableCellRenderer renderer = table.getCellRenderer(row, column);
                Component comp = table.prepareRenderer(renderer, row, column);
                width = Math.max(comp.getPreferredSize().width + 1, width);
            }
            if (width > 300) {
                width = 300;
            }
            columnModel.getColumn(column).setPreferredWidth(width);
        }
    }

    class myTableCellRenderer implements TableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            table.setRowHeight(60);
            return (Component) value;
        }

    }

    private void readFile() throws ClassNotFoundException {
        //this part deserializes the list from file, and then iterates over its members

        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("students.bin"));
            list = (List) ois.readObject();

            if (!list.isEmpty()) {
                int i = 1;
                for (Student st : list) {
                    addDataTable(st, i);
                    i += 1;

                }
            }

        } catch (IOException ex) {
            Logger.getLogger(ListStudent.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void addDataTable(Student st, int i) throws IOException {
        JLabel imageLabel = new JLabel();
        ImageIcon imageicon = new ImageIcon(st.getImage());
        BufferedImage bimg = ImageIO.read(new File(st.getImage()));
        double t = (double) bimg.getWidth() / (double) bimg.getHeight();
        Image imageic = imageicon.getImage().getScaledInstance((int) (150 * t), 150, Image.SCALE_SMOOTH);
        imageLabel.setIcon(new ImageIcon(imageic));
        table.getColumn("Hình ảnh").setCellRenderer(new myTableCellRenderer());
        table.addRow(new Object[]{st.getId(), st.getName(), st.getScore(), st.getAddress(), st.getDescription(), imageLabel});
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel1 = new swing.RoundPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new swing.Table();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(780, 540));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        roundPanel1.setBackground(new java.awt.Color(255, 255, 255));
        roundPanel1.setRound(10);

        table.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MHS", "TenHS", "Diem", "Địa chỉ", "Ghi chú", "Hình ảnh"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        table.setRowHeight(80);
        table.setShowGrid(true);
        jScrollPane1.setViewportView(table);

        jComboBox1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sắp xếp", "Mã HS tăng dần", "Mã HS giảm dần", "Điểm tăng dần", "Điểm giảm dần" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 768, Short.MAX_VALUE)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBox1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        add(roundPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 49, -1, -1));

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 102, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("DANH SÁCH HỌC SINH");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(257, 6, 264, 37));
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:

        // get selected value 
        int x = jComboBox1.getSelectedIndex();

        switch (x) {
            case 1:
                // MHS tang dan
                Collections.sort(list, (st1, st2) -> {
                    return Integer.parseInt(st1.getId()) - Integer.parseInt(st2.getId());
                });
                table.setModel(new DefaultTableModel(null, new String[]{"MHS", "TenHS", "Điểm", "Địa chỉ", "Ghi chú", "Hình ảnh"}));
                if (!list.isEmpty()) {
                    int i = 1;
                    for (Student st : list) {
                        try {
                            addDataTable(st, i);
                        } catch (IOException ex) {
                            Logger.getLogger(ListStudent.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        i += 1;

                    }
                }
                break;
            case 2:
                // MHS tang dan
                Collections.sort(list, (st1, st2) -> {
                    return Integer.parseInt(st2.getId()) - Integer.parseInt(st1.getId());
                });
                table.setModel(new DefaultTableModel(null, new String[]{"MHS", "TenHS", "Điểm", "Địa chỉ", "Ghi chú", "Hình ảnh"}));
                if (!list.isEmpty()) {
                    int i = 1;
                    for (Student st : list) {
                        try {
                            addDataTable(st, i);
                        } catch (IOException ex) {
                            Logger.getLogger(ListStudent.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        i += 1;

                    }
                }
                break;

            case 3:
                // Diem tang dan
                Collections.sort(list, new Comparator<Student>() {
                    @Override
                    public int compare(Student c1, Student c2) {
                        return Double.compare(c1.getScore(), c2.getScore());
                    }
                });
                table.setModel(new DefaultTableModel(null, new String[]{"MHS", "TenHS", "Điểm", "Địa chỉ", "Ghi chú", "Hình ảnh"}));
                if (!list.isEmpty()) {
                    int i = 1;
                    for (Student st : list) {
                        try {
                            addDataTable(st, i);
                        } catch (IOException ex) {
                            Logger.getLogger(ListStudent.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        i += 1;

                    }
                }
                break;

            case 4:
                // Diem tang dan
                Collections.sort(list, new Comparator<Student>() {
                    @Override
                    public int compare(Student c1, Student c2) {
                        return Double.compare(c2.getScore(), c1.getScore());
                    }
                });
                table.setModel(new DefaultTableModel(null, new String[]{"MHS", "TenHS", "Điểm", "Địa chỉ", "Ghi chú", "Hình ảnh"}));
                if (!list.isEmpty()) {
                    int i = 1;
                    for (Student st : list) {
                        try {
                            addDataTable(st, i);
                        } catch (IOException ex) {
                            Logger.getLogger(ListStudent.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        i += 1;

                    }
                }
                break;
            default:
                break;
        }

    }//GEN-LAST:event_jComboBox1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private swing.RoundPanel roundPanel1;
    private swing.Table table;
    // End of variables declaration//GEN-END:variables
}

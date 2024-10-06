/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Set;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import java.io.File;
import java.util.TreeMap;

/**
 *
 * @author Prabhashi
 */
public class PatientRegistrationPanel extends javax.swing.JPanel {

    private final NumberFormat format = NumberFormat.getInstance(Locale.US);
    final DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
    
    //declare and initialize tree maps
    TreeMap<String, String> dataTreeMap = new TreeMap<>();
    private TreeMap<String, Boolean> usedPatientIDs = new TreeMap<>();
   
    public PatientRegistrationPanel() {
        initComponents();
        generateAndSetPatientID(); // Generate and set patient ID
    }
    
   public void saveToTextFile() {
       
    // Add data to class-level TreeMap
    dataTreeMap.put("RoomNumber", (String) jComboBoxRoomNumber.getSelectedItem());
    dataTreeMap.put("RoomType", (String) jComboBoxRoomType.getSelectedItem());
    dataTreeMap.put("Age", jFormattedTextFieldAge.getText());
    dataTreeMap.put("PhoneNo", jFormattedTextFieldPhoneNo.getText());
    dataTreeMap.put("Price", jFormattedTextFieldPrice.getText());
    dataTreeMap.put("RegDate", jFormattedTextFieldRegDate.getText());
    dataTreeMap.put("Gender", (String) jComboBoxGender.getSelectedItem());
    dataTreeMap.put("Disease", jTextFieldDisease.getText());
    dataTreeMap.put("Name", jTextFieldName.getText());
    dataTreeMap.put("Address", jTextAreaAddress.getText());
    dataTreeMap.put("Comments", jTextAreaComments.getText());
    dataTreeMap.put("PatientID", jTextFieldPatientID.getText());

    // Save data to text file
    saveToFile(dataTreeMap);

   }

private void generateAndSetPatientID() {
    String patientID = generateUniquePatientID();
    jTextFieldPatientID.setText(patientID);
}

private String generateUniquePatientID() {
    String patientID;
    do {
        // Generate a random patient ID
        patientID = "PID" + (int) (Math.random() * 10000);
    } while (usedPatientIDs.containsKey(patientID)); // Check if it's already used
    usedPatientIDs.put(patientID, true);
    return patientID;
}


private void saveToFile(TreeMap<String, String> dataTreeMap) {
    try {
        // Get the patient name from the JTextField
        String patientName = jTextFieldName.getText().trim();

        // Create the directory if it doesn't exist
        File folder = new File("Patients Records");
        if (!folder.exists()) {
            folder.mkdir();
        }
        // Specify the file name using the patient name
        File file = new File(folder, patientName + ".txt");

        FileWriter fw = new FileWriter(file, true); // Open file in append mode
        BufferedWriter bw = new BufferedWriter(fw);

        // Write key-value pairs to the file
        for (String key : dataTreeMap.keySet()) {
            String value = dataTreeMap.get(key);
            bw.write(key + ": " + value);
            bw.newLine();
        }
        bw.close();
        fw.close();

        JOptionPane.showMessageDialog(null, "Data saved to file successfully!");
    } catch (IOException e) {
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

        jLabel2 = new javax.swing.JLabel();
        jTextFieldPatientID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jFormattedTextFieldRegDate = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jComboBoxGender = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jFormattedTextFieldAge = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        jFormattedTextFieldPhoneNo = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaAddress = new javax.swing.JTextArea();
        jLabel12 = new javax.swing.JLabel();
        jTextFieldDisease = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaComments = new javax.swing.JTextArea();
        jButtonSave = new javax.swing.JButton();
        jButtonReset = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jFormattedTextFieldPrice = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jComboBoxRoomType = new javax.swing.JComboBox();
        RoomNumber = new javax.swing.JLabel();
        jComboBoxRoomNumber = new javax.swing.JComboBox<>();

        setBackground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
        setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.MatteBorder(null), "Patient Registration", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18))); // NOI18N
        setForeground(new java.awt.Color(102, 102, 255));

        jLabel2.setText("Patient ID :");

        jTextFieldPatientID.setEnabled(false);

        jLabel3.setText("Register Date :");

        jFormattedTextFieldRegDate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy/MM/dd"))));
        jFormattedTextFieldRegDate.setText(dateFormat.format(new java.sql.Date(System.currentTimeMillis())));

        jLabel4.setText("Name :");

        jLabel5.setText("Gender :");

        jComboBoxGender.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Male", "Female", "Other" }));
        jComboBoxGender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxGenderActionPerformed(evt);
            }
        });

        jLabel7.setText("Age :");

        jFormattedTextFieldAge.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        jLabel8.setText("Phone no. :");

        jFormattedTextFieldPhoneNo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        jLabel9.setText("Address :");

        jTextAreaAddress.setColumns(20);
        jTextAreaAddress.setLineWrap(true);
        jTextAreaAddress.setRows(5);
        jTextAreaAddress.setWrapStyleWord(true);
        jScrollPane1.setViewportView(jTextAreaAddress);

        jLabel12.setText("Disease :");

        jLabel11.setText("Comments :");

        jTextAreaComments.setColumns(20);
        jTextAreaComments.setLineWrap(true);
        jTextAreaComments.setRows(5);
        jTextAreaComments.setWrapStyleWord(true);
        jScrollPane2.setViewportView(jTextAreaComments);

        jButtonSave.setText("Save");
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });

        jButtonReset.setText("Reset");
        jButtonReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonResetActionPerformed(evt);
            }
        });

        jButtonCancel.setText("Cancel");
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Room Information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));

        jLabel6.setText("Price (per day) Rs :");

        jFormattedTextFieldPrice.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        jFormattedTextFieldPrice.setEnabled(false);
        jFormattedTextFieldPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextFieldPriceActionPerformed(evt);
            }
        });

        jLabel1.setText("Room Type :");

        jComboBoxRoomType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Normal", "Medium", "VIP" }));
        jComboBoxRoomType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxRoomTypeActionPerformed(evt);
            }
        });

        RoomNumber.setText("Room Number");

        jComboBoxRoomNumber.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Room", "1", "2", "3", "4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFormattedTextFieldPrice))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(37, 37, 37)
                        .addComponent(jComboBoxRoomType, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(RoomNumber)
                        .addGap(24, 24, 24)
                        .addComponent(jComboBoxRoomNumber, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jComboBoxRoomType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jFormattedTextFieldPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RoomNumber)
                    .addComponent(jComboBoxRoomNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jButtonSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(jLabel2))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldPatientID)
                            .addComponent(jTextFieldName)
                            .addComponent(jComboBoxGender, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextFieldDisease)
                            .addComponent(jScrollPane1)
                            .addComponent(jFormattedTextFieldAge)
                            .addComponent(jFormattedTextFieldPhoneNo)
                            .addComponent(jFormattedTextFieldRegDate)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jButtonReset, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(44, 44, 44)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(85, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextFieldPatientID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jFormattedTextFieldRegDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jComboBoxGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jFormattedTextFieldAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jFormattedTextFieldPhoneNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldDisease, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonSave)
                            .addComponent(jButtonCancel)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jButtonReset)))
                .addContainerGap(54, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
    saveToTextFile();
    MainInterface.setDefaultLayout();
    }//GEN-LAST:event_jButtonSaveActionPerformed

    private void jButtonResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonResetActionPerformed
        resetFormReg();
    }//GEN-LAST:event_jButtonResetActionPerformed

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
        resetFormReg();
        MainInterface.setDefaultLayout();
    }//GEN-LAST:event_jButtonCancelActionPerformed

    private void jComboBoxRoomTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxRoomTypeActionPerformed
    String selectedText = (String) jComboBoxRoomType.getSelectedItem();
        
        if (selectedText.equals("VIP")) {
            jFormattedTextFieldPrice.setText("Rs.25,000");
        } else if (selectedText.equals("Medium")) {
            jFormattedTextFieldPrice.setText("Rs.21,000");
        } else {
            jFormattedTextFieldPrice.setText("Rs.19,500");
        }        
    }//GEN-LAST:event_jComboBoxRoomTypeActionPerformed

    private void jComboBoxGenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxGenderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxGenderActionPerformed

    private void jFormattedTextFieldPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextFieldPriceActionPerformed
        
    }//GEN-LAST:event_jFormattedTextFieldPriceActionPerformed

    

    public void resetFormReg() {
        jFormattedTextFieldRegDate.setText(dateFormat.format(new java.sql.Date(System.currentTimeMillis())));
        jTextFieldName.setText("");
        jComboBoxGender.setSelectedIndex(0);

        jFormattedTextFieldAge.setText(" ");
        jFormattedTextFieldAge.setValue(null);

        jFormattedTextFieldPhoneNo.setText("");
        jFormattedTextFieldPhoneNo.setValue(null);

        jTextAreaAddress.setText("");
        jTextFieldDisease.setText("");
        jTextAreaComments.setText("");

        jComboBoxRoomType.setSelectedIndex(0);
        jFormattedTextFieldPrice.setText("");
    }

    public void setJTextFieldPatientIDText(String id) {
        jTextFieldPatientID.setText(id);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel RoomNumber;
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonReset;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JComboBox jComboBoxGender;
    private javax.swing.JComboBox<String> jComboBoxRoomNumber;
    private javax.swing.JComboBox jComboBoxRoomType;
    private javax.swing.JFormattedTextField jFormattedTextFieldAge;
    private javax.swing.JFormattedTextField jFormattedTextFieldPhoneNo;
    private javax.swing.JFormattedTextField jFormattedTextFieldPrice;
    private javax.swing.JFormattedTextField jFormattedTextFieldRegDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextAreaAddress;
    private javax.swing.JTextArea jTextAreaComments;
    private javax.swing.JTextField jTextFieldDisease;
    private javax.swing.JTextField jTextFieldName;
    private javax.swing.JTextField jTextFieldPatientID;
    // End of variables declaration//GEN-END:variables
}

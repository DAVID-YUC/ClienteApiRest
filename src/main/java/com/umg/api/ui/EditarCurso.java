
package com.umg.api.ui;

import com.umg.api.model.Cursomodel;
import com.umg.api.service.CursoServer1;
import javax.swing.*;
import java.util.List;

public class EditarCurso extends javax.swing.JFrame {
    private int idCurso;
    private Cursos cursosPanel; 
    private Cursomodel cursoOriginal;
    private String nombreOriginal;
    
    public EditarCurso() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

 public EditarCurso(int idCurso, Cursos cursosPanel) {
        initComponents();
        this.idCurso = idCurso;
        this.cursosPanel = cursosPanel;
        this.setLocationRelativeTo(null);
        cargarDatosCurso();
    }
    
 private void cargarDatosCurso() {
    try {
        CursoServer1 service = new CursoServer1();
        List<Cursomodel> cursos = service.getCursos();
        
        cursoOriginal = cursos.stream()
                             .filter(c -> c.getId_curso() == idCurso)
                             .findFirst()
                             .orElse(null);

        if (cursoOriginal == null) {
            JOptionPane.showMessageDialog(this, "Curso no encontrado con ID: " + idCurso);
            this.dispose();
            return;
        }

        nombreOriginal = cursoOriginal.getNombre();
        txtCurso.setText(cursoOriginal.getNombre());
        
      
        // Solo verificar si no es null (ya que cambiaste a Integer)
        if (cursoOriginal.getCatedraticoCod() != null) {
            txtIdProfesor.setText(String.valueOf(cursoOriginal.getCatedraticoCod()));
        } else {
            txtIdProfesor.setText(""); // Dejar vacío si es null
        }
        
        cboSemestre.setSelectedItem(cursoOriginal.getSemestre());
        cboCreditos.setSelectedItem(String.valueOf(cursoOriginal.getCreditos()));
        
        // Manejar estado_curso que puede ser null
        if (cursoOriginal.getEstado_curso() != null && !cursoOriginal.getEstado_curso().isEmpty()) {
            cboEstado.setSelectedItem(cursoOriginal.getEstado_curso());
        } else {
            cboEstado.setSelectedIndex(0); // Seleccionar primer item por defecto
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al cargar curso: " + e.getMessage());
        e.printStackTrace();
    }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRound1 = new com.umg.api.ui.PanelRound();
        lblCurso = new javax.swing.JLabel();
        txtCurso = new javax.swing.JTextField();
        lblIdProfesor = new javax.swing.JLabel();
        txtIdProfesor = new javax.swing.JTextField();
        lblSemestre = new javax.swing.JLabel();
        cboSemestre = new javax.swing.JComboBox<>();
        lblCreditos = new javax.swing.JLabel();
        cboCreditos = new javax.swing.JComboBox<>();
        lblEstado = new javax.swing.JLabel();
        cboEstado = new javax.swing.JComboBox<>();
        panelRound3 = new com.umg.api.ui.PanelRound();
        btnGuardar = new javax.swing.JButton();
        panelRound2 = new com.umg.api.ui.PanelRound();
        btnCancelar = new javax.swing.JButton();
        lblTexto1 = new javax.swing.JLabel();
        lblTexto2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelRound1.setBackground(new java.awt.Color(255, 255, 255));
        panelRound1.setRoundBottomLeft(25);
        panelRound1.setRoundBottomRight(25);
        panelRound1.setRoundTopLeft(25);
        panelRound1.setRoundTopRight(25);

        lblCurso.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCurso.setForeground(new java.awt.Color(10, 25, 49));
        lblCurso.setText("Curso *");

        txtCurso.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(74, 127, 167)));

        lblIdProfesor.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblIdProfesor.setForeground(new java.awt.Color(10, 25, 49));
        lblIdProfesor.setText("Id Profesor");

        txtIdProfesor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(74, 127, 167)));
        txtIdProfesor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdProfesorActionPerformed(evt);
            }
        });

        lblSemestre.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblSemestre.setForeground(new java.awt.Color(10, 25, 49));
        lblSemestre.setText("Semestre");

        cboSemestre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1er Semestre", "2do Semestre", "3er Semestre", "4to Semestre", "5to Semestre", "8vo Semestre", "9no Semestre", "10mo Semestre" }));
        cboSemestre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(74, 127, 167)));

        lblCreditos.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCreditos.setForeground(new java.awt.Color(10, 25, 49));
        lblCreditos.setText("Creditos *");

        cboCreditos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5" }));
        cboCreditos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(74, 127, 167)));

        lblEstado.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblEstado.setForeground(new java.awt.Color(10, 25, 49));
        lblEstado.setText("Estado");

        cboEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Desabilitado", " " }));
        cboEstado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(74, 127, 167)));

        panelRound3.setBackground(new java.awt.Color(26, 61, 99));
        panelRound3.setRoundBottomLeft(15);
        panelRound3.setRoundBottomRight(15);
        panelRound3.setRoundTopLeft(15);
        panelRound3.setRoundTopRight(15);

        btnGuardar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setText("Guardar Cambios");
        btnGuardar.setBorderPainted(false);
        btnGuardar.setContentAreaFilled(false);
        btnGuardar.setFocusPainted(false);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound3Layout = new javax.swing.GroupLayout(panelRound3);
        panelRound3.setLayout(panelRound3Layout);
        panelRound3Layout.setHorizontalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGuardar)
                .addContainerGap())
        );
        panelRound3Layout.setVerticalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound3Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panelRound2.setBackground(new java.awt.Color(179, 207, 229));
        panelRound2.setRoundBottomLeft(15);
        panelRound2.setRoundBottomRight(15);
        panelRound2.setRoundTopLeft(15);
        panelRound2.setRoundTopRight(15);

        btnCancelar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(74, 127, 167));
        btnCancelar.setText("Cancelar");
        btnCancelar.setBorderPainted(false);
        btnCancelar.setContentAreaFilled(false);
        btnCancelar.setFocusPainted(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
        panelRound2.setLayout(panelRound2Layout);
        panelRound2Layout.setHorizontalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCancelar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRound2Layout.setVerticalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCancelar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblTexto1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTexto1.setForeground(new java.awt.Color(10, 25, 49));
        lblTexto1.setText("Editar Curso");

        lblTexto2.setForeground(new java.awt.Color(74, 127, 167));
        lblTexto2.setText("Modificar la información del curso.");

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTexto1)
                    .addComponent(lblTexto2)
                    .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblCurso)
                        .addComponent(lblIdProfesor, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cboCreditos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblEstado)
                        .addComponent(lblSemestre)
                        .addComponent(lblCreditos)
                        .addComponent(cboSemestre, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cboEstado, 0, 320, Short.MAX_VALUE)
                        .addComponent(txtIdProfesor)
                        .addComponent(txtCurso)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                            .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(panelRound3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lblTexto1)
                .addGap(5, 5, 5)
                .addComponent(lblTexto2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblCurso)
                .addGap(5, 5, 5)
                .addComponent(txtCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblIdProfesor)
                .addGap(5, 5, 5)
                .addComponent(txtIdProfesor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblSemestre)
                .addGap(5, 5, 5)
                .addComponent(cboSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblCreditos)
                .addGap(5, 5, 5)
                .addComponent(cboCreditos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addComponent(lblEstado)
                        .addGap(5, 5, 5)
                        .addComponent(cboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(panelRound3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdProfesorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdProfesorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdProfesorActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
           try {
            if (txtCurso.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "El nombre del curso es obligatorio");
                return;
            }

            CursoServer1 service = new CursoServer1();
            Cursomodel cursoActualizado = new Cursomodel();

            cursoActualizado.setId_curso(idCurso);
            cursoActualizado.setNombre(txtCurso.getText().trim());
            cursoActualizado.setCodigo(cursoOriginal.getCodigo()); // Asegurar que el código se mantiene

            // Manejar catedraticoCod que puede estar vacío o ser null
            String idProfesorText = txtIdProfesor.getText().trim();
            if (!idProfesorText.isEmpty()) {
                try {
                    cursoActualizado.setCatedraticoCod(Integer.parseInt(idProfesorText));
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "El ID del profesor debe ser un número válido");
                    return;
                }
            } else {
                cursoActualizado.setCatedraticoCod(null); // Enviar null si está vacío
            }

            cursoActualizado.setSemestre(cboSemestre.getSelectedItem().toString());
            cursoActualizado.setCreditos(Integer.parseInt(cboCreditos.getSelectedItem().toString()));
            
            // Manejar estado_curso correctamente
            String estadoSeleccionado = cboEstado.getSelectedItem().toString();
            if (estadoSeleccionado.equals("Seleccione estado")) {
                cursoActualizado.setEstado_curso(null);
            } else {
                cursoActualizado.setEstado_curso(estadoSeleccionado);
            }

            String resultado = service.updateCursoByNombre(nombreOriginal, cursoActualizado);
            JOptionPane.showMessageDialog(this, resultado);

            if (cursosPanel != null) cursosPanel.cargarDatos();
            this.dispose();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error en formato numérico: " + e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al actualizar curso: " + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnGuardarActionPerformed
   
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
 this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(EditarCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditarCurso().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cboCreditos;
    private javax.swing.JComboBox<String> cboEstado;
    private javax.swing.JComboBox<String> cboSemestre;
    private javax.swing.JLabel lblCreditos;
    private javax.swing.JLabel lblCurso;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblIdProfesor;
    private javax.swing.JLabel lblSemestre;
    private javax.swing.JLabel lblTexto1;
    private javax.swing.JLabel lblTexto2;
    private com.umg.api.ui.PanelRound panelRound1;
    private com.umg.api.ui.PanelRound panelRound2;
    private com.umg.api.ui.PanelRound panelRound3;
    private javax.swing.JTextField txtCurso;
    private javax.swing.JTextField txtIdProfesor;
    // End of variables declaration//GEN-END:variables
}













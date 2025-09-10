package com.umg.api.ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import com.umg.api.model.Cursomodel;
import com.umg.api.service.CursoServer1;
import java.util.List;
public class Cursos extends javax.swing.JPanel {
 private CursoServer1 cursoService;
    private DefaultTableModel tableModel;

    public Cursos() {
        initComponents();
        cursoService = new CursoServer1();
        inicializarTabla();
        cargarDatos();
    }

    private void inicializarTabla() {
        tableModel = new DefaultTableModel(
            new Object[]{"ID", "Nombre", "Código", "Semestre", "Créditos", "Estado_curso", "Catedrático"}, 0
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        jTableCursos.setModel(tableModel);
    }

    public void cargarDatos() {
        try {
            List<Cursomodel> cursos = cursoService.getCursos();
            tableModel.setRowCount(0);
            for (Cursomodel curso : cursos) {
                Object[] row = {
                    curso.getId_curso(),
                    curso.getNombre(),
                    curso.getCodigo(),
                    curso.getSemestre(),
                    curso.getCreditos(),
                    curso.getEstado_curso(),
                    curso.getCatedraticoCod()
                };
                tableModel.addRow(row);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar cursos: " + e.getMessage(), 
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRound1 = new com.umg.api.ui.PanelRound();
        panelRound3 = new com.umg.api.ui.PanelRound();
        btnAgregarCurso = new javax.swing.JButton();
        panelRound4 = new com.umg.api.ui.PanelRound();
        btnEliminarCurso = new javax.swing.JButton();
        panelRound5 = new com.umg.api.ui.PanelRound();
        btnEditarCurso = new javax.swing.JButton();
        panelRound6 = new com.umg.api.ui.PanelRound();
        txtBuscarCurso = new javax.swing.JTextField();
        btnBuscarCurso = new javax.swing.JButton();
        lblTexto1 = new javax.swing.JLabel();
        lblTexto2 = new javax.swing.JLabel();
        JTableCursos = new javax.swing.JScrollPane();
        jTableCursos = new javax.swing.JTable();
        panelRound7 = new com.umg.api.ui.PanelRound();
        btnActualizarCurso1 = new javax.swing.JButton();

        panelRound1.setBackground(new java.awt.Color(255, 255, 255));
        panelRound1.setRoundBottomLeft(25);
        panelRound1.setRoundBottomRight(25);
        panelRound1.setRoundTopLeft(25);
        panelRound1.setRoundTopRight(25);
        panelRound1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound3.setBackground(new java.awt.Color(179, 207, 229));
        panelRound3.setPreferredSize(new java.awt.Dimension(90, 35));
        panelRound3.setRoundBottomLeft(15);
        panelRound3.setRoundBottomRight(15);
        panelRound3.setRoundTopLeft(15);
        panelRound3.setRoundTopRight(15);

        btnAgregarCurso.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAgregarCurso.setText("agregar");
        btnAgregarCurso.setBorderPainted(false);
        btnAgregarCurso.setContentAreaFilled(false);
        btnAgregarCurso.setFocusPainted(false);
        btnAgregarCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarCursoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound3Layout = new javax.swing.GroupLayout(panelRound3);
        panelRound3.setLayout(panelRound3Layout);
        panelRound3Layout.setHorizontalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAgregarCurso)
                .addContainerGap(11, Short.MAX_VALUE))
        );
        panelRound3Layout.setVerticalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAgregarCurso)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelRound1.add(panelRound3, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 20, 90, -1));

        panelRound4.setBackground(new java.awt.Color(179, 207, 229));
        panelRound4.setPreferredSize(new java.awt.Dimension(90, 35));
        panelRound4.setRoundBottomLeft(15);
        panelRound4.setRoundBottomRight(15);
        panelRound4.setRoundTopLeft(15);
        panelRound4.setRoundTopRight(15);

        btnEliminarCurso.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEliminarCurso.setText("eliminar");
        btnEliminarCurso.setBorderPainted(false);
        btnEliminarCurso.setContentAreaFilled(false);
        btnEliminarCurso.setFocusPainted(false);
        btnEliminarCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarCursoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound4Layout = new javax.swing.GroupLayout(panelRound4);
        panelRound4.setLayout(panelRound4Layout);
        panelRound4Layout.setHorizontalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnEliminarCurso)
                .addContainerGap(8, Short.MAX_VALUE))
        );
        panelRound4Layout.setVerticalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEliminarCurso)
                .addContainerGap())
        );

        panelRound1.add(panelRound4, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 20, 90, -1));

        panelRound5.setBackground(new java.awt.Color(179, 207, 229));
        panelRound5.setPreferredSize(new java.awt.Dimension(90, 35));
        panelRound5.setRoundBottomLeft(15);
        panelRound5.setRoundBottomRight(15);
        panelRound5.setRoundTopLeft(15);
        panelRound5.setRoundTopRight(15);

        btnEditarCurso.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEditarCurso.setText("Editar");
        btnEditarCurso.setBorderPainted(false);
        btnEditarCurso.setContentAreaFilled(false);
        btnEditarCurso.setFocusPainted(false);
        btnEditarCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarCursoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound5Layout = new javax.swing.GroupLayout(panelRound5);
        panelRound5.setLayout(panelRound5Layout);
        panelRound5Layout.setHorizontalGroup(
            panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnEditarCurso, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelRound5Layout.setVerticalGroup(
            panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnEditarCurso)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelRound1.add(panelRound5, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 20, 90, -1));

        panelRound6.setBackground(new java.awt.Color(179, 207, 229));
        panelRound6.setPreferredSize(new java.awt.Dimension(942, 33));
        panelRound6.setRoundBottomLeft(15);
        panelRound6.setRoundBottomRight(15);
        panelRound6.setRoundTopLeft(15);
        panelRound6.setRoundTopRight(15);
        panelRound6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtBuscarCurso.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(74, 127, 167)));
        txtBuscarCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarCursoActionPerformed(evt);
            }
        });
        panelRound6.add(txtBuscarCurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 820, 20));

        btnBuscarCurso.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBuscarCurso.setText("Buscar");
        btnBuscarCurso.setBorderPainted(false);
        btnBuscarCurso.setContentAreaFilled(false);
        btnBuscarCurso.setFocusPainted(false);
        btnBuscarCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarCursoActionPerformed(evt);
            }
        });
        panelRound6.add(btnBuscarCurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 10, -1, -1));

        panelRound1.add(panelRound6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 970, 40));

        lblTexto1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblTexto1.setForeground(new java.awt.Color(10, 25, 49));
        lblTexto1.setText("Gestión de Cursos");
        panelRound1.add(lblTexto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        lblTexto2.setForeground(new java.awt.Color(74, 127, 167));
        lblTexto2.setText("Administra los cursos académicos");
        panelRound1.add(lblTexto2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        jTableCursos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(179, 207, 229)));
        jTableCursos.setModel(new javax.swing.table.DefaultTableModel(
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
        JTableCursos.setViewportView(jTableCursos);

        panelRound1.add(JTableCursos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 970, 220));

        panelRound7.setBackground(new java.awt.Color(179, 207, 229));
        panelRound7.setPreferredSize(new java.awt.Dimension(90, 35));
        panelRound7.setRoundBottomLeft(15);
        panelRound7.setRoundBottomRight(15);
        panelRound7.setRoundTopLeft(15);
        panelRound7.setRoundTopRight(15);

        btnActualizarCurso1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnActualizarCurso1.setText("Actualizar");
        btnActualizarCurso1.setBorderPainted(false);
        btnActualizarCurso1.setContentAreaFilled(false);
        btnActualizarCurso1.setFocusPainted(false);
        btnActualizarCurso1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarCurso1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound7Layout = new javax.swing.GroupLayout(panelRound7);
        panelRound7.setLayout(panelRound7Layout);
        panelRound7Layout.setHorizontalGroup(
            panelRound7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnActualizarCurso1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRound7Layout.setVerticalGroup(
            panelRound7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnActualizarCurso1)
                .addContainerGap())
        );

        panelRound1.add(panelRound7, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 20, 90, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, 1015, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarCursoActionPerformed
 int fila = jTableCursos.getSelectedRow();
    if (fila == -1) {
        JOptionPane.showMessageDialog(this, "Seleccione un curso para eliminar");
        return;
    }

    // Obtener el nombre del curso desde la tabla
    String nombreCurso = (String) jTableCursos.getValueAt(fila, 1); // Columna 1 = Nombre
    
    // Crear y mostrar el JFrame de eliminación
    EliminarCurso eliminarFrame = new EliminarCurso(nombreCurso);
    eliminarFrame.setVentanaCursos(this); // Pasar referencia a este panel
    eliminarFrame.setVisible(true);
    }//GEN-LAST:event_btnEliminarCursoActionPerformed

    private void btnAgregarCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarCursoActionPerformed
 java.awt.Frame parentFrame = (java.awt.Frame) javax.swing.SwingUtilities.getWindowAncestor(this);
        
        // Crear instancia de AgregarCurso (JFrame)
        AgregarCurso agregarFrame = new AgregarCurso();
        
        // Pasar referencia a este panel Cursos
        agregarFrame.setP1(this); // Usar el método setP1 que ya tienes
        
        // Centrar la ventana respecto al padre
        agregarFrame.setLocationRelativeTo(parentFrame);
        
        // Mostrar la ventana
        agregarFrame.setVisible(true);
                                     
    }//GEN-LAST:event_btnAgregarCursoActionPerformed

    private void btnEditarCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarCursoActionPerformed
    int selectedRow = jTableCursos.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un curso para editar");
            return;
        }
        
        int idCurso = (int) jTableCursos.getValueAt(selectedRow, 0); // Columna 0 = ID
        
        // Obtener el frame padre
        java.awt.Frame parentFrame = (java.awt.Frame) javax.swing.SwingUtilities.getWindowAncestor(this);
        
        // Crear instancia de EditarCurso
        EditarCurso editarFrame = new EditarCurso(idCurso, this);
        editarFrame.setLocationRelativeTo(parentFrame);
        editarFrame.setVisible(true);
    }//GEN-LAST:event_btnEditarCursoActionPerformed

    private void txtBuscarCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarCursoActionPerformed
    }//GEN-LAST:event_txtBuscarCursoActionPerformed

    private void btnBuscarCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarCursoActionPerformed
         String nombreBuscar = txtBuscarCurso.getText().trim();
        if (nombreBuscar.isEmpty()) {
            cargarDatos();
            return;
        }
        try {
            Cursomodel curso = cursoService.getCursoByNombre(nombreBuscar);
            tableModel.setRowCount(0);
            if (curso != null) {
                Object[] row = {
                    curso.getId_curso(),
                    curso.getNombre(),
                    curso.getCodigo(),
                    curso.getSemestre(),
                    curso.getCreditos(),
                    curso.getEstado_curso(),
                    curso.getCatedraticoCod()
                };
                tableModel.addRow(row);
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró el curso: " + nombreBuscar);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al buscar: " + e.getMessage());
        }
    }//GEN-LAST:event_btnBuscarCursoActionPerformed

    private void btnActualizarCurso1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarCurso1ActionPerformed
         cargarDatos();
        txtBuscarCurso.setText("");
        JOptionPane.showMessageDialog(this, "Datos actualizados");
    }//GEN-LAST:event_btnActualizarCurso1ActionPerformed
  private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {                                           
        txtBuscarCurso.setText("");
        cargarDatos();
    }         
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane JTableCursos;
    private javax.swing.JButton btnActualizarCurso1;
    private javax.swing.JButton btnActualizarProfesor;
    private javax.swing.JButton btnActualizarProfesor1;
    private javax.swing.JButton btnAgregarCurso;
    private javax.swing.JButton btnBuscarCurso;
    private javax.swing.JButton btnEditarCurso;
    private javax.swing.JButton btnEliminarCurso;
    private javax.swing.JTable jTableCursos;
    private javax.swing.JLabel lblTexto1;
    private javax.swing.JLabel lblTexto2;
    private com.umg.api.ui.PanelRound panelRound1;
    private com.umg.api.ui.PanelRound panelRound3;
    private com.umg.api.ui.PanelRound panelRound4;
    private com.umg.api.ui.PanelRound panelRound5;
    private com.umg.api.ui.PanelRound panelRound6;
    private com.umg.api.ui.PanelRound panelRound7;
    private javax.swing.JTextField txtBuscarCurso;
    // End of variables declaration//GEN-END:variables
}

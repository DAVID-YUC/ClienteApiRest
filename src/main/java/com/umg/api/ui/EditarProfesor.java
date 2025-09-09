package com.umg.api.ui;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.umg.api.model.Maestromodel;
import com.umg.api.service.MaestroService;
import java.util.List;
import javax.swing.JOptionPane;
import java.time.LocalDate;
public class EditarProfesor extends javax.swing.JFrame {
private String nombreProfesor;
 private MaestroService service;
    
    public EditarProfesor() {
     initComponents();
        this.setLocationRelativeTo(null);
        service = new MaestroService();
    }
    
    public EditarProfesor(String nombre) {
       initComponents();
    this.setLocationRelativeTo(null);
    this.nombreProfesor = nombre;
    this.service = new MaestroService();
    
    // Corregir valores del combo box (una 'n' en "inactivo")
    cboEstado1.setModel(new javax.swing.DefaultComboBoxModel<>(
        new String[] { "activo", "inactivo", "suspendido" }  // ← "inactivo" con una 'n'
    ));
    }
    private void cargarDatosProfesor() {
    try {
        Maestromodel profesor = service.getMaestroByNombre(nombreProfesor); 
        if (profesor != null) {
            // Cargar todos los campos incluyendo nombre y fecha
            txtNombreProfesor1.setText(profesor.getNombre());
            txtApellidoProfesor.setText(profesor.getApellido());
            txtEmailProfesor.setText(profesor.getEmail());
            txtTelefonoProfesor.setText(profesor.getTelefono());
            cboCarrera.setSelectedItem(profesor.getEspecialidad());
            
            // Cargar fecha si existe
            if (profesor.getFecha_ingreso() != null) {
                jDateFechaTrabajo.setDate(java.sql.Date.valueOf(profesor.getFecha_ingreso()));
            }
            
            // Normalizar el estado para el combo box
            String estado = profesor.getEstado();
            if (estado != null) {
                estado = estado.toLowerCase();
                if (estado.equals("activo") || estado.equals("inactivo") || estado.equals("suspendido")) {
                    cboEstado1.setSelectedItem(estado);
                } else {
                    cboEstado1.setSelectedItem("activo");
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "El profesor '" + nombreProfesor + "' no existe.");
            this.dispose();
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al cargar datos: " + e.getMessage());
        this.dispose();
    }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRound2 = new com.umg.api.ui.PanelRound();
        panelRound1 = new com.umg.api.ui.PanelRound();
        btnCancelar = new javax.swing.JButton();
        panelRound3 = new com.umg.api.ui.PanelRound();
        btnGuardar = new javax.swing.JButton();
        lblTexto1 = new javax.swing.JLabel();
        lblTexto2 = new javax.swing.JLabel();
        lblNombreProfesor = new javax.swing.JLabel();
        lblApellidoProfesor = new javax.swing.JLabel();
        txtApellidoProfesor = new javax.swing.JTextField();
        txtEmailProfesor = new javax.swing.JTextField();
        lblEmailProfesor = new javax.swing.JLabel();
        lblSemestre1 = new javax.swing.JLabel();
        txtTelefonoProfesor = new javax.swing.JTextField();
        lblEspecialidad = new javax.swing.JLabel();
        cboCarrera = new javax.swing.JComboBox<>();
        lblEstado1 = new javax.swing.JLabel();
        cboEstado1 = new javax.swing.JComboBox<>();
        txtNombreProfesor1 = new javax.swing.JTextField();
        jDateFechaTrabajo = new com.toedter.calendar.JDateChooser();
        lblFechaNacimientoProfesors = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelRound2.setBackground(new java.awt.Color(255, 255, 255));
        panelRound2.setRoundBottomLeft(25);
        panelRound2.setRoundBottomRight(25);
        panelRound2.setRoundTopLeft(25);
        panelRound2.setRoundTopRight(25);

        panelRound1.setBackground(new java.awt.Color(179, 207, 229));
        panelRound1.setRoundBottomLeft(15);
        panelRound1.setRoundBottomRight(15);
        panelRound1.setRoundTopLeft(15);
        panelRound1.setRoundTopRight(15);

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

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCancelar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCancelar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(btnGuardar)
                .addContainerGap(48, Short.MAX_VALUE))
        );
        panelRound3Layout.setVerticalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnGuardar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblTexto1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTexto1.setForeground(new java.awt.Color(10, 25, 49));
        lblTexto1.setText("Editar Profesor");

        lblTexto2.setForeground(new java.awt.Color(74, 127, 167));
        lblTexto2.setText("Modificar la información del profesor.");

        lblNombreProfesor.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblNombreProfesor.setForeground(new java.awt.Color(10, 25, 49));
        lblNombreProfesor.setText("Nombre *");

        lblApellidoProfesor.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblApellidoProfesor.setForeground(new java.awt.Color(10, 25, 49));
        lblApellidoProfesor.setText("Apellido *");

        txtApellidoProfesor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(74, 127, 167)));
        txtApellidoProfesor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoProfesorActionPerformed(evt);
            }
        });

        txtEmailProfesor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(74, 127, 167)));
        txtEmailProfesor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailProfesorActionPerformed(evt);
            }
        });

        lblEmailProfesor.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblEmailProfesor.setForeground(new java.awt.Color(10, 25, 49));
        lblEmailProfesor.setText("Email *");

        lblSemestre1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblSemestre1.setForeground(new java.awt.Color(10, 25, 49));
        lblSemestre1.setText("Telefono *");

        txtTelefonoProfesor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(74, 127, 167)));
        txtTelefonoProfesor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoProfesorActionPerformed(evt);
            }
        });

        lblEspecialidad.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblEspecialidad.setForeground(new java.awt.Color(10, 25, 49));
        lblEspecialidad.setText("Especialidad *");

        cboCarrera.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ingeniería Informatica", "Ingeniería Civil", "Ingeniería Industrial", "Administración de Empresas", "Contabilidad y Finanzas", "Marketing", "Psicología", "Derecho", "Medicina", "Enfermería", "Arquitectura", "Diseño Grafico" }));
        cboCarrera.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(74, 127, 167)));
        cboCarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboCarreraActionPerformed(evt);
            }
        });

        lblEstado1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblEstado1.setForeground(new java.awt.Color(10, 25, 49));
        lblEstado1.setText("Estado");

        cboEstado1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "activo", "inactivo", "suspendido", " " }));
        cboEstado1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(74, 127, 167)));
        cboEstado1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboEstado1ActionPerformed(evt);
            }
        });

        txtNombreProfesor1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(74, 127, 167)));

        jDateFechaTrabajo.setBackground(new java.awt.Color(255, 255, 255));
        jDateFechaTrabajo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(74, 127, 167)));

        lblFechaNacimientoProfesors.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblFechaNacimientoProfesors.setForeground(new java.awt.Color(10, 25, 49));
        lblFechaNacimientoProfesors.setText("Fecha Inicio Trabajo");

        javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
        panelRound2.setLayout(panelRound2Layout);
        panelRound2Layout.setHorizontalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound2Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelRound3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRound2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(panelRound2Layout.createSequentialGroup()
                                    .addComponent(lblFechaNacimientoProfesors, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jDateFechaTrabajo, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(19, 19, 19))
                                .addGroup(panelRound2Layout.createSequentialGroup()
                                    .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblEspecialidad)
                                        .addComponent(lblTexto1)
                                        .addComponent(lblTexto2)
                                        .addComponent(lblApellidoProfesor)
                                        .addComponent(lblEmailProfesor, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblSemestre1)
                                        .addComponent(lblEstado1)
                                        .addComponent(lblNombreProfesor))
                                    .addGap(118, 118, 118)))
                            .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(cboEstado1, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cboCarrera, javax.swing.GroupLayout.Alignment.LEADING, 0, 312, Short.MAX_VALUE)
                                .addComponent(txtNombreProfesor1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtApellidoProfesor, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtEmailProfesor, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtTelefonoProfesor, javax.swing.GroupLayout.Alignment.LEADING)))))
                .addContainerGap(210, Short.MAX_VALUE))
        );
        panelRound2Layout.setVerticalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblTexto1)
                .addGap(5, 5, 5)
                .addComponent(lblTexto2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblNombreProfesor)
                .addGap(5, 5, 5)
                .addComponent(txtNombreProfesor1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(lblApellidoProfesor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtApellidoProfesor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(lblEmailProfesor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEmailProfesor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSemestre1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTelefonoProfesor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateFechaTrabajo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFechaNacimientoProfesors, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblEspecialidad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblEstado1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboEstado1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelRound3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtEmailProfesorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailProfesorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailProfesorActionPerformed

    private void txtTelefonoProfesorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoProfesorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoProfesorActionPerformed

    private void cboCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboCarreraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboCarreraActionPerformed
  /*  public void setP1(Profesor p1){
    this.pr1 = p1;
    }*/
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
   
    this.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
       try {
        System.out.println("\n=== INICIANDO ACTUALIZACION ===");
        
        // Validar campos obligatorios (agregar nombre)
        if (txtNombreProfesor1.getText().trim().isEmpty() ||
            txtApellidoProfesor.getText().trim().isEmpty() ||
            txtEmailProfesor.getText().trim().isEmpty() ||
            txtTelefonoProfesor.getText().trim().isEmpty()) {
            
            JOptionPane.showMessageDialog(this, "Por favor complete todos los campos obligatorios.");
            return;
        }

        String email = txtEmailProfesor.getText().trim();
        String telefono = txtTelefonoProfesor.getText().trim();

        // Validaciones de email y teléfono (mantener igual)
        if (!email.contains("@") || !email.contains(".")) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese un email válido.");
            return;
        }

        if (!telefono.matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "El teléfono debe contener solo números.");
            return;
        }
        if (telefono.length() < 8) {
            JOptionPane.showMessageDialog(this, "El teléfono debe tener al menos 8 dígitos.");
            return;
        }

        // Verificar que el profesor existe
        Maestromodel profesorExistente = service.getMaestroByNombre(nombreProfesor);
        if (profesorExistente == null) {
            JOptionPane.showMessageDialog(this, "Error: El profesor '" + nombreProfesor + "' no existe");
            this.dispose();
            return;
        }

        // Normalizar el estado
        String estado = (String) cboEstado1.getSelectedItem();
        if (estado != null) {
            estado = estado.toLowerCase().trim();
            if (estado.equals("innactivo")) estado = "inactivo"; // Corregir typo
            if (estado.equals("suspendido")) estado = "suspendido";
            if (estado.equals("activo")) estado = "activo";
            if (estado.isEmpty()) estado = "activo";
        } else {
            estado = "activo";
        }

        // Usar el objeto existente en lugar de crear uno nuevo
        profesorExistente.setNombre(txtNombreProfesor1.getText().trim());
        profesorExistente.setApellido(txtApellidoProfesor.getText().trim());
        profesorExistente.setEmail(email);
        profesorExistente.setTelefono(telefono);
        profesorExistente.setEspecialidad((String) cboCarrera.getSelectedItem());
        profesorExistente.setEstado(estado);
        
        // Agregar fecha si está seleccionada
        if (jDateFechaTrabajo.getDate() != null) {
            profesorExistente.setFecha_ingreso(jDateFechaTrabajo.getDate().toInstant()
                .atZone(java.time.ZoneId.systemDefault())
                .toLocalDate());
        }

        // Debug
        System.out.println("Datos a actualizar:");
        System.out.println("Nombre: " + profesorExistente.getNombre());
        System.out.println("Apellido: " + profesorExistente.getApellido());
        System.out.println("Email: " + profesorExistente.getEmail());
        System.out.println("Telefono: " + profesorExistente.getTelefono());
        System.out.println("Especialidad: " + profesorExistente.getEspecialidad());
        System.out.println("Estado: " + profesorExistente.getEstado());
        System.out.println("Fecha Ingreso: " + profesorExistente.getFecha_ingreso());

        // Intentar la actualización
        String resultado = service.updateMaestroByNombre(nombreProfesor, profesorExistente);
        
        JOptionPane.showMessageDialog(this, "Profesor actualizado correctamente: " + resultado);
        this.dispose();
        
    } catch (Exception e) {
        System.err.println("Error completo en actualización:");
        e.printStackTrace();
        
        String mensajeError = "Error al actualizar: ";
        if (e.getMessage().contains("404")) {
            mensajeError += "Profesor no encontrado en el servidor";
        } else if (e.getMessage().contains("500")) {
            mensajeError += "Error interno del servidor. Verifique los datos ingresados";
        } else {
            mensajeError += e.getMessage();
        }
        
        JOptionPane.showMessageDialog(this, mensajeError);
    }      
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void cboEstado1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboEstado1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboEstado1ActionPerformed

    private void txtApellidoProfesorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoProfesorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoProfesorActionPerformed

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
            java.util.logging.Logger.getLogger(EditarProfesor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarProfesor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarProfesor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarProfesor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditarProfesor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cboCarrera;
    private javax.swing.JComboBox<String> cboEstado1;
    private com.toedter.calendar.JDateChooser jDateFechaTrabajo;
    private javax.swing.JLabel lblApellidoProfesor;
    private javax.swing.JLabel lblEmailProfesor;
    private javax.swing.JLabel lblEspecialidad;
    private javax.swing.JLabel lblEstado1;
    private javax.swing.JLabel lblFechaNacimientoProfesors;
    private javax.swing.JLabel lblNombreProfesor;
    private javax.swing.JLabel lblSemestre1;
    private javax.swing.JLabel lblTexto1;
    private javax.swing.JLabel lblTexto2;
    private com.umg.api.ui.PanelRound panelRound1;
    private com.umg.api.ui.PanelRound panelRound2;
    private com.umg.api.ui.PanelRound panelRound3;
    private javax.swing.JTextField txtApellidoProfesor;
    private javax.swing.JTextField txtEmailProfesor;
    private javax.swing.JTextField txtNombreProfesor1;
    private javax.swing.JTextField txtTelefonoProfesor;
    // End of variables declaration//GEN-END:variables
}

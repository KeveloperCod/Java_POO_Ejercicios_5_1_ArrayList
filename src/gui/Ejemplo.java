package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import arreglo.ArregloAlumno;
import clase.Alumno;

public class Ejemplo extends JFrame {
    private JPanel contentPane;
    private JTable tblTabla;
    private DefaultTableModel modelo;
    private JButton btnListar;
    private JButton btnReportar;
    private JButton btnLimpiar;
    private JLabel lblReporte;


    private ArregloAlumno aa = new ArregloAlumno();

    public Ejemplo() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 750, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);


        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 50, 700, 250);
        contentPane.add(scrollPane);

        tblTabla = new JTable();
        modelo = new DefaultTableModel();
        modelo.addColumn("Código");
        modelo.addColumn("Nombre");
        modelo.addColumn("Nota 1");
        modelo.addColumn("Nota 2");
        modelo.addColumn("Promedio");
        tblTabla.setModel(modelo);
        scrollPane.setViewportView(tblTabla);

   
        btnListar = new JButton("Listar");
        btnListar.setBounds(10, 320, 100, 30);
        btnListar.addActionListener(e -> listarAlumnos());
        contentPane.add(btnListar);


        btnReportar = new JButton("Reportar");
        btnReportar.setBounds(120, 320, 100, 30);
        btnReportar.addActionListener(e -> mostrarReporte());
        contentPane.add(btnReportar);

 
        btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setBounds(230, 320, 100, 30);
        btnLimpiar.addActionListener(e -> limpiarTablaYReporte());
        contentPane.add(btnLimpiar);


        lblReporte = new JLabel("Reporte:");
        lblReporte.setBounds(10, 360, 700, 30);
        contentPane.add(lblReporte);

    
        cargarDatosEjemplo();
    }


    private void cargarDatosEjemplo() {
        aa.adicionar(new Alumno(101, 15, 18, "Juan"));
        aa.adicionar(new Alumno(102, 12, 14, "Ana"));
        aa.adicionar(new Alumno(103, 17, 19, "Luis"));
        aa.adicionar(new Alumno(104, 10, 13, "Maria"));
    }

    
    private void listarAlumnos() {
        modelo.setRowCount(0); 
        for (int i = 0; i < aa.tamanio(); i++) {
            Alumno alumno = aa.obtener(i);
            Object[] fila = {
                alumno.getCodigo(),
                alumno.getNombre(),
                alumno.getNota1(),
                alumno.getNota2(),
                alumno.promedio() 
            };
            modelo.addRow(fila);
        }
    }


    private void mostrarReporte() {
        int totalAlumnos = aa.tamanio();
        double sumaPromedios = 0;

        for (int i = 0; i < totalAlumnos; i++) {
            Alumno alumno = aa.obtener(i);
            sumaPromedios += alumno.promedio();
        }

        double promedioGeneral = totalAlumnos > 0 ? sumaPromedios / totalAlumnos : 0;
        lblReporte.setText(String.format("Reporte: Promedio General = %.2f", promedioGeneral));
    }

 
    private void limpiarTablaYReporte() {
        modelo.setRowCount(0); 
        lblReporte.setText("Reporte:");
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Ejemplo frame = new Ejemplo();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;
import dao.ProductoDao;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.Producto;
/**
 *
 * @author LN710Q
 */
public class Consulta extends JFrame{
    public JLabel lblCodigo, lblTipo, lblCantidad, lblDisponibilidad,lblNombre,lblPrecio;
    public JTextField codigo, cantidad,nombre,precio;
    public JComboBox tipo;
    
    ButtonGroup disponibilidad = new ButtonGroup();
    public JRadioButton no;
    public JRadioButton si;
    public JTable resultados;
    public JPanel table;
    public JButton buscar,eliminar,insertar,limpiar,actualizar;
    private static final int ANCHOC = 130, ALTOC = 30;
    DefaultTableModel tm;
    
    public Consulta(){
        super("Productos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        agregarLabels();
        formulario();
        llenarTabla();
        Container container = getContentPane();
        container.add(lblCodigo);
        container.add(lblTipo);
        container.add(lblDisponibilidad);
        container.add(lblCantidad);
        container.add(lblNombre);
        container.add(lblPrecio);
        container.add(codigo);
        container.add(nombre);
        container.add(precio);
        container.add(tipo);
        container.add(cantidad);
        container.add(si);
        container.add(no);
        container.add(buscar);
        container.add(insertar);
        container.add(actualizar);
        container.add(eliminar);
        container.add(limpiar);
        container.add(table);
        setSize(1000,600);
        eventos();
    }

    private void agregarLabels() {
        lblCodigo = new JLabel("Codigo");
        lblTipo = new JLabel("Cantidad");
        lblCantidad = new JLabel("Tipo");
        lblDisponibilidad = new JLabel("Disponibilidad");
        lblNombre = new JLabel("Nombre");
        lblPrecio = new JLabel("Precio");
        lblCodigo.setBounds(10,10,ANCHOC,ALTOC);
        lblPrecio.setBounds(10,60,ANCHOC,ALTOC);
        lblNombre.setBounds(10,100,ANCHOC,ALTOC);
        lblCantidad.setBounds(10,140,ANCHOC,ALTOC);
        lblTipo.setBounds(10,180,ANCHOC,ALTOC);
        lblDisponibilidad.setBounds(10,220,ANCHOC,ALTOC);
        
        
    }

    private void formulario() {
        
        codigo = new JTextField();
        cantidad = new JTextField();
        nombre = new JTextField();
        precio = new JTextField();
        tipo = new JComboBox();
        si = new JRadioButton("si",true);
        no = new JRadioButton("no");
        resultados = new JTable();
        buscar = new JButton("Buscar");
        insertar = new JButton("Insertar");
        eliminar = new JButton("Eliminar");
        actualizar = new JButton("Actualizar");
        limpiar = new JButton("Limpiar");
        table = new JPanel();
        
        tipo.addItem("Fruta");
        tipo.addItem("Verdura");
        tipo.addItem("Bebida");
        tipo.addItem("Dulce");
        
        disponibilidad = new ButtonGroup();
        disponibilidad.add(si);
        disponibilidad.add(no);
        
        codigo.setBounds(140,10,ANCHOC,ALTOC);
        precio.setBounds(140,60,ANCHOC,ALTOC);
        nombre.setBounds(140,100,ANCHOC,ALTOC);
        tipo.setBounds(140,140,ANCHOC,ALTOC);
        cantidad.setBounds(140,180,ANCHOC,ALTOC);
        si.setBounds(140,220,50,ALTOC);
        no.setBounds(210,220,50,ALTOC);
        
        buscar.setBounds(440,10,ANCHOC,ALTOC);
        insertar.setBounds(280,210,ANCHOC,ALTOC);
        actualizar.setBounds(420,210,ANCHOC,ALTOC);
        eliminar.setBounds(570,210,ANCHOC,ALTOC);
        limpiar.setBounds(720,210,ANCHOC,ALTOC);
        resultados = new JTable();
        table.setBounds(10,250,500,200);
        table.add(new JScrollPane(resultados));
        
        
    }

    private void llenarTabla() {
        tm = new DefaultTableModel(){
            public Class<?> getColumnCLass(int column){
                switch (column){
                    case 0:
                        return String.class;
                    case 1:
                        return String.class;
                    case 2:
                        return String.class;
                    default:
                        return Boolean.class;
                }
                    
            }
        };
        tm.addColumn("Codigo");
        tm.addColumn("Nombre");
        tm.addColumn("Tipo");
        tm.addColumn("Disponibilidad");
        tm.addColumn("Precio");
        tm.addColumn("Cantidad");
        
        ProductoDao pd = new ProductoDao();
        ArrayList<Producto> productos= pd.readAll();
        
        for(Producto pi: productos){
            tm.addRow(new Object[]{pi.getCodigo(),pi.getNombre(),pi.getTipo(),pi.getDisponibilidad(),pi.getPrecio(),pi.getCantidad()});
        }
        resultados.setModel(tm);
    }

    private void eventos() {
        insertar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                ProductoDao pd = new ProductoDao();
                Producto p = new Producto(nombre.getText(),codigo.getText(),tipo.getSelectedItem().toString(),Integer.parseInt(cantidad.getText()), Double.parseDouble(precio.getText()),true);
                
                if (no.isSelected()){
                    p.setDisponibilidad(false);
                }
                
                if (pd.create(p)){
                    JOptionPane.showMessageDialog(null, "Producto registrado con exito");
                    limpiarCampos();
                    llenarTabla();
                }else{
                    JOptionPane.showMessageDialog(null, "Ocurrio un problema al momento de crear el producto");
                }
            }

            
        });
        
        actualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                ProductoDao pd = new ProductoDao();
                Producto p = new Producto(nombre.getText(),codigo.getText(),tipo.getSelectedItem().toString(),Integer.parseInt(cantidad.getText()), Double.parseDouble(precio.getText()),true);
                
                if(no.isSelected()){
                    p.setDisponibilidad(false);
                }
                
                if(pd.update(p)){
                    JOptionPane.showMessageDialog(null, "Producto Modificado con exito");
                    limpiarCampos();
                    llenarTabla();
                } else{
                    JOptionPane.showMessageDialog(null, "Ocuerrio un problema al momento de modificar el producto");
                }
            }
        });
        
        eliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                ProductoDao pd = new ProductoDao();
                if (pd.delete(codigo.getText())){
                    JOptionPane.showMessageDialog(null, "Producto eliminado con exito");
                    limpiarCampos();
                    llenarTabla();
                } else{
                    JOptionPane.showMessageDialog(null, "Ocurrio un problema al momento de eliminar el producto");
                }
            }
        });
        
        buscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProductoDao pd = new ProductoDao();
                Producto p = pd.read(codigo.getText());
                if(p == null){
                    JOptionPane.showMessageDialog(null, "El producto buscado no se ha encontrado");
                } else{
                    codigo.setText(p.getCodigo());
                    nombre.setText(p.getNombre());
                    tipo.setSelectedItem(p.getTipo());
                    cantidad.setText(Integer.toString(p.getCantidad()));
                    precio.setText(Double.toString(p.getPrecio()));
                    
                    if (p.getDisponibilidad()){
                        si.setSelected(true);
                    } else{
                        no.setSelected(true);
                    }
                }
            }
        });
        
        limpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                limpiarCampos();
            }
        });
        
    }
    
    private void limpiarCampos() {
        codigo.setText("");
        tipo.setSelectedItem("Fruta");
        cantidad.setText("");
        nombre.setText("");
        precio.setText("");
    }
    
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Consulta().setVisible(true);
            }
        });
    }
    
}

package persistencia;

import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.*;
import persistencia.exceptions.NonexistentEntityException;

public class ControladorPersistencia {
    
    CineJpaController cine = new CineJpaController();
    ClienteJpaController clienteJpa = new ClienteJpaController();
    ClienteVipJpaController clienteVipJpa = new ClienteVipJpaController();
    CompraJpaController compra = new CompraJpaController();
    EmpleadoJpaController empleadoJpa = new EmpleadoJpaController();
    EntradaJpaController entradaJpa = new EntradaJpaController();
    FuncionJpaController funcionJpa = new FuncionJpaController();
    InsumoJpaController insumo = new InsumoJpaController();
    PagoJpaController pago = new PagoJpaController();
    PeliculaJpaController peliculaJpa = new PeliculaJpaController();
    ProveedorJpaController proveedor = new ProveedorJpaController();
    SalaJpaController salaJpa = new SalaJpaController();
    SalaVipJpaController salaVip = new SalaVipJpaController();
    VentaJpaController ventaJpa = new VentaJpaController();
    
    //Metodos para cliente
    public void guardarCliente(Cliente cliente){
        
        clienteJpa.create(cliente);
        
    }
    
    public List<Cliente> obtenerTodosLosClientes() {
        
        try {

            return clienteJpa.findClienteEntities();

        } catch (Exception e) {

            System.out.println("Error al obtener los clientes: " + e.getMessage());
            return null;

        }
    }
    
    public Cliente buscarCliente(int id){
        
        try{
            Cliente cliente = clienteJpa.findCliente(id);
            
            if(cliente != null){
                return cliente;
            }else{
                JOptionPane.showMessageDialog(null, "El cliente no existe...");
                return null;
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "El cliente no existe...");
            return null;
        }
    }
    
    public void eliminarCliente(Cliente cliente){
        
        try{
           clienteJpa.destroy(cliente.getId());
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Empleado borrado con exito.");
        }
    }
    
    //Metodos para ClienteVip
    
    public void guardarCliente(ClienteVip cliente){
        
        try{
            clienteVipJpa.create(cliente);
            JOptionPane.showMessageDialog(null, "Cliente guardado con exito");
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al guardar el nuevo cliente.");
        }
    }
    
    //Metodos de Empleado
    public void guardarEmpleado(Empleado empleado) {

        try {

            empleadoJpa.create(empleado);
            JOptionPane.showMessageDialog(null, "Empleado guardado exitosamente.");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al guardar en la base de datos..." + e);
        }

    }
    
    public List<Empleado> obtenerTodosLosEmpleados() {
        
        try {

            return empleadoJpa.findEmpleadoEntities();

        } catch (Exception e) {

            System.out.println("Error al obtener los empleados: " + e.getMessage());
            return null;

        }
    }
    
    public Empleado buscarEmpleado(int id){
        
        try{
            Empleado empleado = empleadoJpa.findEmpleado(id);
            
            if(empleado != null){
                return empleado;
            }else{
                JOptionPane.showMessageDialog(null, "El usuario no existe...");
                return null;
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "El usuario no existe...");
            return null;
        }
        
    }
    
    public void eliminarEmpleado(Empleado empleado){
        
        try{
           empleadoJpa.destroy(empleado.getId());
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Empleado borrado con exito.");
        }
    }
    
    //Metodos para entrada
    public Entrada buscarEntrada(int id) {

        try {
            return entradaJpa.findEntrada(id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se encontro la entrada.");
            return null;
        }
    }

    public void venderEntrada(int id) {

        Entrada entrada = Entrada.buscarEntrada(id);

        try {
            entradaJpa.actualizarEntrada(id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al vender la entrada.");
        }
    }
    
    //Metodos para Funcion
     public void guardarFuncion(Funcion funcion) {
        
        try {
            funcionJpa.create(funcion);
            JOptionPane.showMessageDialog(null, "Funcion guardada con exito");
        } catch (Exception e) {
            System.out.println("Error al guardar la funcion " + e);
        }
    }
    
    public Funcion buscarFuncion(int id){
        
        try{
            return funcionJpa.findFuncion(id);
            
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Erro al encontrar la funcion.");
            return null;
        }
    }

    public List<Funcion> obtenerTodasLasFunciones() {

        try {
            
            return funcionJpa.findFuncionEntities();

        } catch (Exception e) {

            System.out.println("Error al obtener los clientes: " + e.getMessage());
            return null;

        }
    }
    
    public void eliminarFuncion(int id){
        
        try{
            funcionJpa.destroy(id);
        } catch (NonexistentEntityException ex){
            JOptionPane.showMessageDialog(null, "La funcion no se encontro la funcion con id: " + id);
            Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean validarHorario(Date horario, int numeroSala) {

        Funcion funcionEncontrada = funcionJpa.coincidenciaSalaHorario(horario, numeroSala);
        if (funcionEncontrada != null) {
            return true;
        } else {
            return false;
        }
    }
    
    //Metodos para pelicula
     public void guardarPelicula(Pelicula pelicula) {

        try {

            peliculaJpa.create(pelicula);
            JOptionPane.showMessageDialog(null, "Pelicula guardada con exito");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al guardar la nuevo pelicula.");
        }
    }

    public List<Pelicula> obtenerTodasLasPeliculas() {

        try {

            return peliculaJpa.findPeliculaEntities();

        } catch (Exception e) {

            System.out.println("Error al obtener los clientes: " + e.getMessage());
            return null;

        }
    }

    public void borrarPelicula(Pelicula pelicula) throws NonexistentEntityException {

        int idPelicula = pelicula.getIdPelicula();

        try {
            peliculaJpa.destroy(pelicula.getIdPelicula());
        } catch (NumberFormatException e) {
            System.out.println("error al destruir el objeto" + e);
        }
    }
    
    public Pelicula buscarPelicula(int id) {

        try {
            Pelicula pelicula = peliculaJpa.findPelicula(id);

            if (pelicula != null) {
                return pelicula;
            } else {
                JOptionPane.showMessageDialog(null, "La pelicula no existe...");
                return null;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al buscar la pelicula...");
            return null;
        }
    }

    public Pelicula buscarPelicula(String titulo) {

        try {
            Pelicula pelicula = peliculaJpa.buscarPelicula(titulo);

            if (pelicula != null) {
                return pelicula;
            } else {
                JOptionPane.showMessageDialog(null, "La pelicula no existe...");
                return null;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al buscar la pelicula...");
            return null;
        }
    }
    
    //Metodo para salas
    public List<Sala> obtenerTodasLasSalas() {

        try {

            return salaJpa.findSalaEntities();

        } catch (Exception e) {

            System.out.println("Error al obtener los clientes: " + e.getMessage());
            return null;

        }
    }

    public Sala buscarSala(int numeroSala) {
        
        try {
            return salaJpa.findSala(numeroSala);
        } catch (Exception e){
            System.out.println("No se pudo encontrar la sala" + e);
            return null;
        }
    }
    
    //Metodos para ventas
     public void guardarVenta(Venta venta){
        
        try{
            ventaJpa.create(venta);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al guardar la venta");
        }
    }
    
    public Venta buscarVenta(int id){
        
        try{
            return ventaJpa.findVenta(id);
        } catch (Exception e){
            System.out.println("Error de carga: " + e);
            JOptionPane.showMessageDialog(null, "Error al cargar los datos de la venta");
            return null;
        }
    }
    
    public List<Venta> cargarVentas(){
        
        try{
            return ventaJpa.findVentaEntities();
        } catch (Exception e){
            System.out.println("Error de carga: " + e);
            JOptionPane.showMessageDialog(null, "Error al cargar los datos de las ventas");
            return null;
        }
    }
    
    public void eliminarVenta(int id){
        
        try{
            ventaJpa.destroy(id);
        } catch (Exception e){
            System.out.println("Error al eliminar la venta: " + e);
            JOptionPane.showMessageDialog(null, "Error al eliminar los datos de la venta");
        }
    }
    
}

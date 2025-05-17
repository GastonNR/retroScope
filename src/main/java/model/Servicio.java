package model;

import java.util.Date;
import java.util.List;
import persistencia.ControladorPersistencia;
import persistencia.exceptions.NonexistentEntityException;

public class Servicio {

    ControladorPersistencia ctr_persis = new ControladorPersistencia();

    //Metodos para cliente
    public void crearCliente(Cliente cliente) {
        ctr_persis.guardarCliente(cliente);
    }

    public List<Cliente> todosClientes() {
        return ctr_persis.obtenerTodosLosClientes();
    }

    public Cliente buscarCliente(int id) {
        return ctr_persis.buscarCliente(id);
    }

    public void borrarCliente(Cliente cliente) {
        ctr_persis.eliminarCliente(cliente);
    }

    //Metodos para ClienteVip
    public void guardarCliente(ClienteVip cliente) {
        ctr_persis.guardarCliente(cliente);
    }

    //Metodos de Empleado
    public void guardarEmpleado(Empleado empleado) {

        ctr_persis.guardarEmpleado(empleado);

    }

    public List<Empleado> obtenerTodosLosEmpleados() {
        return ctr_persis.obtenerTodosLosEmpleados();

    }

    public Empleado buscarEmpleado(int id) {

        return ctr_persis.buscarEmpleado(id);

    }

    public void eliminarEmpleado(Empleado empleado) {

        ctr_persis.eliminarEmpleado(empleado);

    }

    //Metodos para entrada
    public Entrada buscarEntrada(int id) {

        return ctr_persis.buscarEntrada(id);

    }

    public void venderEntrada(int id) {

        ctr_persis.venderEntrada(id);
    }

    //Metodos para Funcion
    public void guardarFuncion(Funcion funcion) {

        ctr_persis.guardarFuncion(funcion);

    }

    public Funcion buscarFuncion(int id) {

        return ctr_persis.buscarFuncion(id);

    }

    public List<Funcion> obtenerTodasLasFunciones() {

        return ctr_persis.obtenerTodasLasFunciones();

    }

    public void eliminarFuncion(int id) {

        ctr_persis.eliminarFuncion(id);

    }

    public boolean validarHorario(Date horario, int numeroSala) {

        return ctr_persis.validarHorario(horario, numeroSala);

    }

    //Metodos para pelicula
    public void guardarPelicula(Pelicula pelicula) {

        ctr_persis.guardarPelicula(pelicula);

    }

    public List<Pelicula> obtenerTodasLasPeliculas() {

        return ctr_persis.obtenerTodasLasPeliculas();

    }

    public void borrarPelicula(Pelicula pelicula) throws NonexistentEntityException {

        ctr_persis.borrarPelicula(pelicula);

    }

    public Pelicula buscarPelicula(int id) {
        return ctr_persis.buscarPelicula(id);

    }

    public Pelicula buscarPelicula(String titulo) {

        return ctr_persis.buscarPelicula(titulo);

    }

    //Metodo para salas
    public List<Sala> obtenerTodasLasSalas() {

        return ctr_persis.obtenerTodasLasSalas();

    }

    public Sala buscarSala(int numeroSala) {

        return ctr_persis.buscarSala(numeroSala);

    }

    //Metodos para ventas
    public void guardarVenta(Venta venta) {
        ctr_persis.guardarVenta(venta);

    }

    public Venta buscarVenta(int id) {

        return ctr_persis.buscarVenta(id);

    }

    public List<Venta> cargarVentas() {

        return ctr_persis.cargarVentas();

    }

    public void eliminarVenta(int id) {

        ctr_persis.eliminarVenta(id);

    }
}

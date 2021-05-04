package com.emergentes.controlador;

import com.emergentes.ConexionDB;
import com.emergentes.modelo.Libro;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String op;
        op = (request.getParameter("op") !=  null) ? request.getParameter("op") : "list";
        ArrayList<Libro> lista = new ArrayList<Libro>();
        ConexionDB canal = new ConexionDB();
        Connection conn = canal.conectar();
        PreparedStatement ps;
        ResultSet rs;
        if (op.equals("list")) {
            try{
                
                String sql = "SELECT * FROM tareas";
                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();
                
                while (rs.next()) {
                    Libro lib = new Libro();
                    lib.setId(rs.getInt("id"));
                    lib.setTarea(rs.getString("tarea"));
                    lib.setPrioridad(rs.getInt("prioridad"));
                    lib.setCompletado(rs.getInt("completado"));
                    lista.add(lib);
                }
                
                request.setAttribute("lista", lista);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } catch(SQLException ex){
                System.out.println("Error en SQL: " + ex.getMessage());
            } finally{
                canal.desconectar();
            }
            
        }
        if (op.equals("nuevo")) {
            Libro l = new Libro();
            request.setAttribute("libro", l);
            request.getRequestDispatcher("editar.jsp").forward(request, response);
        }
        if (op.equals("eliminar")) {
            int id = Integer.parseInt(request.getParameter("id"));
            try{
                String sql = "delete from tareas where id = ?";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, id);
                ps.executeUpdate();
            } catch(SQLException ex){
                System.out.println("Error en SQL: " + ex.getMessage());
            }finally{
                canal.desconectar();
            }
            response.sendRedirect("MainController");
        }
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String tarea = request.getParameter("tarea");
        int prioridad = Integer.parseInt(request.getParameter("prioridad"));
        int completado = Integer.parseInt(request.getParameter("completado"));
        
        Libro l = new Libro();
        
        l.setId(id);
        l.setTarea(tarea); 
        l.setPrioridad(prioridad);
        l.setCompletado(completado);
        
        ConexionDB canal = new ConexionDB();
        Connection conn = canal.conectar();
        PreparedStatement ps;
        ResultSet rs;
        if (id == 0) {
            try{
                String sql = "insert into tareas (tarea, prioridad, completado) value (?, ?, ?)";
                ps = conn.prepareStatement(sql);
                ps.setString(1, l.getTarea());
                ps.setInt(2, l.getPrioridad());
                ps.setInt(3, l.getCompletado());
                
                ps.executeUpdate();
            } catch(SQLException ex){
                System.out.println("Error en SQL: " + ex.getMessage());
            } finally{
                canal.desconectar();
            }
        }
        response.sendRedirect("MainController");
    }
}

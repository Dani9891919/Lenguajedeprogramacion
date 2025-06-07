package com.cibertec.sp4691.servlet;

import com.cibertec.sp4691.dao.GeneroDAO;
import com.cibertec.sp4691.dao.PeliculaDAO;
import com.cibertec.sp4691.model.Genero;
import com.cibertec.sp4691.model.Pelicula;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/peliculas") // Mapea este servlet a la URL /peliculas
public class PeliculaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private PeliculaDAO peliculaDAO;
    private GeneroDAO generoDAO;
    private SimpleDateFormat sdf;

    public void init() {
        peliculaDAO = new PeliculaDAO();
        generoDAO = new GeneroDAO();
        sdf = new SimpleDateFormat("yyyy-MM-dd"); // Formato para las fechas
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "listar"; // Acción por defecto
        }

        try {
            switch (action) {
                case "new":
                    mostrarFormularioNuevo(request, response);
                    break;
                case "insert":
                    insertarPelicula(request, response);
                    break;
                case "delete":
                    eliminarPelicula(request, response);
                    break;
                case "edit":
                    mostrarFormularioEditar(request, response);
                    break;
                case "update":
                    actualizarPelicula(request, response);
                    break;
                case "listar":
                default:
                    listarPeliculas(request, response);
                    break;
            }
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }

	private void listarPeliculas(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void actualizarPelicula(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void mostrarFormularioEditar(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void eliminarPelicula(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void insertarPelicula(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void mostrarFormularioNuevo(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}
};
package com.servlets.parking;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.epam.fileio.FileOperation;
import org.epam.parking.ParkingSpace;

/**
 * Servlet implementation class ReadOperations
 */
@WebServlet("/ReadOperations")
public class ReadOperations extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ParkingSpace parkingSpace = (ParkingSpace)req.getSession().getAttribute("parkingSpace");
		FileOperation read = new FileOperation();
		read.ReadFromFile(parkingSpace);
	}
}

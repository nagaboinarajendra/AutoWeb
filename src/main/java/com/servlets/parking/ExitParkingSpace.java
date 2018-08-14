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
 * Servlet implementation class ExitParkingSpace
 */
@WebServlet("/ExitParkingSpace")
public class ExitParkingSpace extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ParkingSpace parkingSpace = (ParkingSpace) req.getSession().getAttribute("parkingSpace");
		FileOperation write = new FileOperation();
		write.writeToFile(parkingSpace.queue);
		req.getRequestDispatcher("Login.html").forward(req, res);
	}

}

package com.servlets.parking;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.epam.parking.ParkingSpace;
import org.epam.service.ParkVehicle;
/**
 * parks the vehicle into parking space.
 */
@WebServlet("/park")
public class ParkServlet extends HttpServlet{
    
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String carNumber = req.getParameter("carnumber");
		ParkingSpace parkingSpace = (ParkingSpace) req.getSession().getAttribute("parkingSpace");
		ParkVehicle park = new ParkVehicle();
		boolean isParked = park.parkCar(carNumber,parkingSpace);
		req.setAttribute("isParked", isParked);
		req.getRequestDispatcher("Menu.html").forward(req, res);
	}
	
}

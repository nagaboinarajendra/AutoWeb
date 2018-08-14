package com.servlets.parking;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.epam.parking.ParkingSpace;
import org.epam.service.UnParkVehicle;
/**
 * unparks the vehicle.
 */
@WebServlet("/unpark")
public class UnParkServlet extends HttpServlet{
	
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String carNumber = req.getParameter("carnumber");
		ParkingSpace parkingSpace = (ParkingSpace) req.getSession().getAttribute("parkingSpace");
		UnParkVehicle unPark = new UnParkVehicle();
		unPark.unParkCar(carNumber,parkingSpace);
		req.getRequestDispatcher("Menu.html").forward(req, res);
	}
}

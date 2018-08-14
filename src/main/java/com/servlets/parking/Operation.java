package com.servlets.parking;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.epam.parking.ParkingSpace;
import org.epam.service.ParkVehicle;
import org.epam.service.UnParkVehicle;

/**
 * Servlet implementation class Operation
 */
@WebServlet("/operation")
public class Operation extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	    res.setContentType("html");
	    String choice = req.getParameter("choice");
	    String carNumber = req.getParameter("carNumber");
	    ParkVehicle park = new ParkVehicle();
	    UnParkVehicle unpark = new UnParkVehicle();
	    boolean isOperationDone = false;
	    String message="";
	    ParkingSpace parkingSpace = (ParkingSpace) req.getSession().getAttribute("parkigSpace");
         if(choice.equals("parkVehicle")) {
             isOperationDone =  park.parkCar(carNumber, parkingSpace);
         } else if(choice.equals("unparkVehicle")) {
        	 isOperationDone = unpark.unParkCar(carNumber, parkingSpace);
         }
         if(isOperationDone) {
        	 message = "success";
         } else {
        	message = "failure"; 
         }
	    req.setAttribute("message", message);
        req.getRequestDispatcher("/Menu.jsp").forward(req, res);
	}

}


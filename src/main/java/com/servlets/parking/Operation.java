package com.servlets.parking;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("html");
	    String choice = request.getParameter("option");
	    String carNumber = request.getParameter("registration");
	    ParkVehicle park = new ParkVehicle();
	    UnParkVehicle unpark = new UnParkVehicle();
	    boolean isOperationDone = false;
	    ParkingSpace parkingSpace = (ParkingSpace) request.getSession().getServletContext().getAttribute("parkingSpace");
         if(choice.equals("park")) {
             isOperationDone =  park.parkCar(carNumber, parkingSpace);
             if(isOperationDone) {
            	 request.setAttribute("message", "parked SuccessFully");
             } else {
            	 request.setAttribute("message", "Error while parking");
             }
         } else if(choice.equals("unpark")) {
        	 isOperationDone = unpark.unParkCar(carNumber, parkingSpace);
        	 if(isOperationDone) {
            	 request.setAttribute("message", "unparked SuccessFully");

             } else {
            	 request.setAttribute("message", "error while unparking");
             }
         }
         
         //out.println(message);
	    //req.setAttribute("message", message);
	}

}


package com.servlets.parking;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.epam.parking.InTime;
import org.epam.parking.ParkingSpace;
import org.epam.parking.Slot;
import org.epam.vehicle.Car;

import com.parking.db.DBConnection;
/**
 * provides facitities to user.
 * @author rajendra
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	/**
	 * 
	 */
    static DBConnection conn = new DBConnection();

	private static final long serialVersionUID = 1L;
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		boolean isAdminValid = false;
		System.out.println(request.getParameter("hiddenField"));
		PrintWriter out = response.getWriter();
		String username = request.getParameter("uname");
		String password = request.getParameter("psw");
		try {
		isAdminValid = conn.validateAdmin(username ,password);
		} catch (Exception message2) {
		    out.println(message2);
		}
		if (isAdminValid) {
			request.getSession(true);
			ParkingSpace parkingSpace = new ParkingSpace(50);
			intitializeSlots(parkingSpace);
			request.getSession().setAttribute("parkingSpace", parkingSpace);
			request.getSession().setAttribute("username", username);
			request.getSession().getServletContext().setAttribute("parkingSpace", parkingSpace);
			response.sendRedirect("home.jsp");
	      }else {
	    	  request.setAttribute("message","Invalid Username or password");
	    	  request.getRequestDispatcher("index.jsp").forward(request,response);
	      

		}
	}
	/**
     * @param parkingSpace of parking area.
     * @throws IOException occurs when file not found.
     */
    private static void intitializeSlots(ParkingSpace parkingSpace) throws
    IOException {
        Slot.car = new Car[parkingSpace.getTotalSlots() + 1];
        Slot.intime = new InTime[parkingSpace.getTotalSlots() + 1];
        //FileOperation fo = new FileOperation();
        //fo.ReadFromFile(parkingSpace);
        try {
			conn.readOldTransactions(parkingSpace);
		} catch (SQLException e) {
			e.printStackTrace();
		}
        
    }
}

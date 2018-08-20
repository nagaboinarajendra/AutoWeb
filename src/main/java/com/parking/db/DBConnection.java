package com.parking.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.epam.exceptions.InvalidAdminException;
import org.epam.parking.ParkingSpace;
import org.epam.parking.Slot;
 
public class DBConnection {
    public Connection conn = null;
    /**
     * establishes database connection.
     * @return connection variable
     */
    public Connection getConnection() {
    	String databaseURL = "jdbc:mysql://localhost:3306/AutoParking";
        String user = "root";
        String password = "root";
        try {
        	Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(databaseURL, user, password);

            if (conn != null) {
            	return conn;
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
        }
        return null;
    }
    
    
    public boolean validateAdmin(String username, String password)
            throws InvalidAdminException, SQLException {
    	getConnection();
    	Statement st = conn.createStatement();
    	String sql = ("SELECT * FROM admin_parker");
    	ResultSet rs = st.executeQuery(sql);
    	 boolean isAdminValid = false;
    	while(rs.next()) {
    	String adminUserName = rs.getString("admin_parker_username");
    	String adminPassword = rs.getString("admin_parker_password");
        if (username.equals(adminUserName) && password.equals(adminPassword)) {
            isAdminValid = true;
        } else {
            throw new InvalidAdminException("admin credentials are incorrect");
        }
    	}
        return isAdminValid;
    }
    
    public void insertIntoDB(Slot slot) throws SQLException {
    	String carnumber = Slot.car[slot.getSlotNumber()].getCarNumber();
    	int slotnumber = slot.getSlotNumber();
    	long intime = Slot.intime[slot.getSlotNumber()].getInTime();
    	PreparedStatement pstmt = conn.prepareStatement("INSERT INTO slots (carnumber,slotnumber,intime) VALUE (?,?,?)");
    	pstmt.setString(1, carnumber);
    	pstmt.setInt(2, slotnumber);
    	pstmt.setLong(3, intime);
    	pstmt.executeUpdate();
    }
    
    public void deleteFromDB(Slot slot) throws SQLException {
    	String carnumber = Slot.car[slot.getSlotNumber()].getCarNumber();
    	String deleteSQL = "DELETE FROM slots WHERE carnumber = ?";
    	PreparedStatement preparedStatement = conn.prepareStatement(deleteSQL);
    	preparedStatement.setString(1, carnumber);
    	preparedStatement.executeUpdate();
    }
    
    public void readOldTransactions(ParkingSpace parkingSpace) throws SQLException {
        int lastSlot = 0;
        int[] temp = new int[parkingSpace.getTotalSlots()];
    	Statement st = conn.createStatement();
    	String sql = ("SELECT * FROM slots");
    	ResultSet rs = st.executeQuery(sql);
    	while(rs.next()) {
    		String carnumber = rs.getString("carnumber");
    		int slotnumber = rs.getInt("slotnumber");
    		long intime = rs.getLong("intime");
    		parkingSpace.queue.add(new Slot(slotnumber, carnumber, intime));
    		int templastSlot = slotnumber;
    		if(templastSlot >lastSlot) {
    			lastSlot = templastSlot;
    		}
    		temp[slotnumber] = slotnumber;
    	}
    	if(rs.next() == false) {
    		updateQueue(lastSlot, temp, parkingSpace);
            parkingSpace.setSlotNumber(lastSlot + 1);
    	}
    }
    /**
     * updates the queue with empty slots.
     * @param lastSlot
     * @param temp
     * @param parkingSpace
     */
    public void updateQueue(int lastSlot, int temp[], ParkingSpace parkingSpace) {
        for (int slot = 1; slot <= lastSlot; slot++) {
            if (temp[slot] == 0) {
                parkingSpace.nextSlot.add((slot));
            }
        }
    }
}
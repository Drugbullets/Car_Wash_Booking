package com.carwash;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/book")
public class BookingServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String location = request.getParameter("location");
        String latitude = request.getParameter("latitude");
        String longitude = request.getParameter("longitude");
        String service = request.getParameter("service");

        try {
            Connection conn = DBConnection.getConnection();
            String sql = "INSERT INTO CarWashBookings (CustomerName, Phone, Email, Location, Latitude, Longitude, ServiceType) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, phone);
            stmt.setString(3, email);
            stmt.setString(4, location);
            stmt.setString(5, latitude);
            stmt.setString(6, longitude);
            stmt.setString(7, service);

            stmt.executeUpdate();
            conn.close();

            response.sendRedirect("booking.jsp?success=true");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("booking.jsp?error=true");
        }
    }
}

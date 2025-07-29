package com.carwash;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/viewBookings")
public class AdminServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><head><title>Bookings</title></head><body>");
        out.println("<h2>All Bookings</h2>");
        out.println(
                "<table border='1'><tr><th>ID</th><th>Name</th><th>Phone</th><th>Email</th><th>Location</th><th>Service</th><th>Date</th></tr>");

        try {
            Connection conn = DBConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM CarWashBookings ORDER BY BookingDate DESC");

            while (rs.next()) {
                out.println("<tr>");
                out.println("<td>" + rs.getInt("BookingID") + "</td>");
                out.println("<td>" + rs.getString("CustomerName") + "</td>");
                out.println("<td>" + rs.getString("Phone") + "</td>");
                out.println("<td>" + rs.getString("Email") + "</td>");
                out.println("<td>" + rs.getString("Location") + "</td>");
                out.println("<td>" + rs.getString("ServiceType") + "</td>");
                out.println("<td>" + rs.getTimestamp("BookingDate") + "</td>");
                out.println("</tr>");
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        out.println("</table></body></html>");
    }
}

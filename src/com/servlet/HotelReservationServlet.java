package com.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Charges;
import com.model.ChargesPojo;
import com.model.GetMockParameter;
import com.model.Price;

/**
 * Servlet implementation class HotelReservationServlet
 */
@WebServlet("/reservation")
public class HotelReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 102831973239L;


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/* Variables declaration */
		String newPage = "/NewReservation.jsp";
		String action = "";
		String firstName = "", lastName="", address="", rooms="";
		Date checkInDate=null, checkOutDate=null;
		java.sql.Date  checkIn=null, checkOut=null;
		double chargeWithoutTax = 0, taxes = 0, totalCharges = 0, price=0;
		
		ChargesPojo charge = new ChargesPojo();
		
		/* Do this when submit button was clicked */
		action = request.getParameter("action");
		
		System.out.println("action: " + action);

		if(action != null){
			
			if(action.equalsIgnoreCase("reservation")){
				
				firstName = request.getParameter("firstName");
				lastName = request.getParameter("lastName");
				address = request.getParameter("address");
				rooms = request.getParameter("rooms");

                SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");
                String checkInStr = request.getParameter("checkIn").replaceAll("-", "");
                System.out.println("checkInStr: " + checkInStr);
                try {
                    checkInDate = sdf1.parse(checkInStr);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                checkIn = new java.sql.Date(checkInDate.getTime());
               
                String checkOutStr = request.getParameter("checkOut").replaceAll("-", "");
                System.out.println("checkOutStr: " + checkOutStr);
                try {
                    checkOutDate = sdf1.parse(checkOutStr);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                checkOut = new java.sql.Date(checkOutDate.getTime());
                
                long numOfDays =  Math.abs((checkOutDate.getTime() - checkInDate.getTime())/86400000);
                price = new Price().getRoomRates(rooms);
                
                charge = new Charges().calculateCharges(new GetMockParameter(price, numOfDays));
                
                chargeWithoutTax = charge.getChargeWithoutTax();
                taxes = charge.getTaxes();
                totalCharges = charge.getTotalCharges();
			}
			
		}
		
		request.setAttribute("firstName", firstName);
		request.setAttribute("lastName", lastName);
		request.setAttribute("address", address);
		request.setAttribute("checkIn", checkIn);
		request.setAttribute("checkOut", checkOut);
		request.setAttribute("rooms", rooms);
		request.setAttribute("chargeWithoutTax", chargeWithoutTax);
		request.setAttribute("taxes", taxes);
		request.setAttribute("totalCharges", totalCharges);
		
		/* do redirection */ 
		ServletContext sContext = getServletContext();
		RequestDispatcher rDispatcher = sContext.getRequestDispatcher(newPage);
		rDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

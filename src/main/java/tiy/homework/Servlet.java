package tiy.homework;

import tiy.homework06.NumbersGroup;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


@WebServlet(name = "Servlet", urlPatterns = "/generate")
public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // create a ticket
        NumbersGroup aTicket = new NumbersGroup();

        // look for the list
        ArrayList<NumbersGroup> myTicketList = (ArrayList<NumbersGroup>) request.getSession().getAttribute("tList");

        // if not there, this is 1st time so create it and put into session (for next time)
        if(myTicketList == null){
            myTicketList = new ArrayList<NumbersGroup>();
            request.getSession().setAttribute("tList", myTicketList);
        }

        // add ticket to list
        myTicketList.add(aTicket);

        // send to JSP page to display tickets
        String nextJSP = "/index.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(request,response);
    }
}

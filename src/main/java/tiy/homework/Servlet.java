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
    //response.getWriter().write("I received request");

        int one = Integer.parseInt(request.getParameter("one"));
        int two = Integer.parseInt(request.getParameter("two"));
        int three = Integer.parseInt(request.getParameter("three"));
        int four = Integer.parseInt(request.getParameter("four"));
        int five = Integer.parseInt(request.getParameter("five"));
        int six = Integer.parseInt(request.getParameter("six"));

        NumbersGroup manTicket = new NumbersGroup(one, two, three, four, five, six);

        ArrayList<NumbersGroup> myTicketList = (ArrayList<NumbersGroup>) request.getSession().getAttribute("tList");

        // if not there, this is 1st time so create it and put into session (for next time)
        if(myTicketList == null){
            myTicketList = new ArrayList<NumbersGroup>();
            request.getSession().setAttribute("tList", myTicketList);
        }

        NumbersGroup winTicket = new NumbersGroup(7, 48, 8, 16, 31, 10);

        //
        for(int aWinningNumber: winTicket.getNumber()){

            for(NumbersGroup aSingleUserTicket: myTicketList){

                if(aSingleUserTicket.getNumber().contains(aWinningNumber)){
                    //match count

                }

            }

        }

        // now all tickets know their matches

        // add ticket to list
        myTicketList.add(manTicket);

        String nextJSP = "/index.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(request,response);


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

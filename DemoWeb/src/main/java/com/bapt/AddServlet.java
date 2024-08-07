package com.bapt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddServlet extends HttpServlet
{
  public void service(HttpServletRequest req, HttpServletResponse res) throws IOException 
  {
    String amount = req.getParameter("num1");
    String curr1 = req.getParameter("curr1");
    String curr2 = req.getParameter("curr2");
    
    double result = 0;
    try
    {
      result = MoneyApi.main(new String [] {amount, curr1, curr2});
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    PrintWriter out = res.getWriter();
    if (result == 0) {
      out.println("Error, please retry");
      return;
    }
    out.println(result);
  }
}

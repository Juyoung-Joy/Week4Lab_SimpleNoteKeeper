/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Note;

/**
 *
 * @author 824664
 */
public class NoteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        
        BufferedReader br = new BufferedReader(new FileReader(new File(path)));
        String title = br.readLine();
        String contents = br.readLine();
        
        Note note = new Note(title,contents);
        request.setAttribute("note", note);
        
        request.setAttribute("title", title);
        request.setAttribute("contents", contents);
        
        String action = request.getParameter("edit");
        if(action == null) {
            getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp")
                    .forward(request, response);
        }
        else {
            getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp")
                    .forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        
        String inputTitle = request.getParameter("titleName");
        String inputContents = request.getParameter("editContents");
        
                 
        Note note = new Note(inputTitle,inputContents);
        request.setAttribute("note", note);
        
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path,false)));
            pw.println(inputTitle);
            pw.println(inputContents);
            pw.close();
        
            request.setAttribute("title", inputTitle);
            request.setAttribute("contents", inputContents);
        
            getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp")
                    .forward(request, response);
        
        
    }
}

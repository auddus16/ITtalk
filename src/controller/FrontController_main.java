package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class FrontController_main
 */
@WebServlet("*.main")
public class FrontController_main extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController_main() {
        super();
        // TODO Auto-generated constructor stub
    }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      actionDo(request,response);
   }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      actionDo(request,response);
   }
   
   private void actionDo(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
      
      String uri=req.getRequestURI();
      String cp=req.getContextPath();
      String action=uri.substring(cp.length());
      System.out.println("uri "+uri);
      System.out.println("cp "+cp);
      System.out.println("action "+action);
      
      ActionForward forward=null;
      if(action.equals("/main.main")) {
         try {
            forward=new MainAction().execute(req, res);
         } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
      }
      
      else if(action.equals("/login.main")) {
         try {
            forward=new LoginAction().execute(req, res);
         } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
      }
      else if(action.equals("/logout.main")) {
         try {
            forward=new LogoutAction().execute(req, res);
      } catch (Exception e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      }
      else if(action.equals("/checkid.main")) {
         try {
            forward=new MbidCheckAction().execute(req, res);
         } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
      }
      
      else if(action.equals("/checknick.main")) {
         try {
            forward=new Mb_nickCheckAction().execute(req, res);
         } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
      }
      else if(action.equals("/newmem.main")) {
         try {
            forward=new NewMemAction().execute(req, res);
         } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace(); 
         }
      }
      
      else if(action.equals("/emailsend.main")) {
    	  try {
              forward=new EmailSendAction().execute(req, res);
           } catch (Exception e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
           }
      }
      else if(action.equals("/auth.main")) {
    	  try {
              forward=new AuthNumAction().execute(req, res);
           } catch (Exception e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
           }
      }
      else if(action.equals("/searchauth.main")) {
    	  try {
              forward=new SearchAuthAction().execute(req, res);
           } catch (Exception e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
           }
      }
      else {
         // 에러페이지로 이동-404
         forward=new ActionForward();
         forward.setRedirect(false);
         forward.setPath("/error/error404.jsp");
      } 
      
      if(forward!=null) {
         if(forward.isRedirect()) {
            res.sendRedirect(forward.getPath());
         }
         else {
            RequestDispatcher dispatcher=req.getRequestDispatcher(forward.getPath());
            dispatcher.forward(req, res);
         }
      }
      
      
      
      
   }
   
}
package frontproject.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontController
 */

/*
 *  frontcontroller는 모든 가상경로를 제일 먼저 받아 
 *  역할에 맞는 컨트롤러로 요청을 분기하는 처리를 한다.
 * */
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String requestURL = request.getRequestURI(); // 전체 url 도메인 제외.
		String contextPath = request.getContextPath(); // 프로젝트 path.
		
		String command = requestURL.substring(contextPath.length()+1); // 프로젝트 path를 제외한 url.
		
		String[] uris = command.split("/");
		if(uris[0].equals("sampleTB")) {
			
			SampleTBController sampleTBController = new SampleTBController();
			
			sampleTBController.getAction(request,response,uris);
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String requestURL = request.getRequestURI(); // 전체 url 도메인 제외.
		String contextPath = request.getContextPath(); // 프로젝트 path.
		
		String command = requestURL.substring(contextPath.length()+1); // 프로젝트 path를 제외한 url.
		
		String[] uris = command.split("/");
		if(uris[0].equals("sampleTB")) {
			
			SampleTBController sampleTBController = new SampleTBController();
			
			sampleTBController.postAction(request,response,uris);
			
		}
	}

}

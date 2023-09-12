package JSP.tagLib;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class ResultHandler extends TagSupport {
	private static final long serialVersionUID = 1L;

	Connection con;
	PreparedStatement st;

	public ResultHandler() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "open6162");
			st = con.prepareStatement("select * from jsp=?");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public int doStartTag() throws JspException {
		ServletRequest req=pageContext.getRequest();
		String email=req.getParameter("email");
	
	
	
	try {
		st.setString(1, email);
		ResultSet r=st.executeQuery();
		JspWriter out=pageContext.getOut();
		if(r.next()) {
		out.print("User details are given below:");
		out.print("id");
		out.print("male:");
	}
	return 0;
	
}}
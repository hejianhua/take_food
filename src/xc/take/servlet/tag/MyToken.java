package xc.take.servlet.tag;

import java.io.IOException;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import xc.take.util.TokenProccessor;

public class MyToken extends SimpleTagSupport {

	

	@Override
	public void doTag() throws JspException, IOException {
		
			PageContext pageContext =  (PageContext) getJspContext();
			String token = TokenProccessor.getInstance().makeToken();
			HttpSession session = pageContext.getSession();
			//token放入session
			System.out.println("自定义标签的执行");
			session.setAttribute("token", token);
			
			String html="<input type='hidden'  value='"+token+"' name='token'>";
			pageContext.getOut().print(html);
	}


}

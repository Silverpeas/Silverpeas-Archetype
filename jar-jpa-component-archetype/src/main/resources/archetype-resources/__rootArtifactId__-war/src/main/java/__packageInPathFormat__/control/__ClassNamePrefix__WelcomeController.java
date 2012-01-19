#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.control;

import com.silverpeas.webcore.ActionController;
import com.silverpeas.webcore.ActionControllerSupport;

import com.stratelia.webactiv.beans.admin.UserDetail;

import javax.servlet.http.HttpServletRequest;

public class ${ClassNamePrefix}WelcomeController extends ActionControllerSupport implements
        ActionController {

    @Override
    public String resolveView(HttpServletRequest request) {
        UserDetail userDetail = getComponentSessionController().getUserDetail();
        String[] userRoles = getComponentSessionController().getUserRoles();
        request.setAttribute("userDetail", userDetail);
        request.setAttribute("userRoles", userRoles);

        return "welcome.jsp";
    }

}

#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )

package ${package}.servlets;

import javax.servlet.http.HttpServletRequest;
import com.stratelia.silverpeas.silvertrace.SilverTrace;
import com.stratelia.silverpeas.peasCore.servlets.ComponentRequestRouter;
import com.stratelia.silverpeas.peasCore.MainSessionController;
import com.stratelia.silverpeas.peasCore.ComponentContext;
import com.stratelia.silverpeas.peasCore.ComponentSessionController;

import ${package}.control.${className}SessionController;

public class ${className}RequestRouter extends ComponentRequestRouter
{
    /**
     * This method has to be implemented in the component request rooter class.
     * returns the session control bean name to be put in the request object
     * ex : for almanach, returns "almanach"
     */
    public String getSessionControlBeanName()
	 {
	    return "${className}";
	 }

    /**
     * Method declaration
     *
     *
     * @param mainSessionCtrl
     * @param componentContext
     *
     * @return
     *
     * @see
     */
    public ComponentSessionController createComponentSessionController(MainSessionController mainSessionCtrl, ComponentContext componentContext)
    {
        return new ${className}SessionController(mainSessionCtrl, componentContext);
    }

    /**
     * This method has to be implemented by the component request rooter
     * it has to compute a destination page
     * @param function The entering request function (ex : "Main.jsp")
     * @param componentSC The component Session Control, build and initialised.
     * @return The complete destination URL for a forward (ex : "/almanach/jsp/almanach.jsp?flag=user")
     */
    public String getDestination(String function, ComponentSessionController componentSC, HttpServletRequest request)
    {
        String destination = "";
        ${className}SessionController  ${rootArtifactId}SC = (${className}SessionController)componentSC;
        SilverTrace.info("${rootArtifactId}", "${className}RequestRouter.getDestination()", "root.MSG_GEN_PARAM_VALUE", "User=" + componentSC.getUserId() + " Function=" + function);

        try
        {
            if (function.startsWith("Main"))
            {
	            destination = "welcome.jsp";
            }
            else
            {
                destination = "welcome.jsp";
            }
            destination = "/${rootArtifactId}/jsp/" + destination;
        }
        catch (Exception e)
        {
            request.setAttribute("javax.servlet.jsp.jspException", e);
            destination = "/admin/jsp/errorpageMain.jsp";
        }

        SilverTrace.info("${rootArtifactId}", "${className}RequestRouter.getDestination()", "root.MSG_GEN_PARAM_VALUE", "Destination=" + destination);
        return destination;
    }

}

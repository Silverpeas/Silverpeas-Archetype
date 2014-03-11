#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/**
 * Copyright (C) 2000 - 2011 Silverpeas
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * As a special exception to the terms and conditions of version 3.0 of
 * the GPL, you may redistribute this Program in connection with Free/Libre
 * Open Source Software ("FLOSS") applications as described in Silverpeas's
 * FLOSS exception.  You should have received a copy of the text describing
 * the FLOSS exception, and it is also available here:
 * "http://www.silverpeas.com/legal/licensing"
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package ${package}.servlets;

import com.stratelia.silverpeas.silvertrace.SilverTrace;
import com.stratelia.silverpeas.peasCore.servlets.ComponentRequestRouter;
import com.stratelia.silverpeas.peasCore.MainSessionController;
import com.stratelia.silverpeas.peasCore.ComponentContext;
import com.stratelia.silverpeas.peasCore.ComponentSessionController;
import org.silverpeas.servlet.HttpRequest;

import ${package}.control.${ClassNamePrefix}SessionController;

public class ${ClassNamePrefix}RequestRouter extends ComponentRequestRouter<ComponentSessionController> {

  /**
   * This method has to be implemented in the component request rooter class.
   * returns the session control bean name to be put in the request object
   * ex : for almanach, returns "almanach"
   */
  @Override
  public String getSessionControlBeanName() {
	    return "${ClassNamePrefix}";
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
  @Override
  public ComponentSessionController createComponentSessionController(MainSessionController mainSessionCtrl, ComponentContext componentContext) {
    return new ${ClassNamePrefix}SessionController(mainSessionCtrl, componentContext);
  }

  /**
   * This method has to be implemented by the component request rooter
   * it has to compute a destination page
   * @param function The entering request function (ex : "Main.jsp")
   * @param componentSC The component Session Control, build and initialised.
   * @return The complete destination URL for a forward (ex : "/almanach/jsp/almanach.jsp?flag=user")
   */
  @Override
  public String getDestination(String function, ComponentSessionController componentSC, HttpRequest request) {
    String destination = "";
    ${ClassNamePrefix}SessionController  ${rootArtifactId}SC = (${ClassNamePrefix}SessionController)componentSC;
    SilverTrace.info("${rootArtifactId}", "${ClassNamePrefix}RequestRouter.getDestination()", "root.MSG_GEN_PARAM_VALUE", "User=" + componentSC.getUserId() + " Function=" + function);

    try {
      if (function.equals("Main")) {
	      destination = home(${rootArtifactId}SC, request);
      } else {
        destination = home(${rootArtifactId}SC, request);
      }
      destination = "/${rootArtifactId}/jsp/" + destination;
    } catch (Exception e) {
      request.setAttribute("javax.servlet.jsp.jspException", e);
      destination = "/admin/jsp/errorpageMain.jsp";
    }

    SilverTrace.info("${rootArtifactId}", "${ClassNamePrefix}RequestRouter.getDestination()", "root.MSG_GEN_PARAM_VALUE", "Destination=" + destination);
    return destination;
  }

  /**
   * Perform homepage
   * @param componentSC
   * @param request
   * @return destination
   */
  private String home(${ClassNamePrefix}SessionController componentSC, HttpServletRequest request) {
    // Insert the homepage code here
    return "welcome.jsp";
  }
}

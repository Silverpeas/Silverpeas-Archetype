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

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import ${package}.control.ActionControllerSupport;
import ${package}.control.${ClassNamePrefix}WelcomeController;
import ${package}.control.${ClassNamePrefix}SessionController;
import com.stratelia.silverpeas.peasCore.ComponentContext;
import com.stratelia.silverpeas.peasCore.MainSessionController;
import com.stratelia.silverpeas.peasCore.PeasCoreException;
import com.stratelia.silverpeas.peasCore.servlets.ComponentRequestRouter;
import com.stratelia.silverpeas.silvertrace.SilverTrace;
import com.stratelia.webactiv.util.exception.SilverpeasRuntimeException;

public class ${ClassNamePrefix}RequestRouter extends
		ComponentRequestRouter<${ClassNamePrefix}SessionController> {
	private static final long serialVersionUID = 2306409242623119934L;

	private final Map<String, ActionControllerSupport> viewMappings = new HashMap<String, ActionControllerSupport>();

	public ${ClassNamePrefix}RequestRouter() {
		super();
		viewMappings.put("Main", new ${ClassNamePrefix}WelcomeController());
	}

	/**
	 * This method has to be implemented in the component request rooter class.
	 * returns the session control bean name to be put in the request object ex
	 * : for almanach, returns "almanach"
	 */
	@Override
	public String getSessionControlBeanName() {
		return "${rootArtifactId}";
	}

	/**
	 * Method declaration
	 * 
	 * @param mainSessionCtrl
	 * @param componentContext
	 * @return
	 * @see
	 */
	@Override
	public ${ClassNamePrefix}SessionController createComponentSessionController(
			MainSessionController mainSessionCtrl,
			ComponentContext componentContext) {
		return new ${ClassNamePrefix}SessionController(mainSessionCtrl, componentContext);
	}

	/**
	 * This method has to be implemented by the component request rooter it has
	 * to compute a destination page
	 * 
	 * @param function
	 *            The entering request function (ex : "Main.jsp")
	 * @param componentSC
	 *            The component Session Control, build and initialised.
	 * @return The complete destination URL for a forward (ex :
	 *         "/almanach/jsp/almanach.jsp?flag=user")
	 */
	@Override
	public String getDestination(String function,
			${ClassNamePrefix}SessionController componentSC, HttpServletRequest request) {
		SilverTrace.info(componentSC.getComponentName(), "${ClassNamePrefix}RequestRouter.getDestination()",
				"root.MSG_GEN_PARAM_VALUE", "User=" + componentSC.getUserId()
						+ " Function=" + function);
		try {
			String destination = getDestination(function, componentSC, request,
					false);
			SilverTrace.info(componentSC.getComponentName(),
					"${ClassNamePrefix}RequestRouter.getDestination()",
					"root.MSG_GEN_PARAM_VALUE", "Destination=" + destination);
			return destination;
		} catch (Throwable t) {
			request.setAttribute("javax.servlet.jsp.jspException", t);
			return "/admin/jsp/errorpageMain.jsp";
		}
	}

	protected String getDestination(String function,
			${ClassNamePrefix}SessionController componentSC, HttpServletRequest request,
			boolean isRedirect) throws PeasCoreException {
		if (getViewMappings().containsKey(function)) {
			ActionControllerSupport actionController = getViewMappings()
					.get(function);		
			String view = resolveView(actionController, componentSC, request,
					isRedirect);
			request.setAttribute("action", function);
			return view;
		}

		throw new PeasCoreException(
				"${ClassNamePrefix}RequestRouter.getDestination()",
				SilverpeasRuntimeException.ERROR, "Action " + function
						+ " doesn't match any controller");

	}

	protected String resolveView(
			ActionControllerSupport actionController,
			${ClassNamePrefix}SessionController componentSC, HttpServletRequest request,
			boolean isRedirect) throws PeasCoreException {
		actionController.setSessionController(componentSC);
		String view = actionController.resolveView(request);
		if (view == null) {
			throw new PeasCoreException(
					"${ClassNamePrefix}RequestRouter.getDestination()",
					SilverpeasRuntimeException.ERROR, "Controller "
							+ actionController.getClass().getName()
							+ " can't resolve view");
		}
		if (view.startsWith("redirect:")) {
			if (isRedirect) {
				throw new PeasCoreException(
						"${ClassNamePrefix}RequestRouter.getDestination()",
						SilverpeasRuntimeException.ERROR,
						"Circular redirection");
			}
			return getDestination(view.substring("redirect:".length()),
					componentSC, request, true);
		}
		
		return "/"+componentSC.getComponentName()+"/jsp/" + view;


	}

	public Map<String, ActionControllerSupport> getViewMappings() {
		return viewMappings;
	}

}

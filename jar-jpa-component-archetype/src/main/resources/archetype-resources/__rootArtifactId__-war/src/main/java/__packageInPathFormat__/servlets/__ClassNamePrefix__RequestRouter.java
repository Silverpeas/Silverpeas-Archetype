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

import ${package}.control.${ClassNamePrefix}SessionController;
import ${package}.control.${ClassNamePrefix}WelcomeController;
import com.silverpeas.webcore.ActionControllerSupport;
import com.silverpeas.webcore.RequestRouterSupport;
import com.stratelia.silverpeas.peasCore.ComponentContext;
import com.stratelia.silverpeas.peasCore.MainSessionController;

import java.util.HashMap;
import java.util.Map;

public class ${ClassNamePrefix}RequestRouter extends
        RequestRouterSupport<${ClassNamePrefix}SessionController> {
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

    @Override
	public Map<String, ActionControllerSupport> getViewMappings() {
		return viewMappings;
	}

}

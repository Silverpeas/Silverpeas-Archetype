package com.silverpeas.webcore;

import com.stratelia.silverpeas.peasCore.ComponentContext;
import com.stratelia.silverpeas.peasCore.ComponentSessionController;
import com.stratelia.silverpeas.peasCore.MainSessionController;
import com.stratelia.silverpeas.peasCore.PeasCoreException;
import com.stratelia.silverpeas.peasCore.servlets.ComponentRequestRouter;
import com.stratelia.silverpeas.silvertrace.SilverTrace;
import com.stratelia.webactiv.util.exception.SilverpeasRuntimeException;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public abstract class RequestRouterSupport<SC extends ComponentSessionController> extends ComponentRequestRouter<SC> {
    private static final long serialVersionUID = 9146669532231580837L;

    public RequestRouterSupport() {
        super();
    }

    @Override
    public abstract String getSessionControlBeanName();

    @Override
    public abstract SC createComponentSessionController(
            MainSessionController mainSessionCtrl,
            ComponentContext componentContext);

    private String getDestination(String function,
                                    SC componentSC, HttpServletRequest request,
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
				"RequestRouterSupport.getDestination()",
				SilverpeasRuntimeException.ERROR, "Action " + function
						+ " doesn't match any controller");

	}

    private String resolveView(
			ActionControllerSupport actionController,
            SC componentSC, HttpServletRequest request,
			boolean isRedirect) throws PeasCoreException {
		actionController.setSessionController(componentSC);
		String view = actionController.resolveView(request);
		if (view == null) {
			throw new PeasCoreException(
					"RequestRouterSupport.getDestination()",
					SilverpeasRuntimeException.ERROR, "Controller "
							+ actionController.getClass().getName()
							+ " can't resolve view");
		}
		if (view.startsWith("redirect:")) {
			if (isRedirect) {
				throw new PeasCoreException(
						"RequestRouterSupport.getDestination()",
						SilverpeasRuntimeException.ERROR,
						"Circular redirection");
			}
			return getDestination(view.substring("redirect:".length()),
					componentSC, request, true);
		}

		return "/"+componentSC.getComponentName()+"/jsp/" + view;
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
                                 SC componentSC, HttpServletRequest request) {
        SilverTrace.info(componentSC.getComponentName(), "RequestRouterSupport.getDestination()",
                "root.MSG_GEN_PARAM_VALUE", "User=" + componentSC.getUserId()
                + " Function=" + function);
        try {
            String destination = getDestination(function, componentSC, request,
                    false);
            SilverTrace.info(componentSC.getComponentName(),
                    "RequestRouterSupport.getDestination()",
                    "root.MSG_GEN_PARAM_VALUE", "Destination=" + destination);
            return destination;
        } catch (Throwable t) {
            request.setAttribute("javax.servlet.jsp.jspException", t);
            return "/admin/jsp/errorpageMain.jsp";
        }
    }

    protected abstract Map<String, ActionControllerSupport> getViewMappings();
}

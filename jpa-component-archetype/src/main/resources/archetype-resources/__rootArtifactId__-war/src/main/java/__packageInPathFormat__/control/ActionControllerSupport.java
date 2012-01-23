#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.control;

import com.stratelia.silverpeas.peasCore.ComponentSessionController;

public abstract class ActionControllerSupport implements ActionController {
    private ComponentSessionController controller;

    protected ComponentSessionController getComponentSessionController() {
        return controller;
    }

    public void setSessionController(ComponentSessionController controller) {
        this.controller = controller;
    }
}

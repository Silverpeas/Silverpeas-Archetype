#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )

package ${package}.control;

import com.stratelia.silverpeas.peasCore.AbstractComponentSessionController;
import com.stratelia.silverpeas.peasCore.MainSessionController;
import com.stratelia.silverpeas.peasCore.ComponentContext;

public class ${className}SessionController extends AbstractComponentSessionController {
  /**
   * Standard Session Controller Constructeur
   *
   *
   * @param mainSessionCtrl   The user's profile
   * @param componentContext  The component's profile
   *
   * @see
   */
  public ${className}SessionController(MainSessionController mainSessionCtrl, ComponentContext componentContext) {
		super(mainSessionCtrl, componentContext,  "com.silverpeas.components.${rootArtifactId}.multilang.${className}Bundle", "com.silverpeas.components.${rootArtifactId}.settings.${className}Icons");
	}
}
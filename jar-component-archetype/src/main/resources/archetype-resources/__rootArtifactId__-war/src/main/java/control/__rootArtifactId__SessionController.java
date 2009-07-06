#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/*
 * HyperlinkSessionController.java
 *
 */
 
package ${package}.control;

import com.stratelia.silverpeas.peasCore.AbstractComponentSessionController;
import com.stratelia.silverpeas.peasCore.ComponentContext;
import com.stratelia.silverpeas.peasCore.MainSessionController;
import com.stratelia.webactiv.beans.admin.UserFull;

/** 
 *
 * @author  nchaix
 * @version 
 */
public class ${artifactId}SessionController extends AbstractComponentSessionController {
  
  public ${artifactId}SessionController(MainSessionController mainSessionCtrl, ComponentContext context) { 
	super(mainSessionCtrl, context, "com.silverpeas.${parentArtifactId}.multilang.${parentArtifactId}Bundle", null,"com.silverpeas.${parentArtifactId}.settings.${parentArtifactId}Settings");
  }
  
  public UserFull getUserFull()
  {
	  return getOrganizationController().getUserFull(getUserId());
  }
}
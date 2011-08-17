#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )

package ${package};

import com.silverpeas.admin.components.ComponentsInstanciatorIntf;
import com.silverpeas.admin.components.InstanciationException;
import com.stratelia.silverpeas.silvertrace.SilverTrace;
import java.sql.Connection;


public class ${className}Instanciator implements ComponentsInstanciatorIntf {

  public ${className}Instanciator() {
  }

  @Override
  public void create(Connection con, String spaceId, String componentId, String userId) throws InstanciationException {
	  SilverTrace.info("${rootArtifactId}","${className}Instanciator.create()","root.MSG_GEN_ENTER_METHOD", "space = "+spaceId+", componentId = "+componentId+", userId ="+userId);

	  //insert your code here !
	
	  SilverTrace.info("${rootArtifactId}","${className}Instanciator.create()","root.MSG_GEN_EXIT_METHOD");
  }

  @Override
  public void delete(Connection con, String spaceId, String componentId, String userId) throws InstanciationException {
	  SilverTrace.info("${rootArtifactId}","${className}Instanciator.delete()","root.MSG_GEN_ENTER_METHOD","space = "+spaceId+", componentId = "+componentId+", userId ="+userId);

	  //insert your code here !

	  SilverTrace.info("${rootArtifactId}","${className}Instanciator.delete()","root.MSG_GEN_EXIT_METHOD");
  }
}
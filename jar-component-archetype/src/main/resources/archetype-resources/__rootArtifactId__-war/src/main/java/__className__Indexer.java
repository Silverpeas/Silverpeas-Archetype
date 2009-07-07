#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )

package ${package};

import com.stratelia.silverpeas.peasCore.ComponentContext;
import com.stratelia.silverpeas.peasCore.MainSessionController;
import com.stratelia.webactiv.applicationIndexer.control.ComponentIndexerInterface;

public class ${className}Indexer implements ComponentIndexerInterface {

    public void index(MainSessionController mainSessionCtrl, ComponentContext context) throws Exception {
    }
}
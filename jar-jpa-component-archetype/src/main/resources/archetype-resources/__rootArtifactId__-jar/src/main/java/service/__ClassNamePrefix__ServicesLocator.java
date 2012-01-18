#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service;

//import javax.inject.Inject;

public class ${ClassNamePrefix}ServicesLocator {
	//TODO inject your services here.
	/* Your services implementation class should be annotated 
	 * with standard annotations : @Singleton and @Named 
	 */
//    @Inject
//    private MyEntityService myentityService;

    private static class SingletonLoader {
        private static final ${ClassNamePrefix}ServicesLocator _instance = new ${ClassNamePrefix}ServicesLocator();
    }

    public static ${ClassNamePrefix}ServicesLocator getInstance() {
        return SingletonLoader._instance;
    }

    //TODO insert your services getters here
//    public MyEntityService getMyEntityService() {
//        return myentityService;
//    }

}

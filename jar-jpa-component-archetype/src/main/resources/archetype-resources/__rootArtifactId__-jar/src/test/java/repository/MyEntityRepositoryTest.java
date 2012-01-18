#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.repository;

//import ${package}.model.MyEntity;
//import ${package}.service.${ClassNamePrefix}ServicesLocator;
import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.dataset.ReplacementDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.naming.NamingException;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;
//import java.util.List;

public class MyEntityRepositoryTest {

//	private static final String COMPONENT_ID="1";
//    private static MyEntityRepository repository;
    private static ClassPathXmlApplicationContext context;
    private static ReplacementDataSet dataSet;
    private static DatabaseConnection connection;

    public MyEntityRepositoryTest() {
    }

    @BeforeClass
    public static void generalSetUp() throws IOException, NamingException,
            Exception {
        context = new ClassPathXmlApplicationContext("spring-${rootArtifactId}.xml");
//        repository = context.getBean(MyEntityRepository.class);
        DataSource ds = (DataSource) context.getBean("jpaDataSource");
        FlatXmlDataSetBuilder builder = new FlatXmlDataSetBuilder();
        FlatXmlDataSet idataSet = builder
                .build(MyEntityRepositoryTest.class
                        .getClassLoader()
                        .getResourceAsStream(
                                "${packageInPathFormat}/data/${rootArtifactId}-dataset.xml"));
        dataSet = new ReplacementDataSet(idataSet);
        dataSet.addReplacementObject("[NULL]", null);
        connection = new DatabaseConnection(ds.getConnection());
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        context.close();
    }

    @Before
    public void before() throws DatabaseUnitException, SQLException {
        DatabaseOperation.CLEAN_INSERT.execute(connection, dataSet);
    }
    
    @Test
    public void testConfig(){
    	//just test config
    }

//    @Test
//    public void testFindNotExistingMyEntity() throws Exception {
//        int id = 99999;
//        MyEntity dbMyEntity = repository.findOne(id);
//        Assert.assertNull(dbMyEntity);
//    }
//
//    @Test
//    public void testDeleteAndGetAll() throws Exception {
//        List<MyEntity> dbMyEntitys = repository.getAll(COMPONENT_ID);
//        int count = dbMyEntitys.size();
//
//        repository.delete(1);
//
//        dbMyEntitys = repository.getAll(COMPONENT_ID);
//        Assert.assertEquals(count-1, dbMyEntitys.size());
//    }


}

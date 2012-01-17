#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.repository;

//import ${package}.model.Sample;
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

public class SampleRepositoryTest {

//	private static final String COMPONENT_ID="1";
//    private static SampleRepository repository;
    private static ClassPathXmlApplicationContext context;
    private static ReplacementDataSet dataSet;
    private static DatabaseConnection connection;

    public SampleRepositoryTest() {
    }

    @BeforeClass
    public static void generalSetUp() throws IOException, NamingException,
            Exception {
        context = new ClassPathXmlApplicationContext("spring-${rootArtifactId}.xml");
//        repository = context.getBean(SampleRepository.class);
        DataSource ds = (DataSource) context.getBean("dataSource");
        FlatXmlDataSetBuilder builder = new FlatXmlDataSetBuilder();
        FlatXmlDataSet idataSet = builder
                .build(SampleRepositoryTest.class
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
//    public void testFindNotExistingSample() throws Exception {
//        int id = 99999;
//        Sample dbSample = repository.findOne(id);
//        Assert.assertNull(dbSample);
//    }
//
//    @Test
//    public void testDeleteAndGetAll() throws Exception {
//        List<Sample> dbSamples = repository.getAll(COMPONENT_ID);
//        int count = dbSamples.size();
//
//        repository.delete(1);
//
//        dbSamples = repository.getAll(COMPONENT_ID);
//        Assert.assertEquals(count-1, dbSamples.size());
//    }


}

#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.dao;

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

public class TestSampleDao {

//	private static final String COMPONENT_ID="1";
//    private static SampleDAO dao;
    private static ClassPathXmlApplicationContext context;
    private static ReplacementDataSet dataSet;
    private static DatabaseConnection connection;

    public TestSampleDao() {
    }

    @BeforeClass
    public static void generalSetUp() throws IOException, NamingException,
            Exception {
        context = new ClassPathXmlApplicationContext("spring-${rootArtifactId}.xml");
//        dao = context.getBean(SampleDAO.class);
        DataSource ds = (DataSource) context.getBean("dataSource");
        FlatXmlDataSetBuilder builder = new FlatXmlDataSetBuilder();
        FlatXmlDataSet idataSet = builder
                .build(TestSampleDao.class
                        .getClassLoader()
                        .getResourceAsStream(
                                "${packageInPathFormat}/dao/${rootArtifactId}-dataset.xml"));
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
//        Sample dbSample = dao.findOne(id);
//        Assert.assertNull(dbSample);
//    }
//
//    @Test
//    public void testDeleteAndGetAll() throws Exception {
//        List<Sample> dbSamples = dao.getAll(COMPONENT_ID);
//        int count = dbSamples.size();
//
//        dao.delete(1);
//
//        dbSamples = dao.getAll(COMPONENT_ID);
//        Assert.assertEquals(count-1, dbSamples.size());
//    }


}

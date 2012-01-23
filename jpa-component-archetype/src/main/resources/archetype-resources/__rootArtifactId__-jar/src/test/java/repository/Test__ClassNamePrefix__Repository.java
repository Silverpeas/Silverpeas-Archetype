#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/*
 * Copyright (C) 2000 - 2011 Silverpeas
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * As a special exception to the terms and conditions of version 3.0 of
 * the GPL, you may redistribute this Program in connection with Free/Libre
 * Open Source Software ("FLOSS") applications as described in Silverpeas's
 * FLOSS exception.  You should have recieved a copy of the text describing
 * the FLOSS exception, and it is also available here:
 * "http://www.silverpeas.org/legal/licensing"
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package ${package}.repository;

import java.io.IOException;
import java.sql.SQLException;
import javax.inject.Inject;
import javax.naming.NamingException;
import javax.sql.DataSource;
import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.ReplacementDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring-${rootArtifactId}.xml"})
@TransactionConfiguration(transactionManager = "jpaTransactionManager")
public class Test${ClassNamePrefix}Repository {
  @Inject
  private DataSource ds;
 
  private static ReplacementDataSet dataSet;

  public Test${ClassNamePrefix}Repository() {
  }

  @BeforeClass
  public static void generalSetUp() throws IOException, NamingException, DataSetException {
    FlatXmlDataSetBuilder builder = new FlatXmlDataSetBuilder();
    FlatXmlDataSet idataSet = builder.build(Test${ClassNamePrefix}Repository.class.getClassLoader().getResourceAsStream("${packageInPathFormat}/repository/${rootArtifactId}-dataset.xml"));
    dataSet = new ReplacementDataSet(idataSet); 
    dataSet.addReplacementObject("[NULL]", null);
  }

  @Before
  public void setUp() throws DatabaseUnitException, SQLException {
    IDatabaseConnection connection = new DatabaseConnection(ds.getConnection());
    DatabaseOperation.CLEAN_INSERT.execute(connection, dataSet);
  }
  
  @Test
  public void testConfig(){
    	//just test config
  }
}
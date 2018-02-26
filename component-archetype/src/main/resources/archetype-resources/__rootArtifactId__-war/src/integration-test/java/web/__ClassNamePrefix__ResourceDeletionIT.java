#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/*
 * Copyright (C) 2000 - 2018 Silverpeas
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * As a special exception to the terms and conditions of version 3.0 of
 * the GPL, you may redistribute this Program in connection with Free/Libre
 * Open Source Software ("FLOSS") applications as described in Silverpeas's
 * FLOSS exception.  You should have received a copy of the text describing
 * the FLOSS exception, and it is also available here:
 * "http://www.silverpeas.com/legal/licensing"
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package ${package}.web;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import ${package}.WarBuilder;
import ${package}.model.Toto;
import org.silverpeas.web.ResourceDeletionTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * Integration tests about the management of ${ClassNamePrefix} contributions.
 */
@RunWith(Arquillian.class)
public class ${ClassNamePrefix}ResourceDeletionIT extends ResourceDeletionTest {

  public static final String DATABASE_CREATION_SCRIPT = "/${package}/create_database.sql";

  public static final String DATASET_SCRIPT = "/${package}/${rootArtifactId}-dataset.sql";

  private String sessionKey;

  public ${ClassNamePrefix}ResourceDeletionIT() {
    dbSetupRule.loadInitialDataSetFrom(DATASET_SCRIPT);
  }

  @Override
  protected String getCreationTable() {
    return DATABASE_CREATION_SCRIPT;
  }

  @Deployment
  public static Archive<?> createTestArchive() {
    return WarBuilder.onWarForTestClass(${ClassNamePrefix}ResourceDeletionIT.class)
      .addAsResource(DATABASE_CREATION_SCRIPT.substring(1))
      .addAsResource(DATASET_SCRIPT.substring(1))
      .build();
  }

  @Before
  public void prepareTestResources() {
    sessionKey = getTokenKeyOf(getSilverpeasEnvironmentTest().createDefaultUser());
  }

  @Test
  public void emptyTest() {
    // empty test
  }

  @Override
  public String aResourceURI() {
    return "${rootArtifactId}/k2/1";
  }

  @Override
  public String anUnexistingResourceURI() {
    return "${rootArtifactId}/k2/2}";
  }

  @Override
  public ${ClassNamePrefix} aResource() {
    return ${ClassNamePrefix}.getById("1");
  }

  @Override
  public String getAPITokenValue() {
    return sessionKey;
  }

  @Override
  public Class<?> getWebEntityClass() {
    return ${ClassNamePrefix}Entity.class;
  }

  @Override
  public String[] getExistingComponentInstances() {
    return new String[]{"k1", "k2"};
  }

}
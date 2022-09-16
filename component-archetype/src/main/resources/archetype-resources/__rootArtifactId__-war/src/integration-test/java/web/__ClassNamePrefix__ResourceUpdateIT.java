#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/*
 * Copyright (C) 2000 - 2022 Silverpeas
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
 * "https://www.silverpeas.com/legal/licensing"
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package ${package}.web;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import ${package}.${ClassNamePrefix}WarBuilder;
import ${package}.model.${ClassNamePrefix};
import org.silverpeas.core.admin.user.model.User;
import org.silverpeas.web.ResourceUpdateTest;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * Integration tests about the modification of ${ClassNamePrefix} contributions.
 */
@RunWith(Arquillian.class)
public class ${ClassNamePrefix}ResourceUpdateIT extends ResourceUpdateTest {

  private static final String DATABASE_CREATION_SCRIPT = "/${rootArtifactId}-database.sql";

  private static final String DATASET_SCRIPT = "/${rootArtifactId}-dataset.sql";

  private static final String EXPECTED_ID = "45d42847-2009-4ca8-86bb-1918909dc094";

  private String authToken;
  private ${ClassNamePrefix}Entity expected;

  @Deployment
  public static Archive<?> createTestArchive() {
    return ${ClassNamePrefix}WarBuilder.onWarForTestClass(${ClassNamePrefix}ResourceUpdateIT.class)
    .addRESTWebServiceEnvironment()
    .addAsResource(DATABASE_CREATION_SCRIPT.substring(1))
    .addAsResource(DATASET_SCRIPT.substring(1))
    .build();
  }

  @Override
  protected String getTableCreationScript() {
    return DATABASE_CREATION_SCRIPT;
  }

  @Override
  protected String getDataSetScript() {
    return DATASET_SCRIPT;
  }

  @Before
  public void prepareTestResources() {
    authToken = getTokenKeyOf(User.getById("1"));
    expected = new ${ClassNamePrefix}Entity(${ClassNamePrefix}.getById(EXPECTED_ID));
  }

  @Override
  @Test
  @Ignore
  public void updateOfAResourceFromAnInvalidOne() {
    // TODO remove it once the entity validity is implemented in ${ClassNamePrefix}Resource
  }

  @Override
  @Test
  @Ignore
  public void updateWithAnInvalidResourceState() {
    // TODO remove it once the entity validity is implemented in ${ClassNamePrefix}Resource
  }

  @Test
  public void emptyTest() {
    assertThat(true, is(true));
  }

  @Override
  public String aResourceURI() {
    return "${rootArtifactId}/" + getExistingComponentInstances()[0] + "/" + EXPECTED_ID;
  }

  @Override
  public String anUnexistingResourceURI() {
    return "${rootArtifactId}/" + getExistingComponentInstances()[0] + "/100";
  }

  @Override
  @SuppressWarnings("unchecked")
  public ${ClassNamePrefix}Entity aResource() {
    return expected;
  }

  @Override
  @SuppressWarnings("unchecked")
  public ${ClassNamePrefix}Entity anInvalidResource() {
    return new ${ClassNamePrefix}Entity();
  }

  @Override
  public String getAPITokenValue() {
    return authToken;
  }

  @Override
  public Class<?> getWebEntityClass() {
    return ${ClassNamePrefix}Entity.class;
  }

  @Override
  public String[] getExistingComponentInstances() {
    return new String[]{"${rootArtifactId}1", "${rootArtifactId}2"};
  }

}
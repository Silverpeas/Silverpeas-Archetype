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
package ${package};

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.silverpeas.core.test.rule.DbSetupRule;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * Integration tests about the management of ${ClassNamePrefix} contributions.
 */
@RunWith(Arquillian.class)
public interface ${ClassNamePrefix}ManagementIT {

  public static final String DATABASE_CREATION_SCRIPT = "/${package}/create_database.sql";

  public static final String DATASET_SCRIPT = "/${package}/${rootArtifactId}-dataset.sql";

  @Rule
  public DbSetupRule dbSetupRule = DbSetupRule.createTablesFrom(DATABASE_CREATION_SCRIPT)
      .loadInitialDataSetFrom(DATASET_SCRIPT);

  @Deployment
  public static Archive<?> createTestArchive() {
    return WarBuilderFor${rootArtifactId}.onWarForTestClass(${ClassNamePrefix}ManagementIT.class)
      .addAsResource(TABLE_CREATION_SCRIPT.substring(1))
      .addAsResource(DATASET_SCRIPT.substring(1))
      .build();
  }

  @Test
  public void emptyTest() {
    // empty test
  }

}
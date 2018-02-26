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

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import ${package}.repository.${ClassNamePrefix}Repository;
import org.silverpeas.core.admin.service.OrganizationController;
import org.silverpeas.core.admin.user.model.UserDetail;
import org.silverpeas.core.persistence.datasource.OperationContext;
import org.silverpeas.core.test.rule.CommonAPI4Test;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Unit tests about the ${ClassNamePrefix} contributions.
 */
public class ${ClassNamePrefix}Test {

  @Rule
  public CommonAPI4Test commonAPI4Test = new CommonAPI4Test();

  @Before
  public void mockRequiredResources() {
    ${ClassNamePrefix}Repository repository = mock(${ClassNamePrefix}Repository.class);
    OrganizationController organizationController = mock(OrganizationController.class);
    commonAPI4Test.injectIntoMockedBeanContainer(repository);
    commonAPI4Test.injectIntoMockedBeanContainer(organizationController);
    when(organizationController.getUserDetail(anyString())).thenAnswer(a -> {
      String id = a.getArgument(0);
      UserDetail user = new UserDetail();
      user.setId(id);
      return user;
    });

    OperationContext.fromUser("0");

  }

  @Test
  public void emptyTest() {
    // empty test
  }

}
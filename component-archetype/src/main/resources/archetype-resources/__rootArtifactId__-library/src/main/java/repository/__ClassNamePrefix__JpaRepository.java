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
package ${package}.repository;

import ${package}.model.${ClassNamePrefix};
import org.silverpeas.core.persistence.datasource.repository.jpa.NamedParameters;
import org.silverpeas.core.persistence.datasource.repository.jpa.SilverpeasJpaEntityRepository;

import javax.inject.Singleton;
import java.util.List;

/**
 * Implementation of the repository of ${ClassNamePrefix} contributions by extending the
 * {@link org.silverpeas.core.persistence.datasource.repository.jpa.SilverpeasJpaEntityRepository}
 * base repository that provides all the basic and necessary methods to save, to update, to delete
 * and to get the business entities by using the JPA engine.
 */
@Singleton
public class ${ClassNamePrefix}JpaRepository
    extends SilverpeasJpaEntityRepository<${ClassNamePrefix}>
    implements ${ClassNamePrefix}Repository {

  @Override
  public List<${ClassNamePrefix}> getByComponentInstanceId(final String componentInstanceId) {
    NamedParameters parameters = newNamedParameters();
    return findByNamedQuery("${ClassNamePrefix}ByComponentInstanceId",
    parameters.add("componentInstanceId", componentInstanceId));
  }
}
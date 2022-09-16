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
package ${package}.repository;

import ${package}.model.${ClassNamePrefix};
import org.silverpeas.core.persistence.datasource.repository.EntityRepository;
import org.silverpeas.core.util.ServiceProvider;

import java.util.List;

/**
 * This repository manages the persistence of ${ClassNamePrefix} contributions. It abstracts the
 * nature of the datasource in which are stored the ${ClassNamePrefix} as well as the persistence
 * engine used to manage the access to such a datasource.
 */
public interface ${ClassNamePrefix}Repository extends EntityRepository<${ClassNamePrefix}> {

  /**
   * Gets the single instance of this repository.
   */
  static ${ClassNamePrefix}Repository get() {
    return ServiceProvider.getService(${ClassNamePrefix}Repository.class);
  }

  /**
   * Gets all ${ClassNamePrefix} instances belonging to the specified component instance.
   * @param componentInstanceId the unique identifier of a component instance.
   */
  List<${ClassNamePrefix}> getByComponentInstanceId(String componentInstanceId);
}
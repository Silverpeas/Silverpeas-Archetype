#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/**
 * Copyright (C) 2000 - 2014 Silverpeas
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
package ${package}.model;

import org.silverpeas.persistence.model.identifier.UuidIdentifier;
import org.silverpeas.persistence.model.jpa.AbstractJpaEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * It represents the business entities handled in the Silverpeas component. Its persistence is
 * managed by the {@link ${package}.repository.${ClassNamePrefix}Repository} JPA repository.
 * <p/>
 * All the business methods related to this entity should be defined here.
 */
@Entity
@Table(name = "SC_${ClassNamePrefix}")
public final class ${ClassNamePrefix}
    extends AbstractJpaEntity<${ClassNamePrefix}, UuidIdentifier> {

  @Column(name = "instanceId", nullable = false)
  private String componentInstanceId;

  public String getComponentInstanceId() {
    return componentInstanceId;
  }
}
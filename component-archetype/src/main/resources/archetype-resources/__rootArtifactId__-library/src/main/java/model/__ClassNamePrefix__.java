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
package ${package}.model;

import org.silverpeas.core.admin.user.model.User;
import org.silverpeas.core.persistence.Transaction;
import org.silverpeas.core.contribution.model.Contribution;
import org.silverpeas.core.contribution.model.ContributionIdentifier;
import org.silverpeas.core.persistence.datasource.model.identifier.UuidIdentifier;
import org.silverpeas.core.persistence.datasource.model.jpa.SilverpeasJpaEntity;
import ${package}.repository.${ClassNamePrefix}Repository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * It represents the business contribution handled in the Silverpeas component. Its persistence is
 * managed by the {@link ${package}.repository.${ClassNamePrefix}Repository} JPA repository.
 */
@Entity
@Table(name = "SC_${ClassNamePrefix}")
public final class ${ClassNamePrefix}
    extends SilverpeasJpaEntity<${ClassNamePrefix}, UuidIdentifier>
    implements Contribution {

  @Column(name = "instanceId", nullable = false)
  private String componentInstanceId;

  /**
   * Gets a ${ClassNamePrefix} by its identifier.
   * @param id the unique identifier of a ${ClassNamePrefix} contribution.
   * @return the ${ClassNamePrefix} instance or null if it does not exist.
   */
  public static ${ClassNamePrefix} getById(final String id) {
    ${ClassNamePrefix}Repository repository = ${ClassNamePrefix}Repository.get();
    return repository.getById(id);
  }

  public String getComponentInstanceId() {
    return componentInstanceId;
  }

  @Override
  public ContributionIdentifier getContributionId() {
    return ContributionIdentifier.from(componentInstanceId, getId(), getContributionType());
  }

  @Override
  public User getLastModifier() {
    return getLastUpdater();
  }

  @Override
  public Date getLastModificationDate() {
    return getLastUpdateDate();
  }

  /**
   * Saves this contribution into the persistence context.
  */
  public void save() {
    Transaction.performInOne(() -> {
      ${ClassNamePrefix}Repository repository = ${ClassNamePrefix}Repository.get();
      repository.save(this);
      return null;
    });
  }

  /**
   * Deletes this contribution in the persistence context.
   */
  public void delete() {
    Transaction.performInOne(() -> {
      ${ClassNamePrefix}Repository repository = CalendarRepository.get();
      repository.delete(this);
      return null;
    });
  }
}
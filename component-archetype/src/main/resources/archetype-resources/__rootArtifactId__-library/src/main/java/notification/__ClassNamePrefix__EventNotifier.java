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
package ${package}.notification;

import org.silverpeas.core.annotation.Bean;
import org.silverpeas.core.notification.system.CDIResourceEventNotifier;
import org.silverpeas.core.notification.system.ResourceEvent;
import org.silverpeas.core.util.ServiceProvider;

import ${package}.model.${ClassNamePrefix};

/**
 * A notifier on the changes in the state of a ${ClassNamePrefix} business object.
 */
@Bean
public final class ${ClassNamePrefix}EventNotifier
    extends CDIResourceEventNotifier<${ClassNamePrefix}, ${ClassNamePrefix}Event> {

  public static ${ClassNamePrefix}EventNotifier get() {
    return ServiceProvider.getService(${ClassNamePrefix}EventNotifier.class);
   }

  @Override
  protected ${ClassNamePrefix}Event createResourceEventFrom(final ResourceEvent.Type type,
    final ${ClassNamePrefix}... resource) {
    return new ${ClassNamePrefix}Event(type, resource);
  }
}
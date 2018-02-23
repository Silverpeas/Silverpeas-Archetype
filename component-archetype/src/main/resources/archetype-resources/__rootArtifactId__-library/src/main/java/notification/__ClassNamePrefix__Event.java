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
package ${package}.notification;

import org.silverpeas.core.notification.system.AbstractResourceEvent;
import javax.validation.constraints.NotNull;

import ${package}.model.${ClassNamePrefix};

/**
 * Event on a change in the state of a given ${ClassNamePrefix} business object.
 */
public final class ${ClassNamePrefix}Event extends AbstractResourceEvent<${ClassNamePrefix}> {

  /**
   * Constructs a new event with the specified type and that implies the specified
   * ${ClassNamePrefix} states, each of them representing by a different ${ClassNamePrefix} instance.
   * @param type the type of the lifecycle event (the type of the transition occurring in the
   * @param contribution the states of a ${ClassNamePrefix} concerned by a state transition.
  */
  public ${ClassNamePrefix}Event(final Type type,
    @NotNull final ${ClassNamePrefix}... contribution) {
      super(type, contribution);
  }
}
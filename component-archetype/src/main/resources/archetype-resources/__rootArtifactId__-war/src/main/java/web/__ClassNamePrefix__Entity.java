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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import ${package}.model.${ClassNamePrefix};
import org.silverpeas.core.web.rs.WebEntity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.net.URI;

/**
 * It represents the Web entity of a ${ClassNamePrefix} state from which a representation (usually
 * in JSON) can be generated.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ${ClassNamePrefix}Entity implements WebEntity {

  private static final long serialVersionUID = 1L;

  @XmlElement(defaultValue = "")
  private URI uri;
  @XmlElement(required = true)
  private String id;

  protected ${ClassNamePrefix}Entity() {
    // required by the JSON/XML unmarshaller
  }

  protected ${ClassNamePrefix}Entity(final ${ClassNamePrefix} resource) {
    this.id = resource.getId();
  }

  ${ClassNamePrefix}Entity identifiedBy(final URI uri) {
    this.uri = uri;
    return this;
  }

  @Override
  public URI getURI() {
    return this.uri;
  }

  public String getId() {
    return this.id;
  }

  /**
   * Gets the ${ClassNamePrefix} business object represented by this entity and for the specified
   * component instance.
   * @param componentInstanceId the unique identifier of a component instance.
   * @return ${ClassNamePrefix} the business object represented by this entity.
   */
  public ${ClassNamePrefix} as${ClassNamePrefix}For(final String componentInstanceId) {
    ${ClassNamePrefix} resource = new ${ClassNamePrefix}(componentInstanceId);
    // TODO fill the resource with the required properties
    return resource;
  }

  /**
   * Updates the specified resource with the changes in this entity.
   * @param resource the resource to update.
   */
  public void update(final ${ClassNamePrefix} resource) {
    // TODO update the properties of the specified resource if they have changed
  }
}
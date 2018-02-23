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

import org.silverpeas.core.test.BasicCoreWarBuilder;

/**
 * This builder extends the {@link WarBuilder} in order to centralize the
 * definition of common archive part definitions.
 */
public class WarBuilderFor${rootArtifactId} extends BasicCoreWarBuilder {

  /**
   * Constructs a war builder for the specified test class. It will load all the resources in the
   * same packages of the specified test class.
   * @param test the class of the test for which a war archive will be build.
   */
  protected <T> WarBuilderFor${rootArtifactId}(final Class<T> test) {
    super(test);
    addMavenDependencies("org.silverpeas.core:silverpeas-core");
    addMavenDependencies("org.silverpeas.core.services:silverpeas-core-silverstatistics");
    addMavenDependencies("org.silverpeas.core.services:silverpeas-core-comment");

    addAsResource("org/silverpeas/components/${rootArtifactId}/settings/${rootArtifactId}Settings.properties");
  }

  /**
   * Gets an instance of a war archive builder for the specified test class.
   * @return the instance of the war archive builder.
   */
  public static <T> WarBuilderFor${rootArtifactId} onWarForTestClass(Class<T> test) {
    return new WarBuilderFor${rootArtifactId}(test);
  }

}
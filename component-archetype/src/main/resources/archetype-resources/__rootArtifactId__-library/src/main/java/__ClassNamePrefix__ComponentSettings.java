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
package ${package};

import org.silverpeas.core.util.LocalizationBundle;
import org.silverpeas.core.util.ResourceLocator;
import org.silverpeas.core.util.SettingBundle;

/**
 * It gathers all the settings and i18n relative to the ${rootArtifactId} component.
 */
public final class ${ClassNamePrefix}ComponentSettings {

  private ${ClassNamePrefix}ComponentSettings() {
  }

  /**
   * The name of the application (id est component or peas) in Silverpeas.
   */
  public static final String COMPONENT_NAME = "${rootArtifactId}";

  /**
   * The relative path of the properties file containing the settings of the Silverpeas
   * component.
   */
  public static final String SETTINGS_PATH =
    "org.silverpeas.components.${rootArtifactId}.settings.${rootArtifactId}Settings";

  /**
   * The relative path of the i18n bundle of the Silverpeas component.
   */
  public static final String MESSAGES_PATH =
    "org.silverpeas.components.${rootArtifactId}.multilang.${rootArtifactId}Bundle";

  /**
   * Gets all the messages for the Silverpeas component and translated in the specified language.
   * @param language the language in which are written the messages.
   * @return the resource with the translated messages.
   */
  public static LocalizationBundle getMessagesIn(String language) {
    return ResourceLocator.getLocalizationBundle(MESSAGES_PATH, language);
  }

  /**
   * Gets all the settings of the Silverpeas component.
   * @return the resource with the different component settings.
   */
  public static SettingBundle getSettings() {
    return ResourceLocator.getSettingBundle(SETTINGS_PATH);
  }
}
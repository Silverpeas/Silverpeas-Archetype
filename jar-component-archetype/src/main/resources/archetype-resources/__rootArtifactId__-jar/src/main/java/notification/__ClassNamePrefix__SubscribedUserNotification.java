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
package ${package}.notification;

import com.silverpeas.notification.builder.AbstractTemplateUserNotificationBuilder;
import com.silverpeas.notification.model.NotificationResourceData;
import com.silverpeas.subscribe.SubscriptionService;
import com.silverpeas.subscribe.SubscriptionServiceFactory;
import com.silverpeas.subscribe.constant.SubscriberType;
import com.silverpeas.subscribe.service.ComponentSubscriptionResource;
import com.silverpeas.subscribe.util.SubscriptionUtil;
import com.silverpeas.util.template.SilverpeasTemplate;
import com.stratelia.silverpeas.notificationManager.constant.NotifAction;
import ${package}.model.${ClassNamePrefix};

import java.util.Collection;
import java.util.Map;

/**
 * A notification of users subscribed to the change in the application. The text of the notification
 * is taken from a template that is built with the data of the ${ClassNamePrefix} entity concerned
 * by the change.
 */
public final class ${ClassNamePrefix}SubscribedUserNotification
    extends AbstractTemplateUserNotificationBuilder<${ClassNamePrefix}> {

  private final NotifAction action;
  private final Map<SubscriberType, Collection<String>> subscriberIdsByTypes = SubscriptionUtil.
    indexSubscriberIdsByType(null);

  public ${ClassNamePrefix}SubscribedUserNotification(final ${ClassNamePrefix} resource) {
    super(resource);
    action = NotifAction.CREATE;
  }

  @Override
  protected void initialize() {
    super.initialize();
    SubscriptionUtil.indexSubscriberIdsByType(subscriberIdsByTypes, getSubscribeBm().getSubscribers(
        ComponentSubscriptionResource.from(getResource().getComponentInstanceId())));
    subscriberIdsByTypes.get(SubscriberType.USER).remove(getSender());
  }

  @Override
  protected void performTemplateData(final String language, final ${ClassNamePrefix} resource,
      final SilverpeasTemplate template) {
    getNotificationMetaData()
        .addLanguage(language, getBundle(language).getString(getBundleSubjectKey(), getTitle()), "");
    // TODO set the different attributes of the template from the resource here
  }

  @Override
  protected void performNotificationResource(final String language, final ${ClassNamePrefix} resource,
    final NotificationResourceData notificationResourceData) {
    String resourceName = ""; // TODO set the resource name from the ${ClassNamePrefix} instance
    notificationResourceData.setResourceName(resourceName);
  }

  @Override
  protected boolean stopWhenNoUserToNotify() {
    return (!NotifAction.REPORT.equals(action));
  }

  @Override
  protected NotifAction getAction() {
    return action;
  }

  @Override
  protected String getComponentInstanceId() {
    return getResource().getComponentInstanceId();
  }

  @Override
  protected String getMultilangPropertyFile() {
    return "org.silverpeas.components.${rootArtifactId}.multilang.${ClassNamePrefix}Bundle";
  }

  @Override
  protected String getTemplatePath() {
    return "${rootArtifactId}}";
  }

  @Override
  protected String getBundleSubjectKey() {
    return "GML.subscription";
  }

  @Override
  protected String getFileName() {
    return "${ClassNamePrefix}SubscribedUserNotification";
  }

  @Override
  protected final String getSender() {
    return getResource().getCreatedBy();
  }

  @Override
  protected Collection<String> getUserIdsToNotify() {
    return subscriberIdsByTypes.get(SubscriberType.USER);
  }

  @Override
  protected Collection<String> getGroupIdsToNotify() {
    return subscriberIdsByTypes.get(SubscriberType.GROUP);
  }

  /**
   * Gets the service instance of subscription management.
   * @return the subscriptions service instance.
   */
  protected SubscriptionService getSubscribeBm() {
    return SubscriptionServiceFactory.getFactory().getSubscribeService();
  }
}
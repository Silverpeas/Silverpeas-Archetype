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

import org.silverpeas.core.notification.user.UserSubscriptionNotificationBehavior;
import org.silverpeas.core.subscription.constant.SubscriberType;
import org.silverpeas.core.subscription.service.ResourceSubscriptionProvider;
import org.silverpeas.core.subscription.util.SubscriptionSubscriberMapBySubscriberType;
import org.silverpeas.core.notification.user.client.constant.NotifAction;
import org.silverpeas.core.notification.user.builder.AbstractContributionTemplateUserNotificationBuilder;

import ${package}.model.${ClassNamePrefix};

import java.util.Collection;

/**
 * A notification of users subscribed to the changes in the application. The text of the
 * notification is taken from a template that is built with the data of the ${ClassNamePrefix}
 * entity concerned by the change.
 */
public final class ${ClassNamePrefix}SubscribedUserNotificationBuilder
    extends AbstractContributionTemplateUserNotificationBuilder<${ClassNamePrefix}>
    implements UserSubscriptionNotificationBehavior {

  private final NotifAction action;
  private final SubscriptionSubscriberMapBySubscriberType subscriberIdsByTypes =
      new SubscriptionSubscriberMapBySubscriberType();

  public static ${ClassNamePrefix}SubscribedUserNotificationBuilder aboutCreationOf(
      final ${ClassNamePrefix} contribution) {
    return new ${ClassNamePrefix}SubscribedUserNotificationBuilder(contribution, NotifAction.CREATE);
  }

  public static ${ClassNamePrefix}SubscribedUserNotificationBuilder aboutUpdateOf(
      final ${ClassNamePrefix} contribution) {
    return new ${ClassNamePrefix}SubscribedUserNotificationBuilder(contribution, NotifAction.UPDATE);
  }

  private ${ClassNamePrefix}SubscribedUserNotificationBuilder(final ${ClassNamePrefix} contribution,
      final NotifAction action) {
    super(contribution);
    this.action = action;
  }

  @Override
  protected void initialize() {
    super.initialize();
    subscriberIdsByTypes.addAll(ResourceSubscriptionProvider
        .getSubscribersOfComponent(getResource().getComponentInstanceId()));
  }

  @Override
  protected void perform(final ${ClassNamePrefix} resource) {
    super.perform(resource);
    getNotificationMetaData().displayReceiversInFooter();
  }

  @Override
  protected boolean stopWhenNoUserToNotify() {
    return (!NotifAction.REPORT.equals(action));
  }

  @Override
  protected String getBundleSubjectKey() {
    return "GML.subscription";
  }

  @Override
  protected String getTemplateFileName() {
    return "${rootArtifactId}SubscribedUserNotification";
  }

  @Override
  protected Collection<String> getUserIdsToNotify() {
    return subscriberIdsByTypes.get(SubscriberType.USER).getAllIds();
  }

  @Override
  protected Collection<String> getGroupIdsToNotify() {
    return subscriberIdsByTypes.get(SubscriberType.GROUP).getAllIds();
  }

  @Override
  protected NotifAction getAction() {
    return action;
  }

  @Override
  protected final String getSender() {
    return getResource().getLastUpdater().getId();
  }

  @Override
  protected String getLocalizationBundlePath() {
    return "org.silverpeas.components.${rootArtifactId}.multilang.${rootArtifactId}Bundle";
  }

  @Override
  protected String getTemplatePath() {
    return "${rootArtifactId}";
  }

  @Override
  protected String getContributionAccessLinkLabelBundleKey() {
    return "${rootArtifactId}.notifLinkLabel";
  }
}
<div style="font-family:Arial;font-size:11px">
TODO setzen Sie Ihre individuellem Text hier

$if(notification_receiver_users)$
Diese Nachricht wurde gesendet
 nutzer : $notification_receiver_users$
$endif$

$if(notification_receiver_groups)$
  $if(!notification_receiver_users)$
  Diese Nachricht wurde gesendet
  $endif$
 gruppen : $notification_receiver_groups$
$endif$
</div>
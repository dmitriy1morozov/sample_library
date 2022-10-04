package com.dmitriy1morozov.sample.library

import android.content.Intent
import android.os.IBinder
import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification
import android.util.Log


class NotificationListenerExampleService : NotificationListenerService() {

    override fun onBind(intent: Intent?): IBinder? {
        return super.onBind(intent)
    }

    override fun onNotificationRemoved(sbn: StatusBarNotification?) {
        // Implement what you want here
    }
    override fun onNotificationPosted(sbn: StatusBarNotification?) {
        super.onNotificationPosted(sbn)
        Log.d("TAG", "onNotificationPosted: ")
    }

    override fun onSilentStatusBarIconsVisibilityChanged(hideSilentStatusIcons: Boolean) {
        super.onSilentStatusBarIconsVisibilityChanged(hideSilentStatusIcons)
        Log.d("TAG", "onSilentStatusBarIconsVisibilityChanged: ")
    }

    override fun onNotificationRankingUpdate(rankingMap: RankingMap?) {
        super.onNotificationRankingUpdate(rankingMap)
        Log.d("TAG", "onNotificationRankingUpdate: ")
    }

    override fun onNotificationPosted(sbn: StatusBarNotification?, rankingMap: RankingMap?) {
        super.onNotificationPosted(sbn, rankingMap)
        Log.d("TAG", "onNotificationPosted: ")
    }

    override fun getActiveNotifications(): Array<StatusBarNotification> {
        return super.getActiveNotifications()
        Log.d("TAG", "getActiveNotifications: ")
    }

}
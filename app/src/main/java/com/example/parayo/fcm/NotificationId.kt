package com.example.parayo.fcm

import com.example.parayo.common.Prefs
import java.util.concurrent.Semaphore

/**
 * Created by KSW on 2020-09-14
 */

class NotificationId {
    companion object {
        private val lock = Semaphore(1)
        private var id = Prefs.notificationId

        fun generate(): Int {
            lock.acquire()
            val next = id + 1
            id = next
            Prefs.notificationId = next
            lock.release()
            return next
        }
    }
}
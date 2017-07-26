package com.callegasdev.springreactor.service;

import com.callegasdev.springreactor.domain.NotificationData;

public interface NotificationService {

    void initiateNotification(NotificationData notificationData)
            throws InterruptedException;

}
package com.example.case_modul6.service.before.InterfaceService.All;

import com.example.case_modul6.model.before.Notification.NotificationEnterprise;

import java.util.List;

public interface INotificationEnterpriseService {


    void save(NotificationEnterprise notificationEnterprise);

    NotificationEnterprise findById(int id);
    List<NotificationEnterprise> notificationEnterpriseSByEnterprise(int id);

    void updateStatusNotifi(int id);
}

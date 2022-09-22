package com.example.case_modul6.service.before.impl;

import com.example.case_modul6.model.before.Notification.NotificationEnterprise;
import com.example.case_modul6.repository.before.INotificationEnterpriseRepo;
import com.example.case_modul6.service.before.InterfaceService.All.INotificationEnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationEnterpriseService implements INotificationEnterpriseService {
    @Autowired
    INotificationEnterpriseRepo notificationEnterpriseRepo;

    @Override
    public void save(NotificationEnterprise notificationEnterprise) {
        notificationEnterpriseRepo.save(notificationEnterprise);
    }

    @Override
    public NotificationEnterprise findById(int id) {
        return notificationEnterpriseRepo.findById(id).get();
    }

    @Override
    public List<NotificationEnterprise> notificationEnterpriseSByEnterprise(int id) {
        return notificationEnterpriseRepo.notificationEnterpriseSByEnterprise(id);
    }

    @Override
    public void updateStatusNotifi(int id) {
          notificationEnterpriseRepo.updateStatusNotifi(id);
    }
}

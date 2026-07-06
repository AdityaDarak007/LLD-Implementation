package com.example.quickcommerce.services;

import com.example.quickcommerce.models.PartnerTaskMapping;

import java.util.List;

public interface MatchPartnerTaskService {
    public List<PartnerTaskMapping> matchPartnersAndTasks(List<Long> partnerIds, List<Long> taskIds);
}

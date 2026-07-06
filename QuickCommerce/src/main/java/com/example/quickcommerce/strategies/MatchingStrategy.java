package com.example.quickcommerce.strategies;

import com.example.quickcommerce.models.Partner;
import com.example.quickcommerce.models.PartnerTaskMapping;
import com.example.quickcommerce.models.Task;

import java.util.List;

public interface MatchingStrategy {
    public List<PartnerTaskMapping> matchPartnersAndTasks (List<Partner> partners, List<Task> tasks);
}

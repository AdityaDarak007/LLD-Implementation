package com.example.quickcommerce.services;

import com.example.quickcommerce.strategies.MatchingStrategy;
import com.example.quickcommerce.models.Partner;
import com.example.quickcommerce.models.PartnerTaskMapping;
import com.example.quickcommerce.models.Task;
import com.example.quickcommerce.repositories.PartnerRepository;
import com.example.quickcommerce.repositories.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MatchPartnerTaskServiceImpl implements MatchPartnerTaskService {
    @Autowired
    private PartnerRepository partnerRepository;
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private MatchingStrategy matchingStrategy;

    @Override
    public List<PartnerTaskMapping> matchPartnersAndTasks(List<Long> partnerIds, List<Long> taskIds) {
        List<Partner>  partners = partnerRepository.findAllById(partnerIds);
        List<Task> tasks = taskRepository.findAllById(taskIds);

        return matchingStrategy.matchPartnersAndTasks(partners, tasks);

    }
}

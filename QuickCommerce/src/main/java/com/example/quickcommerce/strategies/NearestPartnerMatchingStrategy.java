package com.example.quickcommerce.strategies;

import com.example.quickcommerce.models.Partner;
import com.example.quickcommerce.models.PartnerTaskMapping;
import com.example.quickcommerce.models.Task;
import com.example.quickcommerce.utils.DistanceUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class NearestPartnerMatchingStrategy implements MatchingStrategy {
    @Override
    public List<PartnerTaskMapping> matchPartnersAndTasks(List<Partner> partners, List<Task> tasks) {
        List<PartnerTaskMapping> partnerTaskMappings = new ArrayList<>();
        Set<Long> assignedPartners = new HashSet<>();

        for (Task task : tasks) {
            Partner nearestPartner = null;
            double minDistance = Double.MAX_VALUE;

            for (Partner partner : partners) {
                if(assignedPartners.contains(partner)) {
                    continue;
                }

                double distance = DistanceUtils.calculateDistance(partner.getCurrentLocation(), task.getPickupLocation());

                if(distance < minDistance) {
                    minDistance = distance;
                    nearestPartner = partner;
                }
            }
            if(nearestPartner != null) {
                assignedPartners.add(nearestPartner.getId());

                PartnerTaskMapping ptm = new PartnerTaskMapping();

                ptm.setPartner(nearestPartner);
                ptm.setTask(task);

                partnerTaskMappings.add(ptm);
            }
        }

        return partnerTaskMappings;
    }
}

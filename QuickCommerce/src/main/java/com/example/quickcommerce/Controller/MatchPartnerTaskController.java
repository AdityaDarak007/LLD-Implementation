package com.example.quickcommerce.Controller;

import com.example.quickcommerce.dtos.MatchPartnerTaskRequestDto;
import com.example.quickcommerce.dtos.MatchPartnerTaskResponseDto;
import com.example.quickcommerce.dtos.ResponseStatus;
import com.example.quickcommerce.models.PartnerTaskMapping;
import com.example.quickcommerce.services.MatchPartnerTaskService;
import lombok.AllArgsConstructor;

import java.util.List;


@RestController
@AllArgsConstructor
public class MatchPartnerTaskController {
    private MatchPartnerTaskService matchPartnerTaskService;

    public MatchPartnerTaskResponseDto matchPartnersAndTasks(MatchPartnerTaskRequestDto requestDto){
        MatchPartnerTaskResponseDto responseDto = new MatchPartnerTaskResponseDto();

        try{
            List<PartnerTaskMapping> partnerTaskMappingList = matchPartnerTaskService.matchPartnersAndTasks(
                    requestDto.getPartnerIds(),
                    requestDto.getTaskIds());
            responseDto.setPartnerTaskMappings(partnerTaskMappingList);
            responseDto.setResponseStatus(ResponseStatus.SUCCESS);
        }
        catch(Exception e){
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
        }

        return responseDto;
    }
}

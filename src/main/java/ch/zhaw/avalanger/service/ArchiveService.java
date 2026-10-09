package ch.zhaw.avalanger.service;

import org.springframework.stereotype.Service;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.annotation.Transactional;

import ch.zhaw.avalanger.model.Avalange;
import ch.zhaw.avalanger.model.AvalangeState;
import ch.zhaw.avalanger.repository.AvalangeRepository;
import lombok.RequiredArgsConstructor;

@Service 
@RequiredArgsConstructor 
public class ArchiveService {

    private final AvalangeRepository avalangeRepository;

    @Scheduled(cron = "0 0 0 * * *")
    @Transactional
    public void archiveAvalanges() {
        var avalanges = avalangeRepository.findAll();
        avalanges.forEach(avalange -> avalange.setState(AvalangeState.ARCHIVED));
        avalangeRepository.saveAll(avalanges);
    }
    
}

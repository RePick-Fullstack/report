package repick.report.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import repick.report.domain.Report;
import repick.report.repository.ReportRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {

    private final ReportRepository reportRepository;

    @Override
    public List<Report> getLastTenReports() {
        return reportRepository.findTop10ByReportTypeOrderByReportDateDesc(PageRequest.of(0, 10));
    }
}

package repick.report.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import repick.report.domain.Report;
import repick.report.service.ReportService;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/reports")
@RequiredArgsConstructor
public class ReportController {
    private final ReportService reportService;

    @GetMapping
    public List<Report> getLastTenReports() {
        return reportService.getLastTenReports();
    }
}

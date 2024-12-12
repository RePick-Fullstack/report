package repick.report.controller;

import lombok.RequiredArgsConstructor;
import org.bson.json.JsonObject;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import repick.report.domain.CompanyReport;
import repick.report.domain.IndustryReport;
import repick.report.service.ReportService;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/reports")
@RequiredArgsConstructor
public class ReportController {
    private final ReportService reportService;

    @GetMapping("/company")
    public Page<CompanyReport> getLastTenReports(@RequestParam int page, @RequestParam int size) {
        return reportService.getLastTenReports(page, size);
    }

    @GetMapping("/industry")
    public Page<IndustryReport> getIndustryReports(@RequestParam int page, @RequestParam int size) {
        return reportService.getIndustryReports(page, size);
    }

}

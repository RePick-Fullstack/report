package repick.report.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import repick.report.domain.CompanyReport;
import repick.report.domain.IndustryReport;
import repick.report.domain.User;
import repick.report.repository.UserReportRepository;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserReportRepository userReportRepository;

    @Value("${jwt.secret-key}")
    private String jwtSecretKey;

    @Override
    public Long userIdFromToken(String bearerToken) {
        String token = bearerToken.substring(7);
        Claims claims = Jwts.parser()
                .setSigningKey(jwtSecretKey)
                .parseClaimsJws(token)
                .getBody();
        return claims.get("userId", Long.class);
    }


    @Override
    public User getUserByUserId(Long id) {
        System.out.println(id);
        return userReportRepository.findUserByUserId(id.toString());
    }

    @Override
    public Page<String> getPreferredCompaniesByUserId(Long id, int page, int size) {
        User user = userReportRepository.findUserByUserId(id.toString());
        return convertListToPage(user.getPreferredCompanies(), PageRequest.of(page, size));
    }

    @Override
    public Page<String> getPreferredIndustriesByUserId(Long id, int page, int size) {
        User user = userReportRepository.findUserByUserId(id.toString());
        return convertListToPage(user.getPreferredIndustries(), PageRequest.of(page, size));
    }

    @Override
    public Slice<CompanyReport> getCompanyReportsByUserId(Long id, int page, int size) {
        return userReportRepository.findCompanyReportsByUserId(id.toString(), PageRequest.of(page, size));
    }

    @Override
    public Slice<IndustryReport> getIndustryReportsByUserId(Long id, int page, int size) {
        return userReportRepository.findIndustryReportsByUserId(id.toString(), PageRequest.of(page, size));
    }

    @Override
    public Slice<CompanyReport> getBookmarkCompanyReportsByUserId(Long id, int page, int size) {
        return userReportRepository.findBookmarkCompanyReportsByUserId(id.toString(), PageRequest.of(page, size));
    }

    @Override
    public Slice<IndustryReport> getBookmarkIndustryReportsByUserId(Long id, int page, int size) {
        return userReportRepository.findBookmarkIndustryReportsByUserId(id.toString(), PageRequest.of(page, size));
    }

    public static <T> Page<T> convertListToPage(List<T> list, Pageable pageable) {
        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), list.size());

        if (start > list.size()) {
            return new PageImpl<>(List.of(), pageable, list.size());
        }

        List<T> subList = list.subList(start, end);
        return new PageImpl<>(subList, pageable, list.size());
    }
}

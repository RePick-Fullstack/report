package repick.report.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;
import repick.report.domain.CompanyReport;
import repick.report.domain.IndustryReport;
import repick.report.domain.User;
import repick.report.repository.UserReportRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final MongoTemplate mongoTemplate;
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
    public Page<CompanyReport> getCompanyReportsByUserId(Long id, int page, int size) {
        return userReportRepository.findCompanyReportsByUserId(id.toString(), PageRequest.of(page, size));
    }

    @Override
    public Page<IndustryReport> getIndustryReportsByUserId(Long id, int page, int size) {
        return userReportRepository.findIndustryReportsByUserId(id.toString(), PageRequest.of(page, size));
    }
}

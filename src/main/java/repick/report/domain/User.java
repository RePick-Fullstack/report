package repick.report.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "users")
public class User {
    @Id
    private ObjectId id;
    private Long userId;
    private String gender;
    private int age;
    private List<Integer> reports;
    private List<String> preferredIndustries;
    private List<String> preferredCompanies;
    private List<Integer> bookmark;
    private List<Integer> downLoad;
    private List<Integer> recentReports;
    private List<Integer> Company_recommendedReports;
    private List<Integer> Industry_recommendedReports;
}

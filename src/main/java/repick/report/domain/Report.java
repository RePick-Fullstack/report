package repick.report.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "reports")
public class Report {
    @Id
    private ObjectId id;
    private int report_id;
    private String securities_firm;
    private String company_code;
    private String company_name;
    private String report_title;
    private String report_date;
    private String pdf_link;
}

package com.johndoeo.es.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

/**
 * @Auther: JohnDoeo
 * @Date: 2019/7/3 14:12
 * @Description:
 */
@Document(indexName = "job")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Job implements Serializable {
//    private static final long serialVersionUID = 1L;
    @Id
    private Integer id = 100;
    private String jobTitle;
    private String salary;
    private String company;
    private String companyUrl;
    private String hrName;
    private String address;
    private String profession;
    private String publishDate;
}


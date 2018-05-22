package com.base.knowhow.forms;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArticleForm {

    private Date articleDate;

    private String description;

    private String articleName;

    private String title;
}

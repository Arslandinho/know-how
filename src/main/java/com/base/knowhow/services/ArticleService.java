package com.base.knowhow.services;


import com.base.knowhow.forms.ArticleForm;
import com.base.knowhow.models.Article;
import com.base.knowhow.models.User;

import java.util.List;

public interface ArticleService {
    Article createArticle(ArticleForm articleForm, User reviewAuthor);

    List<Article> getAllArticles();

    Article getArticleById(Long id);

    void deleteArticleById(Long id);

    List<Article> findAllByUser(User user);


}

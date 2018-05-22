package com.base.knowhow.services.implementations;

import com.base.knowhow.forms.ArticleForm;
import com.base.knowhow.models.Article;
import com.base.knowhow.models.User;
import com.base.knowhow.repositories.ArticleRepository;
import com.base.knowhow.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public Article createArticle(ArticleForm articleForm, User articleAuthor) {
        Date date = new Date();
        Article newArticle = Article.builder()
                .articleName(articleForm.getArticleName())
                .user(articleAuthor)
                .articleDate(String.valueOf(date))
                .description(articleForm.getDescription())
                .build();
        articleRepository.save(newArticle);
        return newArticle;
    }

    @Override
    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    @Override
    public Article getArticleById(Long id) {
        return articleRepository.getArticleById(id);
    }
}

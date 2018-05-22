package com.base.knowhow.controllers;

import com.base.knowhow.forms.ArticleForm;
import com.base.knowhow.models.Article;
import com.base.knowhow.models.User;
import com.base.knowhow.services.AuthenticationService;
import com.base.knowhow.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @Autowired
    private AuthenticationService authenticationService;

    private List<User> authors = new ArrayList<>();


    @GetMapping("/addArticle")
    public String getPage(Authentication authentication, ArticleForm articleForm) {
        if (authentication==null) {
            return "redirect:/signIn";
        }
        return "article-form";
    }

    @PostMapping("addArticle")
    public String sendArticle(Authentication authentication, ArticleForm articleForm){
        User articleAuthor = authenticationService.getUserByAuthentication(authentication);
        articleService.createArticle(articleForm, articleAuthor);

        return "redirect:/articles";
    }

    @GetMapping("/articles")
    public String getAllArticles(Model model){
        List<Article> allArticles = articleService.getAllArticles();
        model.addAttribute("article", allArticles);

        for (Article article : allArticles){
            User author = article.getUser();
                authors.add(author);
        }
        model.addAttribute("allAuthors",authors);

        return "articles";
    }
    @GetMapping("/article/{id}")
    public String findArticle(@PathVariable("id") Long id, Model model){
        Article article = articleService.getArticleById(id);
        model.addAttribute("article", article);

        return "article";
    }

    @GetMapping("/myArticles")
    public String showPersonalArticles(Authentication authentication,Model model){
        User user = authenticationService.getUserByAuthentication(authentication);
        model.addAttribute("user",user);
        model.addAttribute("article",articleService.findAllByUser(user));
        return "personal-articles";
    }

    @GetMapping("/deleted/{id}")
    public String deletedArticlePage(@PathVariable("id")Long id){
        articleService.deleteArticleById(id);

        return "deleted";
    }
}

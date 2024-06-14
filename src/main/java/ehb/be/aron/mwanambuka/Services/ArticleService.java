package ehb.be.aron.mwanambuka.Services;

import ehb.be.aron.mwanambuka.Models.Article;
import ehb.be.aron.mwanambuka.Repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    public List<Article> getLatestArticles() {
        return articleRepository.findTop10ByOrderByIdDesc();
    }

    public Article getArticleById(Long id) {
        return articleRepository.findById(id).orElse(null);
    }

    public Article saveArticle(Article article) {
        return articleRepository.save(article);
    }
}


package ehb.be.aron.mwanambuka.Repository;

import ehb.be.aron.mwanambuka.Models.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    List<Article> findTop10ByOrderByIdDesc();
}

package ehb.be.aron.mwanambuka.Controllers;

import ehb.be.aron.mwanambuka.Models.Article;
import ehb.be.aron.mwanambuka.Services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("articles", articleService.getLatestArticles());
        return "index";
    }

    @GetMapping("/new")
    public String newArticleForm(Model model) {
        model.addAttribute("article", new Article());
        return "new";
    }

    @PostMapping("/new")
    public String saveArticle(@ModelAttribute Article article, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "new";
        }
        articleService.saveArticle(article);
        return "redirect:/";
    }

    @GetMapping("/details/{id}")
    public String articleDetails(@PathVariable Long id, Model model) {
        model.addAttribute("article", articleService.getArticleById(id));
        return "details";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }
}


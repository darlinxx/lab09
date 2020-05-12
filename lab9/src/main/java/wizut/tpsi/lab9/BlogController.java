package wizut.tpsi.lab9;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class BlogController {
    
    private final BlogRepository blogRepo;
    
    @Autowired        
    public BlogController(BlogRepository blogRepo){
        this.blogRepo = blogRepo;
    }
            
    @RequestMapping("/")
    public String home(Model model) throws SQLException{
        List<BlogPost> blogposts = blogRepo.getAllPosts();
        
        model.addAttribute("post", blogposts);
        return "index.html";

    }
    
    @PostMapping("/newpost") 
    public String newPost(BlogPost post) throws SQLException{
        blogRepo.createPost(post);
        return "redirect:/";
    }
    
    @PostMapping("/deletepost") 
    public String deletePost(@RequestParam Long id) throws SQLException{
        blogRepo.deletePost(id);
        return "redirect:/";
    }
    
    
    
    
}
    

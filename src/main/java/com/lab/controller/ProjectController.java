package com.lab.controller;

import com.lab.pojo.Project;
import com.lab.service.ProjectsService;
import com.lab.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectController {

    @Autowired
    ProjectsService projectsService;

    @Autowired
    JsonUtil jsonUtil;

    /**
     * 获取所有实验室科研项目
     * */
    @GetMapping("/get_all_projects")
    public String getAllProjects () {
        return jsonUtil.getJson(projectsService.selectAllProjects());
    }

    /**
     * 增加一条科研项目
     * */
    @PostMapping("/add_project")
    public int addProject (@RequestBody Project project) {
        return projectsService.addProject(project);
    }

    /**
     * 根据项目名称的前缀查询项目名称
     * 返回所有满足条件的字符串
     * */
    @GetMapping("/search_name")
    public String searchTitle (String key) {
        return jsonUtil.getJson(projectsService.searchName(key));
    }

    /**
     * 搜索科研项目，全文检索
     * 默认将接受到的关键字按2个一组进行分词
     * 返回项目名称，项目类型和主持人的内容中含有分词后关键字的所有科研项目
     * 配置分词器办法：
     * 在MySQL的配置文件中增加 ： ngram_token_size=@{分词数量}
     * */
    @GetMapping("/search_project")
    public String searchProject (String key) {
        return jsonUtil.getJson(projectsService.searchProjects(key));
    }

    /**
     * 删除一条科研项目
     * */
    @PostMapping("/delete_project")
    public int deleteProject (@RequestBody Project project) {
        return projectsService.deleteProject(project);
    }

}

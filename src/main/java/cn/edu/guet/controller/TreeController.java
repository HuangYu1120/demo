package cn.edu.guet.controller;

import cn.edu.guet.bean.Tree;
import cn.edu.guet.dao.ITreeDao;
import cn.edu.guet.dao.impl.TreeDaoImpl;
import cn.edu.guet.mvc.annotaion.Controller;
import cn.edu.guet.mvc.annotaion.RequestMapping;

import java.util.List;

/**
 * @Author liwei
 * @Date 2021-06-24 21:38
 * @Version 1.0
 */
@Controller
public class TreeController {

    ITreeDao treeDao=new TreeDaoImpl();

    /**
     * SpringMVC框架返回Bean的时候，也是默认返回JSON
     * @return
     */
    @RequestMapping("tree/getAllTree.do")
    public List<Tree> getAllTree(){
        return treeDao.getAllTree();
    }
}
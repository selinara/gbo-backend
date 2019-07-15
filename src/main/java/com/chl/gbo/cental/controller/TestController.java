package com.chl.gbo.cental.controller;

import java.util.List;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.chl.gbo.cental.domain.Book;
import com.chl.gbo.cental.domain.Me;
import com.chl.gbo.cental.repository.BookRepository;

@Controller
public class TestController {

    Logger log = LogManager.getLogger(TestController.class);

    @Autowired
    private Me me;

    @Autowired
    private BookRepository bookRepository;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String test(){
        return "我的名字叫"+me.getName()+"，今年"+me.getAge()+"岁，身高"+me.getTall()+"厘米。";
    }

    /**
     * 集合的形式访问同一个控制器
     * @return
     */
    @RequestMapping(value = {"/how","/what"}, method = RequestMethod.GET)
    public String aggregation(){
        return "我的名字叫"+me.getName()+"，今年"+me.getAge()+"岁，身高"+me.getTall()+"厘米。";
    }

    @GetMapping(value = "/bookmall")
    public String findAll(Model model){
        log.info("展示所有的书籍");
        model.addAttribute("booklist", bookRepository.findAll());
        return "book";
    }

    @GetMapping(value = "/bookmall/{id}")
    public Optional<Book> getById(@PathVariable("id") Integer id){
        return bookRepository.findById(id);
    }

    @GetMapping(value = "/book")
    public List<Book> getByName(@RequestParam("name") String name){
        return bookRepository.findByName(name);
    }

}

package jp.ac.ohara.senatyan.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jp.ac.ohara.senatyan.model.GakuseiHyou;
import jp.ac.ohara.senatyan.service.GakuseiService;



@Controller
public class MainController {
	
	@Autowired
	private GakuseiService GakuseiService;
	
	@GetMapping("/")
	public String top(Model model) {
		model.addAttribute("list", this.GakuseiService.getGakuseiList());
		return "top";
	}
	
	
	
	@GetMapping("/add/")
	public ModelAndView add(GakuseiHyou gakuseihyou, ModelAndView model) {
		model.addObject("gakuseihyou", gakuseihyou);
		model.setViewName("add");
		return model;
	}
	
	
	
	@PostMapping("/add/")
	public String add(@Validated @ModelAttribute @NonNull GakuseiHyou gakuseihyou, RedirectAttributes result,ModelAndView model,
			RedirectAttributes redirectAttributes) {
		try {
			this.GakuseiService.save(gakuseihyou);
			redirectAttributes.addFlashAttribute("exception", "");

		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("exception", e.getMessage());
		}
		return "redirect:/";

	}
	
	// 削除を行う
	@GetMapping("/delete")
	public String delete(Model model, GakuseiHyou gakuseihyou) {
			
	    // データベースのデータを削除する
	    GakuseiService.delete(gakuseihyou.getId());

	    // 本の一覧画面にリダイレクト
	    return "redirect:/";
	}
	
	
	// 学生情報の編集機能の追加(のちにedit_student.htmlという編集ページつくる)
	@GetMapping("/top/edit/{id}")
	public String editStudent(@PathVariable Long id, Model model) {
	    GakuseiHyou student = GakuseiService.getStudentById(id);
	    model.addAttribute("student", student);
	    
	    // 入学年度の選択肢を設定(あんま気にしないで)
	    List<Integer> years = Arrays.asList(2014, 2015, 2016, 2017, 2018, 2019, 2020, 2021, 2022, 2023, 2024, 2025, 2026, 2027, 2028, 2029, 2030, 2031, 2032, 2033, 2034);
	    model.addAttribute("years", years);
	    
	    // クラス番号の選択肢を設定(これもあんま気にしないで)
	    List<String> classNumbers = Arrays.asList("101", "102", "103", "104", "105", "201", "202", "203", "204", "205", "301", "302", "303", "304", "305");
	    model.addAttribute("classNumbers", classNumbers);
	    
	    return "edit_student";
	}

}
	
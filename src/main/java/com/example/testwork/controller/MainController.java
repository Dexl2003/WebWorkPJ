package com.example.testwork.controller;

import com.example.testwork.models.SortDB;
import com.example.testwork.repository.sortDbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class MainController {

    @Autowired
    private sortDbRepository sortDbRepository;

    @GetMapping
    public String home(Model model) {
        return "home";
    }

    SortDB sortDB = new SortDB();
    @PostMapping
    public String home(@RequestParam String one) {
        String[] arr = one.split(",");
        int[] qqq = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            qqq[i] = Integer.parseInt(arr[i]);
        }
        //add review fo db
        sortDB = new SortDB(sortArray(qqq));
        sortDbRepository.save(sortDB);
        return "home";
    }

    private int[] sortArray(int[] array) {
        //sort array
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
        return array;
    }

    @GetMapping("/{id}")
    public String sortInfo (@PathVariable(value = "id") long id,Model model) throws ClassNotFoundException {
        Optional<SortDB> sortDB = sortDbRepository.findById(id);
        List<SortDB> res = new ArrayList<>();
        sortDB.ifPresent(res::add);




        //TODO Доделать вывод массива из БД(выводит Java.lang)


        model.addAttribute("arr", res);
//        model.addAttribute("split", qwe);

        return "sort";
    }
}
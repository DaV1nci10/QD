package com.example.HackatonByGreatDevelopers.controllers;

import com.example.HackatonByGreatDevelopers.entity.Phrase;
import com.example.HackatonByGreatDevelopers.entity.SectionBody;
import com.example.HackatonByGreatDevelopers.services.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/firstTest")
@RequiredArgsConstructor
public class TestForMaks {

    private final TestService testService;
    @PostMapping
    public List<Phrase> firstTest(@RequestBody List<SectionBody> sections){
        List<String> list = testService.sectionDelimited(sections.get(0).getText());
        List<Phrase> replie = new ArrayList<>();

        List<String> list2 = new ArrayList<>();
        list2.add("жидкий стул");
        list2.add("жидкий ступор");
        list2.add("жидкий слизень");
        list2.add("высокая температура");
        list2.add("боль в ноге");
        list2.add("боль в жопе");
        for (int i = 0; i < list.size(); i++){
            switch (zzz(list.get(i))){
                case 1:
                    replie.add(new Phrase(list.get(i), false, new ArrayList<>(), true));
                    break;
                case 2:
                    replie.add(new Phrase(list.get(i), true, null, false));
                    break;
                case 3:
                    replie.add(new Phrase(list.get(i), false, list2, false));
                    break;
            }
        }
        return replie;
    }

    public Boolean isMatch(String str){
        List<String> variants = new ArrayList<>();
        variants.add("жидкий стул");
        variants.add("высокая температура");
        variants.add("боль в животе");
        for (int i = 0; i < variants.size(); i++)
        {
            if (str.contains(variants.get(i)))
                return true;
        }
        return false;
    }
    public Boolean isDelimiter(String str){
        if (str.contains(",") | str.contains(".") | str.contains(";") | str.contains(":"))
            return true;
        return false;
    }

    public int zzz(String str){
        if (isDelimiter(str))
            return 1;
        if (isMatch(str))
            return 2;
        return 3;
    }
}

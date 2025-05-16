package com.example.rest.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.HTML;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

@RestController
public class ViewController {
    @GetMapping()
    public String showView() throws FileNotFoundException {
        StringBuilder html_st  = new StringBuilder();
        File html = new File("./src/main/resources/static/index.html");
        Scanner sc = new Scanner(html);
        while(sc.hasNextLine()){
            html_st.append(sc.nextLine());
        }
        return html_st.toString();
    }
    @GetMapping("/vista2")
    public String showView2() throws FileNotFoundException {
        StringBuilder html_st  = new StringBuilder();
        File html = new File("./src/main/resources/static/vista2.html");
        Scanner sc = new Scanner(html);
        while(sc.hasNextLine()){
            html_st.append(sc.nextLine());
        }
        return html_st.toString();
    }
}

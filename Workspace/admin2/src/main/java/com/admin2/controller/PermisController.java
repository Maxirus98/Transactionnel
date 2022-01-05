package com.admin2.controller;

import com.admin2.model.Permis;
import com.admin2.repository.PermisRepository;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

// Controller , n'utilise pas un mapping HTTP (rest)
// utilise MVC, rend des
@Controller
public class PermisController {
    @Autowired
    PermisRepository repository;


//    // SELECT ALL
//    @GetMapping("/all") // chemin url, dans une classe qui s'appel Model, Model de MVC
//    public String getAllPermits(Model model){
//        model.addAttribute("permits", repository.findAll());
//        return "permits"; //Nom de la page html qui s'appelle permits.html
//    }

    @GetMapping("/permits")
    public String getAllPermits(Model model){
        model.addAttribute("permits", repository.findAll());
        return "permits";
    }

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/permits/qrcode/{id}")
    public void showProductImage(@PathVariable int id,
                                 HttpServletResponse response) throws IOException, IOException {
        response.setContentType("image/jpeg"); // Or whatever format you wanna use
        Permis permit = repository.getOne(id);

        InputStream is = new ByteArrayInputStream(permit.getQrCode());
        IOUtils.copy(is, response.getOutputStream());
    }

    @GetMapping("/permits/edit/{id}")
    public String editPermit(Model model, @PathVariable(value = "id") Integer id){
        model.addAttribute("lePermit", repository.findById(id));
        return "edit";
    }

    //Même chose que la valeur de l'attribut action dans la balise form
    @PostMapping("permits")
    public String updatePermis(@Valid Permis permis, BindingResult bindingResult){
        //Meme chose que if formulaire.valid dans angular
        if(bindingResult.hasErrors())
            return "edit";
        else{
            repository.save(permis);
            return "redirect:/";
        }
    }

    @GetMapping("/permits/delete/{id}")
    public String deletePermit(Model model, @PathVariable(value = "id") Integer id){
        repository.deleteById(id);
        return "redirect:/permits";
    }

}

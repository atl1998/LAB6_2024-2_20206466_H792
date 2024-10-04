package com.example.lab6_20206466.controller;
import com.example.lab6_20206466.entity.*;
import com.example.lab6_20206466.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;
@Controller
@RequestMapping("/index")
public class AdminController {
    @Autowired
    DirectorRepository directorRepository;
    @Autowired
    PeliculaRepository peliculaRepository;

    @GetMapping({""})
    public String PaginaPrincipal(Model model) {

        return "/paginaprincipal";
    }
    @GetMapping("/listapeliculas")
    public String listarPeliculas( Model model) {
        List<Pelicula> lista = peliculaRepository.findAll();
        model.addAttribute("listaPeliculas", lista);

        return "listapeliculas";
    }
    @GetMapping("/newpelicula")
    public String nuevaPeliculaFrm(@ModelAttribute("pelicula") Pelicula pelicula, Model model) {

        return "formPelicula";
    }
    @GetMapping("/editpelicula")
    public String editarPelicula(@ModelAttribute("pelicula") Pelicula pelicula, Model model,@RequestParam("id") int id) {
        Optional<Pelicula> optPelicula=peliculaRepository.findById(id);
        if(optPelicula.isPresent()){
           pelicula= optPelicula.get();
           model.addAttribute("pelicula",pelicula);
        }
        return "newPelicula";
    }
    @PostMapping("/savepelicula")
    public String guardarPelicula(@ModelAttribute("pelicula") Pelicula pelicula, RedirectAttributes attr) {
        if(pelicula.getPeliculaid()==0){
            attr.addFlashAttribute("msg","Pelicula creada exitosamente");
        }else{
            attr.addFlashAttribute("msg","Pelicula actualizada exitosamente");
        }
        peliculaRepository.save(pelicula);
        return "redirect:/index/listapeliculas";
    }



}

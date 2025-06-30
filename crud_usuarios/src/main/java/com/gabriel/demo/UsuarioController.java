package com.gabriel.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioRepository repo;

    @GetMapping("/")
    public String listar(Model model) {
        model.addAttribute("usuarios", repo.findAll());
        return "index";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Usuario usuario) {
        repo.save(usuario);
        return "redirect:/";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable int id, Model model) {
        model.addAttribute("usuario", repo.findById(id).get());
        return "formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable int id) {
        repo.deleteById(id);
        return "redirect:/";
    }
}

package com.eduardo.facturadigital.controllers;

import com.eduardo.facturadigital.models.entity.Cliente;
import com.eduardo.facturadigital.models.entity.Factura;
import com.eduardo.facturadigital.models.service.IClienteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Map;
import java.util.Objects;

@Controller
@RequestMapping("/factura")
@SessionAttributes("factura")
public class FacturaController {

    @Autowired
    private IClienteService clienteService;
    private final Logger log = LoggerFactory.getLogger(getClass());
    @GetMapping("/ver/{id]")
    public String ver(@PathVariable(value = "id"), Long id, Model model, RedirectAttributes flash){
        Factura factura = clienteService.findFacturaById(id);

        if (factura == null){
            flash.addFlashAttribute("error", "La factura no existe en la base de datos!");
            return "redirect:/listar";
        }

        model.addAttribute("factura", factura);
        model.addAttribute("titulo", "Factura: ".concat(factura.getDescripcion()));

        return "factura/ver";
    }

    @GetMapping(value = "/form")
    public String crear(@PathVariable(value = "clienteId") Long clienteId, Map<String, Object> model,
                        RedirectAttributes flash) {

        Cliente cliente = clienteService.findOne(clienteId);
        if (cliente == null){
            flash.addFlashAttribute("error", "El cliente no existe en la base de datos");
            return "redirect:/listar";
        }
        Factura factura = new Factura();
        factura.setCliente(cliente);
    }
}

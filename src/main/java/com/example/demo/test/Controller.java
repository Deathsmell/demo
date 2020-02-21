package com.example.demo.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.persistence.EntityManager;
import java.util.List;

@org.springframework.stereotype.Controller
public class Controller{

    @Autowired
    private ClientRepo clientRepo;
    @Autowired
    private MasterRepo masterRepo;

    @GetMapping ("/test0")
    public String test0 (){
        Master master1 = new Master().setName("master").setId(1);
        Master master = masterRepo.save(master1);

        return "redirect:/test/" + master.getId();
    }

    @GetMapping("/test4")
    public String test1 (){


        List<Client> clients = clientRepo.findAll();
        System.err.println(clients);
        Master master = masterRepo.findMasterById(1).setClients(clients);
        System.err.println(master.getClients());


        return "redirect:/test2";
    }

    @GetMapping("/test/{id}")
    public String test (@PathVariable Integer id){
        Master master = masterRepo.findMasterById(id);
        Client client = clientRepo.save(new Client().setName("client").setId(1).setMaster(master));
        Client client3 = clientRepo.save(new Client().setName("client3").setId(2).setMaster(master));
        Client client2 = clientRepo.save(new Client().setName("client2").setId(3).setMaster(master));


//        master.getClients().add(client2);
//        master.getClients().add(client3);
        return "redirect:/test4";
    }

    @GetMapping("/test2")
    public String test2 (Model model){
        Master master = masterRepo.findMasterById(1);
        model.addAttribute("clients", master.getClients());
        return "testpage";
    }

}

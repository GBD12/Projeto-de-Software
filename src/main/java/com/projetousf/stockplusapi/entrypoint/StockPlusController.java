package com.projetousf.stockplusapi.entrypoint;

import com.projetousf.stockplusapi.domain.Cliente;
import com.projetousf.stockplusapi.service.StockPlusService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/stockplus")
@AllArgsConstructor
public class StockPlusController {

    @Autowired
    private StockPlusService stockPlusService;

    @PostMapping("/clientes")
    public ResponseEntity<Cliente> cadastraCliente(@RequestBody Cliente requestBody) {
        Cliente cliente = stockPlusService.createCliente(requestBody);

        return ResponseEntity.ok().body(cliente);
    }

    @GetMapping("/clientes")
    public ResponseEntity<List<Cliente>> getClientes() {
        return ResponseEntity.ok().body(stockPlusService.findAllClientes());
    }

    @GetMapping("/clientes/{id}")
    public ResponseEntity<Cliente> getClientes(@PathVariable Integer id) {
        return ResponseEntity.ok().body(stockPlusService.findClienteById(id));
    }

}

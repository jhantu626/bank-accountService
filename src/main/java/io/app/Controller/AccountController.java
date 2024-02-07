package io.app.Controller;

import io.app.Dto.AccountDto;
import io.app.Service.Impl.AccountServiceImpl;
import io.app.config.Response;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
	@Autowired
	private AccountServiceImpl service;

	//Add Account RestApi
	@PostMapping
	public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto){
		return new ResponseEntity<>(service.createAccount(accountDto), HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<AccountDto> getAccountById(@PathVariable("id") Long id){
		return ResponseEntity.ok(service.getAccountById(id));
	}

	@PutMapping("/{id}/deposit")
	public ResponseEntity<AccountDto> deposit(@PathVariable("id") Long id,@RequestBody Map<String,Double> request){
		double money=request.get("amount");
		return new ResponseEntity<>(service.deposit(id,money),HttpStatus.OK);
	}

	@PutMapping("/{id}/withdraw")
	public ResponseEntity<AccountDto> withdraw(@PathVariable("id") Long id,@RequestBody Map<String,Double> request){
		double ammount=request.get("amount");
		return new ResponseEntity<>(service.withdraw(id,ammount),HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<AccountDto>> getAllAccounts(){
		return ResponseEntity.ok(service.getAllAccounts());
	}

//	@Hidden //it used to hide the endpoints
	@DeleteMapping
	public Response deleteAccount(@RequestParam("id") Long id){
		service.deleteAccount(id);
		return Response.builder()
				.msg("Account Deleted").httpStatus(HttpStatus.OK).build();
	}


}

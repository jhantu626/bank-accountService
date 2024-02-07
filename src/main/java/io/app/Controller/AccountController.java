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

	public ResponseEntity<String> Wecome(){
		return new ResponseEntity<>("Welcome to First Bank",HttpStatus.OK);
	}

	//Add Account RestApi
	@PostMapping
	public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto){
		return new ResponseEntity<>(service.createAccount(accountDto), HttpStatus.CREATED);
	}


	//get Account by id/{it is sending data to service and service is getting data from repository(DAO)}
	@GetMapping("/{id}")
	public ResponseEntity<AccountDto> getAccountById(@PathVariable("id") Long id){
		return ResponseEntity.ok(service.getAccountById(id));
	}


	//This api will be responsible to deposit amount on the bank account
	@PutMapping("/{id}/deposit")
	public ResponseEntity<AccountDto> deposit(@PathVariable("id") Long id,@RequestBody Map<String,Double> request){
		double money=request.get("amount");
		return new ResponseEntity<>(service.deposit(id,money),HttpStatus.OK);
	}

	//this api endpoint will be responsible for withdraw money
	@PutMapping("/{id}/withdraw")
	public ResponseEntity<AccountDto> withdraw(@PathVariable("id") Long id,@RequestBody Map<String,Double> request){
		double ammount=request.get("amount");
		return new ResponseEntity<>(service.withdraw(id,ammount),HttpStatus.OK);
	}

	//this endpoint is helping to get all the accounts holder complete information
	@GetMapping
	public ResponseEntity<List<AccountDto>> getAllAccounts(){
		return ResponseEntity.ok(service.getAllAccounts());
	}

//	@Hidden //it used to hide the endpoints
	//This Endpint is used to close the account
	@DeleteMapping
	public Response deleteAccount(@RequestParam("id") Long id){
		service.deleteAccount(id);
		return Response.builder()
				.msg("Account Deleted").httpStatus(HttpStatus.OK).build();
	}


}

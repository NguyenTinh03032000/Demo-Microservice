package ShopShoeApp.controllers;
import java.util.List;
import java.util.Optional;

import ShopShoeApp.entity.AccountEntity;
import ShopShoeApp.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("account")
public class AccountController {

	@Autowired
	private AccountRepository accountRepository;

	@GetMapping()
	public List<AccountEntity> getAllAccount() {
		return accountRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<AccountEntity> getAccountById(@PathVariable(value = "id") Long id) {
		return accountRepository.findById(id);
	}
	
	@PostMapping()
	public String crateAccount(@RequestBody AccountEntity accountEntity){
		accountRepository.save(accountEntity);
		return "Create successful";
	}
	
	@DeleteMapping("/{id}")
	public String deleteAccount(@PathVariable long id) {
		try {
			AccountEntity account = accountRepository.getById(id);
			accountRepository.delete(account);
			return "Delete successful";
		} catch (Exception e) {
			return "Error";
		}	
	}
}

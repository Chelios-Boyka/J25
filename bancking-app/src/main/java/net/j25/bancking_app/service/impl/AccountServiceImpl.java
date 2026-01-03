package net.j25.bancking_app.service.impl;

import net.j25.bancking_app.dto.AccountDto;
import net.j25.bancking_app.entity.Account;
import net.j25.bancking_app.mapper.AccountMapper;
import net.j25.bancking_app.repository.AccountRepository;
import net.j25.bancking_app.service.AccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = AccountMapper.mapToAccount(accountDto);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto getAccountById(Long id) {

        Account account = accountRepository
                .findById(id)
                .orElseThrow(
                        ()-> new RuntimeException("Account not found"));

        return AccountMapper.mapToAccountDto(account);
    }


}

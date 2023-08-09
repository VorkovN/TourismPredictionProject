package ru.relex.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.relex.entity.Wallet;

public interface WalletDAO extends JpaRepository<Wallet, Long> {

}

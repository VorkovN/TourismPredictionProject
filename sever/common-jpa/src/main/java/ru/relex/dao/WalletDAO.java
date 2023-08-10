package ru.relex.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.relex.entity.Wallet;

@Repository
public interface WalletDAO extends JpaRepository<Wallet, Long> {

}

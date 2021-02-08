package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс реализует банковский сервис
 *
 * @author Vasiliy Novopashin
 * @version 1.0
 */
public class BankService {

    /**
     * Поле типа HashMap хранит всех пользователей системы с привязанными к ним счетами
     */
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает на вход пользователя и добавляет в систему,
     * вслучае если такого пользователя еще нет
     *
     * @param user пользователь который добавляется в users
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод принимает на вход паспорт и счет пользователя,
     * проверяет счета пользователя и если такого счета нет,
     * добавляет новый счет к пользователю.
     *
     * @param passport паспорт пользователя
     * @param account  счет пользователя
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        List<Account> list = users.get(user);
        if (!list.contains(account)) {
            list.add(account);
        }
    }

    /**
     * Метод принимает на вход паспорт по которому ведется поиск пользователя
     *
     * @param passport паспорт пользователя
     * @return возвращает пользователя
     */
    public User findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(user -> passport.equals(user.getPassport()))
                .findFirst()
                .orElse(null);

    }

    /**
     * Метод принимает на вход паспорт и реквизиты по которым ведет поиск счета пользователя
     *
     * @param passport  паспорт
     * @param requisite реквизиты
     * @return возвращает счет
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            return users.get(user)
                    .stream()
                    .filter(account -> requisite.equals(account.getRequisite()))
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

    /**
     * Метод принимает на вход паспорт и реквизиты для получения счета с которого переводят,
     * паспорт и реквизиты для получения счета получателя, а также сумму перевода средств
     *
     * @param srcPassport   паспорт для получения счета списания средств
     * @param srcRequisite  реквизиты для получения счета списания средств
     * @param destPassport  паспорт для получения счета зачисления средств
     * @param destRequisite реквизиты для получения счета зачисления средств
     * @param amount        сумма перевода
     * @return если счет списания или зачисления не найден, а также не достаточно средств,
     * метод вернет false иначе true
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = true;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);

        if (srcAccount == null || destAccount == null || srcAccount.getBalance() < amount) {
            rsl = false;
        }
        srcAccount.setBalance(srcAccount.getBalance() - amount);
        destAccount.setBalance(destAccount.getBalance() + amount);
        return rsl;
    }
}

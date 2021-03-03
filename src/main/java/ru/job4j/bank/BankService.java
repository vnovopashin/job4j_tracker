package ru.job4j.bank;

import java.util.*;

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
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            List<Account> list = users.get(user.get());
            if (!list.contains(account)) {
                list.add(account);
            }
        }
    }

    /**
     * Метод принимает на вход паспорт по которому ведется поиск пользователя
     *
     * @param passport паспорт пользователя
     * @return возвращает пользователя
     */
    public Optional<User> findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(user -> passport.equals(user.getPassport()))
                .findFirst();
    }

    /**
     * Метод принимает на вход паспорт и реквизиты по которым ведет поиск счета пользователя
     *
     * @param passport  паспорт
     * @param requisite реквизиты
     * @return возвращает счет
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        Optional<Account> rsl = Optional.empty();
        if (user.isPresent()) {
            rsl = users.get(user.get())
                    .stream()
                    .filter(account -> requisite.equals(account.getRequisite()))
                    .findFirst();
        }
        return rsl;
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

        Optional<Account> srcAccount = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> destAccount = findByRequisite(destPassport, destRequisite);

        if (srcAccount.isPresent() && destAccount.isPresent()) {
            if (srcAccount.get().getBalance() >= amount) {
                srcAccount.get().setBalance(srcAccount.get().getBalance() - amount);
                destAccount.get().setBalance(destAccount.get().getBalance() + amount);
                return true;
            }
        }
        return false;
    }
}

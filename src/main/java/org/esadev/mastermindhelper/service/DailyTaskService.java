package org.esadev.mastermindhelper.service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import org.springframework.stereotype.Service;

@Service
public class DailyTaskService {

  private static final Map<Integer, String> DAILY_TASKS = new HashMap<>();
  private final Set<Integer> usedTasks = new HashSet<>();


  public DailyTaskService() {
    DAILY_TASKS.put(0,
            "Виділіть 15 хвилин для медитації або практики уваги. Можна використовувати додатки, наприклад, Headspace чи Calm, якщо потрібно.");
    DAILY_TASKS.put(1, "Складіть список трьох речей, які ви хочете досягти у своїй кар'єрі протягом наступних 5 років.");
    DAILY_TASKS.put(2, "Пройдіться до звичного вам місця (магазину, офісу, кав'ярні) новим маршрутом. Звертайте увагу на речі навколо.)");
    DAILY_TASKS.put(3, "Послухайте подкаст, що НЕ стосується кар'єри, поділіться з рештою, якщо вам сподобався випуск");
    DAILY_TASKS.put(4, "Виконайте 5-хвилинну розминку за робочим столом для розтягнення і розслаблення м'язів.");
    DAILY_TASKS.put(5,
            "Поділіться загадкою або головоломкою з групою. Людина, яка першою її вирішить, отримає +10% до свого тижневого прогресу по цілям цілям \uD83D\uDE03!");
    DAILY_TASKS.put(6,
            "Сьогодні - групове завдання! Зробіть всі разом міні-фітнес-завдання, наприклад, 50 присідань або утримання планки протягом 1 хв. Спорт - це сила!");

    DAILY_TASKS.put(7, "Порекомендуйте книгу або статтю, яка склала велике враження на вас.");
    DAILY_TASKS.put(8,
            "Приділіть декілька хвилин, щоб налаштувати своє робоче місце для кращої ергономіки. Поділіться порадами щодо комфортного організації робочого місця.");
    DAILY_TASKS.put(9, "Відведіть 15 хвилин на глибоке дихання для розслаблення і фокусування розуму.");
    DAILY_TASKS.put(10,
            "Пообіцяйте собі після 20:00 не користуватися телефоном, ноутбуком або телевізором для відпочинку очей та покращення якості сну.");
    DAILY_TASKS.put(11,
            "Проведіть обід без будь-яких технологічних відволікаючих чинників — ні телефонів, ноутбуків чи телевізорів. Сконцентруйтеся на смаку їжі та більше уваги моменту.");
  }

  public String choose() {
    Integer randIndx = ThreadLocalRandom.current().nextInt(DAILY_TASKS.size());
    while (usedTasks.contains(randIndx)) {
      randIndx = ThreadLocalRandom.current().nextInt(DAILY_TASKS.size());
    }
    if (LocalDate.now().equals(LocalDate.of(2023, 12, 31))) {
      return "Вітаю, останнє завдання! Ти провів потужний рік, тому на сьогодні головне завдання - відпочити і набратися сил на наступний рік!";
    }

    usedTasks.add(randIndx);
    return DAILY_TASKS.get(randIndx);
  }
}

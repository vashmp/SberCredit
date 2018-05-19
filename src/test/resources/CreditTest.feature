#language: ru
Функционал: Кредитование

  Сценарий: Кредит
    Когда выбран пункт меню "Взять кредит" и подпункт меню "Приобретение готового жилья"
    И выбран рассчет ипотеки
    Тогда проверен заголовок на соответствие "Онлайн консультация и одобрение ипотеки без визита в офис банка"

    Когда заполняются поля:
      |Цель кредита|Покупка квартиры в новостройке|
      |Стоимость недвижимости|6000000|
      |Первоначальный взнос|3000000|
      |Срок кредита|10|

    И Отмечается чекбокс "Страхование жизни"
    И Отмечается чекбокс "Скидка от застройщика"

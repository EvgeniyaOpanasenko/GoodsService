# GoodsService

Общая постановка

Необходимо создать RESTful сервис, который будет отвечать на запросы о наличии, количестве и ценах товара.

Технические условия

–	JBOSS7
–	JEE
–	Использование паттернов проектирования
–	Данные о наличии товаров — в хранилище Redis
–	Ответ — в формате JSON

Структура хранимых данных

Считается, что данные в Redis уже есть. Как они туда попали — не имеет значения, достаточно создать тестовый набор с данными из 10-20 записей. Сами данные значения не имеют.

Храним следующие данные
–	id продукта (unsigned integer, уникальный)
–	mpn продукта (manufacturer part number, string(30), уникальный)
–	предложения от магазина
–	id магазина (unsigned integer)
–	цена товара в евро (decimal 10,2)
–	наличие на складе ( enumerated list: 0 – нет, 1 — мало, 2 - достаточно)

Структура входных запросов

http://localhost/restful.api/getprice?
	mpn=<MPN>
	&availability=<AVAILABILITY FILTER>
	&pricesort=<PRICE SORT>

Описание параметров

MPN – обязательный параметр запроса
Идентификатор товара, запрос данных о товаре по конкретному MPN

availability — необязательный параметр. Дефолт значение = 0
Может принимать следующие значения
availability
	=0 – не фильтровать данные
	=1 — показать товары у которых наличие МАЛО или ДОСТАТОЧНО
	=2 — показать товары у которых наличие ДОСТАТОЧНО

pricesort – необязательный параметр, дефолт значение — 0
Может принимать следующие значения
pricesort
	=0 – не сортировать преложения по цене
	=1 сортировать предложения по возрастанию цены
	=2 сортировать предложения по убыванию цены


Валидация параметров

1.	не валидные значения параметров
Если хотя бы один из параметров несоответственен требованиям выше необходимо выдать ошибку и указать причину останова.
2.	Если запрашиваемый mpn не обнаружен — выдать соответствующее сообщение

Выходной формат

{
  "mpn": "SA-12KP",
  "status": "OK",
  "id": 19,
  "array": [
    {
      "id": 17,
      "price": "183.91",
      "stock": "0"
    },
    {
      "id": 11,
      "price": "192.90",
      "stock": "1"
    },
    {
      "id": 19,
      "price": "199.12",
      "stock": "2"
    }
  ]
}

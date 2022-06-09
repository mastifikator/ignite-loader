Данная утилита позволяет обращаться к cache Apache Ignite и запрашивать у него значения по ключу
Результирующий jar с зависимостями находится в папке target (ignite-loader.jar)

Пример использования:
java -jar ignite-loader.jar 172.16.1.1 PersonCache 1

Где:
172.16.1.1 - IP адрес Apache Ignite
PersonCache - название таблицы в Apache Ignite
1 - значение ключа по которому будет запрошено значение

Пример успешного вывода:
Connected to Ignite on: 172.16.1.1
Connected to table: PersonCache
Cache size before operation: 1
Result query key 1 is aNike5
Time elapsed query: 25
Cache size after operation: 1

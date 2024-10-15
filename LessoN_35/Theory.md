Complexity
Понятие Complexity (вычислительная сложность), позволяет оценить эффективность алгоритмических решений. 
Простым языком можно сказать, что вычислительная сложность говорит, пропорционально какой функции растет 
количество действий при обработке множества элементов, если увеличивать количество элементов этого множества.

Для описания вычислительной сложности используется т. н. "Big O notation". Например, запись O(n) говорит 
о линейной сложности алгоритма. А запись O(log(n)), характеризует логарифмическую сложность.

Java Collection Framework (JCF)
Java Collection Framework (JCF) - множество классов и интерфейсов которые реализуют наиболее часто 
используемые структуры данных. JCF состоит из двух больших подразделов: Map и Collection. Мы начинаем 
наше изучение с коллекций.

Интерфейс Collection расширяет интерфейс Iterable, т. е. все коллекции итерируемые. Интерфейс Collection 
определяет некоторый основной набор методов для работы с коллекциями данных. Например: добавление, удаление, 
поиск, получение количества элементов в коллекции и т. д.

Есть большое количество интерфейсов расширяющих интерфейс Collection. Мы рассмотрим интерфейсы Set и List. 
И начнем с интерфейса List.

Интерфейс List (список) определяет коллекции элементы которых имеют индексы, т. е. некий аналог массива, 
но не имеющий ограничения по размеру. Соответственно в интерфейсе List, помимо методов унаследованных от 
Iterable и Collection, определены методы работающие с индексами. Например, вставка элемента списка по индексу, 
удаление по индексу, получение элемента по индексу, поиск индекса заданного элемента и т. п.

Одной из имплементаций интерфейса List является класс ArrayList. Для реализации функциональности интерфейса 
List, ArrayList инкапсулирует в себе массив некоторого начального размера - 10 элементов. Когда этот массив 
полностью заполняется, то его элементы копируются в новый массив, но уже большего размера. И теперь ждем когда 
заполнится новый массив. И т. д. Т. е. говоря простым языком, ArrayList представляет из себя "резиновый массив".

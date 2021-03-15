# SF

# Поддерживаются следующие алгоритмы шифрования
<li>
Энигма

[Автор реализации https://github.com/Gurf](https://github.com/Gurf)

>Оригинальная Enigma кодирует латинскими буквами в Caps Lock без пробелов, знаков препинания и цифр;
Ключ для оригинальной Энигмы - любые 3 латинские буквы в Caps Lock
>Алфавит Энигмы M3 раcширен, добавлены цифры, кирилица, пробел, знаки препинания
и многие символы, также добавлена латиница в строчном регистре
(оригинальная Энигма работала в прописном регистре).
Код Энигмы - любые 3 знака из ее нового алфавита.
Алфавит расширенной Энигмы: " !"#$%&\'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~«»АБВГДЕЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯабвгдежзийклмнопрстуфхцчшщъыьэюя–"
</li>

<li>
Шифр Атбаша

[Автор реализации https://github.com/ChapaevAnton](https://github.com/ChapaevAnton)

>Самый-самый простой шифр. Его суть – переворот алфавита с ног на голову.
</li>

<li>
Шифр Andrew

[Автор реализации https://github.com/Quertte](https://github.com/Quertte)

>Простейший шифр собственной разработки на основе бинарной логики. На основании строки ключа создается целочисленная переменная
> которая в дальнейшем побитово складывается с каждым символом шифруемой строки.
</li>

<li>
Шифр Вернама (XOR-шифр)

[Автор реализации https://github.com/Gurf](https://github.com/Gurf)

>Простейший шифр на основе бинарной логики, который обладает абсолютной криптографической стойкостью. Без знания ключа, расшифровать его невозможно (доказано Клодом Шенноном).
> Используется побитовое сложение ("исключающее или") шифруемой/расшифруемой строки
> со строкой ключа. В идеале длина строки ключа должна быть равна длине шифруемой/расшифруемой строки. При коротком ключе, знаки ключа используются "по кругу"
> до тех пор, пока не будет достигнут конец шифруемой/расшифруемой строки.
</li>


***Для разработчиков:***

Абстрактный класс `EncryptString` - от которого можно пронаследоваться в ваш класс шифрования, всего лишь нужно реализовать абстрактные методы алгоритма шифрования и дешифровки...

//алгоритм шифровки

```abstract String encryptionAlgorithm(String text, String encryptKey);```

//алгоритм дешифровки

```abstract String decryptionAlgorithm(String text, String encryptKey);```

Зашифрованная строка типа `EncryptingString` создается на основе данных `String`.

`EncryptingString <name> = CreatingString.<type>.toCreate(<String>);`
Данная строка содержит собственно саму строку(на основе которой она создана), а так же служебную информацию о применяемом алгоритме шифрования, текущем статусе(зашифрована или нет) и дата/время последнего изменения. Так же строку можно преобразовать в `String`(с потерей дополнительной служебной информации).

Далее после создания объекта вашей строки использовать интерфейс `EncryptingString` и его методы для шифровки и дешифровки строк, которые по умолчанию вызывают алгоритм шифровки и дешифровки - соблюдая некоторые условия - нельзя зашифровать то что уже зашифровано или нельзя расшифровать то что не зашифровано, но ничего не мешает их переопределить...в своем производном классе.

//шифровка текста с ключом
```EncryptString encrypt(String encryptKey);```

//дешифровка текста с ключом

```EncryptString deEncrypt(String encryptKey);```

//служебная информация

```void getStrInfo();```

//перевод в String

```String toString();```
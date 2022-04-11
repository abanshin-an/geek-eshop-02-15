SET search_path TO "geekbrains";

INSERT INTO category (id,name)
VALUES (1,'Смартфоны')
     ,(2,'Ноутбуки')
     ,(3,'Планшеты')
     ,(4,'МФУ')
     ,(5,'Мониторы')
     ;


INSERT INTO product (id, price, name, category_id,description)
VALUES( 1,	109990,'iPhone 13 Pro',         1,'Топовая модель в линейке флагманских смартфонов Apple 2021 года. Релиз новинки состоялся 14 сентября, старт продаж — 24 сентября 2021')
     ,( 2,	 35365,'Samsung Galaxy S21',     1, 'Смартфон Samsung Galaxy S21 5G оснащен AMOLED-дисплеем (Dynamic AMOLED 2X) с диагональю 6,2 дюйма и разрешением 1080×2400, с самым современным стеклом Corning Gorilla Glass Victus')
     ,( 3,	 50000,'Xiaomi 11T',             1,'Оснащается плоским 6,67-дюймовым AMOLED дисплеем разрешением 2400 х 1080. Сенсорный экран считывает касания на частоте 480 Гц, а картинка обновляется на частоте 120 Гц')
     ,( 4,	 19544,'TrustPhone Т1',          1,'Cнабжен HD-экраном на 6,56 дюйма с защитным стеклом GorillaGlass 3. Модель оснащена основной двойной камерой с модулями на 12 и 5 мегапикселей, а также фронтальной камерой на 13 мегапикселей. Литий-полимерный аккумулятор имеет емкость 4000 мАч. Интегрирован модуль NFC для бесконтактной оплаты услуг. Объем оперативной памяти заявлен на уровне 4 ГБ.')
     ,( 5,	147990,'iPad Pro Max',          2,'12,9-дюймовый iPad Pro 2021 года с процессором M1 и 16 ГБ оперативной памяти.')
     ,( 6,	 13499,'Lenovo Tab M10',         2,'Процессор, Snapdragon 429, Хелио Р22Т ; Память, Гб, 2/32')
     ,( 7,	 84824,'Aquarius Cmp NS208',     2,'Планшетный компьютер с диагональю 8'''' в пылевлагозащитном корпусе усиленной конструкции. Пылевлагозащитная конструкция по критериям IP67')
     ,( 8,	 45890,'Samsung Galaxy Tab S8',  2,'11-дюймовым LTPS TFT-дисплеем с частотой обновления 120 Гц. Девайс получит батарею на 8000 мА*ч с функцией быстрой зарядки')
     ,( 9,	334990,'Macbook Pro',           3,'На базе M1 Max c 10 ядрами CPU и 32 ядрами GPU, а также с 64 ГБ объединенной памяти')
     ,(10,  1499990,'HP Envy 17',          3,'17-дюймовых ноутбук HP Envy 17-j000 на базе процессоров Intel Core четвертого поколения (Haswell)')
     ,(11,	 711991,'Dell Inspiron 5505',   3,'Отличный выбор для решения домашних задач. Жидко-кристаллическая WVA+ матрица с диагональю 15.6” и разрешением 1920х1080 имеет матовое покрытие, отлично отображает графику и текст. Современный 8 ядерный процессор AMD Ryzen 7 4700U с тактовой частотой 2000 Мгц обеспечивает достаточную производительность с невысоким энергопотреблением. В базовой комплектации установлено 8 Гб памяти DDR4 non-ECC которую, в случае необходимости, можно расширить. Ноутбук оснащен накопителем SSD 512Gb, который обеспечивает надежное хранение и быстрый доступ к программам, документам и фотографиям. Видеокарта AMD Radeon HD. Корпус выполнен из металла. Вес ноутбука 1.7 кг')
     ,(12,	5568002,'Lenovo ThinkPad P17 Gen 2',3,'Самый производительный (на момент выхода осенью 2021 года) ноутбук для профессиональных задач в модельном ряду производителя.')
     ,(13,	2749903,'HP Color LaserJet Enterprise M681dh',4,'МФУ HP Color LaserJet с технологией JetIntelligence сочетает в себе исключительную производительность, пониженное энергопотребление и надежную печать документов профессионального качества, при этом защищая вашу сеть с помощью лучших средств обеспечения безопасности HP.')
     ,(14,	 622544,'Canon i-SENSYS LBP351X',4,'Высокопроизводительные решения для печати необходимы компаниям, которым важен высокий уровень производительности и возможность настройки черно-белых лазерных принтеров.')
     ,(15,	 531185,'HP LaserJet Pro MFP M426fdn',4,'Надежный и практичный аппарат компактных габаритов, который оптимально подходит для компаний среднего размера. Он обеспечивает качественное сканирование необходимых документов и высокоскоростную печать, в том числе на бумаге формата A3.')
     ,(16,	 804796,'Xerox B1025V_U',        4,'Надежный и практичный аппарат компактных габаритов, который оптимально подходит для компаний среднего размера. Он обеспечивает качественное сканирование необходимых документов и высокоскоростную печать, в том числе на бумаге формата A3.')
     ,(17,	3348907,'DELL UltraSharp UP3221Q',5,'Первый монитор с подсветкой mini-LED, разделённой на 2000 зон. Для монитора заявлен охват цветового пространства DCI-P3 на 99,8%, а Adobe RGB — на 93%&')
     ,(18,	1437808,'Samsung S49AG950NI',   5,'Размер экрана 49 ". Разрешение экрана 5120x1440. Частота обновления 240 Гц. Соотношение сторон экрана 32:9. Тип матрицы VA. Яркость экрана 420 кд/м2. Время отклика (GTG) 1 мс')
     ,(19,	 697809,'LG UltraGear 34GN850-B',5,'Игровой монитор UltraGear 34GN850-B, в котором используется 34-дюймовая изогнутая панель Nano-IPS производства LG Display Разрешение — UWQHD (3440 x 1440 пикселей)')
     ,(20,	 750100,'HP Z43',               5,'Модель с диагональю 42.5" и разрешением 3840x2160 пикселей (Ultra HD (UHD) / 4K / 2160p). Тип матрицы - IPS с подсветкой W-LED. Максимальная яркость - 350 кд/м2, а углы обзора 178 градусов по горизонтали и 178 градусов по вертикали.');

-- INSERT INTO price (product_id, price_date, price_value)
-- VALUES (1, LOCALTIMESTAMP,	109990) --+'iPhone 13 Pro', 'Топовая модель в линейке флагманских смартфонов Apple 2021 года. Релиз новинки состоялся 14 сентября, старт продаж — 24 сентября 2021'	)
--       ,(2, LOCALTIMESTAMP,	 35365) --+'Samsung Galaxy S21','Смартфон Samsung Galaxy S21 5G оснащен AMOLED-дисплеем (Dynamic AMOLED 2X) с диагональю 6,2 дюйма и разрешением 1080×2400, с самым современным стеклом Corning Gorilla Glass Victus',	35365	)
--       ,(3, LOCALTIMESTAMP,	 50000) --+'Xiaomi 11T','Оснащается плоским 6,67-дюймовым AMOLED дисплеем разрешением 2400 х 1080. Сенсорный экран считывает касания на частоте 480 Гц, а картинка обновляется на частоте 120 Гц',	50000	)
--       ,(4, LOCALTIMESTAMP,	 19544) --'+TrustPhone Т1','Cнабжен HD-экраном на 6,56 дюйма с защитным стеклом GorillaGlass 3. Модель оснащена основной двойной камерой с модулями на 12 и 5 мегапикселей, а также фронтальной камерой на 13 мегапикселей. Литий-полимерный аккумулятор имеет емкость 4000 мАч. Интегрирован модуль NFC для бесконтактной оплаты услуг. Объем оперативной памяти заявлен на уровне 4 ГБ.',	19544	)
--       ,(5, LOCALTIMESTAMP,	147990) --'+iPad Pro Max','12,9-дюймовый iPad Pro 2021 года с процессором M1 и 16 ГБ оперативной памяти.',	147990	)
--       ,(6, LOCALTIMESTAMP,	 13499) --'+Lenovo Tab M10','Процессор, Snapdragon 429, Хелио Р22Т ; Память, Гб, 2/32',	13499	)
--       ,(7, LOCALTIMESTAMP,	 84824) --'+Aquarius Cmp NS208','Планшетный компьютер с диагональю 8'''' в пылевлагозащитном корпусе усиленной конструкции. Пылевлагозащитная конструкция по критериям IP67',	84824	)
--       ,(8, LOCALTIMESTAMP,	 45890) --'+Samsung Galaxy Tab S8','11-дюймовым LTPS TFT-дисплеем с частотой обновления 120 Гц. Девайс получит батарею на 8000 мА*ч с функцией быстрой зарядки',	45890	)
--       ,(9, LOCALTIMESTAMP,	334990) --'+Macbook Pro','На базе M1 Max c 10 ядрами CPU и 32 ядрами GPU, а также с 64 ГБ объединенной памяти',	334990	)
--       ,(10,LOCALTIMESTAMP,  149999) --'+HP Envy 17','17-дюймовых ноутбук HP Envy 17-j000 на базе процессоров Intel Core четвертого поколения (Haswell)',	149999	)
--       ,(11,LOCALTIMESTAMP,	 71199) --'+Dell Inspiron 5505','Отличный выбор для решения домашних задач. Жидко-кристаллическая WVA+ матрица с диагональю 15.6” и разрешением 1920х1080 имеет матовое покрытие, отлично отображает графику и текст. Современный 8 ядерный процессор AMD Ryzen 7 4700U с тактовой частотой 2000 Мгц обеспечивает достаточную производительность с невысоким энергопотреблением. В базовой комплектации установлено 8 Гб памяти DDR4 non-ECC которую, в случае необходимости, можно расширить. Ноутбук оснащен накопителем SSD 512Gb, который обеспечивает надежное хранение и быстрый доступ к программам, документам и фотографиям. Видеокарта AMD Radeon HD. Корпус выполнен из металла. Вес ноутбука 1.7 кг',	71199	)
--       ,(12,LOCALTIMESTAMP,	556800) --'+Lenovo ThinkPad P17 Gen 2','Самый производительный (на момент выхода осенью 2021 года) ноутбук для профессиональных задач в модельном ряду производителя.',	556800	)
--       ,(13,LOCALTIMESTAMP,	274990) --'+HP Color LaserJet Enterprise M681dh','МФУ HP Color LaserJet с технологией JetIntelligence сочетает в себе исключительную производительность, пониженное энергопотребление и надежную печать документов профессионального качества, при этом защищая вашу сеть с помощью лучших средств обеспечения безопасности HP.',	274990	)
--       ,(14,LOCALTIMESTAMP,	 62254) --'+Canon i-SENSYS LBP351X','Высокопроизводительные решения для печати необходимы компаниям, которым важен высокий уровень производительности и возможность настройки черно-белых лазерных принтеров.',	62254	)
-- 	  ,(15,LOCALTIMESTAMP,	 53118) --'+HP LaserJet Pro MFP M426fdn','Надежный и практичный аппарат компактных габаритов, который оптимально подходит для компаний среднего размера. Он обеспечивает качественное сканирование необходимых документов и высокоскоростную печать, в том числе на бумаге формата A3.',	53118	)
--       ,(16,LOCALTIMESTAMP,	 80479) --'+Xerox B1025V_U','Надежный и практичный аппарат компактных габаритов, который оптимально подходит для компаний среднего размера. Он обеспечивает качественное сканирование необходимых документов и высокоскоростную печать, в том числе на бумаге формата A3.',	80479	)
--       ,(17,LOCALTIMESTAMP,	334890) --+'DELL UltraSharp UP3221Q','Первый монитор с подсветкой mini-LED, разделённой на 2000 зон. Для монитора заявлен охват цветового пространства DCI-P3 на 99,8%, а Adobe RGB — на 93%&',	334890	)
--       ,(18,LOCALTIMESTAMP,	143780) --+'Samsung S49AG950NI','Размер экрана 49 ". Разрешение экрана 5120x1440. Частота обновления 240 Гц. Соотношение сторон экрана 32:9. Тип матрицы VA. Яркость экрана 420 кд/м2. Время отклика (GTG) 1 мс',	143780	)
--       ,(19,LOCALTIMESTAMP,	 69780) --+'LG UltraGear 34GN850-B','Игровой монитор UltraGear 34GN850-B, в котором используется 34-дюймовая изогнутая панель Nano-IPS производства LG Display Разрешение — UWQHD (3440 x 1440 пикселей)',	69780	)
--       ,(20,LOCALTIMESTAMP,	 75010) --+'HP Z43','Модель с диагональю 42.5" и разрешением 3840x2160 пикселей (Ultra HD (UHD) / 4K / 2160p). Тип матрицы - IPS с подсветкой W-LED. Максимальная яркость - 350 кд/м2, а углы обзора 178 градусов по горизонтали и 178 градусов по вертикали.',	75010	);
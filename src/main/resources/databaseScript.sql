DROP TABLE goods;
DROP TABLE manufactures;
DROP TABLE categories;

CREATE TABLE categories (
  c_id BIGINT PRIMARY KEY,
  c_name VARCHAR(256) UNIQUE,
  p_id BIGINT NOT NULL DEFAULT 0
);

CREATE TABLE manufactures (
  m_id BIGINT PRIMARY KEY,
  m_name VARCHAR(256) UNIQUE
);

CREATE TABLE goods (
  g_id BIGINT PRIMARY KEY,
  g_name VARCHAR(256),
  c_id BIGINT REFERENCES categories(c_id),
  m_id BIGINT REFERENCES manufactures(m_id),
  g_price INTEGER NOT NULL,
  g_description VARCHAR(1024) NOT NULL DEFAULT 'There is no description for this good',
  g_avail CHAR(1) CHECK(g_avail IN ('y', 'n')),
  g_img VARCHAR(256) NOT NULL
);


INSERT INTO "public"."categories" (c_id,c_name,p_id) VALUES (32,'Phones and tablets',0);
INSERT INTO "public"."categories" (c_id,c_name,p_id) VALUES (33,'Smartphone',32);
INSERT INTO "public"."categories" (c_id,c_name,p_id) VALUES (22,'TV',0);
INSERT INTO "public"."categories" (c_id,c_name,p_id) VALUES (23,'SmartTV',22);
INSERT INTO "public"."categories" (c_id,c_name,p_id) VALUES (24,'SimpleTV',22);
INSERT INTO "public"."categories" (c_id,c_name,p_id) VALUES (25,'Mobile phone',32);
INSERT INTO "public"."categories" (c_id,c_name,p_id) VALUES (26,'Tablets',32);

INSERT INTO "public"."manufactures" (m_id,m_name) VALUES (31,'Samsung');
INSERT INTO "public"."manufactures" (m_id,m_name) VALUES (32,'Asus');
INSERT INTO "public"."manufactures" (m_id,m_name) VALUES (33,'HTC');
INSERT INTO "public"."manufactures" (m_id,m_name) VALUES (34,'LG');
INSERT INTO "public"."manufactures" (m_id,m_name) VALUES (35,'Sony');
INSERT INTO "public"."manufactures" (m_id,m_name) VALUES (36,'Philips');
INSERT INTO "public"."manufactures" (m_id,m_name) VALUES (37,'Nokia');
INSERT INTO "public"."manufactures" (m_id,m_name) VALUES (39,'Fly');
INSERT INTO "public"."manufactures" (m_id,m_name) VALUES (40,'Apple');
INSERT INTO "public"."manufactures" (m_id,m_name) VALUES (41,'Lenovo');


INSERT INTO "public"."goods" (g_id,g_name,c_id,m_id,g_price,g_description,g_avail,g_img) VALUES (31,'Samsung Galaxy S6 SS 32GB G920',33,31,15999,'Экран (5.1", Super AMOLED, 2560х1440)/ Samsung Exynos 7420 (Quad 2.1 ГГц + Quad 1.5 ГГц)/ основная камера: 16 Мп, фронтальная камера: 5 Мп/ RAM 3 ГБ/ 32 ГБ встроенной памяти/ 3G/ LTE/ GPS/ Nano-SIM/ Android 5.0 (Lollipop) / 2550 мА*ч','y','samsung_galaxy_s6_ss_32_g920_black_images_451361987.jpg');
INSERT INTO "public"."goods" (g_id,g_name,c_id,m_id,g_price,g_description,g_avail,g_img) VALUES (32,'LG Google Nexus 5X 16GB Mint',33,34,11289,'Экран (5.2", IPS, 1920x1080)/ Qualcomm Snapdragon 808 (1.8 ГГц)/ основная камера: 12.3 Мп, фронтальная камера: 5 Мп/ RAM 2 ГБ/ 16 ГБ встроенной памяти/ GPS/ Nano-SIM/ Android 6.0 Marshmallow/ 2700 мА*ч','y','lg_google_nexus_5x_16gb_mint_images_1391363919.jpg');
INSERT INTO "public"."goods" (g_id,g_name,c_id,m_id,g_price,g_description,g_avail,g_img) VALUES (33,'Sony Xperia Z5 Compact Black',33,35,17499,'Экран (4.6", IPS, 1280x720)/ Qualcomm Snapdragon 810 MSM8994 (Quad 2 ГГц + Quad 1.5 ГГц)/ основная камера: 23 Мп, фронтальная камера: 5 Мп/ RAM 3 ГБ/ 32 ГБ встроенной памяти + microSD/SDHC (до 200 ГБ)/ 3G/ LTE/ GPS/ Nano-SIM/ Android 5.1 (Lollipop) / 2700 мА*ч','y','sony_xperia_compact_z5_black_images_1271526199.jpg');
INSERT INTO "public"."goods" (g_id,g_name,c_id,m_id,g_price,g_description,g_avail,g_img) VALUES (34,'HTC One M9 Gold on Silver',33,33,16999,'Металлический корпус с зеркальной окантовкой. Скругленные углы и эргономичные формы – этот смартфон создан повторять контуры твоей руки и обеспечивать максимальный комфорт. Цельная задняя панель имеет изогнутую поверхность, ставшую визитной карточкой легендарных смартфонов серии HTC One.','n','htc_one_m9_gold_on_silver_images_455787647.jpg');
INSERT INTO "public"."goods" (g_id,g_name,c_id,m_id,g_price,g_description,g_avail,g_img) VALUES (35,'LG Google Nexus 5X 32GB Black',33,34,13999,'Nexus 5X оснащен 5.2-дюймовым 423 Full HD IPS дисплеем (423 ppi) с улучшенной технологией In-Cell Touch. Такое устройство быстрее реагирует на касание, и изображение на экране остается четким даже при ярком освещении. Благодаря процессору Qualcomm Snapdragon 808 Nexus 5X справляется с самыми сложными задачами.','n','lg_google_nexus_5x_32gb_black_images_1426652841.jpg');
INSERT INTO "public"."goods" (g_id,g_name,c_id,m_id,g_price,g_description,g_avail,g_img) VALUES (36,'HTC Desire 310 Dual Sim Navy',33,33,2199,'Экран (4.5", TFT, 854x480)/ MediaTek MT6582M (1.3 ГГц)/ основная камера: 5 Мп, фронтальная камера: 0.3 Мп/ RAM 1 ГБ/ 4 ГБ встроенной памяти + microSD/SDHC (до 32 ГБ)/ 3G/ GPS/ поддержка 2х SIM-карт (Mini-SIM)/ Android 4.2 (Jelly Bean)/ 2000 мА*ч','y','htc_desire_310_dual_sim_navy_uacrf_images_58259624.jpg');

INSERT INTO "public"."goods" (g_id,g_name,c_id,m_id,g_price,g_description,g_avail,g_img) VALUES (37,'Sony KDL-43W805C',23,35,18999,'Диагональ экрана: 43" Поддержка Smart TV: Есть Разрешение: 1920x1080 Wi-Fi: Да Диапазоны цифрового тюнера: DVB-S2, DVB-S, DVB-C, DVB-T2, DVB-T Частота обновления: 800 Гц (MotionFlow)','y','sony_kdl_43w805csr2_images_981481534.jpg');
INSERT INTO "public"."goods" (g_id,g_name,c_id,m_id,g_price,g_description,g_avail,g_img) VALUES (38,'Philips 32PFH5500/88',23,36,9599,'Диагональ экрана: 32" Поддержка Smart TV: Есть Разрешение: 1920x1080 Wi-Fi: Да Диапазоны цифрового тюнера: DVB-C, DVB-T Частота обновления: 200 Гц (PMR)','y','philips_32pfh5500_88_images_877878911.jpg');
INSERT INTO "public"."goods" (g_id,g_name,c_id,m_id,g_price,g_description,g_avail,g_img) VALUES (39,'Sony KD-43X8305C',23,35,27899,'Диагональ экрана: 43" Поддержка Smart TV: Есть Разрешение: 3840x2160 Wi-Fi: Да Диапазоны цифрового тюнера: DVB-S2, DVB-S, DVB-C, DVB-T2, DVB-T Частота обновления: 800 Гц (MotionFlow)','y','sony_kd_43x8306cbr2_images_628233622.jpg');
INSERT INTO "public"."goods" (g_id,g_name,c_id,m_id,g_price,g_description,g_avail,g_img) VALUES (40,'Philips 43PUS7150/12',23,36,20999,'Диагональ экрана: 43" Поддержка Smart TV: Есть Разрешение: 3840x2160 Wi-Fi: Да Диапазоны цифрового тюнера: DVB-S2, DVB-S, DVB-C, DVB-T Частота обновления: 800 Гц (PMR)','y','philips_43pus7150_12_images_1335476349.jpg');

INSERT INTO "public"."goods" (g_id,g_name,c_id,m_id,g_price,g_description,g_avail,g_img) VALUES (41,'LG 40UF670V',24,34,16999,'Диагональ экрана: 40" Поддержка Smart TV: Нет Разрешение: 3840x2160 Wi-Fi: Нет Диапазоны цифрового тюнера: DVB-S2, DVB-C, DVB-T2 Частота обновления: PMI 850 Гц','y','lg_40uf670v_images_690602484.jpg');
INSERT INTO "public"."goods" (g_id,g_name,c_id,m_id,g_price,g_description,g_avail,g_img) VALUES (42,'LG 40UF670V',24,36,13699,'Диагональ экрана: 43" Поддержка Smart TV: Нет Разрешение: 3840x2160 Wi-Fi: Нет Диапазоны цифрового тюнера: DVB-C, DVB-T2, DVB-T Частота обновления: 400 Гц (PMR)','y','philips_43put4900_12_images_1346213397.jpg');


INSERT INTO "public"."goods" (g_id,g_name,c_id,m_id,g_price,g_description,g_avail,g_img) VALUES (43,'LG G360 Red V',25,34,1599,'Экран (3", TFT, 240x320)/ основная камера: 1.3 Мп// 20 МБ встроенной памяти + microSD/SDHC (до 16 ГБ)/ поддержка 2х SIM-карт (Mini-SIM)/ 950 мА*ч','y','lg_g360_red_images_1389383739.jpg');
INSERT INTO "public"."goods" (g_id,g_name,c_id,m_id,g_price,g_description,g_avail,g_img) VALUES (54,'Nokia 220 Dual Sim Black',25,37,1019,'Экран (2.4", TFT, 240x320)/ основная камера: 2 Мп// microSD/SDHC (до 32 ГБ)/ поддержка 2х SIM-карт (Mini-SIM)/ 1100 мА*ч','y','nokia_220_dual_sim_black_images_57749212.jpg');
INSERT INTO "public"."goods" (g_id,g_name,c_id,m_id,g_price,g_description,g_avail,g_img) VALUES (44,'Samsung E1200i Indigo blue',25,31,1019,'Экран (1.52", , 128x128)/ Mini-SIM/ 800 мА*ч','y','samsung_e1200_indigo_blue_images_417234002.jpg');
INSERT INTO "public"."goods" (g_id,g_name,c_id,m_id,g_price,g_description,g_avail,g_img) VALUES (45,'Fly FF301 Black',25,39,888,'Экран (3", TN, 240x320)/ основная камера: 1.3 Мп// RAM 32 МБ/ 32 МБ встроенной памяти + microSD/SDHC (до 32 ГБ)/ поддержка 2х SIM-карт (Mini-SIM)/ 1450 мА*ч','y','fly_ff301_black_images_919785158.jpg');
INSERT INTO "public"."goods" (g_id,g_name,c_id,m_id,g_price,g_description,g_avail,g_img) VALUES (46,'Samsung Galaxy Tab S2 9.7" 32GB Black',26,31,13999,'Экран 9.7" Super AMOLED (2048x1536) емкостный MultiTouch / Samsung Exynos 5433 (1.9 ГГц + 1.3 ГГц) / RAM 3 ГБ / 32 ГБ встроенной памяти + microSD / 802.11 a/b/g/n/ac / Bluetooth 4.1 / основная камера 8 Мп, фронтальная 2.1 Мп / GPS / ГЛОНАСС / Android 5.0 (Lollipop) / 375 г / черный','y','samsung_galaxy_tab_s2_97_32gb_black_images_918346994.jpg');
INSERT INTO "public"."goods" (g_id,g_name,c_id,m_id,g_price,g_description,g_avail,g_img) VALUES (47,'Samsung Galaxy Tab E 9.6" Gold Brown',26,31,5499,'Экран 9.6" (1280x800) емкостный MultiTouch / T-Shark2 (1.3 ГГц) / RAM 1.5 ГБ / 8 ГБ встроенной памяти + microSD / Wi-Fi 802.11a/b/g/n / Bluetooth 4.0 / основная камера 5 Мп, фронтальная 2 Мп / GPS / ГЛОНАСС / Android 4.4 (KitKat) / 490 г / коричневый','y','samsung_galaxy_tab_e_brown_images_749141678.jpg');
INSERT INTO "public"."goods" (g_id,g_name,c_id,m_id,g_price,g_description,g_avail,g_img) VALUES (48,'Apple iPad Pro Wi-Fi 4G 128GB',26,40,38199,'Экран 12.9" IPS (2732x2048) емкостный MultiTouch / Apple A9X / RAM 4 ГБ / 128 ГБ встроенной памяти / 3G / 4G / EV-DO / Wi-Fi / Bluetooth 4.2 / основная камера 8 Мп, фронтальная - 1.2 Мп / A-GPS / ГЛОНАСС / iOS 9 / 723 г / золотистый','y','apple_ipad_pro_wi_fi_4g_128gb_ml2k2rk_a_gold_images_1403987500.jpg');
INSERT INTO "public"."goods" (g_id,g_name,c_id,m_id,g_price,g_description,g_avail,g_img) VALUES (49,'Apple iPad Pro Wi-Fi 4G 128GB',26,40,33499,'Благодаря iPad вы всегда могли с невероятной лёгкостью погрузиться во все свои дела. С iPad Pro мир ваших увлечений станет ещё обширнее. Он оснащён потрясающим 12.9-дюймовым дисплеем Retina и улучшенной технологией Multi‑Touch, а его производительность почти в два раза превосходит iPad Air 2. Новый iPad Pro не просто больше — с ним вы получите возможность работать и творить в совершенно иных масштабах.','y','apple_ipad_pro_wi_fi_128gb_ml0n2rk_a_space_gray_images_1403969482.jpg');
INSERT INTO "public"."goods" (g_id,g_name,c_id,m_id,g_price,g_description,g_avail,g_img) VALUES (50,'Lenovo Tab 2 10-30L 16GB LTE Midnight Blue',26,41,5999,'Экран 10.1" (1280x800) IPS емкостный, MultiTouch / Qualcomm Snapdragon 210 (1.1 ГГц) / RAM 1 ГБ / 16 ГБ встроенной памяти + microSD / Wi-Fi b/g/n / Bluetooth 4.0 / 3G / LTE / основная камера 5 Мп + фронтальная - 2 Мп / GPS / Android 5.0 / 525 г / темно-синий','y','lenovo_tab_2_x30l_midnight_blue_images_1416060874.jpg');
INSERT INTO "public"."goods" (g_id,g_name,c_id,m_id,g_price,g_description,g_avail,g_img) VALUES (51,'Lenovo Phab Plus PB1-770M 32GB LTE Gunmetal Grey',26,41,8499,'Экран 6.8" IPS (1920x1080, сенсорный емкостный, MultiTouch) / Qualcomm Snapdragon 615 (1.5 ГГц + 1 ГГц) / RAM 2 ГБ / камера 13 Мп + фронтальная 5 Мп / Bluetooth 4.0 / Wi-Fi 802.11 b/g/n / 32 ГБ встроенной памяти + microSD / поддержка 2-х SIM-карт / разъем 3.5 мм / 3G / LTE / A-GPS / ГЛОНАСС / ОС Android 5.0 (Lollipop) / 186.6 x 96.6 x 7.6 мм, 229 г / серый','y','lenovo_za070002ua_images_1281811243.jpg');
INSERT INTO "public"."goods" (g_id,g_name,c_id,m_id,g_price,g_description,g_avail,g_img) VALUES (52,'Asus ZenPad C 7 8GB Metallic',26,32,2799,'Экран 7" IPS (1024x600) емкостный MultiTouch / Intel Atom x3-C3200 (1.2 ГГц) / RAM 1 ГБ / 8 ГБ встроенной памяти + microSD / Wi-Fi 802.11 b/g/n / Bluetooth 4.0 / основная камера 2 Мп, фронтальная - 0.3 Мп / GPS / ГЛОНАСС / ОС Android 5.0 (Lollipop) / 265 г / металлик','y','asus_z170c_1l002a_metallic_images_1113747171.jpg');
INSERT INTO "public"."goods" (g_id,g_name,c_id,m_id,g_price,g_description,g_avail,g_img) VALUES (53,'Asus ZenPad 10 3G 8GB White',26,32,5299,'Экран 10" IPS (1280x800) емкостный MultiTouch / Intel Atom x3-C3230RK (1.2 ГГц) / RAM 2 ГБ / 8 ГБ встроенной памяти + microSD / 3G / Wi-Fi 802.11 b/g/n / Bluetooth 4.0 / основная камера 2 Мп, фронтальная - 0.3 Мп / GPS / ГЛОНАСС / ОС Android 5.0 (Lollipop) / 510 г / белый','y','copy_asus_z300cg_1b032a_56bb4715e93bd_images_1452971504.jpg');

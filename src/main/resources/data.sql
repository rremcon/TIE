INSERT INTO wallbrackets (id, size, adjustable, name, price) VALUES (1001, '25X32', false, 'LG bracket', 32.23);
INSERT INTO wallbrackets (id, size, adjustable, name, price) VALUES (1002, '25X32/32X40', true, 'LG bracket', 32.23);
INSERT INTO wallbrackets (id, size, adjustable, name, price) VALUES (1003, '25X25', false, 'Philips bracket', 32.23);
INSERT INTO wallbrackets (id, size, adjustable, name, price) VALUES (1004, '25X32/32X40', true, 'Nikkei bracket', 32.23);
INSERT INTO wallbrackets (id, size, adjustable, name, price) VALUES (1005, '25X32', false, 'Nikkei bracket', 32.23);

INSERT INTO cimodules (id, name, type, price) VALUES (1001, 'universal CI-module', '23JI12', 32.5);
INSERT INTO cimodules (id, name, type, price) VALUES (1001, 'universal KPN-module', '23JI12', 32.5);
INSERT INTO cimodules (id, name, type, price) VALUES (1001, 'universal HUAWEI-module', '23JI12', 32.5);

INSERT INTO remotes (id, compatible_with, battery_type, name, brand, price, original_stock) VALUES (1001, 'NH3216SMART', 'AAA', 'Nikkei HD smart TV controller', 'Nikkei', 12.99, 235885);
INSERT INTO remotes (id, compatible_with, battery_type, name, brand, price, original_stock) VALUES (1002, '43PUS6504/12/L', 'AA', 'Philips smart TV controller', 'Philips', 12.99, 235885);
INSERT INTO remotes (id, compatible_with, battery_type, name, brand, price, original_stock) VALUES (1003, 'OLED55C16LA', 'AAA', 'OLED55C16LA TV controller', 'LG', 12.99, 235885);

INSERT INTO televisions (id, type, brand, name, price, available_size, refresh_rate, screen_type, screen_quality, smart_tv, wifi, voice_control, hdr, bluetooth, ambi_light, original_stock, sold) VALUES (1001, 'NH3216SMART', 'Nikkei', 'HD smart TV', 159, 32, 100, 'LED', 'HD ready',  true, true, false, false, false, false, 235885, 45896);
INSERT INTO televisions (id, type, brand, name, price, available_size, refresh_rate, screen_type, screen_quality, smart_tv, wifi, voice_control, hdr, bluetooth, ambi_light, original_stock, sold) VALUES (1002, '43PUS6504/12/L', 'Philips', '4K UHD LED Smart Tv', 379, 43, 60, 'LED', 'Ultra HD',  true, true, false, true, false, false, 8569452, 5685489);
INSERT INTO televisions (id, type, brand, name, price, available_size, refresh_rate, screen_type, screen_quality, smart_tv, wifi, voice_control, hdr, bluetooth, ambi_light, original_stock, sold) VALUES (1003, '43PUS6504/12/M', 'Philips', '4K UHD LED Smart Tv', 379, 50, 60, 'LED', 'Ultra HD',  true, true, false, true, false, false, 345549, 244486);
INSERT INTO televisions (id, type, brand, name, price, available_size, refresh_rate, screen_type, screen_quality, smart_tv, wifi, voice_control, hdr, bluetooth, ambi_light, original_stock, sold) VALUES (1004, '43PUS6504/12/S', 'Philips', '4K UHD LED Smart Tv', 379, 58, 60, 'LED', 'Ultra HD',  true, true, false, true, false, false, 6548945, 4485741);
INSERT INTO televisions (id, type, brand, name, price, available_size, refresh_rate, screen_type, screen_quality, smart_tv, wifi, voice_control, hdr, bluetooth, ambi_light, original_stock, sold) VALUES (1005, 'OLED55C16LA', 'LG', 'LG OLED55C16LA', 989, 55, 100, 'OLED', 'ULTRA HD',  true, true, true, true, true, false, 50000, 20500);

UPDATE televisions SET remote_id = 1001 WHERE id = 1001;
UPDATE televisions SET remote_id = 1002 WHERE id = 1002;
UPDATE televisions SET remote_id = 1003 WHERE id = 1003;

INSERT INTO televisions_wallbrackets(television_id, wallbracket_id) values (1005, 1001);
INSERT INTO televisions_wallbrackets(television_id, wallbracket_id) values (1005, 1002);
INSERT INTO televisions_wallbrackets(television_id, wallbracket_id) values (1002, 1003);
INSERT INTO televisions_wallbrackets(television_id, wallbracket_id) values (1003, 1003);
INSERT INTO televisions_wallbrackets(television_id, wallbracket_id) values (1004, 1003);
INSERT INTO televisions_wallbrackets(television_id, wallbracket_id) values (1001, 1004);
INSERT INTO televisions_wallbrackets(television_id, wallbracket_id) values (1001, 1005);

INSERT INTO users (username, password, enabled, apikey, email) VALUES ('henk', '$2a$12$3U3xuyxiqw2H7vFKYhNdbOHDZUL6RrRn5dKaa.PDu8.6EpQyAad4u', true, '7847493', 'test@testy.tst');
INSERT INTO authorities (username, authority) VALUES ('henk', 'ROLE_ADMIN');






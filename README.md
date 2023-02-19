# Script Postgresql 15


DROP TABLE IF EXISTS users CASCADE;
DROP TABLE IF EXISTS products CASCADE;
DROP TABLE IF EXISTS details CASCADE;

CREATE TABLE products(
	product_id INT GENERATED ALWAYS AS IDENTITY,
	product_name varchar NOT NULL,
	image varchar NOT NULL,
	lore varchar NOT NULL,
	price numeric NOT NULL,
	available bool NOT NULL,
	product_type varchar NOT NULL,
	PRIMARY KEY(product_id)
);

CREATE TABLE users(
	user_id INT GENERATED ALWAYS AS IDENTITY,
	user_name varchar UNIQUE NOT NULL,
	user_password varchar NOT NULL,
	user_role varchar NOT NULL,
	mail varchar NOT NULL,
	validate_by_admin bool NOT NULL,
	PRIMARY KEY(user_id)
);

CREATE TABLE details(
	detail_id INT GENERATED ALWAYS AS IDENTITY,
	user_id INT,
	last_name varchar NULL,
	first_name varchar NULL,
	gender varchar NULL,
	birthdate date NULL,
	description varchar NULL,
	address varchar NULL,
	zipcode integer NULL,
	city varchar NULL,
	phone_number integer NULL,
	detail_image varchar NULL,
	PRIMARY KEY(detail_id),
	CONSTRAINT fk_user
		FOREIGN KEY(user_id)
			REFERENCES users(user_id)	
			ON DELETE CASCADE
);


insert into products (product_name, image, lore, price, available, product_type) values 
	('AATROX', 'https://images.contentstack.io/v3/assets/blt731acb42bb3d1659/blt570145160dd39dca/5db05fa8347d1c6baa57be25/RiotX_ChampionList_aatrox.jpg?quality=90&width=250', 'blablablablabla', 5000, true, 'Combatant'),
	('AHRI', 'https://images.contentstack.io/v3/assets/blt731acb42bb3d1659/blt1259276b6d1efa78/5db05fa86e8b0c6d038c5ca2/RiotX_ChampionList_ahri.jpg?quality=90&width=250', 'blablablablabla', 8000, true, 'Mage'),
	('DIANA', 'https://images.contentstack.io/v3/assets/blt731acb42bb3d1659/blt56570083d2a5e20e/5db05fbc823d426762825fdf/RiotX_ChampionList_diana.jpg?quality=90&width=250', 'blablablablabla', 4500, false, 'Combatant'),
	('FIZZ', 'https://images.contentstack.io/v3/assets/blt731acb42bb3d1659/blt6000fa69e03c25c0/5db05fbc56458c6b3fc17513/RiotX_ChampionList_fizz.jpg?quality=90&width=250', 'blablablablabla', 8125, true, 'Assassin'),
	('HECARIM', 'https://images.contentstack.io/v3/assets/blt731acb42bb3d1659/blteb9ce5304ec48e19/5db05fc5df78486c826dccfa/RiotX_ChampionList_hecarim.jpg?quality=90&width=250', 'blablablablabla', 2690, true, 'Combatant'),
	('JAX', 'https://images.contentstack.io/v3/assets/blt731acb42bb3d1659/blt6b301613598c3f17/5db05fcf89fb926b491ed81d/RiotX_ChampionList_jax.jpg?quality=90&width=250', 'blablablablabla', 5050, false, 'Combatant'),
	('KARMA', 'https://images.contentstack.io/v3/assets/blt731acb42bb3d1659/blt39748c7b67252d6f/5db05fd70b39e86c2f83dc19/RiotX_ChampionList_karma.jpg?quality=90&width=250', 'blablablablabla', 4800, true, 'Mage'),
	('KINDRED', 'https://images.contentstack.io/v3/assets/blt731acb42bb3d1659/bltc0f0007660b7a07b/5db05fd689fb926b491ed823/RiotX_ChampionList_kindred.jpg?quality=90&width=250', 'blablablablabla', 6420, true, 'Tireur'),
	('RAKAN', 'https://images.contentstack.io/v3/assets/blt731acb42bb3d1659/bltbe844b30961ccb7c/5db05ffb2140ec675d68f4ad/RiotX_ChampionList_rakan.jpg?quality=90&width=250', 'blablablablabla', 1500, true, 'Support'),
	('ZOE', 'https://images.contentstack.io/v3/assets/blt731acb42bb3d1659/bltd18587f31803441d/5db060226e8b0c6d038c5cc6/RiotX_ChampionList_zoe.jpg?quality=90&width=250', 'blablablablabla', 5000, false, 'Mage'),
	('XAYAH', 'https://images.contentstack.io/v3/assets/blt731acb42bb3d1659/blt0d029ccdb18a4299/5db0601ba6470d6ab91ce5be/RiotX_ChampionList_xayah.jpg?quality=90&width=250', 'blablablablabla', 8000, true, 'Tireur'),
	('VIEGO', 'https://images.contentstack.io/v3/assets/blt731acb42bb3d1659/blt17591d0be6f2888f/600f2aee5ad9610f6cb7880c/RiotX_ChampionList_viego.jpg?quality=90&width=250', 'blablablablabla', 10000, true, 'Assassin');

insert into users (user_name, user_password, user_role, mail, validate_by_admin) values
	('Kiara', 1234, 'user', 'christopherbouthemy2014@gmail.com', true),
	('Yumi', 1234, 'admin', 'christopherbouthemy2014@gmail.com', true),
	('Olympe', 1234, 'user', 'christopherbouthemy2014@gmail.com', false),
	('Kimie', 1234, 'user', 'christopherbouthemy2014@gmail.com', false),
	('Chouchou', 1234, 'user', 'christopherbouthemy2014@gmail.com', false),
	('Mouche', 1234, 'user', 'christopherbouthemy2014@gmail.com', false),
	('Toffee', 1234, 'user', 'christopherbouthemy2014@gmail.com', false);

insert into details (user_id, last_name, first_name, gender, birthdate, description, address, zipcode, city, phone_number, detail_image) values
	(1, 'Bouthemy', 'Kiara', 'Femme', '2022-04-11', 'Je suis un chat trop mimi', '125 rue du chat', 01150, 'Lagnieu', 0645987885, 'https://geo.img.pmdstatic.net/fit/~1~geo~2022~08~04~ad58919e-babe-47a5-b5fc-f164fe4c0edb.jpeg/1200x630/cr/wqkgR2V0dHkgSW1hZ2VzIC8gR0VP/pourquoi-les-chats-sont-consideres-comme-des-especes-invasives-en-pologne.jpg'),
	(2, 'Bouthemy', 'Yumi', 'Femme', '2022-04-11', 'Je suis un chat trop mimi', '125 rue du chat', 01150, 'Lagnieu', 0645987885, 'https://geo.img.pmdstatic.net/fit/~1~geo~2022~08~04~ad58919e-babe-47a5-b5fc-f164fe4c0edb.jpeg/1200x630/cr/wqkgR2V0dHkgSW1hZ2VzIC8gR0VP/pourquoi-les-chats-sont-consideres-comme-des-especes-invasives-en-pologne.jpg');

# carrental
Project for internship assignment

Stworzony z spring initializr. Korzysta z MySQL
Żeby aplikacja uruchomiła się poprawnie trzeba utworzyć użytkownika carRental z hasłem "haslo", oraz baze danych o nazwie carRentalDB.
Zamiast tego można zmienić ustawienia bazy danych w application.properties.

Działanie aplikacji:

	
	"/init" GET
			wypełnia baze danych przykładowymi użytkownikami oraz samochodami.
		
	"/cars" GET
			zwraca wszystkie auta, które są w bazie danych.
	
	"/cars/ POST
			tworzy nowe auto z podanymi przez nas parametrami.
			
	"/cars/{id}" GET
			zwraca auto, które posiada podane przez nas id.
	
	"/cars/{id}" PUT
			aktualizuje samochód, z podanym przez nas id.
	
	"/cars/{id}" DELETE
			usuwa auto z podanym id z bazy danych.
			
	"/cars/rented" GET
			zwraca aktualnie wynajęte auta.
	
	"/cars/available" GET
			zwraca auta które nie są wypożyczone.
	
	"/users" GET
			zwraca listę użytkowników.
			
	"/users/" POST
			tworzy nowego użytkownika z podanymi przez nas parametrami.
	
	"/users/{id}" GET
			zwraca użytkownika z podanym id.
	
	"/users/{id}" PUT
			aktualizuje użytkownika z danym id.
	
	"/users/{id}" DELETE
			usuwa użytkownika z danym id.
	
	"/users/email/{email}" GET
			zwraca użytkownika z podanym e-mailem.
	
	"users/{id}/car" GET
			zwraca auto wynajęte przez użytkownika z danym id.
	
	"users/{id}/rent/{carId}" PUT
			przypisuje auto do użytkownika.
	
	"users/{id}/endRenting" PUT
			kończy wynajmowanie samochodu przez użytkownika.
			
	
	Przykładowe dane zwracane przez aplikacje:
		/cars/3 GET
		
			{
				"brand": "Fiat",
				"model": "500",
				"mileage": 199324,
				"user": null,
				"id": 3,
				"vin": "F1029DASDAP2"
			}
			
		/users/2 GET

			{
				"name": "Jan Kowalski",
				"password": "p4ssw0rd",
				"email": "janKowalski@wp.pl",
				"id": 2
			}
	

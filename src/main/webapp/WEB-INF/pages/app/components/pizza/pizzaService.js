;
(function() {
	'use strick';

	// Service "pizzaService"
	var pizzaService = function($http) {
		this.findAll = function(callback) {
			console.log('FindAll pizzas ...');
			var request = {
				method : 'GET',
				url : '/pizzaria/api/pizza',
				headers : {
					'Accept' : 'application/json'
				}
			};

			$http(request).success(callback).error(function(data) {
				alert('Something bad happened');
			});
		};

		this.savePizza = function(pizza, callback) {
			console.log('Update pizza: ' + pizza);
			var request = {
				method : pizza.id? 'PUT' : 'POST',
				url : '/pizzaria/api/pizza',
				headers : {
					'Accept' : 'application/json',
					'Content-Type' : 'application/json'
				},
				data : pizza
			};

			$http(request).success(callback).error(function(data) {
				alert('Something bad happened: no update');
			});
		};

		this.deletePizza = function(id, callback) {
			console.log('Delete pizza: ' + id);
			var request = {
				method : 'DELETE',
				url : '/pizzaria/api/pizza/' + id,
			};

			$http(request).success(callback).error(function(data) {
				alert('Something bad happened: no update');
			});
		};
	};

	/* Registrando o novo service "pizzaService" */
	angular.module('pizzariaApp.services')
			.service('pizzaService', pizzaService);
})();
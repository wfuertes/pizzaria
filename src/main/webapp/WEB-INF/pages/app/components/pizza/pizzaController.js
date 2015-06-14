;
(function() {
	'use strict';

	// Controller PizzaCtrl que depende de "pizzaService"
	var pizzaCtrl = function($scope, pizzaService) {

		var loadPizzas = function() {
			pizzaService.findAll(function(data) {
				$scope.pizzas = data;
			});
		};

		$scope.clearPizza = function() {
			$scope.pizza = {};
		};

		$scope.openModal = function(pizza) {
			$scope.pizza = pizza || {};
			$('#pizzaModal').modal();
		};

		$scope.savePizza = function(pizza) {
			pizzaService.savePizza(pizza, function() {
				loadPizzas();
				$scope.clearPizza();
			});
		};

		$scope.deletePizza = function(pizza) {
			pizzaService.deletePizza(pizza.id, function() {
				loadPizzas();
			});
		}

		// Carregando as pizzas
		loadPizzas();
	};

	/* Registrando o novo controller PizzaCtrl */
	angular.module('pizzariaApp.controllers')
			.controller('PizzaCtrl', pizzaCtrl);
})();
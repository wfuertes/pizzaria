;
(function() {
	'use strict';

	// Controller HomeCtrl que depende de "pizzaService"
	var homeCtrl = function($scope, pizzaService) {
		pizzaService.findAll(function(data) {
			$scope.pizzas = data;
		});
	};

	/* Registrando o novo controller HomeCtrl */
	angular.module('pizzariaApp.controllers').controller('HomeCtrl', homeCtrl);
})();
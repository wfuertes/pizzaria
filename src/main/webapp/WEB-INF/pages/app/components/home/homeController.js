;
(function() {
	'use strict';

	var homeCtrl = function($scope, homeService) {
		homeService.fetchPizzas(function(data) {
			console.log(data);
			$scope.pizzas = data;
		});
	};

	/* Controllers */
	angular.module('pizzariaApp.controllers').controller('HomeCtrl', homeCtrl);
})();
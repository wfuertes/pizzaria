;
(function() {
	'use strict';

	// Controller LoginCtrl que depende de "loginService"
	var loginCtrl = function($scope, loginService) {

		var loadPizzas = function() {
			loginService.findAll(function(data) {
				$scope.pizzas = data;
			});
		};

		$scope.doLogin = function(user) {
			loginService.authenticate(user, function() {
				alert('Deu certo');
			});
		};
	};

	/* Registrando o novo controller LoginCtrl */
	angular.module('pizzariaApp.controllers')
			.controller('LoginCtrl', loginCtrl);
})();
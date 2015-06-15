;
(function() {
	'use strict';

	var routes = function($routeProvider) {
		$routeProvider.when('/', {
			//controller : 'HomeCtrl',
			templateUrl : '/pizzaria/pages/app/components/home/homeView.html'
		}).when('/pizzas', {
			//controller : 'PizzaCtrl',
			templateUrl : '/pizzaria/pages/app/components/pizza/pizzaView.html'
		}).when('/users', {
			//controller : 'UserCtrl',
			templateUrl : '/pizzaria/pages/app/components/user/userView.html'
		}).when('/login', {
			//controller : 'LoginCtrl',
			templateUrl : '/pizzaria/pages/app/components/login/loginView.html'
		});
	};

	// Declare app level module which depends on filters, and services
	angular.module('pizzariaApp.routes').config([ '$routeProvider', routes ]);
})();
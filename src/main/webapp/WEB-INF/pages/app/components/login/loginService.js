;
(function() {
	'use strick';

	// Service "loginService"
	var loginService = function($http) {

		this.authenticate = function(user, callback) {
			console.log('Login para user: ' + user.name);
			
			var request = {
				method : 'POST',
				url : '/pizzaria/authenticate',
				headers : {
					'Content-Type' : 'application/x-www-form-urlencoded'
				},
				data : {
					"j_username" : user.username,
					"j_password" : user.password
				}
			};

			$http(request).success(callback).error(function(data) {
				alert('Something bad happened: no loginService');
			});
		};
	};

	/* Registrando o novo service "loginService" */
	angular.module('pizzariaApp.services')
			.service('loginService', loginService);
})();
;
(function() {
	'use strick';

	var homeService = function($http) {
		console.log('homeService.fetchPizzas 1');
		// public
		this.fetchPizzas = function(callback) {
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
	};

	/* Controllers */
	angular.module('pizzariaApp.services').service('homeService', homeService);
})();
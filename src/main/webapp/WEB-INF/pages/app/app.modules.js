;
(function() {
	'use strict';

	// Declare app level module which depends on filters, and services
	angular.module('pizzariaApp', [ 'pizzariaApp.routes',
			'pizzariaApp.controllers' ]);

	angular.module('pizzariaApp.controllers', [ 'pizzariaApp.services' ]);
	angular.module('pizzariaApp.services', []);
	angular.module('pizzariaApp.routes', [ 'ngRoute' ]);
})();

;
(function() {
	'use strict';

	// Declarando o modulo pizzariaApp e sua dependências
	angular.module('pizzariaApp', [ 'pizzariaApp.routes', 'pizzariaApp.controllers' ]);

	// Declarando os demais modulos: services, controllers, routes ...
	angular.module('pizzariaApp.services', []);
	angular.module('pizzariaApp.directives', []);
	angular.module('pizzariaApp.controllers', [ 'pizzariaApp.services' ]);
	angular.module('pizzariaApp.routes', [ 'ngRoute' ]);
})();
